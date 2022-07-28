import React from 'react'
import { useForm } from 'react-hook-form'
import Input from '../components/Input'
import {createUser} from '../api/ApiCalls'
import { toast } from 'react-toastify'

function CreateUser() {

    const {register, formState:{errors}, handleSubmit, reset} = useForm()

    const onSubmit = async data => {
        
        try {
            const response = await createUser(data)
            toast.success("Kuruldu")
            reset()
        } catch (error) {
            toast.error("kurulmadi")
            reset()

        }

    }

  return (
    <div className='container'>
        <h1 className='text-center'></h1>
        
        <form onSubmit={handleSubmit(onSubmit)}>
            <Input name="name" label="Name" errors={errors} register={register}/>
            <Input name="surname" label="Surname" errors={errors} register={register}/>
            <Input name="email" label="Email" errors={errors} register={register} type="email"/>
            <Input name="password" label="Password" errors={errors} register={register} type="password" />

            <button className='btn btn-primary btn-block mt-3' type='submit'>Submit</button>
        </form>
    </div>
  )
}

export default CreateUser
import React, { useState } from "react";
import { useForm } from "react-hook-form";
import { toast } from "react-toastify";
import Alert from "react-bootstrap/Alert";
import { useNavigate } from "react-router-dom";

import { createUser } from "../api/ApiCalls";
import Input from "../components/Input";

function CreateUser() {
  const [ApiErrors, setApiErrors] = useState([]);
  const [show, setShow] = useState(true);
  const navigate = useNavigate();

  const {
    register,
    formState: { errors },
    handleSubmit,
    reset,
  } = useForm();

  const onSubmit = async (data) => {
    toast
      .promise(createUser(data), {
        pending: "Kulanici oluşturuluyor...",
        success: "Kuruldu 👌",
        error: "Kurulmadi 🤯",
      })
      .then((result) => {
        navigate("/");
        reset();
      })
      .catch((err) => {
        setApiErrors(Object.values(err.response.data.validationData));
        setShow(true);
      });
  };

  return (
    <div className="container">
      <h1 className="text-center mt-2">Yeni kullanici olustur</h1>
      <form onSubmit={handleSubmit(onSubmit)}>
        <Input name="name" label="Name" errors={errors} register={register} />
        <Input
          name="surname"
          label="Surname"
          errors={errors}
          register={register}
        />
        <Input
          name="email"
          label="Email"
          errors={errors}
          register={register}
          type="email"
        />
        <Input
          name="password"
          label="Password"
          errors={errors}
          register={register}
          type="password"
        />

        <button className="btn btn-primary btn-block mt-3" type="submit">
          Submit
        </button>

        {ApiErrors &&
          show &&
          ApiErrors.map((error, index) => (
            <Alert
              key={index}
              variant="danger"
              onClose={() => setShow(false)}
              dismissible
            >
              {error}
            </Alert>
          ))}
      </form>
    </div>
  );
}

export default CreateUser;

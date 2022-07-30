import { useEffect, useState } from "react";
import { listUsers } from "../api/ApiCalls";
import List from "../components/List";


function ListUser() {

    const [users,setUsers] = useState([])

    useEffect (() => {
        listUsers()
        .then(response => {
            setUsers(response.data)
        })
        .catch(error => console.log({error}));
    },[])

  return (
    <div>
        <table className="table table-striped mt-1">
                <thead>
                    <tr>
                        <th scope="col">ID</th>
                        <th scope="col">Name</th>
                        <th scope="col">Surname</th>
                        <th scope="col">Email</th>
                    </tr>
                </thead>
               <List users={users}/>
            </table>
    </div>
  )
}

export default ListUser
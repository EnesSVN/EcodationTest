import { useEffect, useState } from "react";
import { listUsers, findUsersByName } from "../api/ApiCalls";
import List from "../components/List";

function ListUser() {
  const [users, setUsers] = useState([]);
  const [search, setSearch] = useState("");

  useEffect(() => {
    listUsers()
      .then((response) => {
        setUsers(response.data);
      })
      .catch((error) => console.log({ error }));
  }, []);

  const handleSearch = async (e) => {
    setSearch(e.target.value);
    try {
      const foundUsers = await findUsersByName(e.target.value);
      setUsers(foundUsers.data);
    } catch (error) {
      console.log(error);
    }
  };

  return (
    <div className="container">
      <h1 className="text-center">Kulanici listeleme ve Arama</h1>
      <input
        placeholder="Kullanici adini girin"
        className="form-control"
        type="text"
        value={search}
        onChange={handleSearch}
      />
      {users.length ? (
        <table className="table table-striped mt-1 table-dark">
          <thead>
            <tr>
              <th scope="col">ID</th>
              <th scope="col">Name</th>
              <th scope="col">Surname</th>
              <th scope="col">Email</th>
            </tr>
          </thead>
          <List users={users} />
        </table>
      ) : (
        <div className="text-center">Kullanici bulunamadi</div>
      )}
    </div>
  );
}

export default ListUser;

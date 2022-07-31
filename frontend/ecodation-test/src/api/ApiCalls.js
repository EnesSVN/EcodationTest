import axios from "axios";

export const createUser = (body) => {
  return axios.post("http://localhost:8081/users/create", body);
};

export const listUsers = (body) => {
  return axios.get("http://localhost:8081/users/all", body);
};

export const findUsersByName = (search) => {
  return axios.get(`http://localhost:8081/users?search=${search}`);
};

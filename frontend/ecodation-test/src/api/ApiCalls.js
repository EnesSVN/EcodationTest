import axios from 'axios';


export const createUser = (body) => {
    return axios 
        .post('http://localhost:8081/users/create',body)

} 


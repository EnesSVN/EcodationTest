import React from 'react'

function List({ users }) {
    return (

        <tbody>
            {users.map((user) => (
                <tr key={user.id}>
                    <th scope="row">{user.id}</th>
                    <td>{user.name}</td>
                    <td>{user.surname}</td>
                    <td>{user.email}</td>

                </tr>
            ))}
        </tbody>

    )
}

export default List
package com.example.ecodationtest.entity;


import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users")
@NamedQueries({
        @NamedQuery(name = "UserEntity.findAllUser",
                query = "SELECT u FROM UserEntity u")

})
public class UserEntity extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

}

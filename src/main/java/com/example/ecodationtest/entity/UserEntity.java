package com.example.ecodationtest.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
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
                query = "SELECT u FROM UserEntity u"),
        @NamedQuery(name = "UserEntity.findUserByIdUser",
                query = "SELECT u FROM UserEntity u WHERE u.id = :id"),

})
public class UserEntity extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

}

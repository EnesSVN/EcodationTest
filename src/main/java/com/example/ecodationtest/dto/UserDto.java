package com.example.ecodationtest.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class UserDto {

    private Long id;

    @NotNull(message = "kullanıcı adı boş geçilemez.")
    @Size(min = 3, max = 250, message = "kullanıcı adı min:3 max:250 olabilir")
    private String name;

    @NotNull(message = "soyadı boş geçilemez.")
    @Size(min = 3, max = 250, message = "kullanıcı soyadı min:3 max:250 olabilir")
    private String surname;

    @NotNull(message = "e-posta boş geçilemez.")
    @Email(message = "e-posta formatı hatalı.")
    private String email;

    @NotNull(message = "şifre boş geçilemez.")
    @Size(min = 7, max = 200, message = "şifre min:7 max:200 olabilir")
    @Pattern(regexp = "^[a-zA-Z0-9]{7}")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
}

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
    @Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$", message = "şifre en az 8 karakter olmalıdır. en az 1 büyük, 1 küçük, 1 sayı ve 1 özel karakter içermelidir.")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
}

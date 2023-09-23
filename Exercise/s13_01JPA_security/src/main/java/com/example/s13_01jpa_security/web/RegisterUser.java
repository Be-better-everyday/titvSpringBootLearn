package com.example.s13_01jpa_security.web;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class RegisterUser {
    @NotBlank
    @Column(name = "username")
    @Size(min = 1, message = "Min length of userName is 8")
    private String userName;
    @NotBlank
    @Size(min = 8, message = "min length of password is 8")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[@#$%^&+=!])(?=\\S+$).*$", message = "Wrong pattern, your password need at least 1 special character")
    private String password;
    //    private boolean enabled;
    @NotBlank(message = "Required information !")
    @Column(name = "first_name")
    private String firstName;
    @NotBlank(message = "Required information !")
    @Column(name = "last_name")
    private String lastName;
    @NotBlank(message = "Required information !")
    @Email(message = "This email is not valid")
    private String email;

//    public static void main(String[] args) {
//        RegisterUser registerUser = new RegisterUser();
//        registerUser.setEmail("123");
//        System.out.println(registerUser);
//    }
}

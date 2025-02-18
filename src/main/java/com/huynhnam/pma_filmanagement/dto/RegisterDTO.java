package com.huynhnam.pma_filmanagement.dto;


import com.huynhnam.pma_filmanagement.validations.RegisterChecked;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@RegisterChecked
public class RegisterDTO {
    @Size(min = 6, max = 100, message = "FullName must greater than 5 character and less than 101 character !")
    private String fullName;
    @Email(message = "Email don't match format !")
    private String email;
    @Size(min = 10, max = 20, message = "Phone number must be greater than 9 and less than 21 character !")
    private String phone;
    @NotBlank(message = "Address is not empty !")
    private String address;
    @Size(min = 6, message = "Password must greater than 5 character !")
    private String password;
    private String confirmPassword;
}

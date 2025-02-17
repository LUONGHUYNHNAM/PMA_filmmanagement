package com.huynhnam.pma_filmanagement.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer userId;

    @Email (message = "Email incorrect format !")
    private String email;
    @Size(min = 6 , message = "Password must be greater than 5 character !" )
    private String password;

    @Size(min = 9, max = 20, message = "Phone number must be greater than 8 character !")
    private String phoneNumber;

    @NotBlank (message = "Address is not empty !")
    private String address;

    @Temporal(TemporalType.DATE)
    private Date day_of_birth ;

    private Boolean gender;

    @NotBlank (message = "Fullname is not empty !")
    private String fullname;

    @ManyToOne
    @JoinColumn (name = "role_id")
    private Role role;


}

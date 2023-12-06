package com.example.springecommerce.models;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.example.springecommerce.dtos.UserDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;
    private String imageUrl;
    private String password;
    private String fullName;
    private BigDecimal balance;


    public Users(UserDto usersDTO) {
        this.username = usersDTO.getUsername();
        this.password = BCrypt.withDefaults()
                .hashToString(12, usersDTO.getPassword().toCharArray());
        this.fullName = usersDTO.getFullName();
        this.balance = new BigDecimal(2500000);
    }

}

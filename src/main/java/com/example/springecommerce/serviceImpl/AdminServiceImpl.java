package com.example.springecommerce.serviceImpl;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.example.springecommerce.dtos.PasswordDto;
import com.example.springecommerce.models.Admin;
import com.example.springecommerce.repositories.AdminRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class AdminServiceImpl {

    private AdminRepositories adminRepositories;

    @Autowired
    public AdminServiceImpl(AdminRepositories adminRepositories) {
        this.adminRepositories = adminRepositories;
    }

    public Function<String, Admin> findUsersByUsername = (username)->
            adminRepositories.findByUsername(username)
                    .orElseThrow(()->new NullPointerException("Admin not found!"));
    public Function<Long, Admin> findUsersById = (id)->
            adminRepositories.findById(id)
                    .orElseThrow(()->new NullPointerException("Admin not found!"));

    public Function<Admin, Admin> saveAdmin = (admin)->adminRepositories.save(admin);

    public Function<PasswordDto, Boolean> verifyUserPassword = passwordDTO -> BCrypt.verifyer()
            .verify(passwordDTO.getPassword().toCharArray(),
                    passwordDTO.getHashPassword().toCharArray())
            .verified;
}

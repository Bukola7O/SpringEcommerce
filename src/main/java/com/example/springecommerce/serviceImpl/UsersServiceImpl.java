package com.example.springecommerce.serviceImpl;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.example.springecommerce.dtos.PasswordDto;
import com.example.springecommerce.models.Users;
import com.example.springecommerce.repositories.UsersRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class UsersServiceImpl {

    private UsersRepositories usersRepositories;

    @Autowired
    public UsersServiceImpl(UsersRepositories usersRepositories) {
        this.usersRepositories = usersRepositories;
    }

    public Function<String, Users> findUsersByUsername = (username)->
            usersRepositories.findByUsername(username)
                    .orElseThrow(()->new NullPointerException("User not found!"));
    public Function<Long, Users> findUsersById = (id)->
            usersRepositories.findById(id)
                    .orElseThrow(()->new NullPointerException("User not found!"));

    public Function<Users, Users> saveUser = (user)->usersRepositories.save(user);

    public Function<PasswordDto, Boolean> verifyUserPassword = passwordDTO -> BCrypt.verifyer()
            .verify(passwordDTO.getPassword().toCharArray(),
                    passwordDTO.getHashPassword().toCharArray())
            .verified;
}
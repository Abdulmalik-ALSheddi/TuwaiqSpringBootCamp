package com.example.day8userproject.Service;

import com.example.day8userproject.Exception.APIException;
import com.example.day8userproject.Model.User;
import com.example.day8userproject.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public void updateUser(Integer id, User user) {
        User user1 = userRepository.findUserById(id);
        if(user1 == null)
            throw new APIException("User NOT FOUND !!");
        user1.setAge(user.getAge());
        user1.setName(user.getName());
        user1.setRole(user.getRole());
        user1.setEmail(user.getEmail());
        user1.setPassword(user.getPassword());
        user1.setUsername(user.getUsername());
        userRepository.save(user1);
        return;
    }

    public void deleteUser(Integer id) {
        if(userRepository.findUserById(id) == null)
            throw new APIException("User NOT FOUND !!");
        userRepository.deleteById(id);
        return;
    }

    /*Check if username and password match*/
    public User check(String username, String password) {
        User user = userRepository.findUserByUsername(username);
        if(user == null)
            throw new APIException("Username NOT FOUND !!");
        if(user.getPassword().equals(password))
            throw new APIException("Password not correct !!");
        return user;
    }

    /*Get user by email*/
    public User getUserByEmail(String email)
    {
        if(userRepository.findUserByEmail(email) == null)
            throw new APIException("User NOT FOUND !!");
        return userRepository.findUserByEmail(email);
    }

    /*Get All users with specific role*/
    public List<User> getUsersByRole(String role) {
        if(userRepository.findAllByRole(role).isEmpty())
            throw new APIException("No Users have this role !!");
        return userRepository.findAllByRole(role);
    }

    /*Get All users with specific age or above*/
    public List<User> getUsersByAge(Integer age) {
        if(userRepository.findAllByAgeGreaterThanEqual(age).isEmpty())
            throw new APIException("No users of this age or older");
        return userRepository.findAllByAgeGreaterThanEqual(age);
    }

}

package com.example.day7managementsoftwere.Service;

import com.example.day7managementsoftwere.Model.User;
import com.example.day7managementsoftwere.Repository.ManagementRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ManagementService {
    private final ManagementRepository managementRepository;


    public List<User> getUsers() {
        return managementRepository.findAll();
    }

    public void addUser(User user) {
        managementRepository.save(user);
    }

    public boolean updateUser(Integer id, User user) {
        if(managementRepository.getById(id) != null)
        {
            managementRepository.getById(id).setAge(user.getAge());
            managementRepository.getById(id).setEmail(user.getEmail());
            managementRepository.getById(id).setName(user.getName());
            managementRepository.getById(id).setRole(user.getRole());
            managementRepository.getById(id).setPassword(user.getPassword());
            managementRepository.getById(id).setUsername(user.getUsername());
            managementRepository.getById(id).setId(user.getId());
            return true;
        }
        return false;
    }

    public boolean deleteUser(Integer id) {
        if(managementRepository.getById(id) != null)
        {
            managementRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

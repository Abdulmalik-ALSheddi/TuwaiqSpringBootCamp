package com.example.day7managementsoftwere.Repository;

import com.example.day7managementsoftwere.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagementRepository extends JpaRepository<User,Integer> {

}

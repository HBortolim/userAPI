package com.example.ClientCRUD.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ClientCRUD.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}

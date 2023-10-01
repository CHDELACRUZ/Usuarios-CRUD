package com.usuarioscrud.springboot.web.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.usuarioscrud.springboot.web.app.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}

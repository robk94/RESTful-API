package com.rk.app.rest.Repo;


import com.rk.app.rest.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long>{
}

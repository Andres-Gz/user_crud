package org.example.usercrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.example.usercrud.model.User;

public interface IUserRepository extends JpaRepository<User, Long> {

}

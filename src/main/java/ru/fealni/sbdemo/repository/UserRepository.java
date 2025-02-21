package ru.fealni.sbdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "select * from users where email = :email", nativeQuery = true)
    Optional<User> findByEmail(String email);

    @Query(value = "select u from User u where u.email = :email")
    User findByEmailJpql(String email);

    User findUserByEmailContaining(String email);
}

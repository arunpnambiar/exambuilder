package com.exambuilder.dao;

import com.exambuilder.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailsDao extends JpaRepository<User,Long> {
    @Query("SELECT u FROM User u WHERE u.username = :username")
    public User getUserByUsername(@Param("username") String username);

    @Query("SELECT u FROM User u WHERE u.username =:username and u.password =:password")
    public User  loginWithUsernameAndPassword(@Param("username") String username,@Param("password") String password);
}

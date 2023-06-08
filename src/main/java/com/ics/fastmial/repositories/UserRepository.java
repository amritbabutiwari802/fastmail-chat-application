package com.ics.fastmial.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.ics.fastmial.entity.User;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, String> {
    public List<User> findByName(String name);

    public User findByUsername(String username);

    public boolean existsByUsername(String username);
    
//    @Modifying
//    @Transactional
//    public int deleteByName(String name);
}

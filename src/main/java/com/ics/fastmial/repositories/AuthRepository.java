package com.ics.fastmial.repositories;

import org.springframework.data.repository.CrudRepository;

import com.ics.fastmial.entity.Auth;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuthRepository extends CrudRepository<Auth, String> {

    public boolean existsByUsername(String username);
    public List<Auth> findByUsername(String username);
}

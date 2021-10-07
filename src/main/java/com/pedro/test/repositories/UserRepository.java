package com.pedro.test.repositories;

import com.pedro.test.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Spring Data
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}

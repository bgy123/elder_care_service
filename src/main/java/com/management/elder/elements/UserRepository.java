package com.management.elder.elements;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {
    User findByUserIdEqualsAndUserPw(String id,String pw);
    //User findByUserIdEquals(String id);
    User findByUserNoEquals(Long id);

}

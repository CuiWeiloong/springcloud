package com.cralor.springcloud_prepare.dao;


import com.cralor.springcloud_prepare.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserDao extends JpaRepository<User, Long>{

	User findByUsername(String username);
}

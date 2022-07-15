package com.evo.be_jwt_user.dao;

import com.evo.be_jwt_user.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends CrudRepository<User,String> {
}

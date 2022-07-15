package com.evo.be_jwt_user.service;

import com.evo.be_jwt_user.dao.RoleDao;
import com.evo.be_jwt_user.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private RoleDao roleDao;

    public Role createNewRole(Role  role) {

        return roleDao.save(role);
    }
}

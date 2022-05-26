package com.deskita.admin.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.deskita.common.entity.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role,Integer> {

}

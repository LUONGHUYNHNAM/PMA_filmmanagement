package com.huynhnam.pma_filmanagement.repository;

import com.huynhnam.pma_filmanagement.model.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role, Integer> {

}

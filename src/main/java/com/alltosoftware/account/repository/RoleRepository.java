package com.alltosoftware.account.repository;

import com.alltosoftware.account.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}

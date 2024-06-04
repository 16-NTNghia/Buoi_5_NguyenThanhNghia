package com.hutech.bai_1.Repositories;

import com.hutech.bai_1.Entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, String> {
}

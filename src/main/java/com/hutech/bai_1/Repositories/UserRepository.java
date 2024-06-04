package com.hutech.bai_1.Repositories;

import com.hutech.bai_1.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}

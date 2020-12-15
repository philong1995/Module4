package com.codegym.repository.login;

import com.codegym.entity.login.AppUser;
import com.codegym.entity.login.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRoleRepository extends JpaRepository<UserRole,Long> {
    List<UserRole> findByAppUser(AppUser appUser);
}

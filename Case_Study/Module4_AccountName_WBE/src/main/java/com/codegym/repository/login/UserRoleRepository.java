package com.codegym.repository.login;

import com.codegym.entity.login.AppUser;
import com.codegym.entity.login.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRoleRepository extends JpaRepository<UserRole,Long> {
    @Query(value = "select role_name from app_role join user_role on app_role.role_id = user_role.role_id join app_user on user_role.user_id = app_user.user_id where app_user.user_id = ?1", nativeQuery = true)
    List<String> findByAppUser(Long id);
}

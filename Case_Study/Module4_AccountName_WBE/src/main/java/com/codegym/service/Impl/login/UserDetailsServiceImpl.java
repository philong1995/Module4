//package com.codegym.service.Impl.login;
//
//import com.codegym.entity.login.AppRole;
//import com.codegym.entity.login.AppUser;
//import com.codegym.entity.login.UserRole;
//import com.codegym.repository.login.AppRoleRepository;
//import com.codegym.repository.login.AppUserRepository;
//import com.codegym.repository.login.UserRoleRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//public class UserDetailsServiceImpl implements UserDetailsService {
//    @Autowired
//    private AppUserRepository appUserRepository;
//
//    @Autowired
//    private AppRoleRepository appRoleRepository;
//
//    @Autowired
//    private UserRoleRepository userRoleRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
//        AppUser appUser = this.appUserRepository.findByUserName(userName);
//
//        if (appUser == null) {
//            System.out.println("User not found! " + userName);
//            throw new UsernameNotFoundException("User " + userName + " was not found in the database");
//        }
//
//        System.out.println("Found User: " + appUser);
//
//        // [ROLE_USER, ROLE_ADMIN,..]
//        List<UserRole> userRoles = this.userRoleRepository.findByAppUser(appUser);
//
//        List<GrantedAuthority> grantList = new ArrayList<>();
//        if (userRoles != null) {
//            for (UserRole userRole : userRoles) {
//                // ROLE_USER, ROLE_ADMIN,..
//                GrantedAuthority authority = new SimpleGrantedAuthority(userRole.getAppRole().getRoleName());
//                grantList.add(authority);
//            }
//        }
//
//        return (UserDetails) new User(appUser.getUserName(), //
//                appUser.getEncrytedPassword(), grantList);
//    }
//
//    public List<AppRole> allAppRole() {
//        return this.appRoleRepository.findAll();
//    }
//
//    public List<AppUser> allAppUser() {
//        return this.appUserRepository.findAll();
//    }
//
//    public void saveNewUser(AppUser appUser) {
//        this.appUserRepository.save(appUser);
//    }
//
//    public void saveUserRole(AppUser appUser, Long id) {
//        this.userRoleRepository.save(new UserRole(appUser, this.appRoleRepository.findById(id).orElse(null)));
//    }
//}
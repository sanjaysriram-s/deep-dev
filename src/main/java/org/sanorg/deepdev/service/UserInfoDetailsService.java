package org.sanorg.deepdev.service;

import org.sanorg.deepdev.config.UserInfoUserDetails;
import org.sanorg.deepdev.entity.UserInfo;
import org.sanorg.deepdev.repo.UserInfoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserInfoDetailsService implements UserDetailsService {

    @Autowired
    private UserInfoRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserInfo> userInfo = repo.findByName(username);
        return userInfo.map(UserInfoUserDetails::new).orElseThrow(()-> new UsernameNotFoundException("User not found: "+username));
    }
}

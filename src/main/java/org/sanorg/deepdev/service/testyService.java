package org.sanorg.deepdev.service;

import org.sanorg.deepdev.entity.UserInfo;
import org.sanorg.deepdev.repo.UserInfoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class testyService {

    @Autowired
    private UserInfoRepo userRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public String addUser(UserInfo userInfo){
        userInfo.setPasswd(passwordEncoder.encode(userInfo.getPasswd()));
        userRepo.save(userInfo);
        return "User added successfully";
    }

}

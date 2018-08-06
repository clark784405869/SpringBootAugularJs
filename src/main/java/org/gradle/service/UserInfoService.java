package org.gradle.service;

import java.util.List;

import org.gradle.entity.Item;
import org.gradle.entity.UserInfo;
import org.springframework.data.jpa.repository.Query;



public interface UserInfoService {
	   
    /**通过username查找用户信息;*/
    public UserInfo findByUsername(String username);
    /**保存用户信息;*/
    public void userInfoSave(UserInfo userInfo);
   
    
    
}

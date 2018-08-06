package org.gradle.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.gradle.entity.Item;
import org.gradle.entity.UserInfo;
import org.gradle.repository.ItemRepository;
import org.gradle.repository.UserInfoRepository;
import org.gradle.service.UserInfoService;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl implements UserInfoService{
   
    @Resource
    private UserInfoRepository userInfoRepository;
    
    @Resource
    private ItemRepository itemRepository;
   
    public UserInfo findByUsername(String username) {
       System.out.println("UserInfoServiceImpl.findByUsername()");
       return userInfoRepository.findByUsername(username);
    }
    /**
     * 这里的save方法是CrudRepository默认提供的
     */
	public void userInfoSave(UserInfo userInfo) {
		System.out.println("UserInfoServiceImpl.UserInfoSave()");
		 userInfoRepository.save(userInfo);
	}
	
	
	
	
    
   
}

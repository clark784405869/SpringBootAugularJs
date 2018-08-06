package org.gradle.controller;


import org.gradle.entity.UserInfo;
import org.gradle.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/userInfo")
public class UserInfoController {
	@Autowired
    UserInfoService userInfoService;
    /**
     * 用户查询.使用自定义方法
     * @return
     */
    @RequestMapping(value="/user",method=RequestMethod.GET)
    public UserInfo userInfo(@RequestParam String username){
    	return userInfoService.findByUsername(username);
    }
   
    /**
     * 用户添加 使用系统自带方法;
     * @return
     */
    @RequestMapping(value="/user",method=RequestMethod.POST)
    public String userInfoAdd(@RequestBody UserInfo userInfo){
    	userInfoService.userInfoSave(userInfo);
       return "userInfoAdd";
    }
   
}
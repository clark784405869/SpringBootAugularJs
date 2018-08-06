package org.gradle.repository;


import org.gradle.entity.UserInfo;
import org.springframework.data.repository.CrudRepository;

/**
* UserInfo持久化类;
* @author 
* @version 
*/
public interface UserInfoRepository extends CrudRepository<UserInfo,Long>{
  
   /**通过username查找用户信息;*/
   public UserInfo findByUsername(String username);
  
}

package org.gradle.entity;


import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 * 用户信息.
 * @author Angel(QQ:412887952)
 * @version v.0.1
 */
@Entity
public class UserInfo implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id@GeneratedValue
    private long uid;//用户id;
   
   
    private String username;//名称（昵称或者真实姓名，不同系统不同定义）
   
    private String password; //密码;
   
    private byte state;//用户状态,0:创建未认证（比如没有激活，没有输入验证码等等）--等待验证的用户 , 1:正常状态,2：用户被锁定.
   
 
    public long getUid() {
       return uid;
    }
 
    public void setUid(long uid) {
       this.uid = uid;
    }

 
    public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getPassword() {
       return password;
    }
 
    public void setPassword(String password) {
       this.password = password;
    }
 
    
 
    public byte getState() {
       return state;
    }
 
    public void setState(byte state) {
       this.state = state;
    }
 
   
    @Override
    public String toString() {
       return "UserInfo [uid=" + uid + ", username=" + username + ", password=" + password
              + ", state=" + state + "]";
    }
 
   
}

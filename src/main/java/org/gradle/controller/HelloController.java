package org.gradle.controller;


import org.gradle.config.MyException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * 
 *测试Controller
 *@RestController 实现Rest服务的常用注解，相当于在@Controller的基础上，自动为将所有的请求方法追加@ResponseBody
 *实现以
 */
@RestController
@RequestMapping("/hello/")
public class HelloController {
	
	/**
	 * 该请求默认以rest方式返回hello gradle
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("hellogradle")
      public String testHello() throws Exception {
		throw new MyException();
		//return "hello gradle";
	}
	
	
	
}

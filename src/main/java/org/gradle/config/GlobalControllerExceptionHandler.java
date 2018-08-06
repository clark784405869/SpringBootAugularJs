package org.gradle.config;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class GlobalControllerExceptionHandler {
  @Autowired
  LocaleMessageUtil localeMessageUtil;
  // 异常处理方法：
  // 根据特定的异常返回指定的 HTTP 状态码
  @ResponseStatus(value=HttpStatus.BAD_REQUEST)  // 400
  @ExceptionHandler(MyException.class)
  @ResponseBody
  public RestServiceError handleValidationException(MyException ex) {
	    System.out.println("");
        return localeMessageUtil.getLocalErrorMessage(RestServiceError.Type.INTERNAL_SERVER_ERROR,"");
  }

  // 通用异常的处理，返回500
  @ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)  // 500
  @ExceptionHandler(Exception.class)
  @ResponseBody
  public RestServiceError handleException(Exception ex) {
        return localeMessageUtil.getLocalErrorMessage(RestServiceError.Type.INTERNAL_SERVER_ERROR,"");
  }
}
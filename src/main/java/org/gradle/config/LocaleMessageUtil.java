package org.gradle.config;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

@Component
public class LocaleMessageUtil {

    @Autowired
    private MessageSource messageSource;
    

    public RestServiceError getLocalErrorMessage(RestServiceError.Type errorCode, String description) {
        Locale locale = LocaleContextHolder.getLocale();
        String errorMessage = messageSource.getMessage("zhangpeng", null, locale);
        RestServiceError error = RestServiceError.build(errorCode, errorMessage, description);
        return error;
    }

}
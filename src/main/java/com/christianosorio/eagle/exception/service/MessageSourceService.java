package com.christianosorio.eagle.exception.service;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import static org.springframework.context.i18n.LocaleContextHolder.getLocale;

@Service
public class MessageSourceService {
    private final MessageSource messageSource;

    public MessageSourceService(final MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public String getMessage(final String messageCode, final Object... args) {
        return messageSource.getMessage(messageCode, args, messageCode, getLocale());
    }
}
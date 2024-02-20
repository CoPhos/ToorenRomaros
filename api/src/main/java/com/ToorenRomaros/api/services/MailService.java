package com.ToorenRomaros.api.services;

import javax.mail.MessagingException;

public interface MailService {
    void sendNewMail(String to, String subject, String body) throws MessagingException;
}

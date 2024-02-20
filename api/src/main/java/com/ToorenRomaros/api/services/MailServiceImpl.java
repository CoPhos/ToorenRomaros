package com.ToorenRomaros.api.services;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;

@Service
public class MailServiceImpl implements MailService{
    private final JavaMailSender javaMailSender;
    private final MimeMessageHelper mimeMessageHelper;

    public MailServiceImpl(JavaMailSender javaMailSender, MimeMessageHelper mimeMessageHelper) {
        this.javaMailSender = javaMailSender;
        this.mimeMessageHelper = mimeMessageHelper;
    }

    @Override
    public void sendNewMail(String to, String subject, String body) throws MessagingException {
        mimeMessageHelper.setTo(to);
        mimeMessageHelper.setSubject(subject);
        mimeMessageHelper.setText(body);
        javaMailSender.send(mimeMessageHelper.getMimeMessage());
    }
}

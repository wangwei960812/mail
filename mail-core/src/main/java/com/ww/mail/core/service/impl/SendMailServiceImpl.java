package com.ww.mail.core.service.impl;

import com.ww.mail.core.service.SendMailService;
import com.ww.mail.model.dto.req.SimpleMailMessageDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class SendMailServiceImpl implements SendMailService {

    @Resource
    private JavaMailSender javaMailSender;

    @Override
    public void send(SimpleMailMessageDTO simpleMailMessageDTO) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(simpleMailMessageDTO.getFrom());
        List<String> tos = simpleMailMessageDTO.getTo();
        String[] tosArr = new String[tos.size()];
        simpleMailMessage.setTo(tos.toArray(tosArr));
        simpleMailMessage.setSubject(simpleMailMessageDTO.getSubject());
        simpleMailMessage.setText(simpleMailMessageDTO.getText());
        javaMailSender.send(simpleMailMessage);
    }
}

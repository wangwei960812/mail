package com.ww.mail.core.service;


import com.ww.mail.model.dto.req.SimpleMailMessageDTO;

public interface SendMailService {
    void send(SimpleMailMessageDTO simpleMailMessageDTO);
}

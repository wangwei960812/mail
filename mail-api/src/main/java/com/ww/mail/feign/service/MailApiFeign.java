package com.ww.mail.feign.service;

import com.ww.mail.model.dto.req.SimpleMailMessageDTO;
import com.ww.model.vo.CommonResVO;
import feign.Headers;
import feign.RequestLine;

import javax.validation.Valid;

public interface MailApiFeign{

    @RequestLine("POST /v1/api/mail/send/simple")
    @Headers({"Content-Type:application/json"})
    CommonResVO sendMail(@Valid SimpleMailMessageDTO simpleMailMessageDTO);
}

package com.ww.mail.core.controller;

import com.alibaba.fastjson.JSONObject;
import com.ww.mail.api.MailApi;
import com.ww.mail.core.service.SendMailService;
import com.ww.model.constant.SystemErrConstant;
import com.ww.model.constant.SystemInfoConstant;
import com.ww.model.vo.CommonResVO;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Slf4j
@Api(value = "邮件发送接口", tags = {"邮件发送接口"})
@RestController
public class MailController implements MailApi {

    @Resource
    SendMailService sendMailService;

    @Override
    public CommonResVO sendMail(com.ww.mail.model.dto.req.@Valid SimpleMailMessageDTO simpleMailMessageDTO) {
        log.info("邮件发送请求信息：{}", JSONObject.toJSONString(simpleMailMessageDTO));
        try{
            sendMailService.send(simpleMailMessageDTO);
        }catch (Exception e){
            log.error("邮件发送请求失败：{}",e);
            e.printStackTrace();
            return CommonResVO.error(SystemErrConstant.MAIL_SEND_FAIL);
        }
        log.info("邮件发送请求成功");
        return CommonResVO.success(SystemInfoConstant.MAIL_SEND_SUCC);
    }
}

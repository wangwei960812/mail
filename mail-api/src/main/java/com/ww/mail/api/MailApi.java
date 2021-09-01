package com.ww.mail.api;

import com.ww.mail.model.dto.req.SimpleMailMessageDTO;
import com.ww.model.vo.CommonResVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

/**
 * @author ：黑洞里的光
 * @date ：Created in 2021/8/28 18:46
 * @description：对外api接口
 */
@RequestMapping(value = "/v1/api")
public interface MailApi {

    @PostMapping("/mail/send/simple")
    @ApiOperation(value = "简单邮件发送接口")
    CommonResVO sendMail(@RequestBody @Valid SimpleMailMessageDTO simpleMailMessageDTO);
}

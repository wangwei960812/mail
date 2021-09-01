package com.ww.mail.model.dto.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@ApiModel(value="邮件发送信息", description="用于发送邮件的基本信息：发送者、接受者、主题、内容")
public class SimpleMailMessageDTO {

    @ApiModelProperty(value = "邮件发送者",required = true)
    @NotBlank(message = "邮件发送者不能为空")
    @Email
    private String from;

    @ApiModelProperty(value = "邮件接收者",required = true)
    @NotEmpty(message = "邮件接收者不能为空")
    private List<@NotBlank @Email String> to;

    @ApiModelProperty(value = "邮件主题",required = true)
    @NotBlank(message = "邮件主题不能为空")
    private String subject;

    @ApiModelProperty(value = "邮件正文内容")
    private String text;
}

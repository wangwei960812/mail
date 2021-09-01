# mail
简单邮件系统

邮件系统分为两个模块：api和core
api为接口包，可以提供给第三方系统调用
core包为核心包，实现真正发邮件功能

swagger访问路径
http://127.0.0.1:9001/mail/swagger-ui.html

邮件相关配置可以配置在虚拟机参数中，样例如下：
-Dspring.mail.host=smtp.163.com -Dspring.mail.username=xxxxxx@163.com -Dspring.mail.password=xxxxx

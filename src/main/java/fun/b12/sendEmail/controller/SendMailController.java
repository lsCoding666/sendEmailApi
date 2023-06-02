package fun.b12.sendEmail.controller;

import fun.b12.sendEmail.bean.MailRequest;
import fun.b12.sendEmail.service.SendMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/send-mail")
//@Api(value = "发送邮件接口",tags = {"发送邮件接口"})
public class SendMailController {
    @Autowired
    private SendMailService sendMailService;

    @PostMapping("/simple")
    public void SendSimpleMessage(@RequestBody MailRequest mailRequest) {
        sendMailService.sendSimpleMail(mailRequest);
    }

    @PostMapping("/html")
    public void SendHtmlMessage(@RequestBody MailRequest mailRequest) { sendMailService.sendHtmlMail(mailRequest);}
}

1、 修改 application.properties 账户密码

2、调用方式
发送纯文本邮件通知
```agsl
curl --location --request POST 'http://xxxx:8080/send-mail/simple' --header 'Content-Type: application/json'  --data-raw '{"sendTo": "1076696990@qq.com","subject": "克莱茵微信机器人监控","text": "微信机器掉线了，正在尝试重启。等待 1 分钟后观察机器人状态。"}'
```

3、环境：java17

4、打包：mavan执行 package即可，可以在 target下找到 jar文件
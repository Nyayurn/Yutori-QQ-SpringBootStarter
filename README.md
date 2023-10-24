<div align="center">

# Yutori-QQ-SpringBootStarter

基于 [Satori](https://satori.js.org/zh-CN/) 协议和 [Yutori-QQ](https://github.com/Nyayurn/Yutori-QQ) 的 Java
[SpringBoot](https://spring.io/projects/spring-boot) QQ 机器人开发框架

<img src="https://img.shields.io/badge/JDK-17+-brightgreen.svg?style=flat-square" alt="jdk-version">

</div>

# 快速开始

1. 创建一个 SpringBoot 项目
2. 依赖引入
3. 基本配置
4. 进阶

## 依赖引入

### Maven

```xml
<dependencies>
    <dependency>
        <groupId>io.github.nyayurn</groupId>
        <artifactId>yutori-qq-spring-boot-starter</artifactId>
        <version>0.0.1</version>
    </dependency>
</dependencies>
```

## 第一个监听器

```java
@Component
public class TestListener implements MessageCreatedListener {
    @Override
    public void onMessageCreated(Bot bot, MessageCreatedEvent event, String msg) {
        if ("test".equals(msg)) {
            // 通过 bot 对象创建消息
            bot.getMessageApi().createMessage(event.getChannel().getId(), "test done!");
        }
    }
}
```

# 进阶

## 配置
application.yml:
```yaml
yutori:
  token: 114514
  platform: chronocat
  address: 127.0.0.1:5500
```

- 请参考 [Satori 文档](https://satori.js.org/zh-CN/protocol)
- 请参考 [Yutori-QQ 文档](https://github.com/Nyayurn/Yutori-QQ)
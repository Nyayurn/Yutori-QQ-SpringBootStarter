<div align="center">

# YurnQbotFramework-spring-boot-starter

基于 [Satori](https://satori.js.org/zh-CN/) 协议和 [YurnQbotFramework](https://github.com/Nyayurn/YurnQbotFramework) 的 Java
[SpringBoot](https://spring.io/projects/spring-boot) QQ 机器人开发框架

<img src="https://img.shields.io/badge/JDK-17+-brightgreen.svg?style=flat-square" alt="jdk-version">

</div>

# 快速开始

## 基础信息

> 提示: 本文档默认您了解并熟悉 Java 基本语法以及 SpringBoot 开发体系

## 项目创建

1. 首先创建一个空的 SpringBoot 项目(什么?不会?可以右上角关闭本页面了)
2. 依赖引入
3. 基本配置
4. 进阶

## 依赖引入

### Maven

```xml
<dependencies>
    <dependency>
        <groupId>com.yurn</groupId>
        <artifactId>YurnQbotFramework-spring-boot-starter</artifactId>
        <version>0.0.1-SNAPSHOT</version>
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
            bot.createMessage(event.getChannel(), "test done!");
        }
    }
}
```

# 进阶

- 请参考 [Satori 文档](https://satori.js.org/zh-CN/protocol)
- 源码含有 javadoc 方便阅读, 请自行阅读源码

/*
Copyright (c) 2023 Yurn
YurnQbotFramework-spring-boot-starter is licensed under Mulan PSL v2.
You can use this software according to the terms and conditions of the Mulan PSL v2.
You may obtain a copy of Mulan PSL v2 at:
         http://license.coscl.org.cn/MulanPSL2
THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND,
EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT,
MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
See the Mulan PSL v2 for more details.
 */

package com.yurn.satori.framework.qq.springboot.autoconfigure;

import com.yurn.satori.framework.qq.Boot;
import com.yurn.satori.framework.qq.listener.EventListenerContainer;
import com.yurn.satori.framework.qq.listener.message.created.GroupMessageCreatedListener;
import com.yurn.satori.framework.qq.listener.message.created.MessageCreatedListener;
import com.yurn.satori.framework.qq.listener.message.created.PrivateMessageCreatedListener;
import com.yurn.satori.framework.qq.listener.message.deleted.GroupMessageDeletedListener;
import com.yurn.satori.framework.qq.listener.message.deleted.MessageDeletedListener;
import com.yurn.satori.framework.qq.listener.message.deleted.PrivateMessageDeletedListener;
import com.yurn.satori.framework.qq.listener.user.FriendRequestListener;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.Nullable;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author Yurn
 */
@EnableAsync
@EnableConfigurationProperties(YurnSatoriProperties.class)
@Configuration
public class YurnQbotAutoConfiguration {
    @Bean
    public EventListenerContainer eventListenerContainer(
            @Nullable MessageCreatedListener[] messageCreatedListenerList,
            @Nullable PrivateMessageCreatedListener[] privateMessageCreatedListenerList,
            @Nullable GroupMessageCreatedListener[] groupMessageCreatedListenerList,
            @Nullable MessageDeletedListener[] messageDeletedListenerList,
            @Nullable PrivateMessageDeletedListener[] privateMessageDeletedListenerList,
            @Nullable GroupMessageDeletedListener[] groupMessageDeletedListenerList,
            @Nullable FriendRequestListener[] friendRequestListenerList) {
        var eventListenerContainer = new EventListenerContainer();
        eventListenerContainer.addOnMessageCreatedListener(messageCreatedListenerList);
        eventListenerContainer.addOnPrivateMessageCreatedListener(privateMessageCreatedListenerList);
        eventListenerContainer.addOnGroupMessageCreatedListener(groupMessageCreatedListenerList);
        eventListenerContainer.addOnMessageDeletedListener(messageDeletedListenerList);
        eventListenerContainer.addOnPrivateMessageDeletedListener(privateMessageDeletedListenerList);
        eventListenerContainer.addOnGroupMessageDeletedListener(groupMessageDeletedListenerList);
        eventListenerContainer.addOnFriendRequestListener(friendRequestListenerList);
        return eventListenerContainer;
    }

    @Bean
    public Boot boot(YurnSatoriProperties properties, EventListenerContainer eventListenerContainer) {
        Boot boot = new Boot(properties.getPlatform(), properties.getAddress(), properties.getToken(), eventListenerContainer);
        boot.run();
        return boot;
    }
}
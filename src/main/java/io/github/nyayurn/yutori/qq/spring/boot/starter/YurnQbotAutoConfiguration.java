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

package io.github.nyayurn.yutori.qq.spring.boot.starter;

import io.github.nyayurn.yutori.qq.Boot;
import io.github.nyayurn.yutori.qq.listener.EventListenerContainer;
import io.github.nyayurn.yutori.qq.listener.guild.GuildAddedListener;
import io.github.nyayurn.yutori.qq.listener.guild.GuildRemovedListener;
import io.github.nyayurn.yutori.qq.listener.guild.GuildRequestListener;
import io.github.nyayurn.yutori.qq.listener.guild.GuildUpdatedListener;
import io.github.nyayurn.yutori.qq.listener.guild.member.GuildMemberAddedListener;
import io.github.nyayurn.yutori.qq.listener.guild.member.GuildMemberRemovedListener;
import io.github.nyayurn.yutori.qq.listener.guild.member.GuildMemberRequestListener;
import io.github.nyayurn.yutori.qq.listener.guild.member.GuildMemberUpdatedListener;
import io.github.nyayurn.yutori.qq.listener.guild.role.GuildRoleCreatedListener;
import io.github.nyayurn.yutori.qq.listener.guild.role.GuildRoleDeletedListener;
import io.github.nyayurn.yutori.qq.listener.guild.role.GuildRoleUpdatedListener;
import io.github.nyayurn.yutori.qq.listener.login.LoginAddedListener;
import io.github.nyayurn.yutori.qq.listener.login.LoginRemovedListener;
import io.github.nyayurn.yutori.qq.listener.login.LoginUpdatedListener;
import io.github.nyayurn.yutori.qq.listener.message.created.GroupMessageCreatedListener;
import io.github.nyayurn.yutori.qq.listener.message.created.MessageCreatedListener;
import io.github.nyayurn.yutori.qq.listener.message.created.PrivateMessageCreatedListener;
import io.github.nyayurn.yutori.qq.listener.message.deleted.GroupMessageDeletedListener;
import io.github.nyayurn.yutori.qq.listener.message.deleted.MessageDeletedListener;
import io.github.nyayurn.yutori.qq.listener.message.deleted.PrivateMessageDeletedListener;
import io.github.nyayurn.yutori.qq.listener.user.FriendRequestListener;
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
            @Nullable GuildAddedListener[] guildAddedListeners,
            @Nullable GuildUpdatedListener[] guildUpdatedListeners,
            @Nullable GuildRemovedListener[] guildRemovedListeners,
            @Nullable GuildRequestListener[] guildRequestListeners,

            @Nullable GuildMemberAddedListener[] guildMemberAddedListeners,
            @Nullable GuildMemberUpdatedListener[] guildMemberUpdatedListeners,
            @Nullable GuildMemberRemovedListener[] guildMemberRemovedListeners,
            @Nullable GuildMemberRequestListener[] guildMemberRequestListeners,

            @Nullable GuildRoleCreatedListener[] guildRoleCreatedListeners,
            @Nullable GuildRoleUpdatedListener[] guildRoleUpdatedListeners,
            @Nullable GuildRoleDeletedListener[] guildRoleDeletedListeners,

            @Nullable LoginAddedListener[] loginAddedListeners,
            @Nullable LoginRemovedListener[] loginRemovedListeners,
            @Nullable LoginUpdatedListener[] loginUpdatedListeners,

            @Nullable MessageCreatedListener[] messageCreatedListeners,
            @Nullable PrivateMessageCreatedListener[] privateMessageCreatedListeners,
            @Nullable GroupMessageCreatedListener[] groupMessageCreatedListeners,

            @Nullable MessageDeletedListener[] messageDeletedListeners,
            @Nullable PrivateMessageDeletedListener[] privateMessageDeletedListeners,
            @Nullable GroupMessageDeletedListener[] groupMessageDeletedListeners,

            @Nullable FriendRequestListener[] friendRequestListeners) {
        var eventListenerContainer = new EventListenerContainer();
        eventListenerContainer.addOnGuildAddedListener(guildAddedListeners);
        eventListenerContainer.addOnGuildUpdatedListener(guildUpdatedListeners);
        eventListenerContainer.addOnGuildRemovedListener(guildRemovedListeners);
        eventListenerContainer.addOnGuildRequestListener(guildRequestListeners);

        eventListenerContainer.addOnGuildMemberAddedListener(guildMemberAddedListeners);
        eventListenerContainer.addOnGuildMemberUpdatedListener(guildMemberUpdatedListeners);
        eventListenerContainer.addOnGuildMemberRemovedListener(guildMemberRemovedListeners);
        eventListenerContainer.addOnGuildMemberRequestListener(guildMemberRequestListeners);

        eventListenerContainer.addOnGuildRoleCreatedListener(guildRoleCreatedListeners);
        eventListenerContainer.addOnGuildRoleUpdatedListener(guildRoleUpdatedListeners);
        eventListenerContainer.addOnGuildRoleDeletedListener(guildRoleDeletedListeners);

        eventListenerContainer.addOnLoginAddedListener(loginAddedListeners);
        eventListenerContainer.addOnLoginRemovedListener(loginRemovedListeners);
        eventListenerContainer.addOnLoginUpdatedListener(loginUpdatedListeners);

        eventListenerContainer.addOnMessageCreatedListener(messageCreatedListeners);
        eventListenerContainer.addOnPrivateMessageCreatedListener(privateMessageCreatedListeners);
        eventListenerContainer.addOnGroupMessageCreatedListener(groupMessageCreatedListeners);

        eventListenerContainer.addOnMessageDeletedListener(messageDeletedListeners);
        eventListenerContainer.addOnPrivateMessageDeletedListener(privateMessageDeletedListeners);
        eventListenerContainer.addOnGroupMessageDeletedListener(groupMessageDeletedListeners);

        eventListenerContainer.addOnFriendRequestListener(friendRequestListeners);
        return eventListenerContainer;
    }

    @Bean
    public Boot boot(YurnSatoriProperties properties, EventListenerContainer eventListenerContainer) {
        Boot boot = new Boot(properties.getPlatform(), properties.getAddress(), properties.getToken(), eventListenerContainer);
        boot.run();
        return boot;
    }
}
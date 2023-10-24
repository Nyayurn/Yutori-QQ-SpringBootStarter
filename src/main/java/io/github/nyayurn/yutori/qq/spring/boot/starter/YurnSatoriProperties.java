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

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Yurn
 */
@Data
@ConfigurationProperties(prefix = "yutori")
public class YurnSatoriProperties {
    /**
     * 机器人的平台
     */
    private String platform = "chronocat";

    /**
     * SDK 的地址
     */
    private String address = "127.0.0.1:5500";

    /**
     * Token
     */
    private String token;
}

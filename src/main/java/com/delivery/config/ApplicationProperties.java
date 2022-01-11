package com.delivery.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = "application", ignoreUnknownFields = false)
public class ApplicationProperties {

    private NewPostApiProperties newPostApiProperties;

    @Getter
    @Setter
    public static class NewPostApiProperties {
        private String url;
        private String apiKey;
    }
}

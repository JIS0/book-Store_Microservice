package com.jisojoy.bookStore.catalog.config;

import jakarta.validation.constraints.Min;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.DefaultValue;

@ConfigurationProperties("app")
public record ApplicationConfig(
        @DefaultValue("10") @Min(1)
        int pageSize
        ){};

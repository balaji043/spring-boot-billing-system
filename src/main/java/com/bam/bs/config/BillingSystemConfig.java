package com.bam.bs.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;

@Configuration
@ConfigurationProperties(prefix = "bs")
@Getter
@Setter
public class BillingSystemConfig {
	private String jwtSecret;
	private int jwtExpirationMs;
}
package com.example;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Component
@ConfigurationProperties(prefix = "target")
// 2019.07.03 add. 
// see https://www.logicbig.com/tutorials/spring-framework/spring-boot/configuration-properties-validation.html 
@Validated
public class TargetProperties {
	@NotEmpty
	private String host;
	@Min(1)
	@Max(65535)
	private int port;
	
	public String getHost() { return this.host; }
	public void setHost(String host) { this.host = host; }
	public int getPort() { return this.port; }
	public void setPort(int port) { this.port = port; }
}

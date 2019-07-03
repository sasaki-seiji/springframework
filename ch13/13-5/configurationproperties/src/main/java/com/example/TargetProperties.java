package com.example;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "target")
public class TargetProperties {
	private String host;
	private int port;
	
	public String getHost() { return this.host; }
	public void setHost(String host) { this.host = host; }
	public int getPort() { return this.port; }
	public void setPort(int port) { this.port = port; }
}

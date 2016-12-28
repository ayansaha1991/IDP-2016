package com.ayan.config;

import java.sql.SQLException;

import org.h2.tools.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class H2Bean {

	@Bean(initMethod = "start", destroyMethod = "stop")
	public Server h2WebConsonleServer() throws SQLException {
		return org.h2.tools.Server.createWebServer("-web",
				"-webAllowOthers", "-webDaemon", "-webPort", "8082");
	}

}

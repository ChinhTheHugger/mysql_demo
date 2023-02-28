package com.test_mysql_connection.mysql_demo.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("com.test_mysql_connection.mysql_demo.*")
@EntityScan("com.test_mysql_connection.mysql_demo.*")
@ComponentScan("com.test_mysql_connection.mysql_demo")
public class SpringConfig {

}

package com.example.demo.technique

import org.springframework.boot.Banner
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.transaction.annotation.EnableTransactionManagement

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("com.example.demo.technique.repository")
@EntityScan("com.example.demo.technique.entities")
@SpringBootApplication
class Application

fun main(args: Array<String>) {

	runApplication<Application>(*args) {
		setBannerMode(Banner.Mode.OFF)
	}
}

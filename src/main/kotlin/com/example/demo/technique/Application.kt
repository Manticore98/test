package com.example.demo.technique

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.Banner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.jdbc.core.JdbcTemplate

@SpringBootApplication
class Application

fun main(args: Array<String>) {

	runApplication<Application>(*args) {
		setBannerMode(Banner.Mode.OFF)
	}
}

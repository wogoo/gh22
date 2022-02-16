package com.wogoo.starplanets.Planets

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableFeignClients
class PlanetsApplication

fun main(args: Array<String>) {
	runApplication<PlanetsApplication>(*args)
}
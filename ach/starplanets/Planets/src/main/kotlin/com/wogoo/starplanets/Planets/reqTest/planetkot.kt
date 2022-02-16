package com.wogoo.starplanets.Planets.reqTest

import com.wogoo.starplanets.Planets.model.Planeta
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable


@FeignClient(url = "https://swapi.dev/api/", name = "swapi")
interface planetkot {
    @GetMapping("planets/{id}/")
    fun getPlaneta(@PathVariable id: String): Planeta
}
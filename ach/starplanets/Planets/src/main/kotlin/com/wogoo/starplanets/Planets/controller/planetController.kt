package com.wogoo.starplanets.Planets.controller

import com.wogoo.starplanets.Planets.model.Planeta
import com.wogoo.starplanets.Planets.reqTest.PlanetService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class planetController(
    private val planetService: PlanetService
) {
    @GetMapping("planets/{id}/")
    fun  getPlanetExit(@PathVariable id: Int): ResponseEntity<Planeta>{
        val planeta: Planeta = planetService.buscaPlanetaPorId(id)
        return planeta.let { ResponseEntity.ok(it) }
    }
    @GetMapping("planets/")
    fun getAllPlanets(): ResponseEntity<List<Planeta>>{
        val planetas: List<Planeta> = planetService.buscaPlanetas()
        return planetas.let { ResponseEntity.ok(it.toList()) }
    }
}
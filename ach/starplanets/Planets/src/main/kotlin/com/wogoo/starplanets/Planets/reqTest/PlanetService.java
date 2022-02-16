package com.wogoo.starplanets.Planets.reqTest;

import com.wogoo.starplanets.Planets.model.Planeta;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(url= "https://swapi.dev/api/" , name = "viacep")
public interface PlanetService {
    @GetMapping("planets/{id}/")
    Planeta buscaPlanetaPorId(@PathVariable("id") Integer id);
    @GetMapping("planets/")
    List<Planeta> buscaPlanetas();
}

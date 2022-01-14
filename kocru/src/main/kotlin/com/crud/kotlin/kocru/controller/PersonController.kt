package com.crud.kotlin.kocru.controller

import com.crud.kotlin.kocru.controller.request.PostPersonRequest
import com.crud.kotlin.kocru.controller.request.PutPersonRequest
import com.crud.kotlin.kocru.controller.response.PeopleResponse
import com.crud.kotlin.kocru.extension.toPersonModel
import com.crud.kotlin.kocru.extension.toResponse
import com.crud.kotlin.kocru.repository.PersonRepository
import com.crud.kotlin.kocru.service.PersonService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("persons")
@CrossOrigin("*")
class PersonController(private val personService: PersonService, private val personRepository: PersonRepository) {

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun getPerson(@PathVariable id: Int): PeopleResponse {
        return personService.findById(id).toResponse()
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    fun getAll():List<PeopleResponse> {
        return personService.getAll().map {it.toResponse()}
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody person: PostPersonRequest) {
        personRepository.save(person.toPersonModel())
    }
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun update(@PathVariable id: Int, @RequestBody person: PutPersonRequest) {
        val personSaved = personService.findById(id)
        return personService.update(person.toPersonModel(personSaved))
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id:Int) {
        personService.delete(id)
    }
}
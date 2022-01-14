package com.crud.kotlin.kocru.service

import com.crud.kotlin.kocru.model.PersonModel
import com.crud.kotlin.kocru.repository.PersonRepository
import org.springframework.stereotype.Service

@Service
class PersonService(private val personRepository: PersonRepository) {

    fun findById(id: Int): PersonModel {
        return personRepository.findById(id).orElseThrow()
    }
    fun getAll(): List<PersonModel> {
        return personRepository.findAll().toList()
    }
    fun update(person: PersonModel) {
        personRepository.save(person)
    }
    fun delete(id: Int) {
        val person = findById(id)
        personRepository.delete(person)
    }
}

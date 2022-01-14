package com.crud.kotlin.kocru.repository

import com.crud.kotlin.kocru.model.PersonModel
import org.springframework.data.jpa.repository.JpaRepository

interface PersonRepository: JpaRepository<PersonModel, Int> {

}

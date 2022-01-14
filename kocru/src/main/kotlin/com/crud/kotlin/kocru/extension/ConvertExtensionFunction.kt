package com.crud.kotlin.kocru.extension

import com.crud.kotlin.kocru.controller.request.PostPersonRequest
import com.crud.kotlin.kocru.controller.request.PutPersonRequest
import com.crud.kotlin.kocru.controller.response.PeopleResponse
import com.crud.kotlin.kocru.model.PersonModel

fun PersonModel.toResponse(): PeopleResponse {
    return PeopleResponse(
        id = this.id,
        name = this.name,
        city = this.city
    )
}

fun PutPersonRequest.toPersonModel(previousPerson: PersonModel): PersonModel {
    return PersonModel(id = previousPerson.id, name = this.name, city = this.city)
}

fun PostPersonRequest.toPersonModel(): PersonModel {
    return PersonModel(name = this.name, city = this.city)
}
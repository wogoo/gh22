package com.wogoo.starplanets.Planets.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity(name = "planets")
data class Planeta (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,
    @Column
    val name: String,
    @Column
    val terrain: String,
    @Column
    val population: String,
    @Column
    val climate: String
//    @Column
//    val films: Int? = null
        )
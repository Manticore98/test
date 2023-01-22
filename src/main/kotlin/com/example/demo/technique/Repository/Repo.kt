package com.example.demo.technique.Repository

import com.example.demo.technique.dataclasses.Question
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import org.springframework.stereotype.Service

@Repository
interface Repo:CrudRepository<Question,Long> {
    fun findByTitle(title: String): Iterable<Question>
}
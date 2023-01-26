package com.example.demo.technique.Repository

import com.example.demo.technique.Entities.Question
import org.springframework.data.repository.CrudRepository

interface QuestionRepo: CrudRepository<Question,String> {
    fun findQuestions(): List<Question> = findAll().toList()
}
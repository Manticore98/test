package com.example.demo.technique.repository

import com.example.demo.technique.entities.Question
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository

interface QuestionRepo: JpaRepository<Question,Long> {
}
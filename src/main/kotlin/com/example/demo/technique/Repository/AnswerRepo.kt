package com.example.demo.technique.Repository

import com.example.demo.technique.Entities.Answer
import org.springframework.data.repository.CrudRepository

interface AnswerRepo:CrudRepository<Answer,String>
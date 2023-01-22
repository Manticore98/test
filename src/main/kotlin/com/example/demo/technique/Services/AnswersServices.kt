package com.example.demo.technique.Services

import com.example.demo.technique.dataclasses.Question
import com.example.smarttesthiring.domain.Answer
import org.springframework.jdbc.core.JdbcTemplate

class AnswersServices(val db: JdbcTemplate) {
    fun findAnswers(): List<Answer> = db.query("select * from answers") { response, _ ->
        Answer(response.getString("body"), response.getString("channel"))
    }
    fun save(answer: Answer){
        db.update("insert into questions (title,promoted) values ( ?, ? )",
            answer.body, answer.channel)
    }
}
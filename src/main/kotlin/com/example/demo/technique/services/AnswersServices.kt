package com.example.demo.technique.services

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Service

@Service
class AnswersServices @Autowired constructor(val jdbcTemplate: JdbcTemplate) {

    fun creat(){
        jdbcTemplate.execute("create table if not exists answers (" + "anid Serial  PRIMARY KEY ," +
                "body varchar(500)  ," +
                " channel varchar );")
    }
    /*fun findAnswers(): List<Answer> = jdbcTemplate.query("select (body,channel) from answers") { response, _ ->
        Answer(response.getString("body"), response.getString("channel"))
    }*/
    //fun findAnswers(): List<Answer> = answerRepo.findAll().toList()

    /*fun save(answer: Answer){
        jdbcTemplate.update("insert into answers (body,channel) values ( ? ,?)",
           answer.body, answer.channel)
    }*/
}
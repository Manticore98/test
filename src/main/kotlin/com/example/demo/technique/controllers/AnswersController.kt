package com.example.demo.technique.controllers

import com.example.demo.technique.Services.AnswersServices
import com.example.demo.technique.Services.QuestionsServices
import com.example.demo.technique.dataclasses.Question
import com.example.smarttesthiring.domain.Answer
import com.example.smarttesthiring.domain.Channel
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import java.io.IOException

class AnswersController(val service: AnswersServices) {
    @GetMapping("/answers/{body}")
    fun bodytest(@PathVariable("body") body : String, answer: Answer): String {
        if(body.isEmpty()){
            throw IOException("body required")
        }else{
            if (body.length>500){
                throw IOException("500 character max")
            }else
               answer.body=body
        }
        return answer.body
    }
    @GetMapping("/answers/{channel}")
    fun channeltest(@PathVariable("channel") chan : String, answer: Answer): String {
        if(chan==null){
            throw IOException("channel required")
        }else{
            if (chan != "faq" || chan != "bot"){
                throw IOException("Doesn t Match with requirement")
        }
            post(answer)
        }
        return answer.body
    }
    @PostMapping("/")
    fun post(@RequestBody answer: Answer) {
        service.save(answer)
    }
    @GetMapping("/answers/aff")
    fun index(): List<Answer> = service.findAnswers()
}
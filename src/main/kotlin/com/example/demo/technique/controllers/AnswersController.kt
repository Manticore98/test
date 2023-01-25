package com.example.demo.technique.controllers

import com.example.demo.technique.Services.AnswersServices
import com.example.demo.technique.Entities.Answer
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class AnswersController(val service: AnswersServices) {
    @GetMapping("/answers/{body}/{channel}")
    fun bodytest(@PathVariable("body") body : String,@PathVariable("channel") chan : String, answer: Answer): String {
        if(body.isEmpty() || body.length>500){
            throw IllegalStateException("body is missing or dosnt match with reauirements 500 charcters al least")
        }else{
            if(chan!=null){
                if(chan=="Faq" || chan=="Bot"){
                    creat()
                    post(answer)
                }else{
                    throw IllegalStateException("Doesn t match with requirements or null")}
            }

        }
        return "Done"
    }
    /*@GetMapping("/answers/{channel}")
    fun channeltest(, answer: Answer): String {
        if(chan==null){
            throw IOException("channel required")
        }else{
            if (chan != "faq" || chan != "bot"){
                throw IOException("Doesn t Match with requirement")
        }
            post(answer)
        }
        return answer.body
    }*/
    @PostMapping("/answers")
    fun post(@RequestBody answer: Answer) {
        service.save(answer)
    }
    fun creat() {
        service.creat()
    }
    @GetMapping("/answers/aff")
    fun index(): List<Answer> = service.findAnswers()
}
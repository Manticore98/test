package com.example.demo.technique.controllers

import com.example.demo.technique.Services.QuestionsServices
import com.example.demo.technique.dataclasses.Question
import com.example.demo.technique.Repository.Repo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.io.IOException

@RestController
class QuestionsController(val service: QuestionsServices) {
   /* @Autowired
    lateinit var repository: Repo*/

    @GetMapping("/questions/{title}")
    fun blog(@PathVariable("title") title : String,question: Question): String {
        if(title.isEmpty()){
            throw IOException("Title required")
        }else{
            if (title.length>100){
                throw IOException("100 character max")
            }else{
                if(question.status!=("Draft") || question.status!=("Published")){
                    throw IOException("Doesn t match with requirement")
                }
            }
            post(question)
        }
        return question.title
    }
    @PostMapping("/")
    fun post(@RequestBody question: Question) {
        service.save(question)
    }
    @GetMapping("/questions/aff")
    fun index(): List<Question> = service.findQuestions()
   /* @RequestMapping("/save")
    fun save(): String {
        repository.save(Question("Q1"))
        repository.save(Question("Q2"))
        return "Done"
    }
    @RequestMapping("/find/{title}")
    fun findByTtile(@PathVariable title: String)
            = repository.findByTitle(title)*/
}
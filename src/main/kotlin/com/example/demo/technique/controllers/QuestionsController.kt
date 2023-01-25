package com.example.demo.technique.controllers

import com.example.demo.technique.Services.QuestionsServices
import com.example.demo.technique.Entities.Question
import org.springframework.web.bind.annotation.*
import java.io.IOException
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@RestController
class QuestionsController(val service: QuestionsServices) {
   /* @Autowired
    lateinit var repository: Repo*/

    @GetMapping("/question/creat/{title}")
    fun blog(@PathVariable("title") title : String,question: Question): String {
        creat();
        if(title.isEmpty()){
            throw IllegalStateException("Title required")
        }else{
            if (title.length>100){
                throw IOException("100 character max")
            }else{
                if(question.status=="Draft" || question.status=="Published"){
                    post(question)
                }else{
                    throw IllegalStateException("Doesn t match with requirement")
                }
            }

        }
        return question.title
    }
    @PostMapping("/questions")
    fun post(@RequestBody question: Question) {
        service.save(question)
    }

    @GetMapping("/questions/update/{title}/{status}/{newtitle}/{newstat}")
    fun updatequestion(@PathVariable("title") title: String,@PathVariable("status") status:String,@PathVariable("newtitle") newtitle:String,@PathVariable("newstat") newstat:String): String {

        service.savehisto(title,status)
        service.updatequestion(title,status,newtitle,newstat)
        return "Done"
    }

    @PostMapping("/question/creat")
    fun creat() {
        service.creat()
    }


    @GetMapping("/questions/aff")
    fun index(): List<Question> = service.findQuestions()
   /* @RequestMapping("/save")
    fun save(): String {
        repository.save(Question("Q1"))
        repository.save(Question("Q2"))
        return "Done"
    }*/
}

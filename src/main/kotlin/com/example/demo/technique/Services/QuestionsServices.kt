package com.example.demo.technique.Services
import com.example.demo.technique.dataclasses.Question
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Service

@Service
class QuestionsServices (val db: JdbcTemplate){
    fun findQuestions(): List<Question> = db.query("select * from questions") { response, _ ->
        Question(response.getString("title"), response.getBoolean("promoted"),response.getString("Answer") ,response.getString("status"))
    }
    fun save(question: Question){
        db.update("insert into questions (title,promoted) values ( ?, ? )",
            question.title, question.promoted)
    }
    fun updatequestion(question: Question,titre:String,status:String){
        db.update("update questions set title=$titre,status=$status where title==$titre")
    }

}
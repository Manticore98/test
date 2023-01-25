package com.example.demo.technique.Services
import com.example.demo.technique.Repository.QuestionRepo
import com.example.demo.technique.Entities.Question
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Service
import java.sql.Timestamp
import java.time.LocalDate
import java.util.Date
import java.util.TimeZone

@Service
class QuestionsServices (val db: JdbcTemplate,val bdd: QuestionRepo){
    @Autowired
    lateinit var jdbcTemplate: JdbcTemplate
    fun creat(){
        jdbcTemplate.execute("create table if not exists questions (" +"qid Serial  PRIMARY KEY ,"+ "title VARCHAR(100) ," +
                "promoted boolean ," +
                "status varchar,"+
                " created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP ," +
                " updated_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP );")
    }
    fun creatHisto(){
        jdbcTemplate.execute("create table if not exists histoquestions(qid Serial Primary Key,"+"title Varchar(100),"+"status varchar);")
    }
    /*fun findQuestions(): List<Question> = db.query("select * from questions") { response, _ ->
        Question(response.getInt("qid"),response.getString("title"), response.getBoolean("promoted"),response.getString("Crea") ,response.getString("status"))
    }*/
    fun findQuestions(): List<Question> = bdd.findAll().toList()
    fun save(question: Question){
        db.update("insert into questions (title,promoted) values ( ?, ? )",
            question.title, question.promoted)
    }
    fun savehisto(title:String, status: String){
        db.update("insert into histoquestions (title,status) values ( ?, ? )",
            title, status)
    }
    fun updatequestion(titre:String,status:String,newtitle:String,newstat:String){
        db.update("update questions set title=?,status=? where title=?",newtitle,newstat,titre)
    }

}
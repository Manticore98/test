package com.example.demo.technique.services
import com.example.demo.technique.dto.QuestionDto
import com.example.demo.technique.repository.QuestionRepo
import com.example.demo.technique.entities.Question
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Service

@Service
class QuestionsServices @Autowired constructor(val jdbcTemplate: JdbcTemplate, val questionRepo: QuestionRepo){

    fun creat(){
        jdbcTemplate.execute("create table if not exists question (" +"qid Serial  PRIMARY KEY ,"+ "title VARCHAR(100) ," +
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
    fun findQuestions(): List<Question> = questionRepo.findAll().toList()
    fun save(questionDto: QuestionDto){
        val question : Question = Question() ;

        question.title = questionDto.title;
        this.questionRepo.save(question);
    }
    fun savehisto(title:String, status: String){
        jdbcTemplate.update("insert into histoquestions (title,status) values ( ?, ? )",
            title, status)
    }
    fun updatequestion(titre:String,status:String,newtitle:String,newstat:String){
        jdbcTemplate.update("update questions set title=?,status=? where title=?",newtitle,newstat,titre)
    }

}
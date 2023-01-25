package com.example.demo.technique.Entities
import org.springframework.data.relational.core.mapping.Table
import java.io.Serial

@Table("answers")
data class Answer (var anid:Int?, var body : String, var channel: String) {

}
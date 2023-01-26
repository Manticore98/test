package com.example.demo.technique.entities


import java.util.Date
import jakarta.persistence.*


@Entity
class Question (){

    @Id
    @GeneratedValue(strategy = GenerationType. IDENTITY)
    var qid:Long? = null
    lateinit var title:String
    var promoted:Boolean = false
    var status:String="Draft"
    lateinit var created_at : Date
    lateinit var updated_at: Date

}



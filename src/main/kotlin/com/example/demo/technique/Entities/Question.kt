package com.example.demo.technique.Entities

import org.springframework.data.relational.core.mapping.Table
import java.util.Date
import java.util.TimeZone


@Table("questions")
class Question(){
    var qid:Int? = null
    lateinit var title:String
    var promoted:Boolean = false
    var status:String="Draft"
    lateinit var created_at : Date
    lateinit var updated_at: Date
    constructor(qid:Int,title:String,promoted:Boolean,status: String) : this() {
        this.qid=qid
        this.title=title
        this.promoted=promoted
        this.status=status
    }

}



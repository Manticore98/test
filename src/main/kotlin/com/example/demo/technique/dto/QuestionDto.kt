package com.example.demo.technique.dto

import java.util.*

class QuestionDto {

    var qid:Long? = null
    lateinit var title:String
    var promoted:Boolean = false
    var status:String="Draft"
    lateinit var created_at : Date
    lateinit var updated_at: Date

    constructor(qid: Long?, title: String, promoted: Boolean, status: String, created_at: Date, updated_at: Date) {
        this.qid = qid
        this.title = title
        this.promoted = promoted
        this.status = status
        this.created_at = created_at
        this.updated_at = updated_at
    }
}
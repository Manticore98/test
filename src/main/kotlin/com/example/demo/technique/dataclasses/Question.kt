package com.example.demo.technique.dataclasses

import com.example.smarttesthiring.domain.Answer
import com.example.smarttesthiring.domain.Status
import java.util.Date


class Question(var title: String, var promoted: Boolean =true, var answer :String, var status: String) {
    lateinit var createdAt :Date
    lateinit var updatedAt : Date
}
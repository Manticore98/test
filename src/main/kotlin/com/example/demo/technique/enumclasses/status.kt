package com.example.smarttesthiring.domain

enum class Status(val isok:Boolean =true) {
    Draft(isok = false),
    Publish(isok= false);
}
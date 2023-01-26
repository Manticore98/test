package com.example.demo.technique.entities

 class HistoQuestion(){
    var id:Int? = null
    lateinit var title:String
    var status:String="Draft"
    constructor(id:Int,title:String,promoted:Boolean,status: String) : this() {
        this.id=id
        this.title=title
        this.status=status
    }
}

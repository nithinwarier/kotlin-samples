package com.androidians.showlist

class User {
    var name: String = ""
    var email: String = ""
    var age: Int = 0

    constructor()

    constructor(name: String, email: String, age: Int) {
        this.name = name
        this.email = email
        this.age = age
    }
}
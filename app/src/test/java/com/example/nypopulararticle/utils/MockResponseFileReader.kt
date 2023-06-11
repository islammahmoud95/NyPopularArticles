package com.example.nypopulararticle.utils

import java.io.InputStreamReader

/*
Created by 
Islam Ibrahim
islam.mahmoud116@gmail.com
*/
class MockResponseFileReader(path: String) {
    val content: String

    init {
        val reader = InputStreamReader(this.javaClass.classLoader?.getResourceAsStream(path))
        content = reader.readText()
        reader.close()
    }
}
package com.example.nypopulararticle.domain.exceptions

/*
Created by 
Islam Ibrahim
islam.mahmoud116@gmail.com
*/
class GeneralException(msg: String = "method not found") : Throwable(msg)
class ApiException(var exceptionMsg: String? = "", var statusCode: Int = 0, var data:Any?=null) :
    Throwable(exceptionMsg)
package com.example.note

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class tuturial :AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val flow = flow<String> {
            for (i in 1..10 ){
                emit("hello")
                delay(1000L)
        }
        }

        GlobalScope.launch {
            flow.collect{

                println(it)
                delay(2000L)


            }
        }
    }


}
package com.chillcoding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View

class QuizActivity1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz1)

        val questionList = QuestionValues.getQuestion()
        Log.i("Nombre de questions","${questionList.size}")
    }
    fun goodAnswer(view : View){
        val intent = Intent (this,QuizActivity1 :: class.java)
        startActivity(intent)
        var score: Int = 0
        score += 1

    }
    fun wrongAnswer(view : View){
        val intent = Intent (this,QuizActivity1 :: class.java)
        startActivity(intent)
    }
}
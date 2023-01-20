package com.chillcoding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class QuizActivity1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz1)

        val questionList = QuestionValues.getQuestion()
        Log.i("Nombre de questions","${questionList.size}")
    }
}
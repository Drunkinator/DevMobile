package com.example.helloworld


import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

private lateinit var trueButton: Button
private lateinit var falseButton: Button
private lateinit var nextButton: Button
private lateinit var questionTextView: TextView

private val questionBank= listOf(
    Question(R.string.question1, false),
    Question(R.string.question2, true),
    Question(R.string.question3, true),
    Question(R.string.question4, true),
    Question(R.string.question5, false),
    Question(R.string.question6, true))
private var currentIndex = 0

private fun updateQuestion() {
    val questionTextResId = questionBank[currentIndex].questionResId
    questionTextView.setText(questionTextResId)
}


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i(MainActivity::class.simpleName,
            getString(R.string.text_oncreate))
        trueButton = findViewById(R.id.true_button)
        falseButton = findViewById(R.id.false_button)
        nextButton = findViewById(R.id.next_button)
        questionTextView = findViewById(R.id.question_text_view)


        fun checkAnswer(userAnswer: Boolean) {
            val correctAnswer = questionBank[currentIndex].correctAnswer
            val messageResId = if (userAnswer == correctAnswer) {
                "Bonne réponse"
            } else {
                "Mauvaise réponse"
            }
            Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show()
        }
        trueButton.setOnClickListener { view: View ->
            checkAnswer(true)

        }
        falseButton.setOnClickListener { view: View ->
            checkAnswer(false)


        }
        val questionTextResId = questionBank[currentIndex].questionResId
        questionTextView.setText(questionTextResId)
        nextButton.setOnClickListener {
            currentIndex = (currentIndex + 1) % questionBank.size
            val questionTextResId = questionBank[currentIndex].questionResId
            questionTextView.setText(questionTextResId)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.i(MainActivity::class.simpleName,
            getString(R.string.text_onstart))
    }

    override fun onResume() {
        super.onResume()
        Log.i(MainActivity::class.simpleName,
            getString(R.string.text_onresume))
    }

    override fun onPause() {
        super.onPause()
        Log.i(MainActivity::class.simpleName,
            getString(R.string.text_onpause))
    }

    override fun onRestart() {
        super.onRestart()
        Log.i(MainActivity::class.simpleName,
            getString(R.string.text_onrestart))
    }

    override fun onStop() {
        super.onStop()
        Log.i(MainActivity::class.simpleName,
            getString(R.string.text_onstop))
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(MainActivity::class.simpleName,
            getString(R.string.text_ondestroy))
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.activity_main_menu, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val intent = intent
        when (item.itemId){
            R.id.menu_quit -> finish()

            R.id.menu_score -> Toast.makeText(this,"No score yet",Toast.LENGTH_SHORT).show()

            R.id.menu_restart -> {  val questionTextResId = questionBank[0].questionResId
                                    questionTextView.setText(questionTextResId)
            }
        }
        return super.onOptionsItemSelected(item)
}
}

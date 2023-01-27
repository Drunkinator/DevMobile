package com.example.helloworld


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

private lateinit var trueButton: Button
private lateinit var falseButton: Button
private lateinit var nextButton: Button
private lateinit var questionTextView: TextView
private lateinit var answerTextView: TextView
private val questionBank= listOf(
    Question(R.string.question1, false),
    Question(R.string.question2, true),
    Question(R.string.question3, true),
    Question(R.string.question4, true),
    Question(R.string.question5, false),
    Question(R.string.question6, true))

private val answerBank= listOf(
    Answer(R.string.answer1),
    Answer(R.string.answer2),
    Answer(R.string.answer3),
    Answer(R.string.answer4),
    Answer(R.string.answer5),
    Answer(R.string.answer6))
private var currentIndex = 0
private var currentIndex2 = 0

private fun updateQuestion() {
    val questionTextResId = questionBank[currentIndex].questionResId
    questionTextView.setText(questionTextResId)
}
private fun updateAnswer() {
    val answerTextResId = answerBank[currentIndex2].answerResId
    answerTextView.setText(answerTextResId)
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
        answerTextView = findViewById(R.id.answerTextView)
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
        val answerTextResId = answerBank[currentIndex2].answerResId
        questionTextView.setText(questionTextResId)
        answerTextView.setText(answerTextResId)
        nextButton.setOnClickListener {
            currentIndex = (currentIndex + 1) % questionBank.size
            val questionTextResId = questionBank[currentIndex].questionResId
            questionTextView.setText(questionTextResId)
            currentIndex2 = (currentIndex2 + 1) % answerBank.size
            val answerTextResId = answerBank[currentIndex2].answerResId
            answerTextView.setText(answerTextResId)
            answerTextView.visibility = View.INVISIBLE
        }
        answerTextView.visibility = View.INVISIBLE
        trueButton.setOnClickListener {
            checkAnswer(true)
            answerTextView.visibility = View.VISIBLE
        }
        answerTextView.visibility = View.INVISIBLE
        falseButton.setOnClickListener {
            checkAnswer(true)
            answerTextView.visibility = View.VISIBLE
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
}

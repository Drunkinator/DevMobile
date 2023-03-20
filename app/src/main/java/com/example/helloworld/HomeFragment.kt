package com.example.helloworld

import com.example.helloworld.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

lateinit var trueButton: Button
lateinit var falseButton: Button
lateinit var nextButton: Button
lateinit var questionTextView: TextView

class HomeFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null
    private val questionBank = listOf(
        Question(R.string.questionSport1, false),
        Question(R.string.questionSport2, true),
        Question(R.string.questionSport3, true),
        Question(R.string.questionSport4, true),
        Question(R.string.questionSport5, false),
        Question(R.string.questionSport6, true),
        Question(R.string.questionNature1, false),
        Question(R.string.questionNature2, true),
        Question(R.string.questionNature3, true),
        Question(R.string.questionNature4, true),
        Question(R.string.questionNature5, false),
        Question(R.string.questionNature6, true),
        Question(R.string.questionFood1, false),
        Question(R.string.questionFood2, true),
        Question(R.string.questionFood3, true),
        Question(R.string.questionFood4, true),
        Question(R.string.questionFood5, false),
        Question(R.string.questionFood6, true),
        Question(R.string.questionArt1, false),
        Question(R.string.questionArt2, true),
        Question(R.string.questionArt3, true),
        Question(R.string.questionArt4, true),
        Question(R.string.questionArt5, false),
        Question(R.string.questionArt6, true),
        Question(R.string.questionActuality1, false),
        Question(R.string.questionActuality2, true),
        Question(R.string.questionActuality3, true),
        Question(R.string.questionActuality4, true),
        Question(R.string.questionActuality5, false),
        Question(R.string.questionActuality6, true),
        Question(R.string.questionTek1, false),
        Question(R.string.questionTek2, true),
        Question(R.string.questionTek3, true),
        Question(R.string.questionTek4, true),
        Question(R.string.questionTek5, false),
        Question(R.string.questionTek6, true)

    )
    private var currentIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        trueButton = view.findViewById(R.id.true_button)
        falseButton = view.findViewById(R.id.false_button)
        nextButton = view.findViewById(R.id.next_button)
        questionTextView = view.findViewById(R.id.question_text_view)

        //TextView mName = (TextView)view.findViewById(R.id.myTextView);
        //    mName.setText(firstName + " " + lastName);
        //    return view;

        fun checkAnswer(userAnswer: Boolean) {
            val correctAnswer = questionBank[currentIndex].correctAnswer
            val messageResId = if (userAnswer == correctAnswer) {
                "Bonne réponse"
            } else {
                "Mauvaise réponse"
            }
            Toast.makeText(requireContext(), messageResId, Toast.LENGTH_SHORT).show()

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
        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }



}
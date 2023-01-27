package com.chillcoding

object QuestionValues {

    fun getQuestion() : ArrayList<Question>{

        val questionList = ArrayList<Question>()

        //1st Question
        val q1 = Question(1, R.string.text_question1,R.string.text_q1_op1,R.string.text_q1_op2,R.string.text_q1_op3,R.string.text_q1_op4 , 4 )
        questionList.add(q1)


        //2nd Question
        val q2 = Question(2, R.string.text_question2,R.string.text_q2_op1,R.string.text_q2_op2,R.string.text_q2_op3,R.string.text_q2_op4 , 3 )
        questionList.add(q2)

       /* //3rd Question
        val q3 = Question(3, R.string.text_question3,"5","6","7","8" , 3 )
        questionList.add(q3)

        //4th Question
        val q4 = Question(4, R.string.text_question4,"60","70","80","90" , 1 )
        questionList.add(q4)

        //5th Question
        val q5 = Question(5, R.string.text_question5,"4","5","6","7" , 2 )
        questionList.add(q5)*/


        return questionList
    }

}
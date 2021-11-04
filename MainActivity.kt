package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var resultTextView: TextView

    private var operand: Double = 0.0

    private var operation: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultTextView = findViewById(R.id.resultTextView)

    }

    fun numberClick(clickedView: View) {

        if (clickedView is TextView) {

            var result = resultTextView.text.toString()
            val number = clickedView.text.toString()

            if (result == "0"){

                result = ""

            }

            resultTextView.text = result + number

        }

    }

    fun operationClick(clickedView: View) {

        if (clickedView is TextView) {

            val result = resultTextView.text.toString()

            if (result.isNotEmpty()){
                operand = result.toDouble()
            }

            operation = clickedView.text.toString()

            resultTextView.text = ""


        }

    }

    fun equalsClick(clickedView: View) {

        val secOperandText = resultTextView.text.toString()
        var secOperand: Double = 0.0

        if (secOperandText.isNotEmpty()) {

            secOperand = secOperandText.toDouble()

        }

        when(operation) {

            "+" -> resultTextView.text = (operand + secOperand).toString()

            "-" -> resultTextView.text = (operand - secOperand).toString()

            "×" -> resultTextView.text = (operand * secOperand).toString()

            "÷" -> resultTextView.text = (operand / secOperand).toString()

            "%" -> resultTextView.text = (operand * secOperand / 100).toString()

            "C" -> resultTextView.text = ""

            "√" -> resultTextView.text = (Math.sqrt(operand)).toString()

            "." -> resultTextView.text = "."//წერტილი მუაშაობს ძალიან ცუდად,მაგრამ სულ ცარიელს  ეს ჯობია მეთქი

        }

    }

    fun deleteClick(clickedView: View) {
        val text = resultTextView.text.toString()
        if (text.isNotEmpty()) {
            resultTextView.text = text.dropLast(1)
        }
    }

}
package com.example.lab20

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setButtonListeners()
    }
    private fun setButtonListeners(){
        plus.setOnClickListener {
            val number1 = getNumber1()
            val number2 = getNumber2()
            if (number1 != null && number2 != null)
                result.text = (number1+number2).toString()
            else
                result.text = ""
        }
        minus.setOnClickListener {
            val number1 = getNumber1()
            val number2 = getNumber2()
            if (number1 != null && number2 != null)
                result.text = (number1-number2).toString()
            else
                result.text = ""
        }
        mult.setOnClickListener {
            val number1 = getNumber1()
            val number2 = getNumber2()
            if (number1 != null && number2 != null)
                result.text = (number1*number2).toString()
            else
                result.text = ""
        }
        div.setOnClickListener {
            val number1 = getNumber1()
            val number2 = getNumber2()
            if (number1 != null && number2 != null)
                if (number2 != 0f)
                    result.text = (number1/number2).toString()
                else
                    printMessage("Деление на ноль")
            else
                result.text = ""
        }
    }

    private fun getNumber1():Float?{
        val number1 = number1.text.toString().toFloatOrNull()
        if (number1 == null)
            printMessage("Вы не ввели первое число")
        return number1
    }

    private fun getNumber2():Float?{
        val number2 = number2.text.toString().toFloatOrNull()
        if (number2 == null)
            printMessage("Вы не ввели второе число")
        return number2
    }

    private fun printMessage(msg: String){
        Snackbar.make(result, msg, Snackbar.LENGTH_SHORT).show()
    }
}

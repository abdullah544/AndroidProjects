package com.example.calcpart1kotlin

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.lang.NumberFormatException

enum class State {
    NULL, PLUS, MINUS, DIVIDE, MULT, EQUAL, POW, SQRT
}

enum class Sign {
    PLUS, MINUS, DIVIDE, MULT, NONE, POW, SQRT
}

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var textScreen: TextView
    private lateinit var n0: Button
    private lateinit var n1: Button
    private lateinit var n2: Button
    private lateinit var n3: Button
    private lateinit var n4: Button
    private lateinit var n5: Button
    private lateinit var n6: Button
    private lateinit var n7: Button
    private lateinit var n8: Button
    private lateinit var n9: Button
    private lateinit var btnDot: Button
    private lateinit var equal: Button
    private lateinit var addit: Button
    private lateinit var subs: Button
    private lateinit var mult: Button
    private lateinit var div: Button
    private lateinit var power: Button
    private lateinit var half_power: Button
    private lateinit var deleteAll: Button
    private lateinit var btnDelete: Button

    var dot: Boolean = false
    var num1: Double = 0.0
    var num2: Double = 0.0
    private var oper: State = State.NULL
    var sign: Sign = Sign.NONE


    override fun onCreate(
        savedInstanceState: Bundle?
    ) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializeButtons()
        n0.setOnClickListener(this)
        n1.setOnClickListener(this)
        n2.setOnClickListener(this)
        n3.setOnClickListener(this)
        n4.setOnClickListener(this)
        n5.setOnClickListener(this)
        n6.setOnClickListener(this)
        n7.setOnClickListener(this)
        n8.setOnClickListener(this)
        n9.setOnClickListener(this)
        btnDot.setOnClickListener(this)
        equal.setOnClickListener(this)
        addit.setOnClickListener(this)
        subs.setOnClickListener(this)
        mult.setOnClickListener(this)
        div.setOnClickListener(this)
        power.setOnClickListener(this)
        half_power.setOnClickListener(this)
        deleteAll.setOnClickListener(this)
        btnDelete.setOnClickListener(this)
    }

    private fun initializeButtons() {
        textScreen = findViewById(R.id.textScreen)
        n0 = findViewById(R.id.zero)
        n1 = findViewById(R.id.one)
        n2 = findViewById(R.id.two)
        n3 = findViewById(R.id.three)
        n4 = findViewById(R.id.four)
        n5 = findViewById(R.id.five)
        n6 = findViewById(R.id.six)
        n7 = findViewById(R.id.seven)
        n8 = findViewById(R.id.eight)
        n9 = findViewById(R.id.nine)
        btnDot = findViewById(R.id.dot)
        equal = findViewById(R.id.equal)
        addit = findViewById(R.id.plus)
        subs = findViewById(R.id.minus)
        mult = findViewById(R.id.multiply)
        div = findViewById(R.id.divide)
        power = findViewById(R.id.power)
        half_power = findViewById(R.id.half_power)
        deleteAll = findViewById(R.id.clear)
        btnDelete = findViewById(R.id.delete)
    }

    override fun onClick(v: View?) {
        val id : Int = v!!.id
        when (id) {
            R.id.clear -> {
                textScreen.text = ""
                sign = Sign.NONE
                oper = State.NULL
                dot = false
                num1 = 0.0
                num2 = 0.0
            }
            R.id.delete -> {
                if (textScreen.text.toString() == "Infinity") {
                    textScreen.text = ""
                }
                when {
                    textScreen.text.toString().isEmpty() -> {
                        num1 = 0.0
                        num2 = 0.0
                    }
                    textScreen.text.toString().length != 1 -> {
                        try {
                            textScreen.text = textScreen.text.toString().substring(0, textScreen.text.toString().length - 1)
                            num1 = textScreen.text.toString().toDouble()
                        } catch (e : NumberFormatException) {
                            textScreen.text = ""
                        }
                    }
                    else -> textScreen.text = ""
                }
                if (textScreen.text.toString().contains("."))
                    dot = true
                else
                    dot
            } R.id.dot -> {
                if (textScreen.text.toString() == "Infinity") {
                textScreen.text = ""
                }
                if (textScreen.text.toString().contains("."))
                    dot = true
                if (!dot)
                    textScreen.append(".")
                dot = true;
            } R.id.one -> {
                if (textScreen.text.toString() == "Infinity") {
                    textScreen.text = ""
                }
                if (oper != State.NULL && oper != State.EQUAL) {
                    oper = State.NULL
                    textScreen.text = ""
                }
                textScreen.append("1")
            } R.id.two -> {
                if (textScreen.text.toString() == "Infinity") {
                    textScreen.text = ""
                }
                if (oper != State.NULL && oper != State.EQUAL) {
                    oper = State.NULL
                    textScreen.text = ""
                }
                textScreen.append("2")
            } R.id.three -> {
                if (textScreen.text.toString() == "Infinity") {
                    textScreen.text = ""
                }
                if (oper != State.NULL && oper != State.EQUAL) {
                    oper = State.NULL
                    textScreen.text = ""
                }
                textScreen.append("3")
            } R.id.four -> {
                if (textScreen.text.toString() == "Infinity") {
                    textScreen.text = ""
                }
                if (oper != State.NULL && oper != State.EQUAL) {
                    oper = State.NULL
                    textScreen.text = ""
                }
                textScreen.append("4")
            } R.id.five -> {
                if (textScreen.text.toString() == "Infinity") {
                    textScreen.text = ""
                }
                if (oper != State.NULL && oper != State.EQUAL) {
                    oper = State.NULL
                    textScreen.text = ""
                }
                textScreen.append("5")
            } R.id.six -> {
                if (textScreen.text.toString() == "Infinity") {
                    textScreen.text = ""
                }
                if (oper != State.NULL && oper != State.EQUAL) {
                    oper = State.NULL
                    textScreen.text = ""
                }
                textScreen.append("6")
            } R.id.seven -> {
                if (textScreen.text.toString() == "Infinity") {
                    textScreen.text = ""
                }
                if (oper != State.NULL && oper != State.EQUAL) {
                    oper = State.NULL
                    textScreen.text = ""
                }
                textScreen.append("7")
            } R.id.eight -> {
                if (textScreen.text.toString() == "Infinity") {
                    textScreen.text = ""
                }
                if (oper != State.NULL && oper != State.EQUAL) {
                    oper = State.NULL
                    textScreen.text = ""
                }
                textScreen.append("8")
            } R.id.nine -> {
                if (textScreen.text.toString() == "Infinity") {
                    textScreen.text = ""
                }
                if (oper != State.NULL && oper != State.EQUAL) {
                    oper = State.NULL
                    textScreen.text = ""
                }
                textScreen.append("9")
            } R.id.zero -> {
                if (textScreen.text.toString() == "Infinity") {
                    textScreen.text = ""
                }
                if (oper != State.NULL && oper != State.EQUAL) {
                    oper = State.NULL
                    textScreen.text = ""
                }
                if ((textScreen.text.toString().isEmpty() && !dot) || (textScreen.text.toString()[0] == '0' && !dot))
                    textScreen.text = "0"
                else
                    textScreen.append("0")
            }

            R.id.plus -> {
                oper = State.PLUS
                sign = Sign.PLUS
                if (textScreen.text.toString() == "Infinity") {
                    textScreen.text = ""
                }
                try {
                    num1 = textScreen.text.toString().toDouble()
                } catch (e : NumberFormatException) {
                    textScreen.text = ""
                }
                dot = false;
            } R.id.minus -> {
                oper = State.MINUS
                sign = Sign.MINUS
                if (textScreen.text.toString() == "Infinity") {
                    textScreen.text = ""
                }
                try {
                    num1 = textScreen.text.toString().toDouble()
                } catch (e : NumberFormatException) {
                    textScreen.text = ""
                }
                dot = false;
            } R.id.multiply -> {
                oper = State.MULT
                sign = Sign.MULT
                if (textScreen.text.toString() == "Infinity") {
                    textScreen.text = ""
                }
                try {
                    num1 = textScreen.text.toString().toDouble()
                } catch (e : NumberFormatException) {
                    textScreen.text = ""
                }
                dot = false;
            } R.id.divide -> {
                oper = State.DIVIDE
                sign = Sign.DIVIDE
                if (textScreen.text.toString() == "Infinity") {
                    textScreen.text = ""
                }
                try {
                    num1 = textScreen.text.toString().toDouble()
                } catch (e : NumberFormatException) {
                    textScreen.text = ""
                }
                dot = false;
            } R.id.half_power -> {
                oper = State.SQRT
                sign = Sign.SQRT
                if (textScreen.text.toString() =="Infinity"){
                    textScreen.text = ""
                }
                try {
                    num1 = textScreen.text.toString().toDouble()
                } catch (e: NumberFormatException){
                    textScreen.text = ""
                }
                if (textScreen.text.toString().isNotEmpty()){
                    textScreen.text = Math.sqrt(num1).toString()
                }
                dot = false
            } R.id.power -> {
                oper = State.POW
                sign = Sign.POW
                if (textScreen.text.toString().equals("Infinity")){
                    textScreen.text = ""
                }
                try {
                    num1 = textScreen.text.toString().toDouble()
                } catch (e: NumberFormatException){
                    textScreen.text = ""
                }
                if (textScreen.text.toString().length>0){
                    textScreen.text = Math.pow(num1, 2.0).toString()
                }
                dot = false
            }

            R.id.equal -> {
                if (textScreen.text.toString() == "Infinity") {
                    textScreen.text = ""
                }
                try {
                    num2 = textScreen.text.toString().toDouble()
                } catch (e : NumberFormatException) {
                    textScreen.text = ""
                }
                if (sign == Sign.PLUS)
                    textScreen.text = (num1 + num2).toString()
                else if (sign == Sign.MINUS)
                    textScreen.text = (num1 - num2).toString()
                else if (sign == Sign.MULT)
                    textScreen.text = (num1 * num2).toString()
                else if (sign == Sign.DIVIDE)
                    textScreen.text = (num1 / num2).toString()
                else if (sign == Sign.NONE)
                    textScreen.text = textScreen.text.toString()
                else
                    textScreen.text = "Infinity"
                oper = State.EQUAL
            }
        }
    }
}


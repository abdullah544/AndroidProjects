package com.example.calcpart2kotlin

import android.content.res.Configuration
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

enum class Sign {
    PLUS, MINUS, DIVIDE, MULTIPLY, NONE, POW, SQRT,
    SIN, COS, TAN, PERCENT, LN, LOG, FACT, N_POWER
}

enum class State {
    NULL, PLUS, MINUS, DIVIDE, MULTIPLY, EQUAL, POW, SQRT,
    SIN, COS, TAN, PERCENT, LN, LOG, FACT, N_POWER
}

class MainActivity : AppCompatActivity() , View.OnClickListener{

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
    private lateinit var btnequal: Button
    private lateinit var btnplus: Button
    private lateinit var btnminus: Button
    private lateinit var btnmultiply: Button
    private lateinit var btndivide: Button
    private lateinit var btnpower: Button
    private lateinit var btnn_power: Button
    private lateinit var btnhalf_power: Button
    private lateinit var clearAll: Button
    private lateinit var btndelete: Button

    private var btnfact: Button? = null
    private var btncos: Button? = null
    private var btnsin: Button? = null
    private var btntan: Button? = null
    private var btnln: Button? = null
    private var btnlog: Button? = null
    private var btnpercent: Button? = null

    private var  isDot = false
    private var num1 = 0.0
    private var num2 = 0.0
    private var temp = 0

    private var state: State = State.NULL
    private var sign: Sign = Sign.NONE

    var text: String? = null
    var text1: String? = null

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        num1 = savedInstanceState.getDouble("num1")
        num2 = savedInstanceState.getDouble("num2")
        isDot = savedInstanceState.getBoolean("dot")
        state = savedInstanceState.getSerializable("state") as State
        sign = savedInstanceState.getSerializable("sign") as Sign
        text = savedInstanceState.getString("textScreen")
        textScreen.text = text
        text1 = savedInstanceState.getString("txtView")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putDouble("num1", num1)
        outState.putDouble("num2", num2)
        outState.putBoolean("dot", isDot)
        outState.putSerializable("state", state)
        outState.putSerializable("sign", sign)
        outState.putString("textScreen", textScreen.text.toString())
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializeButtons()
        n0?.setOnClickListener(this)
        n1?.setOnClickListener(this)
        n2?.setOnClickListener(this)
        n3?.setOnClickListener(this)
        n4?.setOnClickListener(this)
        n5?.setOnClickListener(this)
        n6?.setOnClickListener(this)
        n7?.setOnClickListener(this)
        n8?.setOnClickListener(this)
        n9?.setOnClickListener(this)
        btnDot?.setOnClickListener(this)
        btnequal?.setOnClickListener(this)
        btnplus?.setOnClickListener(this)
        btnminus?.setOnClickListener(this)
        btnmultiply?.setOnClickListener(this)
        btndivide?.setOnClickListener(this)
        btndelete?.setOnClickListener(this)
        btnhalf_power?.setOnClickListener(this)
        btnpower?.setOnClickListener(this)
        btnn_power?.setOnClickListener(this)
        clearAll?.setOnClickListener(this)

        if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            btnfact?.setOnClickListener(this)
            btnpercent?.setOnClickListener(this)
            btncos?.setOnClickListener(this)
            btnsin?.setOnClickListener(this)
            btntan?.setOnClickListener(this)
            btnln?.setOnClickListener(this)
            btnlog?.setOnClickListener(this)
            btnpower?.setOnClickListener(this)
            btnn_power?.setOnClickListener(this)
        }
    }

    private fun initializeButtons(){
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
        btnequal = findViewById(R.id.equal)
        btnplus  = findViewById(R.id.plus)
        btnminus = findViewById(R.id.minus)
        btnmultiply = findViewById(R.id.multiply)
        btndivide = findViewById(R.id.divide)
        btndelete = findViewById(R.id.delete)
        btnhalf_power = findViewById(R.id.half_power)
        btnpower = findViewById(R.id.power)
        btnn_power = findViewById(R.id.power)
        clearAll  = findViewById(R.id.clear)

        btnfact = findViewById(R.id.fact)
        btnpercent = findViewById(R.id.percent)
        btnsin = findViewById(R.id.sin)
        btncos = findViewById(R.id.cos)
        btntan = findViewById(R.id.tan)
        btnln = findViewById(R.id.ln)
        btnlog = findViewById(R.id.log)
    }

    override fun onClick(v: View?) {
        val id : Int = v!!.id
        when(id){
            R.id.clear -> {
                textScreen.text= ""
                sign = Sign.NONE
                state = State.NULL
                isDot = false
                num1 = 0.0
                num2 = 0.0
            }
            R.id.delete -> {
                if (textScreen.text.toString().equals("Infinity")) {
                    textScreen.text = ""
                }
                if (textScreen.text.toString().length==0){
                    num1 = 0.0
                    num2 = 0.0
                } else if (textScreen.text.toString().length != 1){
                    try {
                        textScreen.text = textScreen.text.substring(0,textScreen.text.length-1)
                        num1 = textScreen.text.toString().toDouble()
                    } catch ( e : NumberFormatException){
                        textScreen.text = ""
                    }
                } else
                    textScreen.text = ""
                if (textScreen.text.toString().contains("."))
                    isDot = true
                else
                    isDot = false
            }
            R.id.dot -> {
                if (textScreen.text.toString().equals("Infinity")){
                    textScreen.text = ""
                }
                if (textScreen.text.toString().contains("."))
                    isDot = true
                if (isDot!=true)
                    textScreen.append(".")
                isDot = true
            }
            R.id.one -> {
                if (textScreen.text.toString().equals("Infinity")){
                    textScreen.text = ""
                }
                if (state != State.NULL && state!=State.EQUAL){
                    state = State.NULL
                    textScreen.text= ""
                }
                textScreen.append("1")
            }
            R.id.two -> {
                if (textScreen.text.toString().equals("Infinity")){
                    textScreen.text = ""
                }
                if (state != State.NULL && state!=State.EQUAL){
                    state = State.NULL
                    textScreen.text= ""
                }
                textScreen.append("2")
            }
            R.id.three -> {
                if (textScreen.text.toString().equals("Infinity")){
                    textScreen.text = ""
                }
                if (state != State.NULL && state!=State.EQUAL){
                    state = State.NULL
                    textScreen.text= ""
                }
                textScreen.append("3")
            }
            R.id.four -> {
                if (textScreen.text.toString().equals("Infinity")){
                    textScreen.text = ""
                }
                if (state != State.NULL && state!=State.EQUAL){
                    state = State.NULL
                    textScreen.text= ""
                }
                textScreen.append("4")
            }
            R.id.five -> {
                if (textScreen.text.toString().equals("Infinity")){
                    textScreen.text = ""
                }
                if (state != State.NULL && state!=State.EQUAL){
                    state = State.NULL
                    textScreen.text= ""
                }
                textScreen.append("5")
            }
            R.id.six -> {
                if (textScreen.text.toString().equals("Infinity")){
                    textScreen.text = ""
                }
                if (state != State.NULL && state!=State.EQUAL){
                    state = State.NULL
                    textScreen.text= ""
                }
                textScreen.append("6")
            }
            R.id.seven -> {
                if (textScreen.text.toString().equals("Infinity")){
                    textScreen.text = ""
                }
                if (state != State.NULL && state!=State.EQUAL){
                    state = State.NULL
                    textScreen.text= ""
                }
                textScreen.append("7")
            }
            R.id.eight -> {
                if (textScreen.text.toString().equals("Infinity")){
                    textScreen.text = ""
                }
                if (state != State.NULL && state!=State.EQUAL){
                    state = State.NULL
                    textScreen.text= ""
                }
                textScreen.append("8")
            }
            R.id.nine -> {
                if (textScreen.text.toString().equals("Infinity")){
                    textScreen.text = ""
                }
                if (state != State.NULL && state!=State.EQUAL){
                    state = State.NULL
                    textScreen.text= ""
                }
                textScreen.append("9")
            }
            R.id.zero -> {
                if (textScreen.text.toString().equals("Infinity")){
                    textScreen.text = ""
                }
                if (state != State.NULL && state!=State.EQUAL){
                    state = State.NULL
                    textScreen.text= ""
                }
                if ((textScreen.text.toString().length == 0 && isDot == false) ||
                    (textScreen.text.toString().get(0) == '0' && isDot == false))
                    textScreen.text="0"
                else
                    textScreen.append("0")

            }
            R.id.plus -> {
                state = State.PLUS
                sign = Sign.PLUS
                if (textScreen.text.toString().equals("Infinity")){
                    textScreen.text = ""
                }
                try {
                    num1 = textScreen.text.toString().toDouble()
                } catch (e: NumberFormatException){
                    textScreen.text = ""
                }
                isDot = false
            }
            R.id.minus -> {
                state = State.MINUS
                sign = Sign.MINUS
                if (textScreen.text.toString().equals("Infinity")){
                    textScreen.text = ""
                }
                try {
                    num1 = textScreen.text.toString().toDouble()
                } catch (e: NumberFormatException){
                    textScreen.text = ""
                }
                isDot = false
            }
            R.id.multiply -> {
                state = State.MULTIPLY
                sign = Sign.MULTIPLY
                if (textScreen.text.toString().equals("Infinity")){
                    textScreen.text = ""
                }
                try {
                    num1 = textScreen.text.toString().toDouble()
                } catch (e: NumberFormatException){
                    textScreen.text = ""
                }
                isDot = false
            }
            R.id.divide -> {
                state = State.DIVIDE
                sign = Sign.DIVIDE
                if (textScreen.text.toString().equals("Infinity")){
                    textScreen.text = ""
                }
                if (textScreen.text.toString().equals("")){
                    textScreen.text=""
                } else {
                    try {
                        num1 = textScreen.text.toString().toDouble()
                    } catch (e: NumberFormatException){
                        textScreen.text = "Infinity"
                    } }
                isDot = false
            }
            R.id.half_power -> {
                state = State.SQRT
                sign = Sign.SQRT
                if (textScreen.text.toString().equals("Infinity")){
                    textScreen.text = ""
                }
                try {
                    num1 = textScreen.text.toString().toDouble()
                } catch (e: NumberFormatException){
                    textScreen.text = ""
                }
                if (textScreen.text.toString().length>0){
                    textScreen.text = Math.sqrt(num1).toString()
                }
                isDot = false
            }
            R.id.power -> {
                state = State.POW
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
                isDot = false
            }
            R.id.sin -> {
                state = State.SIN
                sign = Sign.SIN
                if (textScreen.text.toString().equals("Infinity")){
                    textScreen.text= ""
                }
                try {
                    num1 = textScreen.text.toString().toDouble()
                } catch (e: java.lang.NumberFormatException) {
                    textScreen.text=""
                }
                if (!textScreen.text.toString().equals("Infinity")){
                    textScreen.text = Math.sin(num1).toString()
                }
                isDot=false
            }
            R.id.cos -> {
                state = State.COS
                sign = Sign.COS
                if (textScreen.text.toString().equals("Infinity")){
                    textScreen.text= ""
                }
                try {
                    num1 = textScreen.text.toString().toDouble()
                } catch (e: java.lang.NumberFormatException) {
                    textScreen.text=""
                }
                if (!textScreen.text.toString().equals("Infinity")){
                    textScreen.text = Math.cos(num1).toString()
                }
                isDot=false
            }
            R.id.tan -> {
                state = State.TAN
                sign = Sign.TAN
                if (textScreen.text.toString().equals("Infinity")){
                    textScreen.text= ""
                }
                try {
                    num1 = textScreen.text.toString().toDouble()
                } catch (e: java.lang.NumberFormatException) {
                    textScreen.text=""
                }
                if (!textScreen.text.toString().equals("Infinity")){
                    textScreen.text = Math.tan(num1).toString()
                }
                isDot=false
            }
            R.id.percent -> {
                state = State.PERCENT
                sign = Sign.PERCENT
                if (textScreen.text.toString().equals("Infinity")){
                    textScreen.text= ""
                }
                try {
                    num1 = textScreen.text.toString().toDouble()
                } catch (e: java.lang.NumberFormatException) {
                    textScreen.text=""
                }
                if (!textScreen.text.toString().equals("Infinity")){
                    textScreen.text = (num1*0.01).toString()
                }
                isDot=false
            }
            R.id.ln -> {
                state = State.LN
                sign = Sign.LN
                if (textScreen.text.toString().equals("Infinity")){
                    textScreen.text= ""
                }
                try {
                    num1 = textScreen.text.toString().toDouble()
                } catch (e: java.lang.NumberFormatException) {
                    textScreen.text=""
                }
                if (!textScreen.text.toString().equals("Infinity")){
                    textScreen.text = Math.log(num1).toString()
                }
                isDot=false
            }
            R.id.log -> {
                state = State.LOG
                sign = Sign.LOG
                if (textScreen.text.toString().equals("Infinity")){
                    textScreen.text= ""
                }
                try {
                    num1 = textScreen.text.toString().toDouble()
                } catch (e: java.lang.NumberFormatException) {
                    textScreen.text=""
                }
                if (!textScreen.text.toString().equals("Infinity")){
                    textScreen.text = Math.log10(num1).toString()
                }
                isDot=false
            }

            R.id.fact -> {
                state = State.FACT
                sign = Sign.FACT
                if (textScreen.text.toString().equals("Infinity")){
                    textScreen.text= ""
                }
                try {
                    num1 = textScreen.text.toString().toDouble()
                    temp = num1.toInt()
                } catch (e: java.lang.NumberFormatException) {
                    textScreen.text=""
                }
                if (temp<0 || temp>100) {
                    textScreen.text="Infinity"
                } else {
                    if (temp==0)
                    {temp=0} else{
                        var result = 1
                        var i =1
                        while (i<=temp){
                            result = result*i
                            i++
                        }
                        temp=result
                    }
                }
                if (!textScreen.text.toString().equals("Infinity")){
                    num1 = temp.toDouble()
                    textScreen.text= num1.toString()
                }
                isDot=false
            }

            R.id.n_power -> {
                state = State.N_POWER
                sign = Sign.N_POWER
                if (textScreen.text.toString().equals("Infinity")){
                    textScreen.text= ""
                }
                try {
                    num1 = textScreen.text.toString().toDouble()
                } catch (e: java.lang.NumberFormatException) {
                    textScreen.text=""
                }
                isDot=false
            }

            R.id.equal -> {
                if (textScreen.text.toString().equals("Infinity")) {
                    textScreen.text = ""
                }
                try {
                    num2 = textScreen.text.toString().toDouble()
                } catch (e : NumberFormatException){
                    textScreen.text = ""
                }
                if (sign == Sign.PLUS)
                    textScreen.text = (num1+num2).toString()
                else if (sign == Sign.MINUS)
                    textScreen.text= (num1-num2).toString()
                else if (sign == Sign.MULTIPLY)
                    textScreen.text= (num1*num2).toString()
                else if (sign == Sign.DIVIDE)
                    textScreen.text= (num1/num2).toString()
                else if (sign == Sign.N_POWER)
                    textScreen.text= Math.pow(num1,num2).toString()
                else if (sign == Sign.NONE)
                    textScreen.text= textScreen.text.toString()
                else
                    textScreen.text = "Infinity"
                state = State.EQUAL

            }
        }
    }
}

package com.example.calc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //ウィジェットの取得
        val btn0 = findViewById<Button>(R.id.btn0)
        val btn1 = findViewById<Button>(R.id.btn1)
        val btn2 = findViewById<Button>(R.id.btn2)
        val btn3 = findViewById<Button>(R.id.btn3)
        val btn4 = findViewById<Button>(R.id.btn4)
        val btn5 = findViewById<Button>(R.id.btn5)
        val btn6 = findViewById<Button>(R.id.btn6)
        val btn7 = findViewById<Button>(R.id.btn7)
        val btn8 = findViewById<Button>(R.id.btn8)
        val btn9 = findViewById<Button>(R.id.btn9)
        val btnAdd = findViewById<Button>(R.id.btnAdd)
        val btnSub = findViewById<Button>(R.id.btnSub)
        val btnMul = findViewById<Button>(R.id.btnMul)
        val btnDiv = findViewById<Button>(R.id.btnDiv)
        val btnEqu = findViewById<Button>(R.id.btnEqu)
        val btnAc = findViewById<Button>(R.id.btnAc)
        val result = findViewById<TextView>(R.id.result)

        //resultの初期値
        result.text = "0"

        //変数の準備
        var value : Int = 0
        var operator : String? = null
        var canClear : Boolean = false
        var canCalc : Boolean = false

        //数ボタンを押した時のメソッド
        fun numClick(num: String){
            result.text = if(result.text.toString() != "0" && canClear == false){
                result.text.toString() + num
            } else {
                canClear = false
                num
            }
            canCalc = true
        }

        btn0.setOnClickListener {
            numClick("0");
        }

        btn1.setOnClickListener {
            numClick("1");
        }

        btn2.setOnClickListener {
            numClick("2");
        }

        btn3.setOnClickListener {
            numClick("3");
        }

        btn4.setOnClickListener {
            numClick("4");
        }

        btn5.setOnClickListener {
            numClick("5");
        }

        btn6.setOnClickListener {
            numClick("6");
        }

        btn7.setOnClickListener {
            numClick("7");
        }

        btn8.setOnClickListener {
            numClick("8");
        }

        btn9.setOnClickListener {
            numClick("9");
        }

        //計算するメソッド
        fun calc(op: String?) :Int {
            return when (op) {
                "+" -> {
                    value + result.text.toString().toInt()
                }
                "-" -> {
                    if(value != 0){
                        value - result.text.toString().toInt()
                    }else{
                        result.text.toString().toInt()
                    }
                }
                "*" -> {
                    if(value != 0){
                        value * result.text.toString().toInt()
                    }else{
                        result.text.toString().toInt()
                    }
                }
                "/" -> {
                    if(value != 0){
                        value / result.text.toString().toInt()
                    }else{
                        result.text.toString().toInt()
                    }
                }
                else -> {
                    result.text.toString().toInt()
                }
            }
        }

        fun calcClick(op : String) {
            if (canCalc == true) {
                value = calc(op)
                canClear = true
                canCalc = false
                result.text = value.toString()
            }
            operator = op
        }

        fun equClick(){
            if (canCalc == true) {
                value = calc(operator)
                canCalc = false
                canClear = true
                result.text = value.toString()
                operator = null
            }
        }

        fun acClick(){
            result.text ="0"
            value = 0
            operator = null
            canClear = false
            canCalc = false
        }


        btnAdd.setOnClickListener {
            calcClick("+")
        }

        btnSub.setOnClickListener {
            calcClick("-")
        }

        btnMul.setOnClickListener {
            calcClick("*")
        }

        btnDiv.setOnClickListener {
            calcClick("/")
        }

        btnEqu.setOnClickListener {
            equClick()
        }

        btnAc.setOnClickListener {
            acClick()
        }
    }
}
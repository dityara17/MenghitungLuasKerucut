package com.dityaranote.luaskerucut

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.AttributeSet
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {

    private lateinit var  edtHeight : EditText
    private lateinit var edtDiameter : EditText
    private lateinit var textScore : TextView
    private lateinit var btnCalculculate : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    fun init(){
        edtHeight = findViewById(R.id.edt_height)
        edtDiameter = findViewById(R.id.edt_diameter)
        textScore = findViewById(R.id.tv_calculate)
        btnCalculculate = findViewById(R.id.btnCalculculate)

        btnCalculculate.setOnClickListener {
            if((TextUtils.isEmpty(edtHeight.getText().toString())) or (TextUtils.isEmpty(edtDiameter.getText().toString()))){
                Toast.makeText(applicationContext, "Please enter some value! ", Toast.LENGTH_SHORT).show()
            } else{
                // jari jari
                val diameter : Int = edtDiameter.text.toString().toInt()
                val jari_jari : Int = diameter / 2
                // tinggi
                val height : Int = edtHeight.text.toString().toInt()
                var garis_pelukis : Double = sqrt(((jari_jari * jari_jari)+(height*height)).toDouble())

                // luas kerucut
                val luas : Double = 3.14 * jari_jari * garis_pelukis

                // set text
                textScore.text = luas.toString()
            }
        }
    }

}

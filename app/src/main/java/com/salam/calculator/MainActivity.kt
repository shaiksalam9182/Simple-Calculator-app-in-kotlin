package com.salam.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import androidx.databinding.DataBindingUtil
import com.salam.calculator.databinding.ActivityMainBinding
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    var firstNumber = 0; var secondNumber = 0; var finalResult = 0;

    enum class OPERATION{
        ADD,
        SUBTRACT,
        MULTIPLY,
        DIVIDE
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        binding.add.setOnClickListener{
            makeCalculation(OPERATION.ADD)
        }

        binding.subtract.setOnClickListener {
            makeCalculation(OPERATION.SUBTRACT)
        }

        binding.multiply.setOnClickListener {
            makeCalculation(OPERATION.MULTIPLY)
        }

        binding.divide.setOnClickListener {
            makeCalculation(OPERATION.DIVIDE)
        }
    }

    private fun makeCalculation(task: OPERATION) {
        try {
            firstNumber = binding.firstNumber.text.toString().toInt()
            secondNumber = binding.secondNumber.text.toString().toInt()
        }catch (exception:NumberFormatException){
            binding.result.text = "Result is: 0"
        }

        if (firstNumber==0 && secondNumber==0){
            binding.result.text = "Result is 0"
        }else{
           if (task==OPERATION.ADD){
               finalResult = firstNumber+secondNumber
           }else if (task==OPERATION.SUBTRACT){
               finalResult = firstNumber-secondNumber
           }else if (task==OPERATION.MULTIPLY){
               finalResult = firstNumber*secondNumber
           }else if (task==OPERATION.DIVIDE){
               finalResult = firstNumber%secondNumber
           }
            updateResult();
        }
    }

    private fun updateResult() {
        binding.result.text = "Result is: "+finalResult
    }
}
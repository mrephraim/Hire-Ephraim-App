package com.example.hireephraim

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlin.math.ceil

class  CalculatorModel: ViewModel() {
    private val _result = MutableStateFlow<String?>(null) // Use String for result display
    val result: StateFlow<String?> = _result
    fun submit(textFieldValue: String) {
        fun preprocessExpression(expression: String): String {
            val replacements = mapOf('×' to '*', '÷' to '/')
            val builder = StringBuilder()
            for (char in expression) {
                builder.append(replacements[char] ?: char)
            }
            return builder.toString()
        }
        val (extractedOperators, extractedOperands) = parse(preprocessExpression(textFieldValue))
        Log.d("Calculator", "Operators: ${extractedOperators.joinToString()}")
        val operandsList = extractedOperands.toList() // Convert DoubleArray to List<Double>
        val operandsArray = operandsList.toTypedArray() // Convert List<Double> to Array<Double>
        Log.d("Calculator", "Operands: ${operandsArray.joinToString()}")
        val result = evaluate(
            operands = operandsArray,
            operators = extractedOperators
        )
//        val resultState = result.toString() // Convert result to String
        val result1 = ceil(result * 100) / 100
        _result.value = result1.toString()
        // Log the resultState after conversion
        Log.d("Calculator", "Result: $_result")
    }

    private fun parse(expression: String): Pair<Array<String>, DoubleArray> {
        val operators = setOf('+', '-', '*', '/', '%')
        val extractedOperators = mutableListOf<String>()
        val extractedOperands = mutableListOf<Double>()
        var currentOperand = ""

        for (char in expression) {
            if (char in operators) {
                // Extract and store operand if not empty
                if (currentOperand.isNotEmpty()) {
                    extractedOperands.add(currentOperand.toDouble())
                    currentOperand = ""
                }
                extractedOperators.add(char.toString())
            } else {
                // Append character to current operand
                currentOperand += char
            }
        }
        // Handle last operand (if any)
        if (currentOperand.isNotEmpty()) {
            extractedOperands.add(currentOperand.toDouble())
        }

        return Pair(extractedOperators.toTypedArray(), extractedOperands.toDoubleArray())
    }

    private fun  evaluate(operands: Array<Double>, operators: Array<String>): Double {
        var result = operands[0]
        for (i in operators.indices) {
            val operator = operators[i]
            val operand = operands[i + 1]
            when (operator) {
                "+" -> result += operand
                "-" -> result -= operand
                "*" -> result *= operand
                "/" -> result /= operand
            }
        }
        return result
    }


}
package com.lchrislee.learnmorse

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.lchrislee.learnmorse.data.MorseCodeTranslator

class MainActivity : AppCompatActivity() {

    private lateinit var userInput: TextView
    private lateinit var userOutput: TextView
    private lateinit var dit: Button
    private lateinit var dah: Button
    private lateinit var space: Button
    private lateinit var clear: Button
    private lateinit var translate: Button

    private var displayString = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViews()
        bindViews()
    }

    private fun findViews() {
        userInput = findViewById(R.id.userInput)
        userOutput = findViewById(R.id.userOutput)
        dit = findViewById(R.id.dit)
        dah = findViewById(R.id.dah)
        space = findViewById(R.id.space)
        clear = findViewById(R.id.clear)
        translate = findViewById(R.id.translate)
    }

    private fun bindViews() {
        dit.setOnClickListener { displayString += MorseCodeTranslator.ditDisplay; refreshInputDisplay() }
        dah.setOnClickListener { displayString += MorseCodeTranslator.dahDisplay; refreshInputDisplay() }
        space.setOnClickListener { displayString += MorseCodeTranslator.wordGapDisplay; refreshInputDisplay() }
        clear.setOnClickListener { displayString = ""; clearDisplays() }
        translate.setOnClickListener {
            val translated = MorseCodeTranslator().codeToAlphanumeric(displayString) ?: "NULL"
            Log.d("results", translated)
            userOutput.text = translated
        }
    }

    private fun refreshInputDisplay() {
        userInput. text = displayString
    }

    private fun clearDisplays() {
        userInput.text = null
        userOutput.text = null
    }
}
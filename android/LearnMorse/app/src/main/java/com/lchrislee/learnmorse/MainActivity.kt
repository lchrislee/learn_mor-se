package com.lchrislee.learnmorse

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.lchrislee.learnmorse.data.MorseCodeEntry
import com.lchrislee.learnmorse.data.MorseCodeTranslator

class MainActivity : AppCompatActivity() {

    private lateinit var userInput: TextView
    private lateinit var userOutput: TextView
    private lateinit var dit: Button
    private lateinit var dah: Button
    private lateinit var letterSpace: Button
    private lateinit var wordSpace: Button
    private lateinit var clear: Button
    private lateinit var translate: Button

    private val translator = MorseCodeTranslator()

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
        letterSpace = findViewById(R.id.letterSpace)
        wordSpace = findViewById(R.id.wordSpace)
        clear = findViewById(R.id.clear)
        translate = findViewById(R.id.translate)
    }

    private fun bindViews() {
        dit.setOnClickListener { translator.append(MorseCodeEntry.Dit); refreshInputDisplay() }
        dah.setOnClickListener { translator.append(MorseCodeEntry.Dah); refreshInputDisplay() }
        letterSpace.setOnClickListener { translator.append(MorseCodeEntry.LetterGap); refreshInputDisplay() }
        wordSpace.setOnClickListener { translator.append(MorseCodeEntry.WordGap); refreshInputDisplay() }
        clear.setOnClickListener { translator.clear(); clearDisplays() }
        translate.setOnClickListener {
            val translated = translator.translated() ?: "NULL"
            Log.d("results", translated)
            userOutput.text = translated
        }
    }

    private fun refreshInputDisplay() {
        userInput.text = translator.displayString()
    }

    private fun clearDisplays() {
        userInput.text = null
        userOutput.text = null
    }
}
package com.lchrislee.learnmorse.data

enum class MorseCodeEntry {
    Dit,
    Dah,
    InterCharacterGap,
    LetterGap,
    WordGap,
}

class MorseCodeTranslator {

    companion object {
        private const val dit = "1"
        private const val dah = "111"
        private const val interCharacterGap = "0"
        private const val letterGap = "000"
        private const val wordGap = "0000000"

        private const val ditDisplay = "·"
        private const val dahDisplay = "—"
        private const val letterGapDisplay = " "
        private const val wordGapDisplay = "   "
    }

    private var codeToAlphanumeric = mutableMapOf<String, String>()
    private var encoded = StringBuilder()
    private var display = StringBuilder()

    init {
        codeToAlphanumeric[ditDisplay] = "e"
        codeToAlphanumeric["$ditDisplay$ditDisplay"] = "i"
        codeToAlphanumeric["$ditDisplay$ditDisplay$ditDisplay"] = "s"
        codeToAlphanumeric["$ditDisplay$ditDisplay$ditDisplay$ditDisplay"] = "h"
        codeToAlphanumeric["$ditDisplay$ditDisplay$ditDisplay$ditDisplay$ditDisplay"] = "5"
        codeToAlphanumeric["$ditDisplay$ditDisplay$ditDisplay$ditDisplay$dahDisplay"] = "4"
        codeToAlphanumeric["$ditDisplay$ditDisplay$ditDisplay$dahDisplay"] = "v"
        codeToAlphanumeric["$ditDisplay$ditDisplay$ditDisplay$dahDisplay$dahDisplay"] = "3"
        codeToAlphanumeric["$ditDisplay$ditDisplay$dahDisplay"] = "u"
        codeToAlphanumeric["$ditDisplay$ditDisplay$dahDisplay$ditDisplay"] = "f"
        codeToAlphanumeric["$ditDisplay$ditDisplay$dahDisplay$dahDisplay$dahDisplay"] = "2"
        codeToAlphanumeric["$ditDisplay$ditDisplay$dahDisplay$dahDisplay$ditDisplay$ditDisplay"] = "?"
        codeToAlphanumeric["$ditDisplay$ditDisplay$dahDisplay$dahDisplay$ditDisplay$dahDisplay"] = "_"
        codeToAlphanumeric["$ditDisplay$dahDisplay"] = "a"
        codeToAlphanumeric["$ditDisplay$dahDisplay$ditDisplay"] = "r"
        codeToAlphanumeric["$ditDisplay$dahDisplay$ditDisplay$ditDisplay"] = "l"
        codeToAlphanumeric["$ditDisplay$dahDisplay$ditDisplay$ditDisplay$dahDisplay$ditDisplay"] = "\""
        codeToAlphanumeric["$ditDisplay$dahDisplay$ditDisplay$dahDisplay$ditDisplay"] = "+"
        codeToAlphanumeric["$ditDisplay$dahDisplay$ditDisplay$dahDisplay$ditDisplay$dahDisplay"] = "."
        codeToAlphanumeric["$ditDisplay$dahDisplay$dahDisplay"] = "w"
        codeToAlphanumeric["$ditDisplay$dahDisplay$dahDisplay$ditDisplay"] = "p"
        codeToAlphanumeric["$ditDisplay$dahDisplay$dahDisplay$ditDisplay$dahDisplay$ditDisplay"] = "@"
        codeToAlphanumeric["$ditDisplay$dahDisplay$dahDisplay$dahDisplay"] = "j"
        codeToAlphanumeric["$ditDisplay$dahDisplay$dahDisplay$dahDisplay$dahDisplay"] = "1"
        codeToAlphanumeric[dahDisplay] = "t"
        codeToAlphanumeric["$dahDisplay$ditDisplay"] = "n"
        codeToAlphanumeric["$dahDisplay$ditDisplay$ditDisplay"] = "d"
        codeToAlphanumeric["$dahDisplay$ditDisplay$ditDisplay$ditDisplay"] = "b"
        codeToAlphanumeric["$dahDisplay$ditDisplay$ditDisplay$ditDisplay$ditDisplay"] = "6"
        codeToAlphanumeric["$dahDisplay$ditDisplay$ditDisplay$ditDisplay$ditDisplay$dahDisplay"] = "-"
        codeToAlphanumeric["$dahDisplay$ditDisplay$ditDisplay$ditDisplay$dahDisplay"] = "="
        codeToAlphanumeric["$dahDisplay$ditDisplay$ditDisplay$dahDisplay"] = "x"
        codeToAlphanumeric["$dahDisplay$ditDisplay$ditDisplay$dahDisplay$ditDisplay"] = "/"
        codeToAlphanumeric["$dahDisplay$ditDisplay$dahDisplay"] = "k"
        codeToAlphanumeric["$dahDisplay$ditDisplay$dahDisplay$ditDisplay"] = "c"
        codeToAlphanumeric["$dahDisplay$ditDisplay$dahDisplay$ditDisplay$dahDisplay$ditDisplay"] = ";"
        codeToAlphanumeric["$dahDisplay$ditDisplay$dahDisplay$ditDisplay$dahDisplay$dahDisplay"] = "!"
        codeToAlphanumeric["$dahDisplay$ditDisplay$dahDisplay$dahDisplay"] = "y"
        codeToAlphanumeric["$dahDisplay$ditDisplay$dahDisplay$dahDisplay$ditDisplay$dahDisplay"] = "()"
        codeToAlphanumeric["$dahDisplay$dahDisplay"] = "m"
        codeToAlphanumeric["$dahDisplay$dahDisplay$ditDisplay"] = "g"
        codeToAlphanumeric["$dahDisplay$dahDisplay$ditDisplay$ditDisplay"] = "z"
        codeToAlphanumeric["$dahDisplay$dahDisplay$ditDisplay$ditDisplay$ditDisplay"] = "7"
        codeToAlphanumeric["$dahDisplay$dahDisplay$ditDisplay$ditDisplay$dahDisplay$dahDisplay"] = ","
        codeToAlphanumeric["$dahDisplay$dahDisplay$ditDisplay$dahDisplay"] = "q"
        codeToAlphanumeric["$dahDisplay$dahDisplay$dahDisplay"] = "o"
        codeToAlphanumeric["$dahDisplay$dahDisplay$dahDisplay$ditDisplay$ditDisplay"] = "8"
        codeToAlphanumeric["$dahDisplay$dahDisplay$dahDisplay$ditDisplay$ditDisplay$ditDisplay"] = ":"
        codeToAlphanumeric["$dahDisplay$dahDisplay$dahDisplay$dahDisplay$ditDisplay"] = "9"
        codeToAlphanumeric["$dahDisplay$dahDisplay$dahDisplay$dahDisplay$dahDisplay"] = "0"
    }

    fun append(entry: MorseCodeEntry) {
        when (entry) {
            MorseCodeEntry.Dit -> { encoded.append(dit); display.append(ditDisplay) }
            MorseCodeEntry.Dah -> { encoded.append(dah); display.append(dahDisplay) }
            MorseCodeEntry.InterCharacterGap -> { encoded.append(interCharacterGap) }
            MorseCodeEntry.LetterGap -> { encoded.append(letterGap); display.append(letterGapDisplay) }
            MorseCodeEntry.WordGap -> { encoded.append(wordGap); display.append(wordGapDisplay) }
        }
    }

    fun displayString() = display.toString()

    fun clear() {
        encoded.clear()
        display.clear()
    }

    fun translated() = codeToAlphanumeric(displayString())

    private fun codeToAlphanumeric(code: String): String? {
        val words = code.split(wordGapDisplay)
        val outputString = StringBuilder()
        words.forEach {word ->
            val translatedLetters = word.split(letterGapDisplay).map {
                val output = codeToAlphanumeric.getOrDefault(it, "")
                output
            }
            val emptyPos = translatedLetters.find { it.isEmpty() }
            if (emptyPos == null) {
//                val outputStringBuilder = StringBuilder()
                translatedLetters.forEach {outputString.append(it) }
                outputString.append(" ")
            } else {
                return null
            }
        }
        return outputString.toString()
    }
}
package com.lchrislee.learnmorse.data

class MorseCodeTranslator {

    companion object {
        val dit = "1"
        val dah = "111"
        val interCharacterGap = "0"
        val letterGap = "000"
        val wordGap = "0000000"

        val ditDisplay = "·"
        val dahDisplay = "—"
        val wordGapDisplay = " "
    }

    private var codeToAlphanumeric = mutableMapOf<String, String>()

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

    fun codeToAlphanumeric(code: String): String? = code.split(wordGapDisplay).map {
        val output = codeToAlphanumeric.getOrDefault(it, "")
        output
    }.let { mappedList ->
        val emptyPos = mappedList.find { it.isEmpty() }
        return if (emptyPos == null) {
            val outputStringBuilder = StringBuilder()
            mappedList.forEach {outputStringBuilder.append(it) }
            return outputStringBuilder.toString()
        } else {
            null
        }
    }
}
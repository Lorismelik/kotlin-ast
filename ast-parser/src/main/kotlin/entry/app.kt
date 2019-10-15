package entry

import parser.*
import parser.common.KeywordDictionary
import parser.common.KeywordDictionary.*
import parser.common.KeywordDictionary.Companion.PLUS


fun main() {
    val path = "/code.txt"
    val text = FileLoader.getResourceAsText(path)
    val name = FileLoader.getResourceName(path)
    val line = "5 <= 4"
    val lol = line.split("(${KeywordDictionary.GT}|${KeywordDictionary.LT}|[${KeywordDictionary.MULT}$PLUS${KeywordDictionary.MINUS}${KeywordDictionary.DIV}${KeywordDictionary.PROC}${KeywordDictionary.LESSER}${KeywordDictionary.GREATER}${KeywordDictionary.EQ}])".toRegex(), 2)
    println(lol)
    //Parser(text, name).buildAst()

}

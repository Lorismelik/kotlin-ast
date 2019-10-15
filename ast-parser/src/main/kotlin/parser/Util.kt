package parser

import parser.common.KeywordDictionary.Companion.CB
import parser.common.KeywordDictionary.Companion.CBF
import parser.common.KeywordDictionary.Companion.COMMA
import parser.common.KeywordDictionary.Companion.OBF
import parser.common.ParserException

fun deleteExtraSpace(str : String) : String = str.replace("\\s+".toRegex(), " ")
fun deleteTabs(str : String) : String  = str.replace("\\t".toRegex(), "")
fun String.splitInLines() : List<String>  = this.lines()
fun deleteFirstSpace(str : String) : String = str.replace("^\\s".toRegex(), "")
infix fun <T> T.then(func: (T) -> T): T = func(this)
fun defineBody(body: List<String>) : List<String>{
    var deepCounter = 0
    val result = ArrayList<String>()
    for(line in body) {
        deepCounter += CBF.toRegex().findAll(line).count()
        deepCounter -= OBF.toRegex().findAll(line).count()
        if (deepCounter<=0) return result else result.add(line)
    }
    throw ParserException("Could not define body")
}
fun defineArgs(line: String) : List<String> = CB.toRegex().split(line).first().split(COMMA.toRegex())



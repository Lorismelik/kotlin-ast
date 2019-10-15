package parser.token

import parser.common.KeywordDictionary
import parser.common.KtType

interface KtToken {
    val type : KtType
    val value : String
    fun addChild(token : KtToken)
    val process : (List<String>) -> Unit
    tailrec fun processToken(body : List<String>) {
        process(body)
        val lst = body.drop(0)
        return if (lst.isEmpty()) Unit else processToken(lst)
    }
}
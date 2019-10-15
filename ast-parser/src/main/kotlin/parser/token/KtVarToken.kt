package parser.token

import parser.common.KeywordDictionary.Companion.VAL
import parser.common.KeywordDictionary.Companion.VAR
import parser.common.KtType
import parser.common.ParserException

class KtVarToken(override val value: String,
                  var typeToken : KtTypeToken? = null,
                  var id : KtIdToken? = null) : KtToken, KtRightHandExpression{
    override val  type : KtType = KtType.VARIABLE

    override fun addChild(token: KtToken) {
        when(token) {
            is KtTypeToken -> typeToken = token
            is KtIdToken -> id = token
            else -> throw ParserException("Add wrong token as child for KtVarToken $value")
        }
    }

    constructor (body : List<String>,
        value: String = "variable") : this(value) {
        processToken(body)
    }

    override val process : (List<String>) -> Unit = {
        val line = it.first()
        val argument = ":".toRegex().split("\\s".toRegex().replace(line, "")).toMutableList()
        if (argument.size == 1) {
            if ("$VAL".toRegex().containsMatchIn(line)) {
                argument.add(0, VAL)
                argument.add(1, line.replace("$VAL", ""))
            }
            else {
                argument.add(0, VAR)
                argument.add(1, line.replace("$VAR", ""))
            }
        }
        addChild(KtIdToken(argument[0]))
        addChild(KtTypeToken(argument[1]))
    }
}
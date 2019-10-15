package parser.token

import parser.common.KeywordDictionary.Companion.ASSIGN
import parser.common.KtType
import parser.common.ParserException

class KtBodyToken(override val value: String,
                  val expressions : MutableList<KtExpressionToken> = ArrayList(),
                  val ifTokens : MutableList<KtIfToken> = ArrayList(),
                  val forTokens : MutableList<KtForToken> = ArrayList()) : KtToken {
    override fun addChild(token: KtToken) {
        when(token) {
            is KtExpressionToken -> expressions.add(token)
            is KtIfToken -> ifTokens.add(token)
            is KtForToken -> forTokens.add(token)
            else -> throw ParserException("Add wrong token as child for KtBodyToken $value")
        }
    }

    constructor(body : List<String>,
                value : String = ""
    ) : this(value) {
        processToken(body)
    }

    override val process : (List<String>) -> Unit = { lines ->
        val line = lines.first()
        when {
            "[^$ASSIGN]$ASSIGN[^$ASSIGN]".toRegex().containsMatchIn(line) -> addChild(KtExpressionToken(ASSIGN, line))
        }
    }

    override val  type : KtType = KtType.BODY
}
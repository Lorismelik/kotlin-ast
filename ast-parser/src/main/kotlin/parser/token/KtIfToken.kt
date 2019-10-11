package parser.token

import parser.common.KtType
import parser.common.ParserException

class KtIfToken(override val value : String,
                var condition : KtExpressionToken? = null,
                var ifBody : KtBodyToken? = null) : KtToken {
    override fun addChild(token: KtToken) {
        when(token) {
            is KtExpressionToken -> condition = token
            is KtBodyToken -> ifBody = token
            else -> throw ParserException("Add wrong token as child for KtIfToken $value")
        }
    }
    override val type : KtType = KtType.IF
}
package parser.token

import parser.common.KtType
import parser.common.ParserException

class KtVarToken(override val value: String,
                  var typeToken : KtTypeToken? = null,
                  var id : KtIdToken? = null) : KtToken, KtRightHandExpression{
    override val  type : KtType = KtType.VAR

    override fun addChild(token: KtToken) {
        when(token) {
            is KtTypeToken -> typeToken = token
            is KtIdToken -> id = token
            else -> throw ParserException("Add wrong token as child for KtVarToken $value")
        }
    }
}
package parser.token

import parser.common.KtType
import parser.common.ParserException

class KtBodyToken(override val value: String,
                  val declarations :  MutableList<KtDeclarationToken> = ArrayList(),
                  val expressions : MutableList<KtExpressionToken> = ArrayList(),
                  val ifTokens : MutableList<KtIfToken> = ArrayList(),
                  val forTokens : MutableList<KtForToken> = ArrayList()) : KtToken {
    override fun addChild(token: KtToken) {
        when(token) {
            is KtDeclarationToken -> declarations.add(token)
            is KtExpressionToken -> expressions.add(token)
            is KtIfToken -> ifTokens.add(token)
            is KtForToken -> forTokens.add(token)
            else -> throw ParserException("Add wrong token as child for KtBodyToken $value")
        }
    }
    override val  type : KtType = KtType.BODY
}
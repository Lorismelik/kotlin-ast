package parser.token

import parser.common.KtType
import parser.common.ParserException

class KtForToken(override val value : String,
                 var firstCondition : KtExpressionToken? = null,
                 var secondCondition : KtExpressionToken? = null,
                 var thirdCondition : KtExpressionToken? = null,
                 var forBody : KtBodyToken? = null) : KtToken {
    override fun addChild(token: KtToken) {
        when(token) {
            is KtExpressionToken -> setConditions(token)
            is KtBodyToken -> forBody = token
            else -> throw ParserException("Add wrong token as child for KtIfToken $value")
        }
    }
    override val type : KtType = KtType.IF

    private fun setConditions(token : KtExpressionToken){
        if (firstCondition == null)  { firstCondition = token; return }
        if (secondCondition == null)  { secondCondition = token; return }
        if (thirdCondition == null)  { thirdCondition = token; return }
    }
}
package parser.token

import parser.common.KtType

open class KtExpressionToken(override val value: String,
                        var left : KtRightHandExpression? = null,
                        var right : KtRightHandExpression? = null) : KtToken, KtRightHandExpression {
    override fun addChild(token: KtToken) {
        if(left == null) left = token as KtRightHandExpression
        else right = token as KtRightHandExpression
    }
    override val type : KtType = KtType.EXPRESSION
}
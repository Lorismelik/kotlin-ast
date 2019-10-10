package parser.token

import parser.common.KtType

class KtIdToken(override val value : String) : KtToken, KtRightHandExpression {
    override fun addChild(token: KtToken) {}
    override val type : KtType = KtType.ID
}
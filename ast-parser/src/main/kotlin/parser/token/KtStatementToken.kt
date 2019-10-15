package parser.token

import parser.common.KtType

class KtStatementToken(override val value : String) : KtToken, KtRightHandExpression {
    override fun addChild(token: KtToken) {}
    override val type : KtType = KtType.STATEMENT
    override val process: (List<String>) -> Unit = {}
}
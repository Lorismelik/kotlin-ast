package parser.token

import parser.common.IdGenerator
import parser.common.KtType

class KtStatementToken(override val value : String,
                       override val children: MutableList<KtToken> = ArrayList(),
                       override val tokenId: Int = IdGenerator.generateId()) : KtToken, KtRightHandExpression {
    override fun addChild(token: KtToken) {}
    override val type : KtType = KtType.STATEMENT
    override val process: (List<String>) -> Unit = {}
}
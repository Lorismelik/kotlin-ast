package parser.token

import parser.common.KtType

class KtTypeToken(override val value : String) : KtToken {
    override fun addChild(token: KtToken) {}
    override val type : KtType = KtType.TYPE
    override val process: (List<String>) -> Unit = {}
}
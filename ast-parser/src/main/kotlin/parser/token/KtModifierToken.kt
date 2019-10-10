package parser.token

import parser.common.KtType

class KtModifierToken(override val value : String) : KtToken {
    override val type : KtType = KtType.MODIFIER
    override fun addChild(token: KtToken) {}
}
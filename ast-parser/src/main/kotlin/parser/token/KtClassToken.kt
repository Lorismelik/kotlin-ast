package parser.token

import parser.common.KtType

class KtClassToken(override val value: String,
                   val modifiers : MutableList<KtModifierToken>) : KtToken {
    override val  type : KtType = KtType.CLASS
    override fun addChild(token: KtToken) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
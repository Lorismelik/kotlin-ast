package parser.token

import parser.common.KtType
import parser.common.ParserException

class KtFunctionToken(override val value: String,
                      val modifiers : MutableList<KtModifierToken> = ArrayList(),
                      val args : MutableList<KtVarToken> = ArrayList(),
                      var body : KtBodyToken? = null) : KtToken {

    override fun addChild(token: KtToken) {
        when(token) {
            is KtModifierToken -> modifiers.add(token)
            is KtVarToken -> args.add(token)
            is KtBodyToken -> body = token
            else -> throw ParserException("Add wrong token as child for KtFunctionToken $value")
        }
    }
    override val  type : KtType = KtType.FUNCTION
}
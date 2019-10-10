package parser.token

import parser.common.KtType

class KtFunctionToken(override val value: String,
                      val modifiers : MutableList<KtModifierToken>,
                      val declarations :  MutableList<KtDeclarationToken>,
                      val expressions : MutableList<KtExpression>) : KtToken {
    override val  type : KtType = KtType.FUNCTION
}
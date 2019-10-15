package parser.token

import parser.common.KtType
import parser.common.ParserException
import parser.defineArgs

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

    override val  process : (List<String>) -> Unit = {}

    constructor (value: String,
                 args: String,
                 body : List<String>) : this(value) {
        defineArgs(args).forEach{addChild(KtVarToken(listOf(it)))}
        addChild(KtBodyToken(body.drop(0)))
    }
}
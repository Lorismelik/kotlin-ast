package parser.token

import parser.common.KeywordDictionary.Companion.ASSIGN
import parser.common.KtType

open class KtExpressionToken(override val value: String,
                        var left : KtRightHandExpression? = null,
                        var right : KtRightHandExpression? = null) : KtToken, KtRightHandExpression {
    override fun addChild(token: KtToken) {
        if(left == null) left = token as KtRightHandExpression
        else right = token as KtRightHandExpression
    }

    constructor(value : String,
                body : String
    ) : this(value) {
        processToken(listOf(body))
    }

    override val process : (List<String>) -> Unit = {lines ->
        val line = lines.first()
        when (value) {
            ASSIGN -> processAssign("$ASSIGN".split(line))
        }
    }


    private fun processAssign(assign : List<String>) {
        addChild(KtVarToken(assign[0]))
        addChild()
    }
    override val type : KtType = KtType.EXPRESSION
}
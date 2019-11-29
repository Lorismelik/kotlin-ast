package parser.token


import parser.common.IdGenerator
import parser.common.KeywordDictionary.Companion.ASSIGN
import parser.common.KeywordDictionary.Companion.IN
import parser.common.KeywordDictionary.Companion.opRegEx
import parser.common.KtType


open class KtExpressionToken(override val value: String,
                        var left : KtRightHandExpression? = null,
                        var right : KtRightHandExpression? = null,
                             override val children: MutableList<KtToken> = ArrayList(),
                             override val tokenId: Int = IdGenerator.generateId()) : KtToken, KtRightHandExpression {
    override fun addChild(token: KtToken) {
        if(left == null) left = token as KtRightHandExpression
        else right = token as KtRightHandExpression
        children.add(token)
    }


    constructor(value : String,
                body : String
    ) : this(value) {
        when (value) {
            ASSIGN -> processAssign(ASSIGN.toRegex().split(body))
            IN -> processIn(" $IN ".toRegex().split(body, 2))
            else -> processRightExpression(body.split(opRegEx, 2))
        }
    }

    override val process : (List<String>) -> Unit = {}

    private fun processAssign(assign : List<String>) {
        addChild(KtVarToken(listOf(assign[0])))
        if (opRegEx.containsMatchIn(assign[1])) {
            addChild(KtExpressionToken(opRegEx.find(assign[1])!!.value, assign[1]))
        } else {
            addChild(KtStatementToken(assign[1]))
        }

    }

    private fun processIn(inExp : List<String>) {
        addChild(KtIdToken(inExp[0]))
        addChild(KtIdToken(inExp[1]))
    }

    private fun processRightExpression(parts : List<String>) {
        addChild(KtStatementToken(parts[0]))
        addChild(KtStatementToken(parts[1]))
    }

    override val type : KtType = KtType.EXPRESSION
}
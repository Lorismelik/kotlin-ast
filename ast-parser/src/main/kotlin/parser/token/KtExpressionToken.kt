package parser.token

import parser.common.KeywordDictionary.Companion.ASSIGN
import parser.common.KeywordDictionary.Companion.DIV
import parser.common.KeywordDictionary.Companion.EQ
import parser.common.KeywordDictionary.Companion.GREATER
import parser.common.KeywordDictionary.Companion.GT
import parser.common.KeywordDictionary.Companion.LESSER
import parser.common.KeywordDictionary.Companion.LT
import parser.common.KeywordDictionary.Companion.MINUS
import parser.common.KeywordDictionary.Companion.MULT
import parser.common.KeywordDictionary.Companion.PLUS
import parser.common.KeywordDictionary.Companion.PROC
import parser.common.KtType
import parser.common.ParserException

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
        this.processToken(listOf(body))
    }

    val opRegEx = "$GT|$LT|[$MULT$PLUS$MINUS$DIV$PROC$LESSER$GREATER$EQ]".toRegex()

    override val process : (List<String>) -> Unit = {lines ->
        val line = lines.first()
        when (value) {
            ASSIGN -> processAssign(ASSIGN.split(line))
            else -> processRightExpression(line.split(opRegEx, 2))
        }
    }


    private fun processAssign(assign : List<String>) {
        addChild(KtVarToken(assign[0]))
        createRightExpression(assign[1])
    }

    private fun processRightExpression(parts : List<String>) {
        addChild(KtStatementToken(parts[0]))
        addChild(KtStatementToken(parts[1]))
    }

    private fun createRightExpression(ex : String) {
          addChild(KtExpressionToken(opRegEx.find(ex)!!.value, ex))
    }
    override val type : KtType = KtType.EXPRESSION
}
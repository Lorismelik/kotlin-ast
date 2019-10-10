package parser.token

import parser.common.KtType

interface KtToken {
    val type : KtType
    val value : String
    fun addChild(token : KtToken)
}
package parser.token

import parser.common.KtType
import parser.common.ParserException

class KtReturnToken (override val value : String,
                     var returnVal : KtRightHandExpression? = null) : KtToken {
    override fun addChild(token: KtToken) {
        if (token is KtRightHandExpression) returnVal = token
        else throw ParserException("Add wrong token as child for KtReturnToken $value")
    }
    override val type : KtType = KtType.TYPE
    override val process: (List<String>) -> Unit = {}
}
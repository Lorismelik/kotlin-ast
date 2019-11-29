package parser.token

import parser.common.IdGenerator
import parser.common.KeywordDictionary
import parser.common.KtType
import parser.common.ParserException

class KtReturnToken (override val value : String,
                     var returnVal : KtRightHandExpression? = null,
                     override val children: MutableList<KtToken> = ArrayList(),
                     override val tokenId: Int = IdGenerator.generateId()) : KtToken {
    override fun addChild(token: KtToken) {
        if (token is KtRightHandExpression) returnVal = token
        else throw ParserException("Add wrong token as child for KtReturnToken $value")
        children.add(token)
    }
    constructor (body : List<String>,
                 value: String = ""): this(value) {
        val line = body.first()
        if (KeywordDictionary.opRegEx.containsMatchIn(line))
            addChild(KtExpressionToken(KeywordDictionary.opRegEx.find(line)!!.value, line))
        else
            addChild(KtStatementToken("^${KeywordDictionary.RETURN} ".toRegex().replace(body.first(), "")))
    }
    override val type : KtType = KtType.RETURN
    override val process: (List<String>) -> Unit = {}
}
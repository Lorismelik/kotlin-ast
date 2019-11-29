package parser.token

import parser.common.IdGenerator
import parser.common.KeywordDictionary
import parser.common.KeywordDictionary.Companion.CB
import parser.common.KeywordDictionary.Companion.IF
import parser.common.KeywordDictionary.Companion.OBF
import parser.common.KtType
import parser.common.ParserException
import parser.defineBody

class KtIfToken(override val value : String,
                var condition : KtExpressionToken? = null,
                var ifBody : KtBodyToken? = null,
                override val children: MutableList<KtToken> = ArrayList(),
                override val tokenId: Int = IdGenerator.generateId()) : KtToken {
    override fun addChild(token: KtToken) {
        when(token) {
            is KtExpressionToken -> condition = token
            is KtBodyToken -> ifBody = token
            else -> throw ParserException("Add wrong token as child for KtIfToken $value")
        }
        children.add(token)
    }
    override val process: (MutableList<String>) -> Unit = {}
    constructor(cond : String, body : MutableList<String>, value : String = IF) : this(value) {
        addChild(KtExpressionToken(KeywordDictionary.opRegEx.find(cond)!!.value,"[\\$CB|\\$OBF]".toRegex().replace(cond, "")))
        addChild(KtBodyToken(defineBody(body)))
    }
    override val type : KtType = KtType.IF
}
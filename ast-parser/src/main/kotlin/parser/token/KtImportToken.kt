package parser.token


import parser.common.KeywordDictionary.Companion.IMPORT
import parser.common.KtType

class KtImportToken(override val value : String = IMPORT,
                    var statement : KtStatementToken? = null) : KtToken {

    override val  process : (List<String>) -> Unit = { addChild(KtStatementToken("^$IMPORT ".toRegex().replace(it.first(), ""))) }

    constructor (body : List<String>,
                 value: String = ""): this(value) {
        processToken(body)
    }

    override fun addChild(token: KtToken) {
        statement = token as KtStatementToken
    }

    override val type : KtType = KtType.IMPORT
}
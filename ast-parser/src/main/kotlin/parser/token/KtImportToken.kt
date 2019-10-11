package parser.token

import parser.common.KtType

class KtImportToken(override val value : String,
                    var statement : KtStatementToken? = null) : KtToken {
    override fun addChild(token: KtToken) {
        statement = token as KtStatementToken
    }
    override val type : KtType = KtType.IMPORT
}
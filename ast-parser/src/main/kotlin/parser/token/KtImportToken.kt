package parser.token

import parser.common.KtType

class KtImportToken(override val value : String,
                    var statement : KtStatementToken) : KtToken {
    override val type : KtType = KtType.IMPORT
}
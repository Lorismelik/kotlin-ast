package parser.token

import parser.common.KtType
import parser.common.ParserException

class KtFileToken(override val value: String,
                  val classes : MutableList<KtClassToken>,
                  val functions : MutableList<KtFunctionToken>,
                  val imports : MutableList<KtImportToken>) : KtToken {
    override val  type : KtType = KtType.FILE

    override fun addChild(token: KtToken) {
        when(token) {
            is KtClassToken -> classes.add(token)
            is KtFunctionToken -> functions.add(token)
            is KtImportToken -> imports.add(token)
            else -> throw ParserException("Add wrong token as child for KtFileToken $value")
        }
    }
}

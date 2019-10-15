package parser.token

import parser.common.KeywordDictionary.Companion.FUN
import parser.common.KeywordDictionary.Companion.IMPORT
import parser.common.KtType
import parser.common.ParserException

class KtFileToken(override val value: String,
                  val classes : MutableList<KtClassToken> = ArrayList(),
                  val functions : MutableList<KtFunctionToken> = ArrayList(),
                  val imports : MutableList<KtImportToken> = ArrayList()) : KtToken {
    override val  type : KtType = KtType.FILE
    override val  process : (String) -> Unit = {
        when {
            "^$IMPORT".toRegex().containsMatchIn(it) -> addChild(KtImportToken(listOf(it)))
            "^$FUN".toRegex().containsMatchIn(it) -> {
                addChild(KtFunctionToken(listOf(it)))
            }
        }
    }

    constructor (value: String,
                 body : List<String>) : this(value) {
        processToken(body)
    }


    override fun addChild(token: KtToken) {
        when(token) {
            is KtClassToken -> classes.add(token)
            is KtFunctionToken -> functions.add(token)
            is KtImportToken -> imports.add(token)
            else -> throw ParserException("Add wrong token as child for KtFileToken $value")
        }
    }
}

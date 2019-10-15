package parser.token

import parser.common.KeywordDictionary.Companion.FUN
import parser.common.KeywordDictionary.Companion.IMPORT
import parser.common.KtType
import parser.common.ParserException
import parser.defineBody

class KtFileToken(override val value: String,
                  val classes : MutableList<KtClassToken> = ArrayList(),
                  val functions : MutableList<KtFunctionToken> = ArrayList(),
                  val imports : MutableList<KtImportToken> = ArrayList()) : KtToken {
    override val  type : KtType = KtType.FILE
    override val  process : (List<String>) -> Unit = { lines ->
        val line = lines.first()
        when {
            "^$IMPORT".toRegex().containsMatchIn(line) -> addChild(KtImportToken(listOf(line)))
            "^$FUN".toRegex().containsMatchIn(line) -> {
                //TODO modifiers
                val signatureParts = "OB".toRegex().split(line.replace("^$FUN ".toRegex(), ""), 1)
                val body = defineBody(lines.drop(0))
                addChild(KtFunctionToken(signatureParts[0], signatureParts[1], body))
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

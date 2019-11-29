package parser

import parser.token.KtFileToken
import parser.token.KtToken

class Parser(var text: String, val fileName: String){

    private fun prepareText(input : String) =
        text.splitInLines()
            .map{ it then ::deleteExtraSpace then :: deleteFirstSpace then ::deleteTabs}
            .filter{it.isNotBlank()}

    fun buildAst() : KtToken {
        val formattedLines = prepareText(text)
        return KtFileToken(fileName, formattedLines as MutableList<String>)
    }
}
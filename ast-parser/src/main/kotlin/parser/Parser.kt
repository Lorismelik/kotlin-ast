package parser

import parser.token.KtFileToken

class Parser(var text: String, val fileName: String){

    private fun prepareText(input : String) =
        text.splitInLines()
            .map{ it then ::deleteExtraSpace then :: deleteFirstSpace then ::deleteTabs}
            .filter{it.isNotBlank()}

    fun buildAst(){
        val formattedLines = prepareText(text)
        val fileToken = KtFileToken(fileName, formattedLines)
        print("")
    }
}
package parser.token

import parser.common.KtType

interface KtToken {
    val tokenId : Int
    val type : KtType
    val value : String
    fun addChild(token : KtToken)
    val process : (MutableList<String>) -> Unit
    val children: MutableList<KtToken>
    tailrec fun processToken(body : MutableList<String>) {
        process(body)
        if (body.isEmpty()) return else body.removeAt(0)
        return if (body.isEmpty()) Unit else  processToken(body)
    }
}
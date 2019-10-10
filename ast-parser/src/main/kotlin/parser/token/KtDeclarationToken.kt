package parser.token

import parser.common.KtType
import parser.common.ParserException

class KtDeclarationToken(override val value: String,
                         var id: KtIdToken,
                         var rightHand: KtRightHandExpression,
                         var varType: KtTypeToken) : KtToken {

        override fun addChild(token: KtToken) {
            when(token) {
                is KtIdToken -> id = token
                is KtRightHandExpression -> rightHand = token
                is KtTypeToken -> varType = token
                else -> throw ParserException("Add wrong token as child for KtDeclarationToken $value")
            }
        }

    override val  type : KtType = KtType.DECL
}
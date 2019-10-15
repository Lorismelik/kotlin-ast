package parser.common

class KeywordDictionary {
    companion object  {
        const val PLUS = "+"
        const val MINUS = "-"
        const val INCR = "++"
        const val DECR = "--"
        const val MULT = "*"
        const val DIV = "/"
        const val PROC = "%"
        const val FOR = "for"
        const val IF = "if"
        const val ELSE = "else"
        const val RETURN = "return"
        const val FUN = "fun"
        const val CLASS = "class"
        const val IMPORT = "import"
        const val OB = "("
        const val CB = ")"
        const val OBF = "{"
        const val CBF = "}"
        const val STRING = "\""
        const val COLON = ":"
        const val COMMA = ","
        const val SEMICOLON = ";"
        const val EQ = "=="
        const val NEQ = "!="
        const val GREATER = ">"
        const val LESSER = "<"
        const val GT = ">="
        const val LT = "<="
        const val ASSIGN = "="
    }

    val operators : List<String> = listOf(
        PLUS,
        MINUS,
        INCR,
        MULT,
        DIV,
        PROC
    )

    val comparison : List<String> = listOf(
        EQ,
        NEQ,
        GREATER,
        LESSER,
        GT,
        LT
    )

}
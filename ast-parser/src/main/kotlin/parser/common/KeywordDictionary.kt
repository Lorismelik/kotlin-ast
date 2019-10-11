package parser.common

class KeywordDictionary {
    companion object  {
        const val PLUS = "+"
        const val MINUS = "-"
        const val INCR = "++"
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
    }

    val operators : List<String> = listOf(
        PLUS,
        MINUS,
        INCR,
        MULT,
        DIV,
        PROC
    )

}
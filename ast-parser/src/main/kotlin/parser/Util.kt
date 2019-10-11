package parser

class Util {
    companion object {
        fun DeleteExtraSpace(str : String) = str.replace("\\s+".toRegex(), " ")

    }
}
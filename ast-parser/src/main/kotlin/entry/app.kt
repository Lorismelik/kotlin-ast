package entry

import parser.*


fun main() {
    val path = "/code.txt"
    val text = FileLoader.getResourceAsText(path)
    val name = FileLoader.getResourceName(path)
    Parser(text, name).buildAst()

}

package entry

import parser.*
import visualization.Drawer

fun main() {
    val path = "/code.txt"
    val text = FileLoader.getResourceAsText(path)
    val name = FileLoader.getResourceName(path)
    val ast = Parser(text, name).buildAst()
    Drawer().drawAST(ast)
}

package entry

fun main() {
    val filename = "/code.txt"
    println(FileLoader.getResourceAsText(filename))
}

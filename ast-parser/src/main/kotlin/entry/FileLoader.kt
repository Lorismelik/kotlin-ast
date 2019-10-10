package entry

object FileLoader {

    fun getResourceAsText(path: String): String {
        return object {}.javaClass.getResource(path).readText()
    }
}
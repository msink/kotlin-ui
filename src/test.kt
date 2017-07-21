
fun main(args: Array<String>) = ui.application {
    val window = ui.Window("Button example", width=320, height=60)
    window.margined = true

    val button = ui.Button()
    button.text = "Konan говорит: click me!"
    button.onClick { println ("Hi Kotlin") }
    window.child = button

    window.show()
}

package ui

import kotlinx.cinterop.*
import libui.*

/**
 * Initializes package ui, runs [init] to set up the program,
 * and executes the GUI main loop. [init] should set up the program's
 * initial state: open the main window, create controls, and set up
 * events.
 */
fun application(init: () -> Unit) {
    memScoped {
        val options = alloc<uiInitOptions>()
        uiInit(options.ptr)
    }
    init()
    uiMain()
}

/**
 * This class is the abstract superclass of all user interface objects (controls, widgets).
 */
abstract class Control(private val _ptr: COpaquePointer?) {
    internal val ptr: COpaquePointer get() = _ptr ?: throw Error("Control is disposed")

    /**
     * Whether the control should be enabled or disabled. 
     * Defaults to `true`.
     */
    var enabled: Boolean
        get() = uiControlEnabled(ptr.reinterpret()) != 0
        set(enabled) = if (enabled) uiControlEnable(ptr.reinterpret()) else uiControlDisable(ptr.reinterpret())

    /**
     * Whether the control should be visible or hidden. 
     * Defaults to `true`.
     */
    var visible: Boolean
        get() = uiControlVisible(ptr.reinterpret()) != 0
        set(visible) = if (visible) uiControlShow(ptr.reinterpret()) else uiControlHide(ptr.reinterpret())

    /**
     * Shortcut for `visible = true`
     */
    fun show() = uiControlShow(ptr.reinterpret())

    /**
     * Returns the OS-level handle that backs the control.
     * On OSs that use reference counting, it does not increment the
     * reference count; you are sharing package ui's reference.
     *
     * Implementations should call `uiControlHandle(ptr.reinterpret())` and
     * document exactly what kind of handle is returned.
     */
    abstract val handle: Long

    /**
     * Destroy the control and frees its resources.
     */
    open fun destroy() = uiControlDestroy(ptr.reinterpret())
}

/**
 * Window is a [Control] that represents a top-level window.
 * A Window contains one child Control that occupies the entirety of the window.
 * Though a Window is a Control, a Window cannot be the child of another Control.
 *
 * Example:
 * ```
 *     val window = ui.Window("Example window", width=640, height=480)
 *     window.show()
 * ```
 *
 * @param[title] text to show in window title bar.
 * @param[width] width of window in pixels
 * @param[height] height of window in pixels
 * @param[hasMenubar] specify that this window has a menu bar. See [Menu]
 */
class Window(title: String, width: Int, height: Int, hasMenubar: Boolean = true) 
    : Control(uiNewWindow(title, width, height, if (hasMenubar) 1 else 0)) {

    /**
     * Returns the OS-level handle associated with this Window.
     * On Windows this is an HWND of a libui-internal class.
     * On GTK+ this is a pointer to a GtkWindow.
     * On OS X this is a pointer to a NSWindow.
     */
    override val handle: Long get() = uiControlHandle(ptr.reinterpret())
 
    /**
     * Specify the control to show in window content area.
     * [Window] instances could contains only one control.
     * If you need more, you have to use [Container]
     */
    var child: Control? = null
        set(child) {
            field = child
            uiWindowSetChild(ptr.reinterpret(), child?.ptr?.reinterpret())
        }

    /**
     * Set or return the text to show in window title bar.
     */
    var title: String
        get() = uiWindowTitle(ptr.reinterpret())?.toKString() ?: ""
        set(title) = uiWindowSetTitle(ptr.reinterpret(), title)

    /**
     * Specify if the window content should have a margin or not.
     * Defaults to `false`.
     */
    var margined: Boolean
        get() = uiWindowMargined(ptr.reinterpret()) != 0
        set(margined) = uiWindowSetMargined(ptr.reinterpret(), if (margined) 1 else 0)

    /**
     * Close the window.
     */
    fun close() = uiControlDestroy(ptr.reinterpret())

    /**
     * Registers [handler] to be run when the user clicks the Window's
     * close button. Only one function can be registered at a time.
     */
    fun onClosing(handler: Window.() -> Unit) { onClosing = handler }
    internal var onClosing: (Window.() -> Unit)? = null
    internal fun onClosing() {
        val isToplevel = uiControlToplevel(ptr.reinterpret()) != 0
        onClosing?.invoke(this)
        close()
        if (isToplevel) uiQuit()
    }

    init {
        windows[ptr.reinterpret()] = this
        uiWindowOnClosing(ptr.reinterpret(), staticCFunction(::windowClosing), null)
    }

    /**
     * Destroys the Window. If the Window has a child,
     * it calls destroy on that as well.
     */
    override fun destroy() {
        visible = false
        child?.destroy()
        child = null
        onClosing = null
        windows.remove(ptr.reinterpret())
        super.destroy()
    }
}

private var windows = mutableMapOf<CPointer<uiWindow>, Window>()

@Suppress("UNUSED_PARAMETER")
private fun windowClosing(ptr: CPointer<uiWindow>?, data: COpaquePointer?): Int {
    val window = windows[ptr!!.reinterpret()] ?: throw Error("Window is disposed")
    window.onClosing()
    return 0
}

/**
 * Button is a [Control] that represents a button that the user can
 * click to perform an action. A Button has a text label that should
 * describe what the button does.
 *
 * Example:
 * ```
 *     val window = ui.Window("Button example", width=320, height=60)
 *     val button = ui.Button()
 *     button.text = "sample text"
 *     window.child = button
 *     window.show()
 * ```
 *
 * @param[text] static text of the button.
 */
class Button(text: String = "")
    : Control(uiNewButton(text)) {

    /**
     * Returns the OS-level handle associated with this Button.
     * On Windows this is an HWND of a standard Windows API BUTTON
     * class (as provided by Common Controls version 6).
     * On GTK+ this is a pointer to a GtkButton.
     * On OS X this is a pointer to a NSButton.
     */
    override val handle: Long get() = uiControlHandle(ptr.reinterpret())

    /**
     * Set or return the static text of the button.
     */
    var text: String
        get() = uiButtonText(ptr.reinterpret())?.toKString() ?: ""
        set(text) = uiButtonSetText(ptr.reinterpret(), text)

    /**
     * Registers [handler] to be run when the user clicks the Button.
     * Only one function can be registered at a time.
     */
    fun onClick(handler: Button.() -> Unit) { onClick = handler }
    internal var onClick: (Button.() -> Unit)? = null
    internal fun onClick() = onClick?.invoke(this)

    init {
        buttons[ptr.reinterpret()] = this
        uiButtonOnClicked(ptr.reinterpret(), staticCFunction(::buttonClicked), null)
    }

    /**
     * Destroys the Button.
     */
    override fun destroy() {
        onClick = null
        buttons.remove(ptr.reinterpret())
        super.destroy()
    }
}

private var buttons = mutableMapOf<CPointer<uiButton>, Button>()

@Suppress("UNUSED_PARAMETER")
private fun buttonClicked(ptr: CPointer<uiButton>?, data: COpaquePointer?) {
    val button = buttons[ptr!!.reinterpret()] ?: throw Error("Button is disposed")
    button.onClick()
}

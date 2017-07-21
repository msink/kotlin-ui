@file:Suppress("UNUSED_EXPRESSION", "UNUSED_VARIABLE")
package libui

import konan.SymbolName
import kotlinx.cinterop.*

fun uiInit(options: CValuesRef<uiInitOptions>?): CPointer<ByteVar>? {
    return memScoped {
        val _options = options?.getPointer(memScope).rawValue
        val res = kni_uiInit(_options)
        interpretCPointer<ByteVar>(res)
    }
}

@SymbolName("libui_kni_uiInit")
private external fun kni_uiInit(options: NativePtr): NativePtr

fun uiUninit(): Unit {
    val res = kni_uiUninit()
    return res
}

@SymbolName("libui_kni_uiUninit")
private external fun kni_uiUninit(): Unit

fun uiFreeInitError(err: String?): Unit {
    return memScoped {
        val _err = err?.cstr?.getPointer(memScope).rawValue
        val res = kni_uiFreeInitError(_err)
        res
    }
}

@SymbolName("libui_kni_uiFreeInitError")
private external fun kni_uiFreeInitError(err: NativePtr): Unit

fun uiMain(): Unit {
    val res = kni_uiMain()
    return res
}

@SymbolName("libui_kni_uiMain")
private external fun kni_uiMain(): Unit

fun uiMainStep(wait: Int): Int {
    val _wait = wait
    val res = kni_uiMainStep(_wait)
    return res
}

@SymbolName("libui_kni_uiMainStep")
private external fun kni_uiMainStep(wait: Int): Int

fun uiQuit(): Unit {
    val res = kni_uiQuit()
    return res
}

@SymbolName("libui_kni_uiQuit")
private external fun kni_uiQuit(): Unit

fun uiQueueMain(f: CPointer<CFunction<(COpaquePointer?) -> Unit>>?, data: COpaquePointer?): Unit {
    val _f = f.rawValue
    val _data = data.rawValue
    val res = kni_uiQueueMain(_f, _data)
    return res
}

@SymbolName("libui_kni_uiQueueMain")
private external fun kni_uiQueueMain(f: NativePtr, data: NativePtr): Unit

fun uiOnShouldQuit(f: CPointer<CFunction<(COpaquePointer?) -> Int>>?, data: COpaquePointer?): Unit {
    val _f = f.rawValue
    val _data = data.rawValue
    val res = kni_uiOnShouldQuit(_f, _data)
    return res
}

@SymbolName("libui_kni_uiOnShouldQuit")
private external fun kni_uiOnShouldQuit(f: NativePtr, data: NativePtr): Unit

fun uiFreeText(text: CValuesRef<ByteVar>?): Unit {
    return memScoped {
        val _text = text?.getPointer(memScope).rawValue
        val res = kni_uiFreeText(_text)
        res
    }
}

@SymbolName("libui_kni_uiFreeText")
private external fun kni_uiFreeText(text: NativePtr): Unit

fun uiControlDestroy(arg0: CValuesRef<uiControl>?): Unit {
    return memScoped {
        val _arg0 = arg0?.getPointer(memScope).rawValue
        val res = kni_uiControlDestroy(_arg0)
        res
    }
}

@SymbolName("libui_kni_uiControlDestroy")
private external fun kni_uiControlDestroy(arg0: NativePtr): Unit

fun uiControlHandle(arg0: CValuesRef<uiControl>?): uintptr_t {
    return memScoped {
        val _arg0 = arg0?.getPointer(memScope).rawValue
        val res = kni_uiControlHandle(_arg0)
        res
    }
}

@SymbolName("libui_kni_uiControlHandle")
private external fun kni_uiControlHandle(arg0: NativePtr): Long

fun uiControlParent(arg0: CValuesRef<uiControl>?): CPointer<uiControl>? {
    return memScoped {
        val _arg0 = arg0?.getPointer(memScope).rawValue
        val res = kni_uiControlParent(_arg0)
        interpretCPointer<uiControl>(res)
    }
}

@SymbolName("libui_kni_uiControlParent")
private external fun kni_uiControlParent(arg0: NativePtr): NativePtr

fun uiControlSetParent(arg0: CValuesRef<uiControl>?, arg1: CValuesRef<uiControl>?): Unit {
    return memScoped {
        val _arg0 = arg0?.getPointer(memScope).rawValue
        val _arg1 = arg1?.getPointer(memScope).rawValue
        val res = kni_uiControlSetParent(_arg0, _arg1)
        res
    }
}

@SymbolName("libui_kni_uiControlSetParent")
private external fun kni_uiControlSetParent(arg0: NativePtr, arg1: NativePtr): Unit

fun uiControlToplevel(arg0: CValuesRef<uiControl>?): Int {
    return memScoped {
        val _arg0 = arg0?.getPointer(memScope).rawValue
        val res = kni_uiControlToplevel(_arg0)
        res
    }
}

@SymbolName("libui_kni_uiControlToplevel")
private external fun kni_uiControlToplevel(arg0: NativePtr): Int

fun uiControlVisible(arg0: CValuesRef<uiControl>?): Int {
    return memScoped {
        val _arg0 = arg0?.getPointer(memScope).rawValue
        val res = kni_uiControlVisible(_arg0)
        res
    }
}

@SymbolName("libui_kni_uiControlVisible")
private external fun kni_uiControlVisible(arg0: NativePtr): Int

fun uiControlShow(arg0: CValuesRef<uiControl>?): Unit {
    return memScoped {
        val _arg0 = arg0?.getPointer(memScope).rawValue
        val res = kni_uiControlShow(_arg0)
        res
    }
}

@SymbolName("libui_kni_uiControlShow")
private external fun kni_uiControlShow(arg0: NativePtr): Unit

fun uiControlHide(arg0: CValuesRef<uiControl>?): Unit {
    return memScoped {
        val _arg0 = arg0?.getPointer(memScope).rawValue
        val res = kni_uiControlHide(_arg0)
        res
    }
}

@SymbolName("libui_kni_uiControlHide")
private external fun kni_uiControlHide(arg0: NativePtr): Unit

fun uiControlEnabled(arg0: CValuesRef<uiControl>?): Int {
    return memScoped {
        val _arg0 = arg0?.getPointer(memScope).rawValue
        val res = kni_uiControlEnabled(_arg0)
        res
    }
}

@SymbolName("libui_kni_uiControlEnabled")
private external fun kni_uiControlEnabled(arg0: NativePtr): Int

fun uiControlEnable(arg0: CValuesRef<uiControl>?): Unit {
    return memScoped {
        val _arg0 = arg0?.getPointer(memScope).rawValue
        val res = kni_uiControlEnable(_arg0)
        res
    }
}

@SymbolName("libui_kni_uiControlEnable")
private external fun kni_uiControlEnable(arg0: NativePtr): Unit

fun uiControlDisable(arg0: CValuesRef<uiControl>?): Unit {
    return memScoped {
        val _arg0 = arg0?.getPointer(memScope).rawValue
        val res = kni_uiControlDisable(_arg0)
        res
    }
}

@SymbolName("libui_kni_uiControlDisable")
private external fun kni_uiControlDisable(arg0: NativePtr): Unit

fun uiAllocControl(n: size_t, OSsig: uint32_t, typesig: uint32_t, typenamestr: String?): CPointer<uiControl>? {
    return memScoped {
        val _n = n
        val _OSsig = OSsig
        val _typesig = typesig
        val _typenamestr = typenamestr?.cstr?.getPointer(memScope).rawValue
        val res = kni_uiAllocControl(_n, _OSsig, _typesig, _typenamestr)
        interpretCPointer<uiControl>(res)
    }
}

@SymbolName("libui_kni_uiAllocControl")
private external fun kni_uiAllocControl(n: Long, OSsig: Int, typesig: Int, typenamestr: NativePtr): NativePtr

fun uiFreeControl(arg0: CValuesRef<uiControl>?): Unit {
    return memScoped {
        val _arg0 = arg0?.getPointer(memScope).rawValue
        val res = kni_uiFreeControl(_arg0)
        res
    }
}

@SymbolName("libui_kni_uiFreeControl")
private external fun kni_uiFreeControl(arg0: NativePtr): Unit

fun uiControlVerifySetParent(arg0: CValuesRef<uiControl>?, arg1: CValuesRef<uiControl>?): Unit {
    return memScoped {
        val _arg0 = arg0?.getPointer(memScope).rawValue
        val _arg1 = arg1?.getPointer(memScope).rawValue
        val res = kni_uiControlVerifySetParent(_arg0, _arg1)
        res
    }
}

@SymbolName("libui_kni_uiControlVerifySetParent")
private external fun kni_uiControlVerifySetParent(arg0: NativePtr, arg1: NativePtr): Unit

fun uiControlEnabledToUser(arg0: CValuesRef<uiControl>?): Int {
    return memScoped {
        val _arg0 = arg0?.getPointer(memScope).rawValue
        val res = kni_uiControlEnabledToUser(_arg0)
        res
    }
}

@SymbolName("libui_kni_uiControlEnabledToUser")
private external fun kni_uiControlEnabledToUser(arg0: NativePtr): Int

fun uiUserBugCannotSetParentOnToplevel(type: String?): Unit {
    return memScoped {
        val _type = type?.cstr?.getPointer(memScope).rawValue
        val res = kni_uiUserBugCannotSetParentOnToplevel(_type)
        res
    }
}

@SymbolName("libui_kni_uiUserBugCannotSetParentOnToplevel")
private external fun kni_uiUserBugCannotSetParentOnToplevel(type: NativePtr): Unit

fun uiWindowTitle(w: CValuesRef<uiWindow>?): CPointer<ByteVar>? {
    return memScoped {
        val _w = w?.getPointer(memScope).rawValue
        val res = kni_uiWindowTitle(_w)
        interpretCPointer<ByteVar>(res)
    }
}

@SymbolName("libui_kni_uiWindowTitle")
private external fun kni_uiWindowTitle(w: NativePtr): NativePtr

fun uiWindowSetTitle(w: CValuesRef<uiWindow>?, title: String?): Unit {
    return memScoped {
        val _w = w?.getPointer(memScope).rawValue
        val _title = title?.cstr?.getPointer(memScope).rawValue
        val res = kni_uiWindowSetTitle(_w, _title)
        res
    }
}

@SymbolName("libui_kni_uiWindowSetTitle")
private external fun kni_uiWindowSetTitle(w: NativePtr, title: NativePtr): Unit

fun uiWindowOnClosing(w: CValuesRef<uiWindow>?, f: CPointer<CFunction<(CPointer<uiWindow>?, COpaquePointer?) -> Int>>?, data: COpaquePointer?): Unit {
    return memScoped {
        val _w = w?.getPointer(memScope).rawValue
        val _f = f.rawValue
        val _data = data.rawValue
        val res = kni_uiWindowOnClosing(_w, _f, _data)
        res
    }
}

@SymbolName("libui_kni_uiWindowOnClosing")
private external fun kni_uiWindowOnClosing(w: NativePtr, f: NativePtr, data: NativePtr): Unit

fun uiWindowSetChild(w: CValuesRef<uiWindow>?, child: CValuesRef<uiControl>?): Unit {
    return memScoped {
        val _w = w?.getPointer(memScope).rawValue
        val _child = child?.getPointer(memScope).rawValue
        val res = kni_uiWindowSetChild(_w, _child)
        res
    }
}

@SymbolName("libui_kni_uiWindowSetChild")
private external fun kni_uiWindowSetChild(w: NativePtr, child: NativePtr): Unit

fun uiWindowMargined(w: CValuesRef<uiWindow>?): Int {
    return memScoped {
        val _w = w?.getPointer(memScope).rawValue
        val res = kni_uiWindowMargined(_w)
        res
    }
}

@SymbolName("libui_kni_uiWindowMargined")
private external fun kni_uiWindowMargined(w: NativePtr): Int

fun uiWindowSetMargined(w: CValuesRef<uiWindow>?, margined: Int): Unit {
    return memScoped {
        val _w = w?.getPointer(memScope).rawValue
        val _margined = margined
        val res = kni_uiWindowSetMargined(_w, _margined)
        res
    }
}

@SymbolName("libui_kni_uiWindowSetMargined")
private external fun kni_uiWindowSetMargined(w: NativePtr, margined: Int): Unit

fun uiNewWindow(title: String?, width: Int, height: Int, hasMenubar: Int): CPointer<uiWindow>? {
    return memScoped {
        val _title = title?.cstr?.getPointer(memScope).rawValue
        val _width = width
        val _height = height
        val _hasMenubar = hasMenubar
        val res = kni_uiNewWindow(_title, _width, _height, _hasMenubar)
        interpretCPointer<uiWindow>(res)
    }
}

@SymbolName("libui_kni_uiNewWindow")
private external fun kni_uiNewWindow(title: NativePtr, width: Int, height: Int, hasMenubar: Int): NativePtr

fun uiButtonText(b: CValuesRef<uiButton>?): CPointer<ByteVar>? {
    return memScoped {
        val _b = b?.getPointer(memScope).rawValue
        val res = kni_uiButtonText(_b)
        interpretCPointer<ByteVar>(res)
    }
}

@SymbolName("libui_kni_uiButtonText")
private external fun kni_uiButtonText(b: NativePtr): NativePtr

fun uiButtonSetText(b: CValuesRef<uiButton>?, text: String?): Unit {
    return memScoped {
        val _b = b?.getPointer(memScope).rawValue
        val _text = text?.cstr?.getPointer(memScope).rawValue
        val res = kni_uiButtonSetText(_b, _text)
        res
    }
}

@SymbolName("libui_kni_uiButtonSetText")
private external fun kni_uiButtonSetText(b: NativePtr, text: NativePtr): Unit

fun uiButtonOnClicked(b: CValuesRef<uiButton>?, f: CPointer<CFunction<(CPointer<uiButton>?, COpaquePointer?) -> Unit>>?, data: COpaquePointer?): Unit {
    return memScoped {
        val _b = b?.getPointer(memScope).rawValue
        val _f = f.rawValue
        val _data = data.rawValue
        val res = kni_uiButtonOnClicked(_b, _f, _data)
        res
    }
}

@SymbolName("libui_kni_uiButtonOnClicked")
private external fun kni_uiButtonOnClicked(b: NativePtr, f: NativePtr, data: NativePtr): Unit

fun uiNewButton(text: String?): CPointer<uiButton>? {
    return memScoped {
        val _text = text?.cstr?.getPointer(memScope).rawValue
        val res = kni_uiNewButton(_text)
        interpretCPointer<uiButton>(res)
    }
}

@SymbolName("libui_kni_uiNewButton")
private external fun kni_uiNewButton(text: NativePtr): NativePtr

fun uiBoxAppend(b: CValuesRef<uiBox>?, child: CValuesRef<uiControl>?, stretchy: Int): Unit {
    return memScoped {
        val _b = b?.getPointer(memScope).rawValue
        val _child = child?.getPointer(memScope).rawValue
        val _stretchy = stretchy
        val res = kni_uiBoxAppend(_b, _child, _stretchy)
        res
    }
}

@SymbolName("libui_kni_uiBoxAppend")
private external fun kni_uiBoxAppend(b: NativePtr, child: NativePtr, stretchy: Int): Unit

fun uiBoxDelete(b: CValuesRef<uiBox>?, index: uintmax_t): Unit {
    return memScoped {
        val _b = b?.getPointer(memScope).rawValue
        val _index = index
        val res = kni_uiBoxDelete(_b, _index)
        res
    }
}

@SymbolName("libui_kni_uiBoxDelete")
private external fun kni_uiBoxDelete(b: NativePtr, index: Long): Unit

fun uiBoxPadded(b: CValuesRef<uiBox>?): Int {
    return memScoped {
        val _b = b?.getPointer(memScope).rawValue
        val res = kni_uiBoxPadded(_b)
        res
    }
}

@SymbolName("libui_kni_uiBoxPadded")
private external fun kni_uiBoxPadded(b: NativePtr): Int

fun uiBoxSetPadded(b: CValuesRef<uiBox>?, padded: Int): Unit {
    return memScoped {
        val _b = b?.getPointer(memScope).rawValue
        val _padded = padded
        val res = kni_uiBoxSetPadded(_b, _padded)
        res
    }
}

@SymbolName("libui_kni_uiBoxSetPadded")
private external fun kni_uiBoxSetPadded(b: NativePtr, padded: Int): Unit

fun uiNewHorizontalBox(): CPointer<uiBox>? {
    val res = kni_uiNewHorizontalBox()
    return interpretCPointer<uiBox>(res)
}

@SymbolName("libui_kni_uiNewHorizontalBox")
private external fun kni_uiNewHorizontalBox(): NativePtr

fun uiNewVerticalBox(): CPointer<uiBox>? {
    val res = kni_uiNewVerticalBox()
    return interpretCPointer<uiBox>(res)
}

@SymbolName("libui_kni_uiNewVerticalBox")
private external fun kni_uiNewVerticalBox(): NativePtr

fun uiCheckboxText(c: CValuesRef<uiCheckbox>?): CPointer<ByteVar>? {
    return memScoped {
        val _c = c?.getPointer(memScope).rawValue
        val res = kni_uiCheckboxText(_c)
        interpretCPointer<ByteVar>(res)
    }
}

@SymbolName("libui_kni_uiCheckboxText")
private external fun kni_uiCheckboxText(c: NativePtr): NativePtr

fun uiCheckboxSetText(c: CValuesRef<uiCheckbox>?, text: String?): Unit {
    return memScoped {
        val _c = c?.getPointer(memScope).rawValue
        val _text = text?.cstr?.getPointer(memScope).rawValue
        val res = kni_uiCheckboxSetText(_c, _text)
        res
    }
}

@SymbolName("libui_kni_uiCheckboxSetText")
private external fun kni_uiCheckboxSetText(c: NativePtr, text: NativePtr): Unit

fun uiCheckboxOnToggled(c: CValuesRef<uiCheckbox>?, f: CPointer<CFunction<(CPointer<uiCheckbox>?, COpaquePointer?) -> Unit>>?, data: COpaquePointer?): Unit {
    return memScoped {
        val _c = c?.getPointer(memScope).rawValue
        val _f = f.rawValue
        val _data = data.rawValue
        val res = kni_uiCheckboxOnToggled(_c, _f, _data)
        res
    }
}

@SymbolName("libui_kni_uiCheckboxOnToggled")
private external fun kni_uiCheckboxOnToggled(c: NativePtr, f: NativePtr, data: NativePtr): Unit

fun uiCheckboxChecked(c: CValuesRef<uiCheckbox>?): Int {
    return memScoped {
        val _c = c?.getPointer(memScope).rawValue
        val res = kni_uiCheckboxChecked(_c)
        res
    }
}

@SymbolName("libui_kni_uiCheckboxChecked")
private external fun kni_uiCheckboxChecked(c: NativePtr): Int

fun uiCheckboxSetChecked(c: CValuesRef<uiCheckbox>?, checked: Int): Unit {
    return memScoped {
        val _c = c?.getPointer(memScope).rawValue
        val _checked = checked
        val res = kni_uiCheckboxSetChecked(_c, _checked)
        res
    }
}

@SymbolName("libui_kni_uiCheckboxSetChecked")
private external fun kni_uiCheckboxSetChecked(c: NativePtr, checked: Int): Unit

fun uiNewCheckbox(text: String?): CPointer<uiCheckbox>? {
    return memScoped {
        val _text = text?.cstr?.getPointer(memScope).rawValue
        val res = kni_uiNewCheckbox(_text)
        interpretCPointer<uiCheckbox>(res)
    }
}

@SymbolName("libui_kni_uiNewCheckbox")
private external fun kni_uiNewCheckbox(text: NativePtr): NativePtr

fun uiEntryText(e: CValuesRef<uiEntry>?): CPointer<ByteVar>? {
    return memScoped {
        val _e = e?.getPointer(memScope).rawValue
        val res = kni_uiEntryText(_e)
        interpretCPointer<ByteVar>(res)
    }
}

@SymbolName("libui_kni_uiEntryText")
private external fun kni_uiEntryText(e: NativePtr): NativePtr

fun uiEntrySetText(e: CValuesRef<uiEntry>?, text: String?): Unit {
    return memScoped {
        val _e = e?.getPointer(memScope).rawValue
        val _text = text?.cstr?.getPointer(memScope).rawValue
        val res = kni_uiEntrySetText(_e, _text)
        res
    }
}

@SymbolName("libui_kni_uiEntrySetText")
private external fun kni_uiEntrySetText(e: NativePtr, text: NativePtr): Unit

fun uiEntryOnChanged(e: CValuesRef<uiEntry>?, f: CPointer<CFunction<(CPointer<uiEntry>?, COpaquePointer?) -> Unit>>?, data: COpaquePointer?): Unit {
    return memScoped {
        val _e = e?.getPointer(memScope).rawValue
        val _f = f.rawValue
        val _data = data.rawValue
        val res = kni_uiEntryOnChanged(_e, _f, _data)
        res
    }
}

@SymbolName("libui_kni_uiEntryOnChanged")
private external fun kni_uiEntryOnChanged(e: NativePtr, f: NativePtr, data: NativePtr): Unit

fun uiEntryReadOnly(e: CValuesRef<uiEntry>?): Int {
    return memScoped {
        val _e = e?.getPointer(memScope).rawValue
        val res = kni_uiEntryReadOnly(_e)
        res
    }
}

@SymbolName("libui_kni_uiEntryReadOnly")
private external fun kni_uiEntryReadOnly(e: NativePtr): Int

fun uiEntrySetReadOnly(e: CValuesRef<uiEntry>?, readonly: Int): Unit {
    return memScoped {
        val _e = e?.getPointer(memScope).rawValue
        val _readonly = readonly
        val res = kni_uiEntrySetReadOnly(_e, _readonly)
        res
    }
}

@SymbolName("libui_kni_uiEntrySetReadOnly")
private external fun kni_uiEntrySetReadOnly(e: NativePtr, readonly: Int): Unit

fun uiNewEntry(): CPointer<uiEntry>? {
    val res = kni_uiNewEntry()
    return interpretCPointer<uiEntry>(res)
}

@SymbolName("libui_kni_uiNewEntry")
private external fun kni_uiNewEntry(): NativePtr

fun uiLabelText(l: CValuesRef<uiLabel>?): CPointer<ByteVar>? {
    return memScoped {
        val _l = l?.getPointer(memScope).rawValue
        val res = kni_uiLabelText(_l)
        interpretCPointer<ByteVar>(res)
    }
}

@SymbolName("libui_kni_uiLabelText")
private external fun kni_uiLabelText(l: NativePtr): NativePtr

fun uiLabelSetText(l: CValuesRef<uiLabel>?, text: String?): Unit {
    return memScoped {
        val _l = l?.getPointer(memScope).rawValue
        val _text = text?.cstr?.getPointer(memScope).rawValue
        val res = kni_uiLabelSetText(_l, _text)
        res
    }
}

@SymbolName("libui_kni_uiLabelSetText")
private external fun kni_uiLabelSetText(l: NativePtr, text: NativePtr): Unit

fun uiNewLabel(text: String?): CPointer<uiLabel>? {
    return memScoped {
        val _text = text?.cstr?.getPointer(memScope).rawValue
        val res = kni_uiNewLabel(_text)
        interpretCPointer<uiLabel>(res)
    }
}

@SymbolName("libui_kni_uiNewLabel")
private external fun kni_uiNewLabel(text: NativePtr): NativePtr

fun uiTabAppend(t: CValuesRef<uiTab>?, name: String?, c: CValuesRef<uiControl>?): Unit {
    return memScoped {
        val _t = t?.getPointer(memScope).rawValue
        val _name = name?.cstr?.getPointer(memScope).rawValue
        val _c = c?.getPointer(memScope).rawValue
        val res = kni_uiTabAppend(_t, _name, _c)
        res
    }
}

@SymbolName("libui_kni_uiTabAppend")
private external fun kni_uiTabAppend(t: NativePtr, name: NativePtr, c: NativePtr): Unit

fun uiTabInsertAt(t: CValuesRef<uiTab>?, name: String?, before: uintmax_t, c: CValuesRef<uiControl>?): Unit {
    return memScoped {
        val _t = t?.getPointer(memScope).rawValue
        val _name = name?.cstr?.getPointer(memScope).rawValue
        val _before = before
        val _c = c?.getPointer(memScope).rawValue
        val res = kni_uiTabInsertAt(_t, _name, _before, _c)
        res
    }
}

@SymbolName("libui_kni_uiTabInsertAt")
private external fun kni_uiTabInsertAt(t: NativePtr, name: NativePtr, before: Long, c: NativePtr): Unit

fun uiTabDelete(t: CValuesRef<uiTab>?, index: uintmax_t): Unit {
    return memScoped {
        val _t = t?.getPointer(memScope).rawValue
        val _index = index
        val res = kni_uiTabDelete(_t, _index)
        res
    }
}

@SymbolName("libui_kni_uiTabDelete")
private external fun kni_uiTabDelete(t: NativePtr, index: Long): Unit

fun uiTabNumPages(t: CValuesRef<uiTab>?): uintmax_t {
    return memScoped {
        val _t = t?.getPointer(memScope).rawValue
        val res = kni_uiTabNumPages(_t)
        res
    }
}

@SymbolName("libui_kni_uiTabNumPages")
private external fun kni_uiTabNumPages(t: NativePtr): Long

fun uiTabMargined(t: CValuesRef<uiTab>?, page: uintmax_t): Int {
    return memScoped {
        val _t = t?.getPointer(memScope).rawValue
        val _page = page
        val res = kni_uiTabMargined(_t, _page)
        res
    }
}

@SymbolName("libui_kni_uiTabMargined")
private external fun kni_uiTabMargined(t: NativePtr, page: Long): Int

fun uiTabSetMargined(t: CValuesRef<uiTab>?, page: uintmax_t, margined: Int): Unit {
    return memScoped {
        val _t = t?.getPointer(memScope).rawValue
        val _page = page
        val _margined = margined
        val res = kni_uiTabSetMargined(_t, _page, _margined)
        res
    }
}

@SymbolName("libui_kni_uiTabSetMargined")
private external fun kni_uiTabSetMargined(t: NativePtr, page: Long, margined: Int): Unit

fun uiNewTab(): CPointer<uiTab>? {
    val res = kni_uiNewTab()
    return interpretCPointer<uiTab>(res)
}

@SymbolName("libui_kni_uiNewTab")
private external fun kni_uiNewTab(): NativePtr

fun uiGroupTitle(g: CValuesRef<uiGroup>?): CPointer<ByteVar>? {
    return memScoped {
        val _g = g?.getPointer(memScope).rawValue
        val res = kni_uiGroupTitle(_g)
        interpretCPointer<ByteVar>(res)
    }
}

@SymbolName("libui_kni_uiGroupTitle")
private external fun kni_uiGroupTitle(g: NativePtr): NativePtr

fun uiGroupSetTitle(g: CValuesRef<uiGroup>?, title: String?): Unit {
    return memScoped {
        val _g = g?.getPointer(memScope).rawValue
        val _title = title?.cstr?.getPointer(memScope).rawValue
        val res = kni_uiGroupSetTitle(_g, _title)
        res
    }
}

@SymbolName("libui_kni_uiGroupSetTitle")
private external fun kni_uiGroupSetTitle(g: NativePtr, title: NativePtr): Unit

fun uiGroupSetChild(g: CValuesRef<uiGroup>?, c: CValuesRef<uiControl>?): Unit {
    return memScoped {
        val _g = g?.getPointer(memScope).rawValue
        val _c = c?.getPointer(memScope).rawValue
        val res = kni_uiGroupSetChild(_g, _c)
        res
    }
}

@SymbolName("libui_kni_uiGroupSetChild")
private external fun kni_uiGroupSetChild(g: NativePtr, c: NativePtr): Unit

fun uiGroupMargined(g: CValuesRef<uiGroup>?): Int {
    return memScoped {
        val _g = g?.getPointer(memScope).rawValue
        val res = kni_uiGroupMargined(_g)
        res
    }
}

@SymbolName("libui_kni_uiGroupMargined")
private external fun kni_uiGroupMargined(g: NativePtr): Int

fun uiGroupSetMargined(g: CValuesRef<uiGroup>?, margined: Int): Unit {
    return memScoped {
        val _g = g?.getPointer(memScope).rawValue
        val _margined = margined
        val res = kni_uiGroupSetMargined(_g, _margined)
        res
    }
}

@SymbolName("libui_kni_uiGroupSetMargined")
private external fun kni_uiGroupSetMargined(g: NativePtr, margined: Int): Unit

fun uiNewGroup(title: String?): CPointer<uiGroup>? {
    return memScoped {
        val _title = title?.cstr?.getPointer(memScope).rawValue
        val res = kni_uiNewGroup(_title)
        interpretCPointer<uiGroup>(res)
    }
}

@SymbolName("libui_kni_uiNewGroup")
private external fun kni_uiNewGroup(title: NativePtr): NativePtr

fun uiSpinboxValue(s: CValuesRef<uiSpinbox>?): intmax_t {
    return memScoped {
        val _s = s?.getPointer(memScope).rawValue
        val res = kni_uiSpinboxValue(_s)
        res
    }
}

@SymbolName("libui_kni_uiSpinboxValue")
private external fun kni_uiSpinboxValue(s: NativePtr): Long

fun uiSpinboxSetValue(s: CValuesRef<uiSpinbox>?, value: intmax_t): Unit {
    return memScoped {
        val _s = s?.getPointer(memScope).rawValue
        val _value = value
        val res = kni_uiSpinboxSetValue(_s, _value)
        res
    }
}

@SymbolName("libui_kni_uiSpinboxSetValue")
private external fun kni_uiSpinboxSetValue(s: NativePtr, value: Long): Unit

fun uiSpinboxOnChanged(s: CValuesRef<uiSpinbox>?, f: CPointer<CFunction<(CPointer<uiSpinbox>?, COpaquePointer?) -> Unit>>?, data: COpaquePointer?): Unit {
    return memScoped {
        val _s = s?.getPointer(memScope).rawValue
        val _f = f.rawValue
        val _data = data.rawValue
        val res = kni_uiSpinboxOnChanged(_s, _f, _data)
        res
    }
}

@SymbolName("libui_kni_uiSpinboxOnChanged")
private external fun kni_uiSpinboxOnChanged(s: NativePtr, f: NativePtr, data: NativePtr): Unit

fun uiNewSpinbox(min: intmax_t, max: intmax_t): CPointer<uiSpinbox>? {
    val _min = min
    val _max = max
    val res = kni_uiNewSpinbox(_min, _max)
    return interpretCPointer<uiSpinbox>(res)
}

@SymbolName("libui_kni_uiNewSpinbox")
private external fun kni_uiNewSpinbox(min: Long, max: Long): NativePtr

fun uiSliderValue(s: CValuesRef<uiSlider>?): intmax_t {
    return memScoped {
        val _s = s?.getPointer(memScope).rawValue
        val res = kni_uiSliderValue(_s)
        res
    }
}

@SymbolName("libui_kni_uiSliderValue")
private external fun kni_uiSliderValue(s: NativePtr): Long

fun uiSliderSetValue(s: CValuesRef<uiSlider>?, value: intmax_t): Unit {
    return memScoped {
        val _s = s?.getPointer(memScope).rawValue
        val _value = value
        val res = kni_uiSliderSetValue(_s, _value)
        res
    }
}

@SymbolName("libui_kni_uiSliderSetValue")
private external fun kni_uiSliderSetValue(s: NativePtr, value: Long): Unit

fun uiSliderOnChanged(s: CValuesRef<uiSlider>?, f: CPointer<CFunction<(CPointer<uiSlider>?, COpaquePointer?) -> Unit>>?, data: COpaquePointer?): Unit {
    return memScoped {
        val _s = s?.getPointer(memScope).rawValue
        val _f = f.rawValue
        val _data = data.rawValue
        val res = kni_uiSliderOnChanged(_s, _f, _data)
        res
    }
}

@SymbolName("libui_kni_uiSliderOnChanged")
private external fun kni_uiSliderOnChanged(s: NativePtr, f: NativePtr, data: NativePtr): Unit

fun uiNewSlider(min: intmax_t, max: intmax_t): CPointer<uiSlider>? {
    val _min = min
    val _max = max
    val res = kni_uiNewSlider(_min, _max)
    return interpretCPointer<uiSlider>(res)
}

@SymbolName("libui_kni_uiNewSlider")
private external fun kni_uiNewSlider(min: Long, max: Long): NativePtr

fun uiProgressBarSetValue(p: CValuesRef<uiProgressBar>?, n: Int): Unit {
    return memScoped {
        val _p = p?.getPointer(memScope).rawValue
        val _n = n
        val res = kni_uiProgressBarSetValue(_p, _n)
        res
    }
}

@SymbolName("libui_kni_uiProgressBarSetValue")
private external fun kni_uiProgressBarSetValue(p: NativePtr, n: Int): Unit

fun uiNewProgressBar(): CPointer<uiProgressBar>? {
    val res = kni_uiNewProgressBar()
    return interpretCPointer<uiProgressBar>(res)
}

@SymbolName("libui_kni_uiNewProgressBar")
private external fun kni_uiNewProgressBar(): NativePtr

fun uiNewHorizontalSeparator(): CPointer<uiSeparator>? {
    val res = kni_uiNewHorizontalSeparator()
    return interpretCPointer<uiSeparator>(res)
}

@SymbolName("libui_kni_uiNewHorizontalSeparator")
private external fun kni_uiNewHorizontalSeparator(): NativePtr

fun uiComboboxAppend(c: CValuesRef<uiCombobox>?, text: String?): Unit {
    return memScoped {
        val _c = c?.getPointer(memScope).rawValue
        val _text = text?.cstr?.getPointer(memScope).rawValue
        val res = kni_uiComboboxAppend(_c, _text)
        res
    }
}

@SymbolName("libui_kni_uiComboboxAppend")
private external fun kni_uiComboboxAppend(c: NativePtr, text: NativePtr): Unit

fun uiComboboxSelected(c: CValuesRef<uiCombobox>?): intmax_t {
    return memScoped {
        val _c = c?.getPointer(memScope).rawValue
        val res = kni_uiComboboxSelected(_c)
        res
    }
}

@SymbolName("libui_kni_uiComboboxSelected")
private external fun kni_uiComboboxSelected(c: NativePtr): Long

fun uiComboboxSetSelected(c: CValuesRef<uiCombobox>?, n: intmax_t): Unit {
    return memScoped {
        val _c = c?.getPointer(memScope).rawValue
        val _n = n
        val res = kni_uiComboboxSetSelected(_c, _n)
        res
    }
}

@SymbolName("libui_kni_uiComboboxSetSelected")
private external fun kni_uiComboboxSetSelected(c: NativePtr, n: Long): Unit

fun uiComboboxOnSelected(c: CValuesRef<uiCombobox>?, f: CPointer<CFunction<(CPointer<uiCombobox>?, COpaquePointer?) -> Unit>>?, data: COpaquePointer?): Unit {
    return memScoped {
        val _c = c?.getPointer(memScope).rawValue
        val _f = f.rawValue
        val _data = data.rawValue
        val res = kni_uiComboboxOnSelected(_c, _f, _data)
        res
    }
}

@SymbolName("libui_kni_uiComboboxOnSelected")
private external fun kni_uiComboboxOnSelected(c: NativePtr, f: NativePtr, data: NativePtr): Unit

fun uiNewCombobox(): CPointer<uiCombobox>? {
    val res = kni_uiNewCombobox()
    return interpretCPointer<uiCombobox>(res)
}

@SymbolName("libui_kni_uiNewCombobox")
private external fun kni_uiNewCombobox(): NativePtr

fun uiEditableComboboxAppend(c: CValuesRef<uiEditableCombobox>?, text: String?): Unit {
    return memScoped {
        val _c = c?.getPointer(memScope).rawValue
        val _text = text?.cstr?.getPointer(memScope).rawValue
        val res = kni_uiEditableComboboxAppend(_c, _text)
        res
    }
}

@SymbolName("libui_kni_uiEditableComboboxAppend")
private external fun kni_uiEditableComboboxAppend(c: NativePtr, text: NativePtr): Unit

fun uiEditableComboboxText(c: CValuesRef<uiEditableCombobox>?): CPointer<ByteVar>? {
    return memScoped {
        val _c = c?.getPointer(memScope).rawValue
        val res = kni_uiEditableComboboxText(_c)
        interpretCPointer<ByteVar>(res)
    }
}

@SymbolName("libui_kni_uiEditableComboboxText")
private external fun kni_uiEditableComboboxText(c: NativePtr): NativePtr

fun uiEditableComboboxSetText(c: CValuesRef<uiEditableCombobox>?, text: String?): Unit {
    return memScoped {
        val _c = c?.getPointer(memScope).rawValue
        val _text = text?.cstr?.getPointer(memScope).rawValue
        val res = kni_uiEditableComboboxSetText(_c, _text)
        res
    }
}

@SymbolName("libui_kni_uiEditableComboboxSetText")
private external fun kni_uiEditableComboboxSetText(c: NativePtr, text: NativePtr): Unit

fun uiEditableComboboxOnChanged(c: CValuesRef<uiEditableCombobox>?, f: CPointer<CFunction<(CPointer<uiEditableCombobox>?, COpaquePointer?) -> Unit>>?, data: COpaquePointer?): Unit {
    return memScoped {
        val _c = c?.getPointer(memScope).rawValue
        val _f = f.rawValue
        val _data = data.rawValue
        val res = kni_uiEditableComboboxOnChanged(_c, _f, _data)
        res
    }
}

@SymbolName("libui_kni_uiEditableComboboxOnChanged")
private external fun kni_uiEditableComboboxOnChanged(c: NativePtr, f: NativePtr, data: NativePtr): Unit

fun uiNewEditableCombobox(): CPointer<uiEditableCombobox>? {
    val res = kni_uiNewEditableCombobox()
    return interpretCPointer<uiEditableCombobox>(res)
}

@SymbolName("libui_kni_uiNewEditableCombobox")
private external fun kni_uiNewEditableCombobox(): NativePtr

fun uiRadioButtonsAppend(r: CValuesRef<uiRadioButtons>?, text: String?): Unit {
    return memScoped {
        val _r = r?.getPointer(memScope).rawValue
        val _text = text?.cstr?.getPointer(memScope).rawValue
        val res = kni_uiRadioButtonsAppend(_r, _text)
        res
    }
}

@SymbolName("libui_kni_uiRadioButtonsAppend")
private external fun kni_uiRadioButtonsAppend(r: NativePtr, text: NativePtr): Unit

fun uiNewRadioButtons(): CPointer<uiRadioButtons>? {
    val res = kni_uiNewRadioButtons()
    return interpretCPointer<uiRadioButtons>(res)
}

@SymbolName("libui_kni_uiNewRadioButtons")
private external fun kni_uiNewRadioButtons(): NativePtr

fun uiNewDateTimePicker(): CPointer<uiDateTimePicker>? {
    val res = kni_uiNewDateTimePicker()
    return interpretCPointer<uiDateTimePicker>(res)
}

@SymbolName("libui_kni_uiNewDateTimePicker")
private external fun kni_uiNewDateTimePicker(): NativePtr

fun uiNewDatePicker(): CPointer<uiDateTimePicker>? {
    val res = kni_uiNewDatePicker()
    return interpretCPointer<uiDateTimePicker>(res)
}

@SymbolName("libui_kni_uiNewDatePicker")
private external fun kni_uiNewDatePicker(): NativePtr

fun uiNewTimePicker(): CPointer<uiDateTimePicker>? {
    val res = kni_uiNewTimePicker()
    return interpretCPointer<uiDateTimePicker>(res)
}

@SymbolName("libui_kni_uiNewTimePicker")
private external fun kni_uiNewTimePicker(): NativePtr

fun uiMultilineEntryText(e: CValuesRef<uiMultilineEntry>?): CPointer<ByteVar>? {
    return memScoped {
        val _e = e?.getPointer(memScope).rawValue
        val res = kni_uiMultilineEntryText(_e)
        interpretCPointer<ByteVar>(res)
    }
}

@SymbolName("libui_kni_uiMultilineEntryText")
private external fun kni_uiMultilineEntryText(e: NativePtr): NativePtr

fun uiMultilineEntrySetText(e: CValuesRef<uiMultilineEntry>?, text: String?): Unit {
    return memScoped {
        val _e = e?.getPointer(memScope).rawValue
        val _text = text?.cstr?.getPointer(memScope).rawValue
        val res = kni_uiMultilineEntrySetText(_e, _text)
        res
    }
}

@SymbolName("libui_kni_uiMultilineEntrySetText")
private external fun kni_uiMultilineEntrySetText(e: NativePtr, text: NativePtr): Unit

fun uiMultilineEntryAppend(e: CValuesRef<uiMultilineEntry>?, text: String?): Unit {
    return memScoped {
        val _e = e?.getPointer(memScope).rawValue
        val _text = text?.cstr?.getPointer(memScope).rawValue
        val res = kni_uiMultilineEntryAppend(_e, _text)
        res
    }
}

@SymbolName("libui_kni_uiMultilineEntryAppend")
private external fun kni_uiMultilineEntryAppend(e: NativePtr, text: NativePtr): Unit

fun uiMultilineEntryOnChanged(e: CValuesRef<uiMultilineEntry>?, f: CPointer<CFunction<(CPointer<uiMultilineEntry>?, COpaquePointer?) -> Unit>>?, data: COpaquePointer?): Unit {
    return memScoped {
        val _e = e?.getPointer(memScope).rawValue
        val _f = f.rawValue
        val _data = data.rawValue
        val res = kni_uiMultilineEntryOnChanged(_e, _f, _data)
        res
    }
}

@SymbolName("libui_kni_uiMultilineEntryOnChanged")
private external fun kni_uiMultilineEntryOnChanged(e: NativePtr, f: NativePtr, data: NativePtr): Unit

fun uiMultilineEntryReadOnly(e: CValuesRef<uiMultilineEntry>?): Int {
    return memScoped {
        val _e = e?.getPointer(memScope).rawValue
        val res = kni_uiMultilineEntryReadOnly(_e)
        res
    }
}

@SymbolName("libui_kni_uiMultilineEntryReadOnly")
private external fun kni_uiMultilineEntryReadOnly(e: NativePtr): Int

fun uiMultilineEntrySetReadOnly(e: CValuesRef<uiMultilineEntry>?, readonly: Int): Unit {
    return memScoped {
        val _e = e?.getPointer(memScope).rawValue
        val _readonly = readonly
        val res = kni_uiMultilineEntrySetReadOnly(_e, _readonly)
        res
    }
}

@SymbolName("libui_kni_uiMultilineEntrySetReadOnly")
private external fun kni_uiMultilineEntrySetReadOnly(e: NativePtr, readonly: Int): Unit

fun uiNewMultilineEntry(): CPointer<uiMultilineEntry>? {
    val res = kni_uiNewMultilineEntry()
    return interpretCPointer<uiMultilineEntry>(res)
}

@SymbolName("libui_kni_uiNewMultilineEntry")
private external fun kni_uiNewMultilineEntry(): NativePtr

fun uiNewNonWrappingMultilineEntry(): CPointer<uiMultilineEntry>? {
    val res = kni_uiNewNonWrappingMultilineEntry()
    return interpretCPointer<uiMultilineEntry>(res)
}

@SymbolName("libui_kni_uiNewNonWrappingMultilineEntry")
private external fun kni_uiNewNonWrappingMultilineEntry(): NativePtr

fun uiMenuItemEnable(m: CValuesRef<uiMenuItem>?): Unit {
    return memScoped {
        val _m = m?.getPointer(memScope).rawValue
        val res = kni_uiMenuItemEnable(_m)
        res
    }
}

@SymbolName("libui_kni_uiMenuItemEnable")
private external fun kni_uiMenuItemEnable(m: NativePtr): Unit

fun uiMenuItemDisable(m: CValuesRef<uiMenuItem>?): Unit {
    return memScoped {
        val _m = m?.getPointer(memScope).rawValue
        val res = kni_uiMenuItemDisable(_m)
        res
    }
}

@SymbolName("libui_kni_uiMenuItemDisable")
private external fun kni_uiMenuItemDisable(m: NativePtr): Unit

fun uiMenuItemOnClicked(m: CValuesRef<uiMenuItem>?, f: CPointer<CFunction<(CPointer<uiMenuItem>?, CPointer<uiWindow>?, COpaquePointer?) -> Unit>>?, data: COpaquePointer?): Unit {
    return memScoped {
        val _m = m?.getPointer(memScope).rawValue
        val _f = f.rawValue
        val _data = data.rawValue
        val res = kni_uiMenuItemOnClicked(_m, _f, _data)
        res
    }
}

@SymbolName("libui_kni_uiMenuItemOnClicked")
private external fun kni_uiMenuItemOnClicked(m: NativePtr, f: NativePtr, data: NativePtr): Unit

fun uiMenuItemChecked(m: CValuesRef<uiMenuItem>?): Int {
    return memScoped {
        val _m = m?.getPointer(memScope).rawValue
        val res = kni_uiMenuItemChecked(_m)
        res
    }
}

@SymbolName("libui_kni_uiMenuItemChecked")
private external fun kni_uiMenuItemChecked(m: NativePtr): Int

fun uiMenuItemSetChecked(m: CValuesRef<uiMenuItem>?, checked: Int): Unit {
    return memScoped {
        val _m = m?.getPointer(memScope).rawValue
        val _checked = checked
        val res = kni_uiMenuItemSetChecked(_m, _checked)
        res
    }
}

@SymbolName("libui_kni_uiMenuItemSetChecked")
private external fun kni_uiMenuItemSetChecked(m: NativePtr, checked: Int): Unit

fun uiMenuAppendItem(m: CValuesRef<uiMenu>?, name: String?): CPointer<uiMenuItem>? {
    return memScoped {
        val _m = m?.getPointer(memScope).rawValue
        val _name = name?.cstr?.getPointer(memScope).rawValue
        val res = kni_uiMenuAppendItem(_m, _name)
        interpretCPointer<uiMenuItem>(res)
    }
}

@SymbolName("libui_kni_uiMenuAppendItem")
private external fun kni_uiMenuAppendItem(m: NativePtr, name: NativePtr): NativePtr

fun uiMenuAppendCheckItem(m: CValuesRef<uiMenu>?, name: String?): CPointer<uiMenuItem>? {
    return memScoped {
        val _m = m?.getPointer(memScope).rawValue
        val _name = name?.cstr?.getPointer(memScope).rawValue
        val res = kni_uiMenuAppendCheckItem(_m, _name)
        interpretCPointer<uiMenuItem>(res)
    }
}

@SymbolName("libui_kni_uiMenuAppendCheckItem")
private external fun kni_uiMenuAppendCheckItem(m: NativePtr, name: NativePtr): NativePtr

fun uiMenuAppendQuitItem(m: CValuesRef<uiMenu>?): CPointer<uiMenuItem>? {
    return memScoped {
        val _m = m?.getPointer(memScope).rawValue
        val res = kni_uiMenuAppendQuitItem(_m)
        interpretCPointer<uiMenuItem>(res)
    }
}

@SymbolName("libui_kni_uiMenuAppendQuitItem")
private external fun kni_uiMenuAppendQuitItem(m: NativePtr): NativePtr

fun uiMenuAppendPreferencesItem(m: CValuesRef<uiMenu>?): CPointer<uiMenuItem>? {
    return memScoped {
        val _m = m?.getPointer(memScope).rawValue
        val res = kni_uiMenuAppendPreferencesItem(_m)
        interpretCPointer<uiMenuItem>(res)
    }
}

@SymbolName("libui_kni_uiMenuAppendPreferencesItem")
private external fun kni_uiMenuAppendPreferencesItem(m: NativePtr): NativePtr

fun uiMenuAppendAboutItem(m: CValuesRef<uiMenu>?): CPointer<uiMenuItem>? {
    return memScoped {
        val _m = m?.getPointer(memScope).rawValue
        val res = kni_uiMenuAppendAboutItem(_m)
        interpretCPointer<uiMenuItem>(res)
    }
}

@SymbolName("libui_kni_uiMenuAppendAboutItem")
private external fun kni_uiMenuAppendAboutItem(m: NativePtr): NativePtr

fun uiMenuAppendSeparator(m: CValuesRef<uiMenu>?): Unit {
    return memScoped {
        val _m = m?.getPointer(memScope).rawValue
        val res = kni_uiMenuAppendSeparator(_m)
        res
    }
}

@SymbolName("libui_kni_uiMenuAppendSeparator")
private external fun kni_uiMenuAppendSeparator(m: NativePtr): Unit

fun uiNewMenu(name: String?): CPointer<uiMenu>? {
    return memScoped {
        val _name = name?.cstr?.getPointer(memScope).rawValue
        val res = kni_uiNewMenu(_name)
        interpretCPointer<uiMenu>(res)
    }
}

@SymbolName("libui_kni_uiNewMenu")
private external fun kni_uiNewMenu(name: NativePtr): NativePtr

fun uiOpenFile(parent: CValuesRef<uiWindow>?): CPointer<ByteVar>? {
    return memScoped {
        val _parent = parent?.getPointer(memScope).rawValue
        val res = kni_uiOpenFile(_parent)
        interpretCPointer<ByteVar>(res)
    }
}

@SymbolName("libui_kni_uiOpenFile")
private external fun kni_uiOpenFile(parent: NativePtr): NativePtr

fun uiSaveFile(parent: CValuesRef<uiWindow>?): CPointer<ByteVar>? {
    return memScoped {
        val _parent = parent?.getPointer(memScope).rawValue
        val res = kni_uiSaveFile(_parent)
        interpretCPointer<ByteVar>(res)
    }
}

@SymbolName("libui_kni_uiSaveFile")
private external fun kni_uiSaveFile(parent: NativePtr): NativePtr

fun uiMsgBox(parent: CValuesRef<uiWindow>?, title: String?, description: String?): Unit {
    return memScoped {
        val _parent = parent?.getPointer(memScope).rawValue
        val _title = title?.cstr?.getPointer(memScope).rawValue
        val _description = description?.cstr?.getPointer(memScope).rawValue
        val res = kni_uiMsgBox(_parent, _title, _description)
        res
    }
}

@SymbolName("libui_kni_uiMsgBox")
private external fun kni_uiMsgBox(parent: NativePtr, title: NativePtr, description: NativePtr): Unit

fun uiMsgBoxError(parent: CValuesRef<uiWindow>?, title: String?, description: String?): Unit {
    return memScoped {
        val _parent = parent?.getPointer(memScope).rawValue
        val _title = title?.cstr?.getPointer(memScope).rawValue
        val _description = description?.cstr?.getPointer(memScope).rawValue
        val res = kni_uiMsgBoxError(_parent, _title, _description)
        res
    }
}

@SymbolName("libui_kni_uiMsgBoxError")
private external fun kni_uiMsgBoxError(parent: NativePtr, title: NativePtr, description: NativePtr): Unit

fun uiAreaSetSize(a: CValuesRef<uiArea>?, width: intmax_t, height: intmax_t): Unit {
    return memScoped {
        val _a = a?.getPointer(memScope).rawValue
        val _width = width
        val _height = height
        val res = kni_uiAreaSetSize(_a, _width, _height)
        res
    }
}

@SymbolName("libui_kni_uiAreaSetSize")
private external fun kni_uiAreaSetSize(a: NativePtr, width: Long, height: Long): Unit

fun uiAreaQueueRedrawAll(a: CValuesRef<uiArea>?): Unit {
    return memScoped {
        val _a = a?.getPointer(memScope).rawValue
        val res = kni_uiAreaQueueRedrawAll(_a)
        res
    }
}

@SymbolName("libui_kni_uiAreaQueueRedrawAll")
private external fun kni_uiAreaQueueRedrawAll(a: NativePtr): Unit

fun uiAreaScrollTo(a: CValuesRef<uiArea>?, x: Double, y: Double, width: Double, height: Double): Unit {
    return memScoped {
        val _a = a?.getPointer(memScope).rawValue
        val _x = x
        val _y = y
        val _width = width
        val _height = height
        val res = kni_uiAreaScrollTo(_a, _x, _y, _width, _height)
        res
    }
}

@SymbolName("libui_kni_uiAreaScrollTo")
private external fun kni_uiAreaScrollTo(a: NativePtr, x: Double, y: Double, width: Double, height: Double): Unit

fun uiNewArea(ah: CValuesRef<uiAreaHandler>?): CPointer<uiArea>? {
    return memScoped {
        val _ah = ah?.getPointer(memScope).rawValue
        val res = kni_uiNewArea(_ah)
        interpretCPointer<uiArea>(res)
    }
}

@SymbolName("libui_kni_uiNewArea")
private external fun kni_uiNewArea(ah: NativePtr): NativePtr

fun uiNewScrollingArea(ah: CValuesRef<uiAreaHandler>?, width: intmax_t, height: intmax_t): CPointer<uiArea>? {
    return memScoped {
        val _ah = ah?.getPointer(memScope).rawValue
        val _width = width
        val _height = height
        val res = kni_uiNewScrollingArea(_ah, _width, _height)
        interpretCPointer<uiArea>(res)
    }
}

@SymbolName("libui_kni_uiNewScrollingArea")
private external fun kni_uiNewScrollingArea(ah: NativePtr, width: Long, height: Long): NativePtr

fun uiDrawNewPath(fillMode: uiDrawFillMode): CPointer<uiDrawPath>? {
    val _fillMode = fillMode
    val res = kni_uiDrawNewPath(_fillMode)
    return interpretCPointer<uiDrawPath>(res)
}

@SymbolName("libui_kni_uiDrawNewPath")
private external fun kni_uiDrawNewPath(fillMode: Int): NativePtr

fun uiDrawFreePath(p: CValuesRef<uiDrawPath>?): Unit {
    return memScoped {
        val _p = p?.getPointer(memScope).rawValue
        val res = kni_uiDrawFreePath(_p)
        res
    }
}

@SymbolName("libui_kni_uiDrawFreePath")
private external fun kni_uiDrawFreePath(p: NativePtr): Unit

fun uiDrawPathNewFigure(p: CValuesRef<uiDrawPath>?, x: Double, y: Double): Unit {
    return memScoped {
        val _p = p?.getPointer(memScope).rawValue
        val _x = x
        val _y = y
        val res = kni_uiDrawPathNewFigure(_p, _x, _y)
        res
    }
}

@SymbolName("libui_kni_uiDrawPathNewFigure")
private external fun kni_uiDrawPathNewFigure(p: NativePtr, x: Double, y: Double): Unit

fun uiDrawPathNewFigureWithArc(p: CValuesRef<uiDrawPath>?, xCenter: Double, yCenter: Double, radius: Double, startAngle: Double, sweep: Double, negative: Int): Unit {
    return memScoped {
        val _p = p?.getPointer(memScope).rawValue
        val _xCenter = xCenter
        val _yCenter = yCenter
        val _radius = radius
        val _startAngle = startAngle
        val _sweep = sweep
        val _negative = negative
        val res = kni_uiDrawPathNewFigureWithArc(_p, _xCenter, _yCenter, _radius, _startAngle, _sweep, _negative)
        res
    }
}

@SymbolName("libui_kni_uiDrawPathNewFigureWithArc")
private external fun kni_uiDrawPathNewFigureWithArc(p: NativePtr, xCenter: Double, yCenter: Double, radius: Double, startAngle: Double, sweep: Double, negative: Int): Unit

fun uiDrawPathLineTo(p: CValuesRef<uiDrawPath>?, x: Double, y: Double): Unit {
    return memScoped {
        val _p = p?.getPointer(memScope).rawValue
        val _x = x
        val _y = y
        val res = kni_uiDrawPathLineTo(_p, _x, _y)
        res
    }
}

@SymbolName("libui_kni_uiDrawPathLineTo")
private external fun kni_uiDrawPathLineTo(p: NativePtr, x: Double, y: Double): Unit

fun uiDrawPathArcTo(p: CValuesRef<uiDrawPath>?, xCenter: Double, yCenter: Double, radius: Double, startAngle: Double, sweep: Double, negative: Int): Unit {
    return memScoped {
        val _p = p?.getPointer(memScope).rawValue
        val _xCenter = xCenter
        val _yCenter = yCenter
        val _radius = radius
        val _startAngle = startAngle
        val _sweep = sweep
        val _negative = negative
        val res = kni_uiDrawPathArcTo(_p, _xCenter, _yCenter, _radius, _startAngle, _sweep, _negative)
        res
    }
}

@SymbolName("libui_kni_uiDrawPathArcTo")
private external fun kni_uiDrawPathArcTo(p: NativePtr, xCenter: Double, yCenter: Double, radius: Double, startAngle: Double, sweep: Double, negative: Int): Unit

fun uiDrawPathBezierTo(p: CValuesRef<uiDrawPath>?, c1x: Double, c1y: Double, c2x: Double, c2y: Double, endX: Double, endY: Double): Unit {
    return memScoped {
        val _p = p?.getPointer(memScope).rawValue
        val _c1x = c1x
        val _c1y = c1y
        val _c2x = c2x
        val _c2y = c2y
        val _endX = endX
        val _endY = endY
        val res = kni_uiDrawPathBezierTo(_p, _c1x, _c1y, _c2x, _c2y, _endX, _endY)
        res
    }
}

@SymbolName("libui_kni_uiDrawPathBezierTo")
private external fun kni_uiDrawPathBezierTo(p: NativePtr, c1x: Double, c1y: Double, c2x: Double, c2y: Double, endX: Double, endY: Double): Unit

fun uiDrawPathCloseFigure(p: CValuesRef<uiDrawPath>?): Unit {
    return memScoped {
        val _p = p?.getPointer(memScope).rawValue
        val res = kni_uiDrawPathCloseFigure(_p)
        res
    }
}

@SymbolName("libui_kni_uiDrawPathCloseFigure")
private external fun kni_uiDrawPathCloseFigure(p: NativePtr): Unit

fun uiDrawPathAddRectangle(p: CValuesRef<uiDrawPath>?, x: Double, y: Double, width: Double, height: Double): Unit {
    return memScoped {
        val _p = p?.getPointer(memScope).rawValue
        val _x = x
        val _y = y
        val _width = width
        val _height = height
        val res = kni_uiDrawPathAddRectangle(_p, _x, _y, _width, _height)
        res
    }
}

@SymbolName("libui_kni_uiDrawPathAddRectangle")
private external fun kni_uiDrawPathAddRectangle(p: NativePtr, x: Double, y: Double, width: Double, height: Double): Unit

fun uiDrawPathEnd(p: CValuesRef<uiDrawPath>?): Unit {
    return memScoped {
        val _p = p?.getPointer(memScope).rawValue
        val res = kni_uiDrawPathEnd(_p)
        res
    }
}

@SymbolName("libui_kni_uiDrawPathEnd")
private external fun kni_uiDrawPathEnd(p: NativePtr): Unit

fun uiDrawStroke(c: CValuesRef<uiDrawContext>?, path: CValuesRef<uiDrawPath>?, b: CValuesRef<uiDrawBrush>?, p: CValuesRef<uiDrawStrokeParams>?): Unit {
    return memScoped {
        val _c = c?.getPointer(memScope).rawValue
        val _path = path?.getPointer(memScope).rawValue
        val _b = b?.getPointer(memScope).rawValue
        val _p = p?.getPointer(memScope).rawValue
        val res = kni_uiDrawStroke(_c, _path, _b, _p)
        res
    }
}

@SymbolName("libui_kni_uiDrawStroke")
private external fun kni_uiDrawStroke(c: NativePtr, path: NativePtr, b: NativePtr, p: NativePtr): Unit

fun uiDrawFill(c: CValuesRef<uiDrawContext>?, path: CValuesRef<uiDrawPath>?, b: CValuesRef<uiDrawBrush>?): Unit {
    return memScoped {
        val _c = c?.getPointer(memScope).rawValue
        val _path = path?.getPointer(memScope).rawValue
        val _b = b?.getPointer(memScope).rawValue
        val res = kni_uiDrawFill(_c, _path, _b)
        res
    }
}

@SymbolName("libui_kni_uiDrawFill")
private external fun kni_uiDrawFill(c: NativePtr, path: NativePtr, b: NativePtr): Unit

fun uiDrawMatrixSetIdentity(m: CValuesRef<uiDrawMatrix>?): Unit {
    return memScoped {
        val _m = m?.getPointer(memScope).rawValue
        val res = kni_uiDrawMatrixSetIdentity(_m)
        res
    }
}

@SymbolName("libui_kni_uiDrawMatrixSetIdentity")
private external fun kni_uiDrawMatrixSetIdentity(m: NativePtr): Unit

fun uiDrawMatrixTranslate(m: CValuesRef<uiDrawMatrix>?, x: Double, y: Double): Unit {
    return memScoped {
        val _m = m?.getPointer(memScope).rawValue
        val _x = x
        val _y = y
        val res = kni_uiDrawMatrixTranslate(_m, _x, _y)
        res
    }
}

@SymbolName("libui_kni_uiDrawMatrixTranslate")
private external fun kni_uiDrawMatrixTranslate(m: NativePtr, x: Double, y: Double): Unit

fun uiDrawMatrixScale(m: CValuesRef<uiDrawMatrix>?, xCenter: Double, yCenter: Double, x: Double, y: Double): Unit {
    return memScoped {
        val _m = m?.getPointer(memScope).rawValue
        val _xCenter = xCenter
        val _yCenter = yCenter
        val _x = x
        val _y = y
        val res = kni_uiDrawMatrixScale(_m, _xCenter, _yCenter, _x, _y)
        res
    }
}

@SymbolName("libui_kni_uiDrawMatrixScale")
private external fun kni_uiDrawMatrixScale(m: NativePtr, xCenter: Double, yCenter: Double, x: Double, y: Double): Unit

fun uiDrawMatrixRotate(m: CValuesRef<uiDrawMatrix>?, x: Double, y: Double, amount: Double): Unit {
    return memScoped {
        val _m = m?.getPointer(memScope).rawValue
        val _x = x
        val _y = y
        val _amount = amount
        val res = kni_uiDrawMatrixRotate(_m, _x, _y, _amount)
        res
    }
}

@SymbolName("libui_kni_uiDrawMatrixRotate")
private external fun kni_uiDrawMatrixRotate(m: NativePtr, x: Double, y: Double, amount: Double): Unit

fun uiDrawMatrixSkew(m: CValuesRef<uiDrawMatrix>?, x: Double, y: Double, xamount: Double, yamount: Double): Unit {
    return memScoped {
        val _m = m?.getPointer(memScope).rawValue
        val _x = x
        val _y = y
        val _xamount = xamount
        val _yamount = yamount
        val res = kni_uiDrawMatrixSkew(_m, _x, _y, _xamount, _yamount)
        res
    }
}

@SymbolName("libui_kni_uiDrawMatrixSkew")
private external fun kni_uiDrawMatrixSkew(m: NativePtr, x: Double, y: Double, xamount: Double, yamount: Double): Unit

fun uiDrawMatrixMultiply(dest: CValuesRef<uiDrawMatrix>?, src: CValuesRef<uiDrawMatrix>?): Unit {
    return memScoped {
        val _dest = dest?.getPointer(memScope).rawValue
        val _src = src?.getPointer(memScope).rawValue
        val res = kni_uiDrawMatrixMultiply(_dest, _src)
        res
    }
}

@SymbolName("libui_kni_uiDrawMatrixMultiply")
private external fun kni_uiDrawMatrixMultiply(dest: NativePtr, src: NativePtr): Unit

fun uiDrawMatrixInvertible(m: CValuesRef<uiDrawMatrix>?): Int {
    return memScoped {
        val _m = m?.getPointer(memScope).rawValue
        val res = kni_uiDrawMatrixInvertible(_m)
        res
    }
}

@SymbolName("libui_kni_uiDrawMatrixInvertible")
private external fun kni_uiDrawMatrixInvertible(m: NativePtr): Int

fun uiDrawMatrixInvert(m: CValuesRef<uiDrawMatrix>?): Int {
    return memScoped {
        val _m = m?.getPointer(memScope).rawValue
        val res = kni_uiDrawMatrixInvert(_m)
        res
    }
}

@SymbolName("libui_kni_uiDrawMatrixInvert")
private external fun kni_uiDrawMatrixInvert(m: NativePtr): Int

fun uiDrawMatrixTransformPoint(m: CValuesRef<uiDrawMatrix>?, x: CValuesRef<DoubleVar>?, y: CValuesRef<DoubleVar>?): Unit {
    return memScoped {
        val _m = m?.getPointer(memScope).rawValue
        val _x = x?.getPointer(memScope).rawValue
        val _y = y?.getPointer(memScope).rawValue
        val res = kni_uiDrawMatrixTransformPoint(_m, _x, _y)
        res
    }
}

@SymbolName("libui_kni_uiDrawMatrixTransformPoint")
private external fun kni_uiDrawMatrixTransformPoint(m: NativePtr, x: NativePtr, y: NativePtr): Unit

fun uiDrawMatrixTransformSize(m: CValuesRef<uiDrawMatrix>?, x: CValuesRef<DoubleVar>?, y: CValuesRef<DoubleVar>?): Unit {
    return memScoped {
        val _m = m?.getPointer(memScope).rawValue
        val _x = x?.getPointer(memScope).rawValue
        val _y = y?.getPointer(memScope).rawValue
        val res = kni_uiDrawMatrixTransformSize(_m, _x, _y)
        res
    }
}

@SymbolName("libui_kni_uiDrawMatrixTransformSize")
private external fun kni_uiDrawMatrixTransformSize(m: NativePtr, x: NativePtr, y: NativePtr): Unit

fun uiDrawTransform(c: CValuesRef<uiDrawContext>?, m: CValuesRef<uiDrawMatrix>?): Unit {
    return memScoped {
        val _c = c?.getPointer(memScope).rawValue
        val _m = m?.getPointer(memScope).rawValue
        val res = kni_uiDrawTransform(_c, _m)
        res
    }
}

@SymbolName("libui_kni_uiDrawTransform")
private external fun kni_uiDrawTransform(c: NativePtr, m: NativePtr): Unit

fun uiDrawClip(c: CValuesRef<uiDrawContext>?, path: CValuesRef<uiDrawPath>?): Unit {
    return memScoped {
        val _c = c?.getPointer(memScope).rawValue
        val _path = path?.getPointer(memScope).rawValue
        val res = kni_uiDrawClip(_c, _path)
        res
    }
}

@SymbolName("libui_kni_uiDrawClip")
private external fun kni_uiDrawClip(c: NativePtr, path: NativePtr): Unit

fun uiDrawSave(c: CValuesRef<uiDrawContext>?): Unit {
    return memScoped {
        val _c = c?.getPointer(memScope).rawValue
        val res = kni_uiDrawSave(_c)
        res
    }
}

@SymbolName("libui_kni_uiDrawSave")
private external fun kni_uiDrawSave(c: NativePtr): Unit

fun uiDrawRestore(c: CValuesRef<uiDrawContext>?): Unit {
    return memScoped {
        val _c = c?.getPointer(memScope).rawValue
        val res = kni_uiDrawRestore(_c)
        res
    }
}

@SymbolName("libui_kni_uiDrawRestore")
private external fun kni_uiDrawRestore(c: NativePtr): Unit

fun uiDrawListFontFamilies(): CPointer<uiDrawFontFamilies>? {
    val res = kni_uiDrawListFontFamilies()
    return interpretCPointer<uiDrawFontFamilies>(res)
}

@SymbolName("libui_kni_uiDrawListFontFamilies")
private external fun kni_uiDrawListFontFamilies(): NativePtr

fun uiDrawFontFamiliesNumFamilies(ff: CValuesRef<uiDrawFontFamilies>?): uintmax_t {
    return memScoped {
        val _ff = ff?.getPointer(memScope).rawValue
        val res = kni_uiDrawFontFamiliesNumFamilies(_ff)
        res
    }
}

@SymbolName("libui_kni_uiDrawFontFamiliesNumFamilies")
private external fun kni_uiDrawFontFamiliesNumFamilies(ff: NativePtr): Long

fun uiDrawFontFamiliesFamily(ff: CValuesRef<uiDrawFontFamilies>?, n: uintmax_t): CPointer<ByteVar>? {
    return memScoped {
        val _ff = ff?.getPointer(memScope).rawValue
        val _n = n
        val res = kni_uiDrawFontFamiliesFamily(_ff, _n)
        interpretCPointer<ByteVar>(res)
    }
}

@SymbolName("libui_kni_uiDrawFontFamiliesFamily")
private external fun kni_uiDrawFontFamiliesFamily(ff: NativePtr, n: Long): NativePtr

fun uiDrawFreeFontFamilies(ff: CValuesRef<uiDrawFontFamilies>?): Unit {
    return memScoped {
        val _ff = ff?.getPointer(memScope).rawValue
        val res = kni_uiDrawFreeFontFamilies(_ff)
        res
    }
}

@SymbolName("libui_kni_uiDrawFreeFontFamilies")
private external fun kni_uiDrawFreeFontFamilies(ff: NativePtr): Unit

fun uiDrawLoadClosestFont(desc: CValuesRef<uiDrawTextFontDescriptor>?): CPointer<uiDrawTextFont>? {
    return memScoped {
        val _desc = desc?.getPointer(memScope).rawValue
        val res = kni_uiDrawLoadClosestFont(_desc)
        interpretCPointer<uiDrawTextFont>(res)
    }
}

@SymbolName("libui_kni_uiDrawLoadClosestFont")
private external fun kni_uiDrawLoadClosestFont(desc: NativePtr): NativePtr

fun uiDrawFreeTextFont(font: CValuesRef<uiDrawTextFont>?): Unit {
    return memScoped {
        val _font = font?.getPointer(memScope).rawValue
        val res = kni_uiDrawFreeTextFont(_font)
        res
    }
}

@SymbolName("libui_kni_uiDrawFreeTextFont")
private external fun kni_uiDrawFreeTextFont(font: NativePtr): Unit

fun uiDrawTextFontHandle(font: CValuesRef<uiDrawTextFont>?): uintptr_t {
    return memScoped {
        val _font = font?.getPointer(memScope).rawValue
        val res = kni_uiDrawTextFontHandle(_font)
        res
    }
}

@SymbolName("libui_kni_uiDrawTextFontHandle")
private external fun kni_uiDrawTextFontHandle(font: NativePtr): Long

fun uiDrawTextFontDescribe(font: CValuesRef<uiDrawTextFont>?, desc: CValuesRef<uiDrawTextFontDescriptor>?): Unit {
    return memScoped {
        val _font = font?.getPointer(memScope).rawValue
        val _desc = desc?.getPointer(memScope).rawValue
        val res = kni_uiDrawTextFontDescribe(_font, _desc)
        res
    }
}

@SymbolName("libui_kni_uiDrawTextFontDescribe")
private external fun kni_uiDrawTextFontDescribe(font: NativePtr, desc: NativePtr): Unit

fun uiDrawTextFontGetMetrics(font: CValuesRef<uiDrawTextFont>?, metrics: CValuesRef<uiDrawTextFontMetrics>?): Unit {
    return memScoped {
        val _font = font?.getPointer(memScope).rawValue
        val _metrics = metrics?.getPointer(memScope).rawValue
        val res = kni_uiDrawTextFontGetMetrics(_font, _metrics)
        res
    }
}

@SymbolName("libui_kni_uiDrawTextFontGetMetrics")
private external fun kni_uiDrawTextFontGetMetrics(font: NativePtr, metrics: NativePtr): Unit

fun uiDrawNewTextLayout(text: String?, defaultFont: CValuesRef<uiDrawTextFont>?, width: Double): CPointer<uiDrawTextLayout>? {
    return memScoped {
        val _text = text?.cstr?.getPointer(memScope).rawValue
        val _defaultFont = defaultFont?.getPointer(memScope).rawValue
        val _width = width
        val res = kni_uiDrawNewTextLayout(_text, _defaultFont, _width)
        interpretCPointer<uiDrawTextLayout>(res)
    }
}

@SymbolName("libui_kni_uiDrawNewTextLayout")
private external fun kni_uiDrawNewTextLayout(text: NativePtr, defaultFont: NativePtr, width: Double): NativePtr

fun uiDrawFreeTextLayout(layout: CValuesRef<uiDrawTextLayout>?): Unit {
    return memScoped {
        val _layout = layout?.getPointer(memScope).rawValue
        val res = kni_uiDrawFreeTextLayout(_layout)
        res
    }
}

@SymbolName("libui_kni_uiDrawFreeTextLayout")
private external fun kni_uiDrawFreeTextLayout(layout: NativePtr): Unit

fun uiDrawTextLayoutSetWidth(layout: CValuesRef<uiDrawTextLayout>?, width: Double): Unit {
    return memScoped {
        val _layout = layout?.getPointer(memScope).rawValue
        val _width = width
        val res = kni_uiDrawTextLayoutSetWidth(_layout, _width)
        res
    }
}

@SymbolName("libui_kni_uiDrawTextLayoutSetWidth")
private external fun kni_uiDrawTextLayoutSetWidth(layout: NativePtr, width: Double): Unit

fun uiDrawTextLayoutExtents(layout: CValuesRef<uiDrawTextLayout>?, width: CValuesRef<DoubleVar>?, height: CValuesRef<DoubleVar>?): Unit {
    return memScoped {
        val _layout = layout?.getPointer(memScope).rawValue
        val _width = width?.getPointer(memScope).rawValue
        val _height = height?.getPointer(memScope).rawValue
        val res = kni_uiDrawTextLayoutExtents(_layout, _width, _height)
        res
    }
}

@SymbolName("libui_kni_uiDrawTextLayoutExtents")
private external fun kni_uiDrawTextLayoutExtents(layout: NativePtr, width: NativePtr, height: NativePtr): Unit

fun uiDrawTextLayoutSetColor(layout: CValuesRef<uiDrawTextLayout>?, startChar: intmax_t, endChar: intmax_t, r: Double, g: Double, b: Double, a: Double): Unit {
    return memScoped {
        val _layout = layout?.getPointer(memScope).rawValue
        val _startChar = startChar
        val _endChar = endChar
        val _r = r
        val _g = g
        val _b = b
        val _a = a
        val res = kni_uiDrawTextLayoutSetColor(_layout, _startChar, _endChar, _r, _g, _b, _a)
        res
    }
}

@SymbolName("libui_kni_uiDrawTextLayoutSetColor")
private external fun kni_uiDrawTextLayoutSetColor(layout: NativePtr, startChar: Long, endChar: Long, r: Double, g: Double, b: Double, a: Double): Unit

fun uiDrawText(c: CValuesRef<uiDrawContext>?, x: Double, y: Double, layout: CValuesRef<uiDrawTextLayout>?): Unit {
    return memScoped {
        val _c = c?.getPointer(memScope).rawValue
        val _x = x
        val _y = y
        val _layout = layout?.getPointer(memScope).rawValue
        val res = kni_uiDrawText(_c, _x, _y, _layout)
        res
    }
}

@SymbolName("libui_kni_uiDrawText")
private external fun kni_uiDrawText(c: NativePtr, x: Double, y: Double, layout: NativePtr): Unit

fun uiFontButtonFont(b: CValuesRef<uiFontButton>?): CPointer<uiDrawTextFont>? {
    return memScoped {
        val _b = b?.getPointer(memScope).rawValue
        val res = kni_uiFontButtonFont(_b)
        interpretCPointer<uiDrawTextFont>(res)
    }
}

@SymbolName("libui_kni_uiFontButtonFont")
private external fun kni_uiFontButtonFont(b: NativePtr): NativePtr

fun uiFontButtonOnChanged(b: CValuesRef<uiFontButton>?, f: CPointer<CFunction<(CPointer<uiFontButton>?, COpaquePointer?) -> Unit>>?, data: COpaquePointer?): Unit {
    return memScoped {
        val _b = b?.getPointer(memScope).rawValue
        val _f = f.rawValue
        val _data = data.rawValue
        val res = kni_uiFontButtonOnChanged(_b, _f, _data)
        res
    }
}

@SymbolName("libui_kni_uiFontButtonOnChanged")
private external fun kni_uiFontButtonOnChanged(b: NativePtr, f: NativePtr, data: NativePtr): Unit

fun uiNewFontButton(): CPointer<uiFontButton>? {
    val res = kni_uiNewFontButton()
    return interpretCPointer<uiFontButton>(res)
}

@SymbolName("libui_kni_uiNewFontButton")
private external fun kni_uiNewFontButton(): NativePtr

fun uiColorButtonColor(b: CValuesRef<uiColorButton>?, r: CValuesRef<DoubleVar>?, g: CValuesRef<DoubleVar>?, bl: CValuesRef<DoubleVar>?, a: CValuesRef<DoubleVar>?): Unit {
    return memScoped {
        val _b = b?.getPointer(memScope).rawValue
        val _r = r?.getPointer(memScope).rawValue
        val _g = g?.getPointer(memScope).rawValue
        val _bl = bl?.getPointer(memScope).rawValue
        val _a = a?.getPointer(memScope).rawValue
        val res = kni_uiColorButtonColor(_b, _r, _g, _bl, _a)
        res
    }
}

@SymbolName("libui_kni_uiColorButtonColor")
private external fun kni_uiColorButtonColor(b: NativePtr, r: NativePtr, g: NativePtr, bl: NativePtr, a: NativePtr): Unit

fun uiColorButtonSetColor(b: CValuesRef<uiColorButton>?, r: Double, g: Double, bl: Double, a: Double): Unit {
    return memScoped {
        val _b = b?.getPointer(memScope).rawValue
        val _r = r
        val _g = g
        val _bl = bl
        val _a = a
        val res = kni_uiColorButtonSetColor(_b, _r, _g, _bl, _a)
        res
    }
}

@SymbolName("libui_kni_uiColorButtonSetColor")
private external fun kni_uiColorButtonSetColor(b: NativePtr, r: Double, g: Double, bl: Double, a: Double): Unit

fun uiColorButtonOnChanged(b: CValuesRef<uiColorButton>?, f: CPointer<CFunction<(CPointer<uiColorButton>?, COpaquePointer?) -> Unit>>?, data: COpaquePointer?): Unit {
    return memScoped {
        val _b = b?.getPointer(memScope).rawValue
        val _f = f.rawValue
        val _data = data.rawValue
        val res = kni_uiColorButtonOnChanged(_b, _f, _data)
        res
    }
}

@SymbolName("libui_kni_uiColorButtonOnChanged")
private external fun kni_uiColorButtonOnChanged(b: NativePtr, f: NativePtr, data: NativePtr): Unit

fun uiNewColorButton(): CPointer<uiColorButton>? {
    val res = kni_uiNewColorButton()
    return interpretCPointer<uiColorButton>(res)
}

@SymbolName("libui_kni_uiNewColorButton")
private external fun kni_uiNewColorButton(): NativePtr

val uiPi: Double = bitsToDouble(4614256656552045848) /* == 3.141592653589793 */

val uiDrawDefaultMiterLimit: Double = bitsToDouble(4621819117588971520) /* == 10.0 */

class uiInitOptions(override val rawPtr: NativePtr) : CStructVar() {
    
    companion object : Type(8, 8)
    
    var Size: size_t
        get() = memberAt<size_tVar>(0).value
        set(value) { memberAt<size_tVar>(0).value = value }
    
}

class uiControl(override val rawPtr: NativePtr) : CStructVar() {
    
    companion object : Type(104, 8)
    
    var Signature: uint32_t
        get() = memberAt<uint32_tVar>(0).value
        set(value) { memberAt<uint32_tVar>(0).value = value }
    
    var OSSignature: uint32_t
        get() = memberAt<uint32_tVar>(4).value
        set(value) { memberAt<uint32_tVar>(4).value = value }
    
    var TypeSignature: uint32_t
        get() = memberAt<uint32_tVar>(8).value
        set(value) { memberAt<uint32_tVar>(8).value = value }
    
    var Destroy: CPointer<CFunction<(CPointer<uiControl>?) -> Unit>>?
        get() = memberAt<CPointerVar<CFunction<(CPointer<uiControl>?) -> Unit>>>(16).value
        set(value) { memberAt<CPointerVar<CFunction<(CPointer<uiControl>?) -> Unit>>>(16).value = value }
    
    var Handle: CPointer<CFunction<(CPointer<uiControl>?) -> uintptr_t>>?
        get() = memberAt<CPointerVar<CFunction<(CPointer<uiControl>?) -> uintptr_t>>>(24).value
        set(value) { memberAt<CPointerVar<CFunction<(CPointer<uiControl>?) -> uintptr_t>>>(24).value = value }
    
    var Parent: CPointer<CFunction<(CPointer<uiControl>?) -> CPointer<uiControl>?>>?
        get() = memberAt<CPointerVar<CFunction<(CPointer<uiControl>?) -> CPointer<uiControl>?>>>(32).value
        set(value) { memberAt<CPointerVar<CFunction<(CPointer<uiControl>?) -> CPointer<uiControl>?>>>(32).value = value }
    
    var SetParent: CPointer<CFunction<(CPointer<uiControl>?, CPointer<uiControl>?) -> Unit>>?
        get() = memberAt<CPointerVar<CFunction<(CPointer<uiControl>?, CPointer<uiControl>?) -> Unit>>>(40).value
        set(value) { memberAt<CPointerVar<CFunction<(CPointer<uiControl>?, CPointer<uiControl>?) -> Unit>>>(40).value = value }
    
    var Toplevel: CPointer<CFunction<(CPointer<uiControl>?) -> Int>>?
        get() = memberAt<CPointerVar<CFunction<(CPointer<uiControl>?) -> Int>>>(48).value
        set(value) { memberAt<CPointerVar<CFunction<(CPointer<uiControl>?) -> Int>>>(48).value = value }
    
    var Visible: CPointer<CFunction<(CPointer<uiControl>?) -> Int>>?
        get() = memberAt<CPointerVar<CFunction<(CPointer<uiControl>?) -> Int>>>(56).value
        set(value) { memberAt<CPointerVar<CFunction<(CPointer<uiControl>?) -> Int>>>(56).value = value }
    
    var Show: CPointer<CFunction<(CPointer<uiControl>?) -> Unit>>?
        get() = memberAt<CPointerVar<CFunction<(CPointer<uiControl>?) -> Unit>>>(64).value
        set(value) { memberAt<CPointerVar<CFunction<(CPointer<uiControl>?) -> Unit>>>(64).value = value }
    
    var Hide: CPointer<CFunction<(CPointer<uiControl>?) -> Unit>>?
        get() = memberAt<CPointerVar<CFunction<(CPointer<uiControl>?) -> Unit>>>(72).value
        set(value) { memberAt<CPointerVar<CFunction<(CPointer<uiControl>?) -> Unit>>>(72).value = value }
    
    var Enabled: CPointer<CFunction<(CPointer<uiControl>?) -> Int>>?
        get() = memberAt<CPointerVar<CFunction<(CPointer<uiControl>?) -> Int>>>(80).value
        set(value) { memberAt<CPointerVar<CFunction<(CPointer<uiControl>?) -> Int>>>(80).value = value }
    
    var Enable: CPointer<CFunction<(CPointer<uiControl>?) -> Unit>>?
        get() = memberAt<CPointerVar<CFunction<(CPointer<uiControl>?) -> Unit>>>(88).value
        set(value) { memberAt<CPointerVar<CFunction<(CPointer<uiControl>?) -> Unit>>>(88).value = value }
    
    var Disable: CPointer<CFunction<(CPointer<uiControl>?) -> Unit>>?
        get() = memberAt<CPointerVar<CFunction<(CPointer<uiControl>?) -> Unit>>>(96).value
        set(value) { memberAt<CPointerVar<CFunction<(CPointer<uiControl>?) -> Unit>>>(96).value = value }
    
}

class uiWindow(override val rawPtr: NativePtr) : COpaque

class uiButton(override val rawPtr: NativePtr) : COpaque

class uiBox(override val rawPtr: NativePtr) : COpaque

class uiCheckbox(override val rawPtr: NativePtr) : COpaque

class uiEntry(override val rawPtr: NativePtr) : COpaque

class uiLabel(override val rawPtr: NativePtr) : COpaque

class uiTab(override val rawPtr: NativePtr) : COpaque

class uiGroup(override val rawPtr: NativePtr) : COpaque

class uiSpinbox(override val rawPtr: NativePtr) : COpaque

class uiSlider(override val rawPtr: NativePtr) : COpaque

class uiProgressBar(override val rawPtr: NativePtr) : COpaque

class uiSeparator(override val rawPtr: NativePtr) : COpaque

class uiCombobox(override val rawPtr: NativePtr) : COpaque

class uiEditableCombobox(override val rawPtr: NativePtr) : COpaque

class uiRadioButtons(override val rawPtr: NativePtr) : COpaque

class uiDateTimePicker(override val rawPtr: NativePtr) : COpaque

class uiMultilineEntry(override val rawPtr: NativePtr) : COpaque

class uiMenuItem(override val rawPtr: NativePtr) : COpaque

class uiMenu(override val rawPtr: NativePtr) : COpaque

class uiArea(override val rawPtr: NativePtr) : COpaque

class uiAreaHandler(override val rawPtr: NativePtr) : CStructVar() {
    
    companion object : Type(40, 8)
    
    var Draw: CPointer<CFunction<(CPointer<uiAreaHandler>?, CPointer<uiArea>?, CPointer<uiAreaDrawParams>?) -> Unit>>?
        get() = memberAt<CPointerVar<CFunction<(CPointer<uiAreaHandler>?, CPointer<uiArea>?, CPointer<uiAreaDrawParams>?) -> Unit>>>(0).value
        set(value) { memberAt<CPointerVar<CFunction<(CPointer<uiAreaHandler>?, CPointer<uiArea>?, CPointer<uiAreaDrawParams>?) -> Unit>>>(0).value = value }
    
    var MouseEvent: CPointer<CFunction<(CPointer<uiAreaHandler>?, CPointer<uiArea>?, CPointer<uiAreaMouseEvent>?) -> Unit>>?
        get() = memberAt<CPointerVar<CFunction<(CPointer<uiAreaHandler>?, CPointer<uiArea>?, CPointer<uiAreaMouseEvent>?) -> Unit>>>(8).value
        set(value) { memberAt<CPointerVar<CFunction<(CPointer<uiAreaHandler>?, CPointer<uiArea>?, CPointer<uiAreaMouseEvent>?) -> Unit>>>(8).value = value }
    
    var MouseCrossed: CPointer<CFunction<(CPointer<uiAreaHandler>?, CPointer<uiArea>?, Int) -> Unit>>?
        get() = memberAt<CPointerVar<CFunction<(CPointer<uiAreaHandler>?, CPointer<uiArea>?, Int) -> Unit>>>(16).value
        set(value) { memberAt<CPointerVar<CFunction<(CPointer<uiAreaHandler>?, CPointer<uiArea>?, Int) -> Unit>>>(16).value = value }
    
    var DragBroken: CPointer<CFunction<(CPointer<uiAreaHandler>?, CPointer<uiArea>?) -> Unit>>?
        get() = memberAt<CPointerVar<CFunction<(CPointer<uiAreaHandler>?, CPointer<uiArea>?) -> Unit>>>(24).value
        set(value) { memberAt<CPointerVar<CFunction<(CPointer<uiAreaHandler>?, CPointer<uiArea>?) -> Unit>>>(24).value = value }
    
    var KeyEvent: CPointer<CFunction<(CPointer<uiAreaHandler>?, CPointer<uiArea>?, CPointer<uiAreaKeyEvent>?) -> Int>>?
        get() = memberAt<CPointerVar<CFunction<(CPointer<uiAreaHandler>?, CPointer<uiArea>?, CPointer<uiAreaKeyEvent>?) -> Int>>>(32).value
        set(value) { memberAt<CPointerVar<CFunction<(CPointer<uiAreaHandler>?, CPointer<uiArea>?, CPointer<uiAreaKeyEvent>?) -> Int>>>(32).value = value }
    
}

class uiAreaDrawParams(override val rawPtr: NativePtr) : CStructVar() {
    
    companion object : Type(56, 8)
    
    var Context: CPointer<uiDrawContext>?
        get() = memberAt<CPointerVar<uiDrawContext>>(0).value
        set(value) { memberAt<CPointerVar<uiDrawContext>>(0).value = value }
    
    var AreaWidth: Double
        get() = memberAt<DoubleVar>(8).value
        set(value) { memberAt<DoubleVar>(8).value = value }
    
    var AreaHeight: Double
        get() = memberAt<DoubleVar>(16).value
        set(value) { memberAt<DoubleVar>(16).value = value }
    
    var ClipX: Double
        get() = memberAt<DoubleVar>(24).value
        set(value) { memberAt<DoubleVar>(24).value = value }
    
    var ClipY: Double
        get() = memberAt<DoubleVar>(32).value
        set(value) { memberAt<DoubleVar>(32).value = value }
    
    var ClipWidth: Double
        get() = memberAt<DoubleVar>(40).value
        set(value) { memberAt<DoubleVar>(40).value = value }
    
    var ClipHeight: Double
        get() = memberAt<DoubleVar>(48).value
        set(value) { memberAt<DoubleVar>(48).value = value }
    
}

class uiDrawContext(override val rawPtr: NativePtr) : COpaque

class uiAreaMouseEvent(override val rawPtr: NativePtr) : CStructVar() {
    
    companion object : Type(72, 8)
    
    var X: Double
        get() = memberAt<DoubleVar>(0).value
        set(value) { memberAt<DoubleVar>(0).value = value }
    
    var Y: Double
        get() = memberAt<DoubleVar>(8).value
        set(value) { memberAt<DoubleVar>(8).value = value }
    
    var AreaWidth: Double
        get() = memberAt<DoubleVar>(16).value
        set(value) { memberAt<DoubleVar>(16).value = value }
    
    var AreaHeight: Double
        get() = memberAt<DoubleVar>(24).value
        set(value) { memberAt<DoubleVar>(24).value = value }
    
    var Down: uintmax_t
        get() = memberAt<uintmax_tVar>(32).value
        set(value) { memberAt<uintmax_tVar>(32).value = value }
    
    var Up: uintmax_t
        get() = memberAt<uintmax_tVar>(40).value
        set(value) { memberAt<uintmax_tVar>(40).value = value }
    
    var Count: uintmax_t
        get() = memberAt<uintmax_tVar>(48).value
        set(value) { memberAt<uintmax_tVar>(48).value = value }
    
    var Modifiers: uiModifiers
        get() = memberAt<uiModifiersVar>(56).value
        set(value) { memberAt<uiModifiersVar>(56).value = value }
    
    var Held1To64: uint64_t
        get() = memberAt<uint64_tVar>(64).value
        set(value) { memberAt<uint64_tVar>(64).value = value }
    
}

class uiAreaKeyEvent(override val rawPtr: NativePtr) : CStructVar() {
    
    companion object : Type(20, 4)
    
    var Key: Byte
        get() = memberAt<ByteVar>(0).value
        set(value) { memberAt<ByteVar>(0).value = value }
    
    var ExtKey: uiExtKey
        get() = memberAt<uiExtKeyVar>(4).value
        set(value) { memberAt<uiExtKeyVar>(4).value = value }
    
    var Modifier: uiModifiers
        get() = memberAt<uiModifiersVar>(8).value
        set(value) { memberAt<uiModifiersVar>(8).value = value }
    
    var Modifiers: uiModifiers
        get() = memberAt<uiModifiersVar>(12).value
        set(value) { memberAt<uiModifiersVar>(12).value = value }
    
    var Up: Int
        get() = memberAt<IntVar>(16).value
        set(value) { memberAt<IntVar>(16).value = value }
    
}

class uiDrawPath(override val rawPtr: NativePtr) : COpaque

class uiDrawBrush(override val rawPtr: NativePtr) : CStructVar() {
    
    companion object : Type(96, 8)
    
    var Type: uiDrawBrushType
        get() = memberAt<uiDrawBrushTypeVar>(0).value
        set(value) { memberAt<uiDrawBrushTypeVar>(0).value = value }
    
    var R: Double
        get() = memberAt<DoubleVar>(8).value
        set(value) { memberAt<DoubleVar>(8).value = value }
    
    var G: Double
        get() = memberAt<DoubleVar>(16).value
        set(value) { memberAt<DoubleVar>(16).value = value }
    
    var B: Double
        get() = memberAt<DoubleVar>(24).value
        set(value) { memberAt<DoubleVar>(24).value = value }
    
    var A: Double
        get() = memberAt<DoubleVar>(32).value
        set(value) { memberAt<DoubleVar>(32).value = value }
    
    var X0: Double
        get() = memberAt<DoubleVar>(40).value
        set(value) { memberAt<DoubleVar>(40).value = value }
    
    var Y0: Double
        get() = memberAt<DoubleVar>(48).value
        set(value) { memberAt<DoubleVar>(48).value = value }
    
    var X1: Double
        get() = memberAt<DoubleVar>(56).value
        set(value) { memberAt<DoubleVar>(56).value = value }
    
    var Y1: Double
        get() = memberAt<DoubleVar>(64).value
        set(value) { memberAt<DoubleVar>(64).value = value }
    
    var OuterRadius: Double
        get() = memberAt<DoubleVar>(72).value
        set(value) { memberAt<DoubleVar>(72).value = value }
    
    var Stops: CPointer<uiDrawBrushGradientStop>?
        get() = memberAt<CPointerVar<uiDrawBrushGradientStop>>(80).value
        set(value) { memberAt<CPointerVar<uiDrawBrushGradientStop>>(80).value = value }
    
    var NumStops: size_t
        get() = memberAt<size_tVar>(88).value
        set(value) { memberAt<size_tVar>(88).value = value }
    
}

class uiDrawBrushGradientStop(override val rawPtr: NativePtr) : CStructVar() {
    
    companion object : Type(40, 8)
    
    var Pos: Double
        get() = memberAt<DoubleVar>(0).value
        set(value) { memberAt<DoubleVar>(0).value = value }
    
    var R: Double
        get() = memberAt<DoubleVar>(8).value
        set(value) { memberAt<DoubleVar>(8).value = value }
    
    var G: Double
        get() = memberAt<DoubleVar>(16).value
        set(value) { memberAt<DoubleVar>(16).value = value }
    
    var B: Double
        get() = memberAt<DoubleVar>(24).value
        set(value) { memberAt<DoubleVar>(24).value = value }
    
    var A: Double
        get() = memberAt<DoubleVar>(32).value
        set(value) { memberAt<DoubleVar>(32).value = value }
    
}

class uiDrawStrokeParams(override val rawPtr: NativePtr) : CStructVar() {
    
    companion object : Type(48, 8)
    
    var Cap: uiDrawLineCap
        get() = memberAt<uiDrawLineCapVar>(0).value
        set(value) { memberAt<uiDrawLineCapVar>(0).value = value }
    
    var Join: uiDrawLineJoin
        get() = memberAt<uiDrawLineJoinVar>(4).value
        set(value) { memberAt<uiDrawLineJoinVar>(4).value = value }
    
    var Thickness: Double
        get() = memberAt<DoubleVar>(8).value
        set(value) { memberAt<DoubleVar>(8).value = value }
    
    var MiterLimit: Double
        get() = memberAt<DoubleVar>(16).value
        set(value) { memberAt<DoubleVar>(16).value = value }
    
    var Dashes: CPointer<DoubleVar>?
        get() = memberAt<CPointerVar<DoubleVar>>(24).value
        set(value) { memberAt<CPointerVar<DoubleVar>>(24).value = value }
    
    var NumDashes: size_t
        get() = memberAt<size_tVar>(32).value
        set(value) { memberAt<size_tVar>(32).value = value }
    
    var DashPhase: Double
        get() = memberAt<DoubleVar>(40).value
        set(value) { memberAt<DoubleVar>(40).value = value }
    
}

class uiDrawMatrix(override val rawPtr: NativePtr) : CStructVar() {
    
    companion object : Type(48, 8)
    
    var M11: Double
        get() = memberAt<DoubleVar>(0).value
        set(value) { memberAt<DoubleVar>(0).value = value }
    
    var M12: Double
        get() = memberAt<DoubleVar>(8).value
        set(value) { memberAt<DoubleVar>(8).value = value }
    
    var M21: Double
        get() = memberAt<DoubleVar>(16).value
        set(value) { memberAt<DoubleVar>(16).value = value }
    
    var M22: Double
        get() = memberAt<DoubleVar>(24).value
        set(value) { memberAt<DoubleVar>(24).value = value }
    
    var M31: Double
        get() = memberAt<DoubleVar>(32).value
        set(value) { memberAt<DoubleVar>(32).value = value }
    
    var M32: Double
        get() = memberAt<DoubleVar>(40).value
        set(value) { memberAt<DoubleVar>(40).value = value }
    
}

class uiDrawFontFamilies(override val rawPtr: NativePtr) : COpaque

class uiDrawTextLayout(override val rawPtr: NativePtr) : COpaque

class uiDrawTextFont(override val rawPtr: NativePtr) : COpaque

class uiDrawTextFontDescriptor(override val rawPtr: NativePtr) : CStructVar() {
    
    companion object : Type(32, 8)
    
    var Family: CPointer<ByteVar>?
        get() = memberAt<CPointerVar<ByteVar>>(0).value
        set(value) { memberAt<CPointerVar<ByteVar>>(0).value = value }
    
    var Size: Double
        get() = memberAt<DoubleVar>(8).value
        set(value) { memberAt<DoubleVar>(8).value = value }
    
    var Weight: uiDrawTextWeight
        get() = memberAt<uiDrawTextWeightVar>(16).value
        set(value) { memberAt<uiDrawTextWeightVar>(16).value = value }
    
    var Italic: uiDrawTextItalic
        get() = memberAt<uiDrawTextItalicVar>(20).value
        set(value) { memberAt<uiDrawTextItalicVar>(20).value = value }
    
    var Stretch: uiDrawTextStretch
        get() = memberAt<uiDrawTextStretchVar>(24).value
        set(value) { memberAt<uiDrawTextStretchVar>(24).value = value }
    
}

class uiDrawTextFontMetrics(override val rawPtr: NativePtr) : CStructVar() {
    
    companion object : Type(40, 8)
    
    var Ascent: Double
        get() = memberAt<DoubleVar>(0).value
        set(value) { memberAt<DoubleVar>(0).value = value }
    
    var Descent: Double
        get() = memberAt<DoubleVar>(8).value
        set(value) { memberAt<DoubleVar>(8).value = value }
    
    var Leading: Double
        get() = memberAt<DoubleVar>(16).value
        set(value) { memberAt<DoubleVar>(16).value = value }
    
    var UnderlinePos: Double
        get() = memberAt<DoubleVar>(24).value
        set(value) { memberAt<DoubleVar>(24).value = value }
    
    var UnderlineThickness: Double
        get() = memberAt<DoubleVar>(32).value
        set(value) { memberAt<DoubleVar>(32).value = value }
    
}

class uiFontButton(override val rawPtr: NativePtr) : COpaque

class uiColorButton(override val rawPtr: NativePtr) : COpaque

// enum (anonymous at ./alpha3.1/src\ui.h:306:1):
val uiDrawBrushTypeSolid: Int = 0
val uiDrawBrushTypeLinearGradient: Int = 1
val uiDrawBrushTypeRadialGradient: Int = 2
val uiDrawBrushTypeImage: Int = 3

// enum (anonymous at ./alpha3.1/src\ui.h:313:1):
val uiDrawLineCapFlat: Int = 0
val uiDrawLineCapRound: Int = 1
val uiDrawLineCapSquare: Int = 2

// enum (anonymous at ./alpha3.1/src\ui.h:319:1):
val uiDrawLineJoinMiter: Int = 0
val uiDrawLineJoinRound: Int = 1
val uiDrawLineJoinBevel: Int = 2

// enum (anonymous at ./alpha3.1/src\ui.h:330:1):
val uiDrawFillModeWinding: Int = 0
val uiDrawFillModeAlternate: Int = 1

// enum (anonymous at ./alpha3.1/src\ui.h:455:1):
val uiDrawTextWeightThin: Int = 0
val uiDrawTextWeightUltraLight: Int = 1
val uiDrawTextWeightLight: Int = 2
val uiDrawTextWeightBook: Int = 3
val uiDrawTextWeightNormal: Int = 4
val uiDrawTextWeightMedium: Int = 5
val uiDrawTextWeightSemiBold: Int = 6
val uiDrawTextWeightBold: Int = 7
val uiDrawTextWeightUtraBold: Int = 8
val uiDrawTextWeightHeavy: Int = 9
val uiDrawTextWeightUltraHeavy: Int = 10

// enum (anonymous at ./alpha3.1/src\ui.h:469:1):
val uiDrawTextItalicNormal: Int = 0
val uiDrawTextItalicOblique: Int = 1
val uiDrawTextItalicItalic: Int = 2

// enum (anonymous at ./alpha3.1/src\ui.h:475:1):
val uiDrawTextStretchUltraCondensed: Int = 0
val uiDrawTextStretchExtraCondensed: Int = 1
val uiDrawTextStretchCondensed: Int = 2
val uiDrawTextStretchSemiCondensed: Int = 3
val uiDrawTextStretchNormal: Int = 4
val uiDrawTextStretchSemiExpanded: Int = 5
val uiDrawTextStretchExpanded: Int = 6
val uiDrawTextStretchExtraExpanded: Int = 7
val uiDrawTextStretchUltraExpanded: Int = 8

// enum (anonymous at ./alpha3.1/src\ui.h:524:1):
val uiModifierCtrl: Int = 1
val uiModifierAlt: Int = 2
val uiModifierShift: Int = 4
val uiModifierSuper: Int = 8

// enum (anonymous at ./alpha3.1/src\ui.h:551:1):
val uiExtKeyEscape: Int = 1
val uiExtKeyInsert: Int = 2
val uiExtKeyDelete: Int = 3
val uiExtKeyHome: Int = 4
val uiExtKeyEnd: Int = 5
val uiExtKeyPageUp: Int = 6
val uiExtKeyPageDown: Int = 7
val uiExtKeyUp: Int = 8
val uiExtKeyDown: Int = 9
val uiExtKeyLeft: Int = 10
val uiExtKeyRight: Int = 11
val uiExtKeyF1: Int = 12
val uiExtKeyF2: Int = 13
val uiExtKeyF3: Int = 14
val uiExtKeyF4: Int = 15
val uiExtKeyF5: Int = 16
val uiExtKeyF6: Int = 17
val uiExtKeyF7: Int = 18
val uiExtKeyF8: Int = 19
val uiExtKeyF9: Int = 20
val uiExtKeyF10: Int = 21
val uiExtKeyF11: Int = 22
val uiExtKeyF12: Int = 23
val uiExtKeyN0: Int = 24
val uiExtKeyN1: Int = 25
val uiExtKeyN2: Int = 26
val uiExtKeyN3: Int = 27
val uiExtKeyN4: Int = 28
val uiExtKeyN5: Int = 29
val uiExtKeyN6: Int = 30
val uiExtKeyN7: Int = 31
val uiExtKeyN8: Int = 32
val uiExtKeyN9: Int = 33
val uiExtKeyNDot: Int = 34
val uiExtKeyNEnter: Int = 35
val uiExtKeyNAdd: Int = 36
val uiExtKeyNSubtract: Int = 37
val uiExtKeyNMultiply: Int = 38
val uiExtKeyNDivide: Int = 39

typealias size_tVar = LongVarOf<size_t>
typealias size_t = Long

typealias uint32_tVar = IntVarOf<uint32_t>
typealias uint32_t = Int

typealias uintptr_tVar = LongVarOf<uintptr_t>
typealias uintptr_t = Long

typealias uintmax_tVar = LongVarOf<uintmax_t>
typealias uintmax_t = Long

typealias intmax_tVar = LongVarOf<intmax_t>
typealias intmax_t = Long

typealias uiModifiersVar = IntVarOf<uiModifiers>
typealias uiModifiers = Int

typealias uint64_tVar = LongVarOf<uint64_t>
typealias uint64_t = Long

typealias uiExtKeyVar = IntVarOf<uiExtKey>
typealias uiExtKey = Int

typealias uiDrawBrushTypeVar = IntVarOf<uiDrawBrushType>
typealias uiDrawBrushType = Int

typealias uiDrawLineCapVar = IntVarOf<uiDrawLineCap>
typealias uiDrawLineCap = Int

typealias uiDrawLineJoinVar = IntVarOf<uiDrawLineJoin>
typealias uiDrawLineJoin = Int

typealias uiDrawFillModeVar = IntVarOf<uiDrawFillMode>
typealias uiDrawFillMode = Int

typealias uiDrawTextWeightVar = IntVarOf<uiDrawTextWeight>
typealias uiDrawTextWeight = Int

typealias uiDrawTextItalicVar = IntVarOf<uiDrawTextItalic>
typealias uiDrawTextItalic = Int

typealias uiDrawTextStretchVar = IntVarOf<uiDrawTextStretch>
typealias uiDrawTextStretch = Int


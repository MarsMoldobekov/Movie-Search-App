package com.example.moviesearchapp.ui.extenstions

import android.view.View
import com.google.android.material.snackbar.Snackbar

fun View.show(): View {
    if (visibility != View.VISIBLE) {
        visibility = View.VISIBLE
    }

    return this
}

fun View.hide(): View {
    if (visibility != View.GONE) {
        visibility = View.GONE
    }

    return this
}

inline fun View.showIf(condition: () -> Boolean): View {
    if (visibility != View.VISIBLE && condition.invoke()) {
        visibility = View.VISIBLE
    }

    return this
}

inline fun View.hideIf(predicate: () -> Boolean): View {
    if (visibility != View.GONE && predicate.invoke()) {
        visibility = View.GONE
    }

    return this
}

fun View.createAndShow(
    text: String,
    actionText: String,
    action: (View) -> Unit,
    length: Int = Snackbar.LENGTH_INDEFINITE
) {
    Snackbar.make(this, text, length).setAction(actionText, action).show()
}

fun View.createAndShow(
    text: String,
    resId: Int,
    action: (View) -> Unit,
    length: Int = Snackbar.LENGTH_INDEFINITE
) {
    Snackbar.make(this, text, length).setAction(
        resources.getString(resId),
        action
    ).show()
}

fun View.createAndShowWithoutAction(text: String, length: Int = Snackbar.LENGTH_INDEFINITE) {
    Snackbar.make(this, text, length).show()
}
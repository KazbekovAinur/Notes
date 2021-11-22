package com.kazbekovainur.notes

import android.content.ContentValues.TAG
import android.util.Log

class NotePresenter (var view: NoteView?) {
    /** Проверка заметки на наличие текста*/
    fun tryToSave(headTitle: String, content: String) {
        if (content.isEmpty()) {
            Log.d(
                TAG,
                "Не удалось сохранить заметку"
            )
            view?.onSaveFaildNotes()
        } else {
            onSaveSuccess(headTitle, content)
        }
    }

    private fun onSaveSuccess(headTitle: String, content: String){
        Log.d(
            TAG,
            "Заметка успешно сохранена! Заголовок: $headTitle, Текст: $content"
        )
        view?.onSaveSuccessNotes()
    }
}
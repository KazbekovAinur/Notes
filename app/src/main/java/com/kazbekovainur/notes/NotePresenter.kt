package com.kazbekovainur.notes

import android.content.ContentValues.TAG
import android.util.Log

class NotePresenter (var view: NoteView?) {

    fun tryToSave(HeadTitle: String, content: String) {
        if (content.isEmpty()) {
            Log.d(
                TAG,
                "Не удалось сохранить заметку"
            )
            view?.onSaveFaildNotes()
        } else {
            onSaveSuccess(HeadTitle, content)
        }
    }

    private fun onSaveSuccess(HeadTitle: String, content: String){
        Log.d(
            TAG,
            "Заметка успешно сохранена! Заголовок: $HeadTitle, Текст: $content"
        )
        view?.onSaveSuccessNotes()
    }
}
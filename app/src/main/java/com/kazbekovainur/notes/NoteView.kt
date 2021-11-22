package com.kazbekovainur.notes

interface NoteView {

    /** Сохранено успешно */
    fun onSaveSuccessNotes()

    /** Не сохранено */
    fun onSaveFaildNotes()
}
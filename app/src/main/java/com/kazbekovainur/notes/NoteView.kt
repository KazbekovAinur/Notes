package com.kazbekovainur.notes

interface NoteView {

    /** Успешное сохранение заметки */
    fun onSaveSuccessNotes()

    /** Попытка сохранения пустой заметки */
    fun onSaveFaildNotes()
}
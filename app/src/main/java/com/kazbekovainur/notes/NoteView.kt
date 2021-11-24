package com.kazbekovainur.notes

interface NoteView {

    /** Успешное сохранение заметки */
    fun onSaveSuccessNotes()

    /** Попытка сохранения пустой заметки */
    fun onSaveFaildNotes()

    /** Отправка заметки во внешнее приложение */
    fun onSendEmail(title: String, content: String)

    /** Переход на страницу About */
    fun goToAboutActivity()
}
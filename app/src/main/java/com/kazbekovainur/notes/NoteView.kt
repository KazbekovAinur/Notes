package com.kazbekovainur.notes

interface NoteView {

    /** Успешное сохранение заметки */
    fun onSaveSuccessNotes()

    /** Попытка сохранения пустой заметки */
    fun onSaveFaildNotes()

    /**
     * Неявный вызов приложений устройства для отправки текста заметки
     *
     * @param title Заголовок заметки
     * @param content Текст заметки
     */
    fun onSendEmail(title: String, content: String)

    /** Переход на страницу About */
    fun goToAboutActivity()
}
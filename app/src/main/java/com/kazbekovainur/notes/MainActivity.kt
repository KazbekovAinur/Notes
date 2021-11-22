package com.kazbekovainur.notes

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity(), NoteView {

    private var presenter: NotePresenter? = null
    private lateinit var title: EditText
    private lateinit var content: EditText
    private lateinit var save_btn: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
        presenter = NotePresenter(this)

    }

    private fun init(){
        title = findViewById<EditText>(R.id.title)
        content = findViewById<EditText>(R.id.content)
        save_btn = findViewById<Button>(R.id.save_btn).also {
            it.setOnClickListener {
                presenter?.tryToSave(
                    title.text.toString(),
                    content.text.toString()
                )
            }
        }
    }

    private fun showToast(text: String){
        Toast.makeText(this, text, Toast.LENGTH_LONG).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter?.view = null
    }

    override fun onSaveSuccessNotes() {
        showToast(getString(R.string.SaveSuccess))
    }

    override fun onSaveFaildNotes() {
        showToast(getString(R.string.SaveFaild))
    }
}
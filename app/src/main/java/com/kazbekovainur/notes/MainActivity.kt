package com.kazbekovainur.notes

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.kazbekovainur.notes.databinding.ActivityMainBinding

/**
 * Активити с простой реализацией сценария создания заметки, имеющую заголовок и обычный текст в качестве контента
 */
class MainActivity : AppCompatActivity(), NoteView {

    private var presenter: NotePresenter? = null
    private lateinit var title: EditText
    private lateinit var content: EditText
    private lateinit var save_btn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.title = getString(R.string.toolBarMainName)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.place_holder, ListNotesFragment())
            .commit()

        init()
        presenter = NotePresenter(this)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.itemAbout -> {
                presenter?.openAboutActivity()
            }
            R.id.itemSend -> {
                presenter?.sendEmailToApp(
                    title.text.toString(),
                    content.text.toString()
                )
            }

        }
        return true
    }

        private fun init() {
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

    override fun onSendEmail(title:String,content: String) {
        startActivity(Intent(Intent.ACTION_SEND).apply {
            type = "text/plain"
            putExtra(Intent.EXTRA_TEXT, "$title\n$content")
        })
    }

    override fun goToAboutActivity() {
        startActivity(Intent(this@MainActivity, AboutActivity::class.java))
    }
}
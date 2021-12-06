package com.kazbekovainur.notes

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kazbekovainur.notes.databinding.FragmentListNotesBinding
/**
 * Главный фрагмент список заметок
 *
 */
class ListNotesFragment : Fragment(), NoteAdapter.OnNoteItemClickListener {

    lateinit var binding: FragmentListNotesBinding
    private val adapterRc = NoteAdapter(createSampleList(), this, onClick = {openNextFrg(noteList = Note("Заголовок","Подзаголовок"))})

    private fun openNextFrg(noteList: Note){
        val intent = Intent(activity,AboutNotesFragment::class.java)
        intent.putExtra("Заголовок",noteList.title)
        intent.putExtra("Подзаголовок",noteList.subtitle)
        startActivity(intent)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentListNotesBinding.inflate(inflater, container, false )
        initRc()
        return binding.root
    }

    private fun initRc(){
        binding.apply {
            rcView.layoutManager = GridLayoutManager(context,2)
            rcView.adapter = adapterRc
        }
    }

    private fun createSampleList(): List<Note> =
        listOf(
            Note("Заголовок 1","Подзаголовок 1"),
            Note("Заголовок 2","Подзаголовок 2")
        )

    override fun onItemClick(noteList: Note, position: Int) {
       /** Toast.makeText(activity, noteList.title, Toast.LENGTH_SHORT).show() */
       requireFragmentManager().beginTransaction()
           .replace(R.id.rc, AboutNotesFragment.newInstance(noteList.title, noteList.subtitle))
           .addToBackStack(null)
           .commit()
    }
}




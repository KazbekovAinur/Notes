package com.kazbekovainur.notes

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kazbekovainur.notes.databinding.NoteItemBinding
/**
 * Адаптер NoteAdapter
 */
class NoteAdapter(private val noteList: List<Note>, var clicListener: OnNoteItemClickListener, private val onClick: (Note) -> Unit): RecyclerView.Adapter<NoteAdapter.NoteHolder>() {

    /**
     * Класс вью холдер
     *
     * @property item
     * */
    class NoteHolder(item: View, private val onClick: (Note)-> Unit): RecyclerView.ViewHolder(item) {

        /**
         * функция инициализация
         **/

        fun initialize(noteList: Note, action: OnNoteItemClickListener){
            binding.tvTitle.text = noteList.title
            binding.tvSubtitle.text = noteList.subtitle

            itemView.setOnClickListener {
                action.onItemClick(noteList,adapterPosition)
            }
        }
        val binding = NoteItemBinding.bind(item)

        /***
         * Функция биндинга данных
         *
         * @property note
         */

        fun bind (note: Note) = with(binding){
            tvTitle.text = note.title
            tvSubtitle.text = note.subtitle
            root.setOnClickListener {
                onClick.invoke(note)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.note_item, parent, false)
        return NoteHolder(view, onClick)
    }

    override fun onBindViewHolder(holder: NoteHolder, position: Int) {
        holder.bind(noteList[position])

        holder.initialize(noteList.get(position),clicListener)

    }

    interface OnNoteItemClickListener{
        fun onItemClick(noteList: Note, position: Int)
    }

    override fun getItemCount(): Int {
        return noteList.size
    }
}
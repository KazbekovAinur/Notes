package com.kazbekovainur.notes

import android.app.Notification
import android.app.Notification.EXTRA_TEXT
import android.content.Intent
import android.content.Intent.*
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.NotificationCompat.EXTRA_TEXT
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kazbekovainur.notes.databinding.FragmentAboutNotesBinding
import com.kazbekovainur.notes.databinding.FragmentListNotesBinding
/**
 * Фрагмент данные заметки
 */
class AboutNotesFragment : Fragment() {

    lateinit var binding: FragmentAboutNotesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAboutNotesBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvTitle1.text = arguments?.getString("TITLE", "").orEmpty()
        binding.tvSubtitle1.text = arguments?.getString("BODY","").orEmpty()
    }

    companion object {
        @JvmStatic
        fun newInstance(title: String, body: String) =
            AboutNotesFragment().apply {
                arguments = Bundle().apply {
                    putString("TITLE", title)
                    putString("BODY", body)
                }
            }
    }
}



package com.example.learnkotlin.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.learnkotlin.R

class MainFragment:Fragment() {
    private lateinit var createButton:Button
    private lateinit var showButton:Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.main_fragment,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        createButton = view.findViewById<Button>(R.id.createPerson)
        createButton.let {
            it.setOnClickListener {
                findNavController().navigate(R.id.createPersonFragment_graph) }
        }
        showButton = view.findViewById<Button>(R.id.showPerson)
        showButton.let {
            it.setOnClickListener {
                findNavController().navigate(R.id.showPersonsFragment)
            }
        }
    }
}
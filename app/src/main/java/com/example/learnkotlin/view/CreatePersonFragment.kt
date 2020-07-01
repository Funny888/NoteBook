package com.example.learnkotlin.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.learnkotlin.R
import com.example.learnkotlin.model.database.PersonTable

class CreatePersonFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.create_person_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val model = MainActivity.getModel()
        val name: EditText = view.findViewById(R.id.editName)
        val family: EditText = view.findViewById(R.id.editLastName)
        val number: EditText = view.findViewById(R.id.editNumber)
        val createButton = view.findViewById<Button>(R.id.btnCreate)
        createButton.setOnClickListener {
            model!!.createPerson(
                PersonTable(
                    Name = name.text.toString(),
                    Family = family.text.toString(),
                    Number = number.text.toString()
                )
            )
            findNavController().navigate(R.id.mainFragment_graph)
            Toast.makeText(context, getString(R.string.message_create_person), Toast.LENGTH_SHORT)
                .show()
        }

    }
}
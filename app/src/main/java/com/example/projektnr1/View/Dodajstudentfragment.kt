package com.example.projektnr1.View

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.projektnr1.R
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import android.text.TextUtils
import android.widget.Toast
import com.example.projektnr1.Model.Kurs
import com.example.projektnr1.Model.Student
import com.example.projektnr1.ViewModel.Kursviewmodel
import com.example.projektnr1.ViewModel.Studentviewmodel
import kotlinx.android.synthetic.main.fragment_dodajkursfragment.*
import kotlinx.android.synthetic.main.fragment_dodajkursfragment.view.*
import kotlinx.android.synthetic.main.fragment_dodajkursfragment.view.buttondodajkursid
import kotlinx.android.synthetic.main.fragment_dodajstudentfragment.*
import kotlinx.android.synthetic.main.fragment_dodajstudentfragment.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Dodajstudentfragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class Dodajstudentfragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    lateinit var studentviewmodel: Studentviewmodel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_dodajstudentfragment, container, false)

        studentviewmodel = ViewModelProvider(this).get(Studentviewmodel::class.java)

        view.buttondodajstudent2.setOnClickListener {
            dodajstudentadolisty()
        }

        return view

    }
    private fun dodajstudentadolisty() {
        val imie = imiestudentdodajid.text.toString()
        val nazwisko = nazwiskostudentdodajid.text.toString()

        if(!TextUtils.isEmpty(imie) && !TextUtils.isEmpty(nazwisko))
        {
            val student = Student(0, imie, nazwisko)
            studentviewmodel.dodajstudenta(student)
            findNavController().navigate(R.id.action_dodajstudent_to_listastudentfragment)

          //  Toast.makeText(requireContext(), "Dodano studenta do listy", Toast.LENGTH_SHORT).show()
        }
    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Dodajstudentfragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Dodajstudentfragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
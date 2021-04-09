package com.example.projektnr1.View

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.projektnr1.R
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.projektnr1.Model.Student
import com.example.projektnr1.View.Helper
import com.example.projektnr1.ViewModel.Studentviewmodel
import kotlinx.android.synthetic.main.fragment_edytujstudentfragment.*
import kotlinx.android.synthetic.main.fragment_edytujstudentfragment.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Edytujstudentfragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class Edytujstudentfragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    lateinit var studenviewmodel: Studentviewmodel

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
        val view = inflater.inflate(R.layout.fragment_edytujstudentfragment, container, false)


        studenviewmodel = ViewModelProvider(this).get(Studentviewmodel::class.java)

        view.imiestudentaid.setText(Helper.studentbiez.imie)
        view.nazwiskostudentaid.setText(Helper.studentbiez.nazwisko)

        view.buttonedytujstudenta.setOnClickListener{
            updateItem()
        }

         return view
    }

    private fun updateItem() {
        val imie = imiestudentaid.text.toString()
        val nazwisko = nazwiskostudentaid.text.toString()

        val editedStudent = Student(Helper.studentbiez.Idstudent, imie, nazwisko)
        studenviewmodel.edytujstudenta(editedStudent)
       // Toast.makeText(requireContext(), "Edytowano wpis z listy", Toast.LENGTH_SHORT).show()
        findNavController().navigate(R.id.action_edytujstudent_to_listastudentfragment)
    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Edytujstudentfragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Edytujstudentfragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
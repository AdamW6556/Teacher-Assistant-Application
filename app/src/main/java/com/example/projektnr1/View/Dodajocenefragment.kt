package com.example.projektnr1.View

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.projektnr1.R
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.projektnr1.Model.Ocena
import com.example.projektnr1.ViewModel.Ocenyviewmodel
import kotlinx.android.synthetic.main.fragment_dodajocenefragment.*
import kotlinx.android.synthetic.main.fragment_dodajocenefragment.view.*
import java.util.*
// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Dodajocenefragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class Dodajocenefragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    lateinit var ocenyviewmodel: Ocenyviewmodel

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
        val view = inflater.inflate(R.layout.fragment_dodajocenefragment, container, false)

        ocenyviewmodel = ViewModelProvider(this).get(Ocenyviewmodel::class.java)

        view.buttonocenid.setOnClickListener {
            addToList()
        }
        return view
    }

    private fun addToList() {
        val tekstoceny = ocena1id.text.toString()
        val x = ocena1id.text.toString().toDouble()
        val notatka = notatkaoceny1.text.toString()
        val studentid = Helper.studentbiez.Idstudent
        val kursid = Helper.kursbiez.Idkurs
        val kurs = Helper.kursbiez.nazwa

        if(!TextUtils.isEmpty(tekstoceny))
        {

            if(!TextUtils.isEmpty(notatka))
            {
                if(x in 2.0..5.0)
                {
                    val ocena = Ocena(0, studentid, kursid, kurs, x, notatka, Date())
                    ocenyviewmodel.dodajocene(ocena)
                    findNavController().navigate(R.id.action_dodajocene_to_listaocen)

                    // Toast.makeText(requireContext(), "Dodano notatkę", Toast.LENGTH_SHORT).show()
                }
                else
                {
                    Toast.makeText(requireContext(), "Nieprawidłowa wartość oceny", Toast.LENGTH_SHORT).show()
                }
            }
            else
            {
                Toast.makeText(requireContext(), "Pola muszą być uzupełnione!", Toast.LENGTH_SHORT).show()
            }


        }
        else
        {
            Toast.makeText(requireContext(), "Pola muszą być uzupełnione!", Toast.LENGTH_SHORT).show()
        }
    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Dodajocenefragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Dodajocenefragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
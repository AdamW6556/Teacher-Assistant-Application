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
import com.example.projektnr1.Model.Kurs
import com.example.projektnr1.ViewModel.Kursviewmodel
import kotlinx.android.synthetic.main.fragment_edytujkursfragment.*
import kotlinx.android.synthetic.main.fragment_edytujkursfragment.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Edytujkursfragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class Edytujkursfragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var kursviewmodel: Kursviewmodel


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
        kursviewmodel = ViewModelProvider(this).get(Kursviewmodel::class.java)
        val view =  inflater.inflate(R.layout.fragment_edytujkursfragment, container, false)
        view.edytujkursid.setText(Helper.kursbiez.nazwa)


        view.buttonedytujkursid.setOnClickListener{
            updateItem()
        }
      return view
    }

    private fun updateItem() {
        val name = edytujkursid.text.toString()


        val nowykurs = Kurs(Helper.kursbiez.Idkurs, name)
        kursviewmodel.edytujkurs(nowykurs)
        //Toast.makeText(requireContext(), "Edytowano wpis z listy", Toast.LENGTH_SHORT).show()
        findNavController().navigate(R.id.action_edytujkurs_to_kurslista)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Edytujkursfragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Edytujkursfragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
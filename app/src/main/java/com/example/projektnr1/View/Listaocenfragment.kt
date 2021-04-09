package com.example.projektnr1.View

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.projektnr1.R
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projektnr1.Adaptery.Adapterlistyocen
import com.example.projektnr1.ViewModel.Ocenyviewmodel
import kotlinx.android.synthetic.main.fragment_listaocenfragment.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Listaocenfragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class Listaocenfragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null


    lateinit var ocenyviewmodel: Ocenyviewmodel
    lateinit var viewManager: RecyclerView.LayoutManager
    lateinit var adapterlistyocen: Adapterlistyocen

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
    ): View?
    {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_listaocenfragment, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var studentid = Helper.studentbiez.Idstudent

        var kursid = Helper.kursbiez.Idkurs

        ocenyviewmodel = ViewModelProvider(requireActivity()).get(Ocenyviewmodel::class.java)


        ocenyviewmodel.ocenystudent(studentid, kursid)

        viewManager = LinearLayoutManager(requireContext())

        adapterlistyocen = Adapterlistyocen(ocenyviewmodel.ocenyall, ocenyviewmodel)


        recyclerviewlistaocen.apply {
            adapter = adapterlistyocen
            layoutManager = viewManager
        }

        ocenyviewmodel.ocenyall.observe(viewLifecycleOwner, Observer {
            adapterlistyocen.notifyDataSetChanged()
        })

        buttondodajocene.setOnClickListener {
            findNavController().navigate(R.id.action_listaocen_to_dodajocene)
        }
    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Listaocenfragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Listaocenfragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
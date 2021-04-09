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
import com.example.projektnr1.Adaptery.Adapterlistykursow
//import com.example.projektnr1.databinding.FragmentCourseListBinding
import com.example.projektnr1.View.Helper
import com.example.projektnr1.ViewModel.Kursviewmodel
import kotlinx.android.synthetic.main.fragment_kursfragment.*
import java.util.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Kursfragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class Kursfragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    // lateinit var binding: FragmentCourseListBinding
    lateinit var kursviewmodel: Kursviewmodel
    lateinit var viewManager: RecyclerView.LayoutManager
    lateinit var adapterkurs: Adapterlistykursow

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
        return inflater.inflate(R.layout.fragment_kursfragment, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        kursviewmodel = ViewModelProvider(requireActivity()).get(Kursviewmodel::class.java)
        viewManager = LinearLayoutManager(requireContext())

        adapterkurs = Adapterlistykursow(kursviewmodel.kursyall, kursviewmodel)

        listakursow.apply {
            adapter = adapterkurs

            layoutManager = viewManager
        }
        kursviewmodel.kursyall.observe(viewLifecycleOwner, Observer {
            adapterkurs.notifyDataSetChanged()
        })

        buttondodajkurs.setOnClickListener {
            findNavController().navigate(R.id.action_listakursow_to_dodajkurs)
        }

        Helper.databiez1[Calendar.HOUR_OF_DAY] = 0
        Helper.databiez1[Calendar.MINUTE] = 0
        Helper.databiez1[Calendar.SECOND] = 0
        Helper.databiez1[Calendar.MILLISECOND] = 0

        Helper.databiez2[Calendar.HOUR_OF_DAY] = 23
        Helper.databiez2[Calendar.MINUTE] = 59
        Helper.databiez2[Calendar.SECOND] = 59
        Helper.databiez2[Calendar.MILLISECOND] = 999
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Kursfragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Kursfragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
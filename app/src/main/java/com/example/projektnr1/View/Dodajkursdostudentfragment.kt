package com.example.projektnr1.View

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.projektnr1.R
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projektnr1.Adaptery.Adapterkursdostudenta
import com.example.projektnr1.ViewModel.KursStudentViewModel
import com.example.projektnr1.ViewModel.KursdoStudent
import kotlinx.android.synthetic.main.fragment_dodajkursdostudentfragment.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Dodajkursdostudentfragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class Dodajkursdostudentfragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var viewManager: RecyclerView.LayoutManager
    lateinit var adapter: Adapterkursdostudenta
    lateinit var kursdostudent: KursdoStudent
    lateinit var kurswstudentviewmodel: KursStudentViewModel

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
        return inflater.inflate(R.layout.fragment_dodajkursdostudentfragment, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        kursdostudent = ViewModelProvider(requireActivity()).get(
            KursdoStudent::class.java)

        kurswstudentviewmodel = ViewModelProvider(requireActivity()).get(KursStudentViewModel::class.java)

        viewManager = LinearLayoutManager(requireContext())

        adapter = Adapterkursdostudenta(kursdostudent.kursyall, kursdostudent, kurswstudentviewmodel, this)

        recyclerviewdodajkursdostudent.apply {
            adapter = adapter
            layoutManager = viewManager
        }

        kursdostudent.kursyall.observe(viewLifecycleOwner, Observer {
            adapter.notifyDataSetChanged()
        })

        var studentid = Helper.studentbiez.Idstudent

        kurswstudentviewmodel.postudencieid(studentid)

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Dodajkursdostudentfragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Dodajkursdostudentfragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
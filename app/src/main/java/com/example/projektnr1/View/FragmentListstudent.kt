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
import com.example.projektnr1.Adaptery.Adapterlistystudentow
import com.example.projektnr1.ViewModel.Studentviewmodel
import kotlinx.android.synthetic.main.fragment_liststudent.*
// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentListstudent.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentListstudent : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null


    lateinit var studentviewmodel: Studentviewmodel
    lateinit var viewManager: RecyclerView.LayoutManager
    lateinit var adapterlistystudentow: Adapterlistystudentow

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
        return inflater.inflate(R.layout.fragment_liststudent, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        studentviewmodel = ViewModelProvider(requireActivity()).get(Studentviewmodel::class.java)
        viewManager = LinearLayoutManager(requireContext())

        adapterlistystudentow = Adapterlistystudentow(studentviewmodel.studenci, studentviewmodel)

        listastudent1.apply {
            adapter = adapterlistystudentow
            layoutManager = viewManager
        }

        studentviewmodel.studenci.observe(viewLifecycleOwner, Observer {
            adapterlistystudentow.notifyDataSetChanged()
        })

        buttondodajstudent.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentliststudent_to_dodajstudent)
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FragmentListstudent.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FragmentListstudent().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
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
import com.example.projektnr1.Adaptery.AdapterKurswstudencie
import com.example.projektnr1.View.Helper
import com.example.projektnr1.ViewModel.StudentdoKursu
import com.example.projektnr1.ViewModel.KursStudentViewModel
import kotlinx.android.synthetic.main.fragment_kurswstudenciefragment.*
import kotlinx.android.synthetic.main.fragment_studentwkursiefragment.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Kurswstudenciefragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class Kurswstudenciefragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    lateinit var kurswstudencie: KursStudentViewModel
    lateinit var studentdokursu: StudentdoKursu
    lateinit var viewManager: RecyclerView.LayoutManager
    lateinit var adapter2: AdapterKurswstudencie

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
        return inflater.inflate(R.layout.fragment_kurswstudenciefragment, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        kurswstudencie = ViewModelProvider(requireActivity()).get(KursStudentViewModel::class.java)

        studentdokursu = ViewModelProvider(requireActivity()).get(StudentdoKursu::class.java)


        kurswstudencie.kursstudentow(Helper.studentbiez.Idstudent)

        viewManager = LinearLayoutManager(requireContext())

        var idstudent = Helper.studentbiez.Idstudent

        adapter2 = AdapterKurswstudencie(kurswstudencie.kursystudenta, kurswstudencie, studentdokursu, idstudent)

        recyclerviewkurswstudencie.apply {
            adapter = adapter2
            layoutManager = viewManager
        }

        kurswstudencie.kursystudenta.observe(viewLifecycleOwner, Observer {
            adapter2.notifyDataSetChanged()
        })

        //buttondodajkurswstudent.setOnClickListener {
       //     findNavController().navigate(R.id.action_kurswstudencie_to_kursdostudenta)
      //  }
    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Kurswstudenciefragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Kurswstudenciefragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
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
import com.example.projektnr1.Adaptery.Adapterstudentwkursie
import com.example.projektnr1.ViewModel.StudentdoKursu
import com.example.projektnr1.ViewModel.StudentKursviewmodel
import kotlinx.android.synthetic.main.fragment_studentwkursiefragment.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Studentwkursiefragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class Studentwkursiefragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    lateinit var studentwkursie: StudentKursviewmodel
    lateinit var studentdokursu: StudentdoKursu
    lateinit var viewManager: RecyclerView.LayoutManager
    lateinit var adapterstudentwkursie: Adapterstudentwkursie

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
        return inflater.inflate(R.layout.fragment_studentwkursiefragment, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        studentwkursie = ViewModelProvider(requireActivity()).get(StudentKursviewmodel::class.java)
        studentdokursu = ViewModelProvider(requireActivity()).get(StudentdoKursu::class.java)
        studentwkursie.studencizkursu(Helper.kursbiez.Idkurs)


        viewManager = LinearLayoutManager(requireContext())

            var kursid = Helper.kursbiez.Idkurs

        adapterstudentwkursie = Adapterstudentwkursie(studentwkursie.kursstudent, studentwkursie, studentdokursu, kursid)

        recyclerviewstudentwkursie.apply {
            adapter = adapterstudentwkursie
            layoutManager = viewManager
        }

        studentwkursie.kursstudent.observe(viewLifecycleOwner, Observer {
            adapterstudentwkursie.notifyDataSetChanged()
        })

        buttondodajstudentwkursie.setOnClickListener {
            findNavController().navigate(R.id.action_studentwkursie_to_studentdokursu)
        }

    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Studentwkursiefragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Studentwkursiefragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
package com.example.projektnr1.View

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.projektnr1.R
import androidx.annotation.RequiresApi
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projektnr1.Adaptery.Adapterraport
import com.example.projektnr1.ViewModel.Raportviewmodel
import kotlinx.android.synthetic.main.fragment_raport.*
import java.util.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Raportfragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class Raportfragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    lateinit var raportViewModel: Raportviewmodel
    lateinit var viewManager: RecyclerView.LayoutManager
    lateinit var adapterraport: Adapterraport

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
        return inflater.inflate(R.layout.fragment_raport, container, false)
    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        raportViewModel = ViewModelProvider(requireActivity()).get(Raportviewmodel::class.java)


        val data1 = Date(Helper.databiez1.timeInMillis)
        val data2 = Date(Helper.databiez2.timeInMillis)

        raportViewModel.ocenaidata(data1, data2)

        viewManager = LinearLayoutManager(requireContext())

        adapterraport = Adapterraport(raportViewModel.ocenystudenta)

        recyclerViewRaport.apply {
            adapter = adapterraport
            layoutManager = viewManager
        }

        raportViewModel.ocenystudenta.observe(viewLifecycleOwner, Observer {
            adapterraport.notifyDataSetChanged()
        })

    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Raportfragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Raportfragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
package com.example.projektnr1.Adaptery
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.projektnr1.R
import com.example.projektnr1.View.Helper
import androidx.navigation.findNavController
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.projektnr1.Model.Kurs
import com.example.projektnr1.ViewModel.StudentdoKursu
import com.example.projektnr1.ViewModel.KursStudentViewModel
import kotlinx.android.synthetic.main.one_row_kurswstudencie.view.*
import kotlinx.android.synthetic.main.one_row_studentwkursie.view.*
import kotlinx.android.synthetic.main.one_row_studentwkursie.view.buttonocen

class AdapterKurswstudencie(var listakursow: LiveData<List<Kurs>>, var kursstudentviewmodel: KursStudentViewModel, var studentdokursuviewmodel: StudentdoKursu, var idstudent: Int): RecyclerView.Adapter<AdapterKurswstudencie.Holder>()
{

    class Holder(val view: View): RecyclerView.ViewHolder(view) {
        val textViewkursstudent= view.findViewById<TextView>(R.id.kursstudent)

    }

    override  fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder{
        val view = LayoutInflater.from(parent.context).inflate(R.layout.one_row_kurswstudencie,parent, false) as View

        return Holder(view)
    }

    override fun getItemCount(): Int {
        return listakursow.value?.size?:0
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {

        val iditem = listakursow.value?.get(position)
        val idkurs = listakursow.value?.get(position)?.Idkurs
        val idstudenta = Helper.studentbiez.Idstudent


        holder.textViewkursstudent.text=listakursow.value?.get(position)?.nazwa

        holder.view.buttonocenst.setOnClickListener {
            if (iditem != null) {
                Helper.kursbiez = iditem
            }
            holder.itemView.findNavController().navigate(R.id.action_kurswstudencie_to_listaocen)
        }

        holder.view.usunkursst.setOnClickListener {
            if (idstudenta != null) {
                if (idkurs != null) {
                    kursstudentviewmodel.usun(idstudenta, idkurs)
                }
            }
        }
    }

}
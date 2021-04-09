package com.example.projektnr1.Adaptery
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.projektnr1.R
import com.example.projektnr1.View.Helper
import com.example.projektnr1.Model.Kurs
import com.example.projektnr1.View.Dodajkursdostudentfragment
import com.example.projektnr1.ViewModel.KursdoStudent
import com.example.projektnr1.ViewModel.KursStudentViewModel
import kotlinx.android.synthetic.main.one_row_kursdostudenta.view.*

class Adapterkursdostudenta(var listakursow: LiveData<List<Kurs>>, var kursdostudentaviewmodel: KursdoStudent, var kurswstudencieviewmodel: KursStudentViewModel, var kursdostd: Dodajkursdostudentfragment): RecyclerView.Adapter<Adapterkursdostudenta.Holder>()
{

    class Holder(val view: View): RecyclerView.ViewHolder(view) {

        val textViewkursstudent= view.findViewById<TextView>(R.id.rowkursstudent)
    }

    override  fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder{
        val view = LayoutInflater.from(parent.context).inflate(R.layout.one_row_kursdostudenta,parent, false) as View

        return Holder(view)
    }

    override fun getItemCount(): Int {
        return listakursow.value?.size?:0
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {

        val iditem = listakursow.value?.get(position)

        val idstudenta = Helper.studentbiez.Idstudent


        holder.textViewkursstudent.text=listakursow.value?.get(position)?.nazwa

        holder.view.rowkursdostudenta.setOnClickListener {

            if(kurswstudencieviewmodel.listast.isEmpty())
            {
                kursdostudentaviewmodel.dodajkurs(
                    Helper.studentbiez.Idstudent,
                    listakursow.value?.get(position)?.Idkurs!!
                )
                holder.itemView.findNavController()
                    .navigate(R.id.action_dodjakursdostudent_to_kurswstudencie)
            }
            else {
                if (!kurswstudencieviewmodel.listast.contains(listakursow.value?.get(position)?.Idkurs!!))
                {
                    kursdostudentaviewmodel.dodajkurs(
                        Helper.studentbiez.Idstudent,
                        listakursow.value?.get(position)?.Idkurs!!
                    )
                    holder.itemView.findNavController().navigate(R.id.action_dodjakursdostudent_to_kurswstudencie)
                }
                else
                {
                    Toast.makeText(kursdostd.context, "Już przypisano", Toast.LENGTH_SHORT).show()
                }
            }

        }

    }
}
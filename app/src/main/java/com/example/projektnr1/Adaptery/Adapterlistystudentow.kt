package com.example.projektnr1.Adaptery
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.projektnr1.R
import com.example.projektnr1.Model.Student
import com.example.projektnr1.View.Helper
import com.example.projektnr1.ViewModel.Studentviewmodel
import kotlinx.android.synthetic.main.one_row_student.view.*
import kotlinx.android.synthetic.main.one_row_student.view.usunbutton
import kotlinx.android.synthetic.main.one_row_student.view.edycjabutton

class Adapterlistystudentow(var listastudent: LiveData<List<Student>>, var studentviewmodel: Studentviewmodel): RecyclerView.Adapter<Adapterlistystudentow.Holder>()
{

    class Holder(val view: View): RecyclerView.ViewHolder(view) {
        val textviewimie= view.findViewById<TextView>(R.id.row_imie)
        val textviewnazwisko= view.findViewById<TextView>(R.id.row_nazwisko)
    }

    override  fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder{
        val view = LayoutInflater.from(parent.context).inflate(R.layout.one_row_student,parent, false) as View

        return Holder(view)
    }

    override fun getItemCount(): Int {
        return listastudent.value?.size?:0
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {

        val iditem = listastudent.value?.get(position)

        holder.textviewimie.text=listastudent.value?.get(position)?.imie
        holder.textviewnazwisko.text=listastudent.value?.get(position)?.nazwisko

        holder.view.edycjabutton.setOnClickListener {
            if (iditem != null) {
                Helper.studentbiez = iditem
            }
            holder.itemView.findNavController().navigate(R.id.action_fragmentliststudent_to_edytujstudent)
        }

        holder.view.usunbutton.setOnClickListener {
            if (iditem != null) {
                Helper.studentbiez= iditem
            }
            studentviewmodel.usunstudenta(Helper.studentbiez)
        }

        holder.view.buttonkursliniastudent.setOnClickListener {
            if (iditem != null) {
                Helper.studentbiez = iditem
            }
            holder.itemView.findNavController().navigate(R.id.action_fragmentliststudent_to_kurswstudencie)
        }
    }
}
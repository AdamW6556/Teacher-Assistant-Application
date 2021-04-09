package com.example.projektnr1.Adaptery
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.projektnr1.R
import com.example.projektnr1.Model.Kurs
import com.example.projektnr1.Model.Student
import com.example.projektnr1.View.Helper
import com.example.projektnr1.ViewModel.StudentdoKursu
import com.example.projektnr1.ViewModel.Kursviewmodel
import com.example.projektnr1.ViewModel.Studentviewmodel
import kotlinx.android.synthetic.main.one_row_kurs.view.*
import kotlinx.android.synthetic.main.one_row_student.view.*
import kotlinx.android.synthetic.main.one_row_student.view.usunbutton
import kotlinx.android.synthetic.main.one_row_student.view.edycjabutton

class Adapterlistykursow(var kurslista: LiveData<List<Kurs>>, var kursviewmodel: Kursviewmodel): RecyclerView.Adapter<Adapterlistykursow.Holder>() {

    class Holder(val view: View): RecyclerView.ViewHolder(view) {
        val textViewnazwakurs= view.findViewById<TextView>(R.id.kursnazwa)
        //val textView2= view.findViewById<TextView>(R.id.row_course_name)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder{
        val view = LayoutInflater.from(parent.context).inflate(R.layout.one_row_kurs,parent, false) as View

        return Holder(view)
    }

    override fun getItemCount(): Int {
        return kurslista.value?.size?:0
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {

        val iditem = kurslista.value?.get(position)

        holder.textViewnazwakurs.text=kurslista.value?.get(position)?.nazwa


        holder.view.edytujkurs.setOnClickListener {
            if (iditem != null) {
                Helper.kursbiez = iditem
            }
            holder.itemView.findNavController().navigate(R.id.action_listakursow_to_edytujkurs)
        }

        holder.view.usunkurs.setOnClickListener {
            if (iditem != null) {
               Helper.kursbiez = iditem
            }
           kursviewmodel.usunkurs(Helper.kursbiez)
        }

        holder.view.buttonstudenciwkurslist.setOnClickListener {
            if (iditem != null) {
                Helper.kursbiez = iditem
            }
            holder.itemView.findNavController().navigate(R.id.action_listakursow_to_studentwkursie)
       }
    }
}
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
import com.example.projektnr1.ViewModel.StudentdoKursu
import com.example.projektnr1.ViewModel.StudentKursviewmodel
import kotlinx.android.synthetic.main.one_row_studentwkursie.view.*
class Adapterstudentwkursie(var listastudent: LiveData<List<Student>>, var studentkursviewmodel: StudentKursviewmodel, var studentdokursuviewmodel: StudentdoKursu, var idkurs: Int): RecyclerView.Adapter<Adapterstudentwkursie.Holder>()
{

    class Holder(val view: View): RecyclerView.ViewHolder(view) {
        val textViewimiewkursie= view.findViewById<TextView>(R.id.imiewkursie)
        val textViewnazwiskowkursie= view.findViewById<TextView>(R.id.nazwiskowkursie)
    }

    override  fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder{
        val view = LayoutInflater.from(parent.context).inflate(R.layout.one_row_studentwkursie,parent, false) as View

        return Holder(view)
    }

    override fun getItemCount(): Int {
        return listastudent.value?.size?:0
    }


    override fun onBindViewHolder(holder: Holder, position: Int) {

        val iditem = listastudent.value?.get(position)
        val idstudent = listastudent.value?.get(position)?.Idstudent
        val courseId = Helper.kursbiez.Idkurs


        holder.textViewimiewkursie.text=listastudent.value?.get(position)?.imie
        holder.textViewnazwiskowkursie.text=listastudent.value?.get(position)?.nazwisko

        holder.view.buttonocen.setOnClickListener {
            if (iditem != null) {
                Helper.studentbiez = iditem
            }
            holder.itemView.findNavController().navigate(R.id.action_studentwkursie_to_listaocen)
        }

        holder.view.buttonusunstudentzkurs.setOnClickListener {
            if (idstudent != null) {
                studentkursviewmodel.usun(idstudent, idkurs)
            }
        }
    }
}
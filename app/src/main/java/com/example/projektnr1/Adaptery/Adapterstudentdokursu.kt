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
import com.example.projektnr1.Model.Student
import com.example.projektnr1.View.Helper
import com.example.projektnr1.View.Dodajstudentdokursfragment
import com.example.projektnr1.ViewModel.StudentdoKursu
import com.example.projektnr1.ViewModel.StudentKursviewmodel
import kotlinx.android.synthetic.main.one_row_studentdokursu.view.*

class Adapterstudentdokursu(var listastudent: LiveData<List<Student>>, var studentdokursuviewmodel: StudentdoKursu, var studentwkursieviewmodel: StudentKursviewmodel, var stdokurs: Dodajstudentdokursfragment): RecyclerView.Adapter<Adapterstudentdokursu.Holder>()
{
    class Holder(val view: View): RecyclerView.ViewHolder(view) {
        val textViewimiewkurs= view.findViewById<TextView>(R.id.imiewkurs)
        val textViewnazwiskowkurs= view.findViewById<TextView>(R.id.nazwiskowkurs)
    }

    override  fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder{
        val view = LayoutInflater.from(parent.context).inflate(R.layout.one_row_studentdokursu,parent, false) as View

        return Holder(view)
    }

    override fun getItemCount(): Int {
        return listastudent.value?.size?:0
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {

        val iditem = listastudent.value?.get(position)

        val idkursu = Helper.kursbiez.Idkurs

        holder.textViewimiewkurs.text=listastudent.value?.get(position)?.imie
        holder.textViewnazwiskowkurs.text=listastudent.value?.get(position)?.nazwisko

        holder.view.rowstudentdokursu.setOnClickListener {

            if(studentwkursieviewmodel.listelement.isEmpty())
            {
                studentdokursuviewmodel.dodajstudenta(
                    listastudent.value?.get(position)?.Idstudent!!,
                    Helper.kursbiez.Idkurs
                )
                holder.itemView.findNavController()
                    .navigate(R.id.action_dodajstudentdokursu_to_studentwkursie)
            }
            else {
                if (!studentwkursieviewmodel.listelement.contains(listastudent.value?.get(position)?.Idstudent!!))
                {
                    studentdokursuviewmodel.dodajstudenta(
                        listastudent.value?.get(position)?.Idstudent!!,
                        Helper.kursbiez.Idkurs
                    )
                    holder.itemView.findNavController().navigate(R.id.action_dodajstudentdokursu_to_studentwkursie)
                }
                else
                {
                    Toast.makeText(stdokurs.context, "Ten student już jest!", Toast.LENGTH_SHORT).show()
                }
            }

        }

    }
}
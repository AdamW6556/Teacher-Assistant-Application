package com.example.projektnr1.Adaptery
import java.text.SimpleDateFormat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.projektnr1.R
import com.example.projektnr1.Model.Ocena
import com.example.projektnr1.Model.StudentOcena
import com.example.projektnr1.View.Helper
import com.example.projektnr1.ViewModel.Ocenyviewmodel
import kotlinx.android.synthetic.main.one_row_kurs.view.*

class Adapterraport(var ocenystudent: LiveData<List<StudentOcena>>): RecyclerView.Adapter<Adapterraport.Holder>()  {

    class Holder(val view: View): RecyclerView.ViewHolder(view) {

        val raportimie= view.findViewById<TextView>(R.id.raportimie)

        val raportnazwisko=  view.findViewById<TextView>(R.id.raportnazwisko)

        val raportocena=  view.findViewById<TextView>(R.id.raportocena)

        val raportopisoceny=  view.findViewById<TextView>(R.id.raportinfo)

        val raportdata=  view.findViewById<TextView>(R.id.raportdata)

        val raportkurs=  view.findViewById<TextView>(R.id.raportprzedmiot)
    }

    override  fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder{
        val view = LayoutInflater.from(parent.context).inflate(R.layout.one_row_raport,parent, false) as View

        return Holder(view)
    }

    override fun getItemCount(): Int {
        return ocenystudent.value?.size?:0
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {

        val currentItem = ocenystudent.value?.get(position)

        holder.raportimie.text=ocenystudent.value?.get(position)?.student?.imie
        holder.raportnazwisko.text=ocenystudent.value?.get(position)?.student?.nazwisko
        holder.raportocena.text=ocenystudent.value?.get(position)?.ocena?.ocena.toString()
        holder.raportopisoceny.text=ocenystudent.value?.get(position)?.ocena?.opis
        holder.raportdata.text= SimpleDateFormat("dd-MM-yyyy").format(ocenystudent.value?.get(position)?.ocena?.data)
        holder.raportkurs.text=ocenystudent.value?.get(position)?.ocena?.kursinfo
    }
}
package com.example.projektnr1.Adaptery
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.projektnr1.R
import com.example.projektnr1.View.Helper
import com.example.projektnr1.Model.Ocena
import com.example.projektnr1.ViewModel.Ocenyviewmodel
import kotlinx.android.synthetic.main.one_row_ocena.view.*
import java.text.SimpleDateFormat

class Adapterlistyocen(var listaocen: LiveData<List<Ocena>>, var ocenyviewmodel: Ocenyviewmodel): RecyclerView.Adapter<Adapterlistyocen.Holder>()
{
    class Holder(val view: View): RecyclerView.ViewHolder(view) {
        val textViewocena= view.findViewById<TextView>(R.id.ocenaocena)
        val textViewnotatka=  view.findViewById<TextView>(R.id.ocenanotatka)
        val textViewdata=  view.findViewById<TextView>(R.id.dataocena)
    }

    override  fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder{
        val view = LayoutInflater.from(parent.context).inflate(R.layout.one_row_ocena,parent, false) as View

        return Holder(view)
    }

    override fun getItemCount(): Int {
        return listaocen.value?.size?:0
    }
    override fun onBindViewHolder(holder: Holder, position: Int) {

        val iditem = listaocen.value?.get(position)

        holder.textViewocena.text=listaocen.value?.get(position)?.ocena.toString()
        holder.textViewnotatka.text=listaocen.value?.get(position)?.opis
        holder.textViewdata.text= SimpleDateFormat("dd.MM.yyyy").format(listaocen.value?.get(position)?.data)

        holder.view.usunocene.setOnClickListener {
            if (iditem != null) {
                Helper.ocenabiez = iditem
            }
            ocenyviewmodel.usunocene(Helper.ocenabiez)
        }
    }
}
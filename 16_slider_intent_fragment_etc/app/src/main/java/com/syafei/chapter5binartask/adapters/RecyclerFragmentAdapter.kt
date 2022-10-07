package com.syafei.chapter5binartask.adapters

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.syafei.chapter5binartask.DetailsActivityRecyclerview
import com.syafei.chapter5binartask.R


class RecyclerFragmentAdapter(
    private val context: Context
) : RecyclerView.Adapter<RecyclerFragmentAdapter.RecyclerViewHolder>() {

    companion object {
        const val NUMBER = "number"
        const val CODE = "code"
        const val CATEGORY = "category"
        const val CONTENT = "content"
    }

    private val kode = arrayOf(
        "d116df5",
        "36ffc75", "f5cfe78", "5b87628",
        "db8d14e", "9913dc4", "e120f96",
        "466251b", "afasfaa", "adasdad"
    )

    private val kategori = arrayOf(
        "Kekayaan", "Teknologi",
        "Keluarga", "Bisnis",
        "Keluarga", "Hutang",
        "Teknologi", "Pidana",
        "fiqih", "tauhid"
    )

    private val isi = arrayOf(
        "pertanyaan 9",
        "pertanyaan 11", "pertanyaan 17", "test forum",
        "pertanyaan 12", "pertanyaan 18", "pertanyaan 20",
        "pertanyaan 21", "pertanyaan 56", "pertanyaan 69"
    )

    //viewHolder hold every view for a recyclerview
    inner class RecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemKode: TextView = itemView.findViewById(R.id.kodePertanyaan)
        var itemKategori: TextView = itemView.findViewById(R.id.kategori)
        var itemIsi: TextView = itemView.findViewById(R.id.isiPertanyaan)
        //val container: CardView = itemView.findViewById(R.id.cv_item_recyler)

        init {

            itemView.setOnClickListener {
                //val position: Int = adapterPosition
                val position: Int = bindingAdapterPosition
                //val context = itemView.context // if uses context itemView instead of class constructor
                val intent = Intent(context, DetailsActivityRecyclerview::class.java).apply {
                    putExtra(NUMBER, position)
                    putExtra(CODE, itemKode.text)
                    putExtra(CATEGORY, itemKategori.text)
                    putExtra(CONTENT, itemIsi.text)
                }
                Toast.makeText(context, " klik posisi adapter: ${position}" , Toast.LENGTH_SHORT).show()
                Log.i("di klik:RecyclerAdapter", itemKategori.toString())
                context.startActivity(intent)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.cardview_item_recyclerview, parent, false)
        return RecyclerViewHolder(view)
    }

    override fun onBindViewHolder(holderRecycler: RecyclerViewHolder, position: Int) {

        holderRecycler.apply {
            itemKode.text = kode[position]
            itemKategori.text = kategori[position]
            itemIsi.text = isi[position]
        }

    }

    override fun getItemCount(): Int {
        return kode.size
    }
}


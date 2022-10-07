package com.syafei.belajarfundamentalaplikasiandroidrecylerview.jsonparsing

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.syafei.belajarfundamentalaplikasiandroidrecylerview.R

class CostumAdapter(
    private var context: Context,
    private var userName: ArrayList<String>,
    private var name: ArrayList<String>,
    private var avatar: ArrayList<String>,
    private var company: ArrayList<String>,
    private var location: ArrayList<String>,
    private var repository: ArrayList<Int>,
    private var followers: ArrayList<Int>,
    private var following: ArrayList<Int>
) : RecyclerView.Adapter<CostumAdapter.MyViewHolder>() {

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imageJs: ImageView = itemView.findViewById<View>(R.id.iv_img_json) as ImageView
        var nameUser: TextView = itemView.findViewById<View>(R.id.tv_name_json) as TextView
        var userName: TextView = itemView.findViewById<View>(R.id.tv_username_json) as TextView
        var company: TextView = itemView.findViewById<View>(R.id.tv_company_json) as TextView

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_rv_json, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.nameUser.text = name[position]
        holder.userName.text = userName[position]
        holder.company.text = company[position]
        Glide.with(holder.itemView.context)
            .load(avatar[position])
            .circleCrop()
            .into(holder.imageJs)

    }

    override fun getItemCount(): Int {
        return name.size
    }
}
package com.example.myapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListItemAdapter : RecyclerView.Adapter<ListItemAdapter.ListItemViewHolder>() {

    var listItem = mutableListOf("Nama 1", "Nama 2", "Nama 3")

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListItemViewHolder {
//        ngasih tau layout mana yang harus diambil untuk list nya
        val viewItem = LayoutInflater.from(parent.context).inflate(R.layout.item_list_data, null)
        return ListItemViewHolder(viewItem)
    }

    override fun getItemCount(): Int = listItem.size

//    define tampilan data yang harus ditampilin di tiap itemnya
    override fun onBindViewHolder(holder: ListItemViewHolder, position: Int) {
        holder.bindData(listItem[position])
    }

    class ListItemViewHolder(val view : View) : RecyclerView.ViewHolder(view) {
        fun bindData(name: String){
            val txtName = view.findViewById<TextView>(R.id.txt_name)
            val txtOffice = view.findViewById<TextView>(R.id.txt_office)

            txtName.text = name
        }
    }
}
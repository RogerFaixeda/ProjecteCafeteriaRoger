package com.faixeda.projectecafeteriaroger.Home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.faixeda.projectecafeteriaroger.R

class CustomAdapter(private val mList: List<MenuModel>,  private val itemClick: (MenuModel) -> Unit) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_design, parent, false)

        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val menuModel = mList[position]

        // sets the text to the textview from our itemHolder class
        holder.textViewNom.text = menuModel.nom

        holder.textViewPreu.text = menuModel.preu.toString() + " €"

        holder.itemView.setOnClickListener{
            itemClick(menuModel)
            Toast.makeText(holder.itemView.context, holder.textViewNom.text.toString() + " afegit a la cistella.", Toast.LENGTH_SHORT).show()
        }


    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val textViewNom: TextView = itemView.findViewById(R.id.textViewNom)
        val textViewPreu: TextView = itemView.findViewById(R.id.textViewPreu)
    }
}

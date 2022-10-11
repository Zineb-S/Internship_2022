package com.example.cmcapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BrandAdapter(private val brandList: List<Brand>) : RecyclerView.Adapter<BrandAdapter.ViewHolder>() {

    private lateinit var brandListener: OnItemClickListener

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the monster_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.brand_card_item, parent, false)

        return ViewHolder(view,brandListener)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        // get the data
        val brand = brandList[position]

        // assign the data to the corresponding UI element
        holder.brandImageView.setImageResource(brand.BrandImage)
        holder.brandNameTextView.text = brand.BrandName


    }
    fun setOnItemClickListener(listener: OnItemClickListener) {
        brandListener = listener
    }
    // return the number of the items in the list
    override fun getItemCount(): Int {
        return brandList.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View, brandListener: OnItemClickListener) : RecyclerView.ViewHolder(ItemView) {
        val brandImageView = itemView.findViewById<ImageView>(R.id.BrandImageView)
        val brandNameTextView = itemView.findViewById<TextView>(R.id.BrandNameTextView)

        init {
            itemView.setOnClickListener {
                brandListener.onItemClick(adapterPosition)


            }

        }

    }
}

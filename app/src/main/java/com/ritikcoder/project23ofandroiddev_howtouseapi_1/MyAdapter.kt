package com.ritikcoder.project23ofandroiddev_howtouseapi_1

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.squareup.picasso.Picasso

class MyAdapter(val context: Activity, val productArrayList: List<Product>) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    //MyViewHolder Class is here.
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView
        val image: ShapeableImageView
        val productDetail: TextView

        init {
            title= itemView.findViewById(R.id.textViewForProductName)
            image= itemView.findViewById(R.id.shapeableImageViewForProductImage)
            productDetail= itemView.findViewById(R.id.textViewForForProductDetail)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView= LayoutInflater.from(context).inflate(R.layout.each_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return productArrayList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem= productArrayList[position]
        holder.title.text= currentItem.title
        //imageView, How to show image in image view if the image is in form of URL, 3rd party library.
        //Picasso.
        Picasso.get().load(currentItem.thumbnail).into(holder.image);
        holder.productDetail.text= currentItem.brand
    }

}
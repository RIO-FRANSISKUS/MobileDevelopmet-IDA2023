package com.example.pertemuanpertamaapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pertemuanpertamaapp.databinding.ItemRowHeroBinding

class ListHeroAdapter(private val listHero: ArrayList<Hero>) : RecyclerView.Adapter<ListHeroAdapter.ListViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback (onItemClickCallback: OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }

    class ListViewHolder(var binding: ItemRowHeroBinding) : RecyclerView.ViewHolder(binding.root) {

    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListHeroAdapter.ListViewHolder {

        //setelah binding
        val binding = ItemRowHeroBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        //sebelum binding
        //val view : View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_hero, parent, false)

        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListHeroAdapter.ListViewHolder, position: Int) {
        val (name, description, photo) = listHero[position]


        //implementasi Glide disini
            Glide.with(holder.itemView.context)
                .load(photo) //URL GAMBAR
                .into(holder.binding.imgItemPhoto) // imageView mana yang akan diterapkan


            holder.binding.tvItemName.text = name
            holder.binding.tvItemDescription.text = description

            holder.itemView.setOnClickListener{
                onItemClickCallback.onItemClicked(listHero[holder.adapterPosition])
            }



//        holder.itemView.setOnClickListener{
//            Toast.makeText(holder.itemView.context, "Kamu memilih " + listHero[holder.adapterPosition].name, Toast.LENGTH_SHORT).show()
//        }
    }

    override fun getItemCount(): Int = listHero.size

    interface OnItemClickCallback {
        fun onItemClicked (data : Hero)
    }
}
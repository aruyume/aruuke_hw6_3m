package com.example.aruuke_rakhmanova_hw_6_3m

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.aruuke_rakhmanova_hw_6_3m.databinding.ItemAnimalBinding

class AdapterAnimal : RecyclerView.Adapter<AdapterAnimal.HolderAnimal>() {
    val animalList = ArrayList<Animal>()

    class HolderAnimal(item: View) : RecyclerView.ViewHolder(item) {
        val binding = ItemAnimalBinding.bind(item)
        fun bind(animal: Animal) = with(binding) {
            imgAnimal.setImageResource(animal.imageId)
            tvName.text = animal.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderAnimal {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_animal, parent, false)
        return HolderAnimal(view)
    }

    override fun getItemCount(): Int {
        return animalList.size
    }

    override fun onBindViewHolder(holder: HolderAnimal, position: Int) {
        holder.bind(animalList[position])
    }
    fun addAnimal(animal: Animal){
        animalList.add(animal)
        notifyDataSetChanged()
    }
}


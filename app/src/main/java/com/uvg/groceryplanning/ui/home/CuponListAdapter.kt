package com.uvg.groceryplanning.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.uvg.groceryplanning.databinding.CuponItemBinding
import com.uvg.groceryplanning.databinding.FragmentHomeBinding
import java.lang.Exception

class cuponListAdapter() : RecyclerView.Adapter<cuponListAdapter.cuponListHolder>() {
    inner class cuponListHolder(val binding: CuponItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): cuponListHolder {
        val binding = CuponItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return cuponListHolder(binding)
    }

    override fun onBindViewHolder(holder: cuponListHolder, position: Int) {
        holder.binding.porcentaje.text = "porcentaje"
        holder.binding.producto.text = "producto"
        holder.binding.supermercado.text = "supermercado"
        holder.binding.disponibilidad.text = "disponibilidad"

        /*val pokemon = pokemonList[position]
        holder.binding.pokemonName.text = pokemon.name

        holder.binding.

        val imageView = holder.binding.pokemonPhoto*/

        /*Picasso.get()
            .load(pokemon.imageUrlFront)
            .resize(200,200)
            //.centerCrop()
            .centerInside()
            .placeholder(R.drawable.wait)
            .error(R.drawable.no)
            .into(imageView, object : Callback {
                override fun onSuccess() {
                    // no-op
                }

                override fun onError(e: Exception?) {
                    e?.printStackTrace()
                }

            })*/
        /*holder.binding.cardView.setOnClickListener(){
            val action = MainFragmentDirections.actionMainFragmentToDetailFragment(position, pokemon.name)
            holder.binding.root.findNavController().navigate(action)
        }*/


    }

    override fun getItemCount(): Int {
        return 3
    }
}
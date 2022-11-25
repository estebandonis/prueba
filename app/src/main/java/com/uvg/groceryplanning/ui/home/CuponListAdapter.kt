package com.uvg.groceryplanning.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.uvg.groceryplanning.database.Cupones.Cupon
import com.uvg.groceryplanning.databinding.CuponItemBinding
import com.uvg.groceryplanning.databinding.FragmentHomeBinding
import java.lang.Exception

class cuponListAdapter() : RecyclerView.Adapter<cuponListAdapter.cuponListHolder>() {
    inner class cuponListHolder(val binding: CuponItemBinding) : RecyclerView.ViewHolder(binding.root)

    val cupon1 = Cupon(0, "50% de descuento", "papel", "walmart", "disponible")
    val cupon2 = Cupon(1, "30% de descuento", "toallas", "paiz", "disponible")
    val cupon3 = Cupon(2, "40% de descuento", "Madera", "novex", "disponible")

    val list = mutableListOf<Cupon>(cupon1,cupon2,cupon3)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): cuponListHolder {
        val binding = CuponItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return cuponListHolder(binding)
    }

    override fun onBindViewHolder(holder: cuponListHolder, position: Int) {
        val cupons = list[position]

        holder.binding.porcentaje.text = cupons.porcentaje
        holder.binding.producto.text = cupons.producto
        holder.binding.supermercado.text = cupons.supermercado
        holder.binding.disponibilidad.text = cupons.disponibilidad

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
                override fun onError(e: Exception?) {
                    e?.printStackTrace()
                }

            })*/
        holder.binding.cardView.setOnClickListener(){
            val action = HomeFragmentDirections.actionNavigationHomeToCuponDetail(cupons.porcentaje, cupons.producto, cupons.supermercado, cupons.disponibilidad)
            holder.binding.root.findNavController().navigate(action)
        }


    }

    override fun getItemCount(): Int {
        return list.size
    }
}
package com.uvg.groceryplanning.ui.dashboard

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.uvg.groceryplanning.database.Ofertas.Oferta
import com.uvg.groceryplanning.databinding.OfertasItemBinding

class ofertaListAdapter() : RecyclerView.Adapter<ofertaListAdapter.ofertaListHolder>() {
    inner class ofertaListHolder(val binding: OfertasItemBinding) : RecyclerView.ViewHolder(binding.root)

    val oferta1 = Oferta(0, "3X2 en", "Jugos", "walmart")
    val oferta2 = Oferta(1, "4X2 en", "Cuadernos", "paiz")
    val oferta3 = Oferta(2, "5X3 en", "Clavos", "novex")

    val list = mutableListOf<Oferta>(oferta1,oferta2,oferta3)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ofertaListHolder {
        val binding = OfertasItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ofertaListHolder(binding)
    }

    override fun onBindViewHolder(holder: ofertaListHolder, position: Int) {
        val oferr = list[position]

        holder.binding.oferta.text = oferr.oferta
        holder.binding.producto.text = oferr.producto
        holder.binding.supermercado.text = oferr.supermercado

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
        holder.binding.cardView.setOnClickListener(){
            val action = DashboardFragmentDirections.actionNavigationDashboardToOfertaDetail(oferr.oferta, oferr.producto, oferr.supermercado)
            holder.binding.root.findNavController().navigate(action)
        }


    }

    override fun getItemCount(): Int {
        return list.size
    }
}
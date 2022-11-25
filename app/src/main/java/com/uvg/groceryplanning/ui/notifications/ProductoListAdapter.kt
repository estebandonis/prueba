package com.uvg.groceryplanning.ui.notifications

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import com.uvg.groceryplanning.R
import com.uvg.groceryplanning.database.Productos.Producto
import com.uvg.groceryplanning.databinding.ProductoItemBinding
import java.lang.Exception

class productoListAdapter() : RecyclerView.Adapter<productoListAdapter.productoListHolder>() {
    inner class productoListHolder(val binding: ProductoItemBinding) : RecyclerView.ViewHolder(binding.root)

    var list = mutableListOf<Producto>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): productoListHolder {
        val binding = ProductoItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return productoListHolder(binding)
    }

    override fun onBindViewHolder(holder: productoListHolder, position: Int) {
        val producto = list[position]

        holder.binding.nombre.text = producto.nombre
        holder.binding.tipo.text = producto.tipo
        holder.binding.supermercado.text = producto.supermercado

        val imageView = holder.binding.imageView

        Picasso.get()
            .load(producto.link)
            //.centerCrop()
            .resize(200,200)
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

            })

        holder.binding.cardView.setOnClickListener() {
            val action = NotificationsFragmentDirections.actionNavigationNotificationsToProductoDetail(
                producto.nombre,
                producto.tipo,
                producto.supermercado,
                producto.descripcion,
                producto.link
            )
            holder.binding.root.findNavController().navigate(action)
        }


    }

    fun setData(data: MutableList<Producto>){
        list = data
    }

    override fun getItemCount(): Int {
        return list.size
    }
}
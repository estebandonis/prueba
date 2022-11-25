package com.uvg.groceryplanning.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import com.uvg.groceryplanning.R
import com.uvg.groceryplanning.databinding.ProductoDetailFragmentBinding
import com.uvg.groceryplanning.ui.home.OfertaDetailArgs
import kotlinx.android.synthetic.main.producto_item.*
import java.lang.Exception

class ProductoDetail : Fragment() {
    val args: ProductoDetailArgs by navArgs()
    private var _binding: ProductoDetailFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = ProductoDetailFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val nombre = args.nombre
        val tipo = args.tipo
        val supermercado = args.supermercado
        val descripcion = args.descripcion
        val link = args.link

        binding.nombre.text = nombre
        binding.tipo.text = tipo
        binding.supermercado.text = supermercado
        binding.Description.text = descripcion

        val imageView = binding.imageView1

        Picasso.get()
            .load(link)
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
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
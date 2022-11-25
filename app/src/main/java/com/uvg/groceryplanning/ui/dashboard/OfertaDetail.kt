package com.uvg.groceryplanning.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.uvg.groceryplanning.databinding.OfertaDetailFragmentBinding

class OfertaDetail : Fragment() {
    val args: OfertaDetailArgs by navArgs()
    private var _binding: OfertaDetailFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = OfertaDetailFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val oferta = args.oferta
        val producto = args.producto
        val supermercado = args.supermercado

        binding.oferta.text = oferta
        binding.producto.text = producto
        binding.supermercado.text = supermercado
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
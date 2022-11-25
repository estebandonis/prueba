package com.uvg.groceryplanning.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.uvg.groceryplanning.databinding.CuponDetailFragmentBinding
import java.lang.Exception

class CuponDetail : Fragment() {
    val args: CuponDetailArgs by navArgs()
    private var _binding: CuponDetailFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = CuponDetailFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val porcentaje = args.porcentaje
        val producto = args.producto
        val supermercado = args.supermercado
        val disponibilidad = args.disponibilidad

        binding.porcentaje.text = porcentaje
        binding.producto.text = producto
        binding.supermercado.text = supermercado
        binding.disponibilidad.text = disponibilidad
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
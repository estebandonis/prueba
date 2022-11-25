package com.uvg.groceryplanning.ui.notifications

import android.app.SearchManager
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
//import androidx.appcompat.widget.SearchView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Query
import com.uvg.groceryplanning.database.Productos.Producto
import com.uvg.groceryplanning.databinding.FragmentNotificationsBinding
import com.uvg.groceryplanning.ui.home.cuponListAdapter
import kotlinx.android.synthetic.main.fragment_notifications.*

class NotificationsFragment : Fragment() {

    private var _binding: FragmentNotificationsBinding? = null
    private lateinit var recyclerView: RecyclerView
    private var isLinearLayoutManager = true
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    val producto1 = Producto(0, "Leche", "lacteos", "walmart", "Producto marca Pinito")
    val producto2 = Producto(1, "Jugo", "bebidas", "paiz", "Producto marca Jumex")
    val producto3 = Producto(2, "Jabon", "higiene", "la torre", "Producto marca Dove")

    val list = mutableListOf<Producto>(producto1, producto2, producto3)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerView = binding.recyclerView
        super.onViewCreated(view, savedInstanceState)

        recyclerView.layoutManager = LinearLayoutManager(context)
        val adapter = productoListAdapter()
        recyclerView.adapter = adapter

        adapter.setData(list)

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let{
                    val list2 = mutableListOf<Producto>()

                    for (producto in list){
                        if (producto.tipo == query){
                            list2.add(producto)
                        }
                    }

                    adapter.setData(list2)
                    recyclerView.adapter = adapter
                }

                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {


                return false
            }

        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
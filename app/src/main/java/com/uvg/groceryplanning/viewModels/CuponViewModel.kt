package com.uvg.groceryplanning.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.uvg.groceryplanning.database.Cupones.Cupon
import com.uvg.groceryplanning.database.Cupones.CuponDao

class CuponViewModel(private val cuponDao: CuponDao): ViewModel(){
    fun fullCupones(): List<Cupon> = cuponDao.getAll()
}

class CuponViewModelFactory(private val cuponDao: CuponDao): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CuponViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return CuponViewModel(cuponDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
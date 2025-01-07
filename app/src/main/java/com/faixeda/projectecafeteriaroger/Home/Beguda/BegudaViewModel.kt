package com.faixeda.projectecafeteriaroger.Home.Beguda

import androidx.lifecycle.ViewModel
import com.faixeda.projectecafeteriaroger.Home.DataSourceProductes
import com.faixeda.projectecafeteriaroger.Home.MenuModel

class BegudaViewModel : ViewModel(){
    private var _beguda: List<MenuModel> = emptyList()
    val beguda: List<MenuModel>
        get() = _beguda

    fun generarProductes() {
        val productes = DataSourceProductes.carregarProductes()
        _beguda = productes.filter { producte -> producte.tipus == "beguda" }
    }
}
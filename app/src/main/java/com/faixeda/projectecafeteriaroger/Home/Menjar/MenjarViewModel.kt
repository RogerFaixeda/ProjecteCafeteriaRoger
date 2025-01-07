package com.faixeda.projectecafeteriaroger.Home.Menjar

import androidx.lifecycle.ViewModel
import com.faixeda.projectecafeteriaroger.Home.DataSourceProductes
import com.faixeda.projectecafeteriaroger.Home.MenuModel

class MenjarViewModel : ViewModel() {
    private var _menjar: List<MenuModel> = emptyList()
    val menjar: List<MenuModel>
        get() = _menjar

    fun generarProductes() {
        val productes = DataSourceProductes.carregarProductes()
        _menjar = productes.filter { producte -> producte.tipus == "menjar" }
    }
}
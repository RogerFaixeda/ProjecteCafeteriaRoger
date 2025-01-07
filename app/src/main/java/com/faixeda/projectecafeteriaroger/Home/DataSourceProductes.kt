package com.faixeda.projectecafeteriaroger.Home

object DataSourceProductes {
    var productes: MutableList<MenuModel> = mutableListOf (
        MenuModel("menjar","Hamburguesa", 1, 7),
        MenuModel("menjar","Patatas Bravas", 1, 5),
        MenuModel("menjar","Bocata", 1, 7),
        MenuModel("beguda","Aigua", 1, 1),
        MenuModel("beguda","Nestea", 1, 2),
        MenuModel("beguda","Aquarius", 1, 3),
        MenuModel("postres", "Pastis", 1, 4),
        MenuModel("postres","Magdalena", 1, 3),
        MenuModel("postres","Cafe", 1, 2),
    )


    fun carregarProductes(): MutableList<MenuModel> {
        return productes
    }
}


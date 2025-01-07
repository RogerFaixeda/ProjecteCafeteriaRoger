package com.faixeda.projectecafeteriaroger

object DataSourceUsers {
    var users: MutableList<UsuarisModel> = mutableListOf (
        UsuarisModel("Roger",  "1234"),
        UsuarisModel("Dani",  "12345"),
    )

    fun returnUsers(): MutableList<UsuarisModel> {
        return users
    }
}


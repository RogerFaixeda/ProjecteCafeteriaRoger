package com.faixeda.projectecafeteriaroger.Login

import androidx.lifecycle.ViewModel
import com.faixeda.projectecafeteriaroger.DataSourceUsers
import com.faixeda.projectecafeteriaroger.UsuarisModel

class LoginViewModel : ViewModel() {
    private var _usuari: String = ""
    val usuari: String
        get() = _usuari

    private var _contrassenya: String = ""
    val contrassenya: String
        get() = _contrassenya

    private var _usuariComprovat: Boolean = false
    val usuariComprovat: Boolean
        get() = _usuariComprovat

    private var _usuariActual: UsuarisModel? = null
    val usuariActual: UsuarisModel?
        get() = _usuariActual

    fun setUsuari(usuari: String, contrassenya: String) {
        _usuari = usuari
        _contrassenya = contrassenya
    }
    fun comprovarUsuari() {
        val users = DataSourceUsers.returnUsers()
        _usuariActual = users.firstOrNull { user ->
            user.nom == usuari && user.contrassenya == contrassenya
        }
        _usuariComprovat = _usuariActual != null
    }
}
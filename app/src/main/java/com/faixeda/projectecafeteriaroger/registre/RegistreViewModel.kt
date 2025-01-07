package com.faixeda.projectecafeteriaroger.registre

import androidx.lifecycle.ViewModel
import com.faixeda.projectecafeteriaroger.DataSourceUsers
import com.faixeda.projectecafeteriaroger.DataSourceUsers.users
import com.faixeda.projectecafeteriaroger.UsuarisModel

class RegistreViewModel : ViewModel() {
    private var _usuari: String = ""
    val usuari: String
        get() = _usuari

    private var _contrassenya: String = ""
    val contrassenya: String
        get() = _contrassenya

    private var _usuariActual: UsuarisModel? = null
    val usuariActual: UsuarisModel?
        get() = _usuariActual

    private var _usuariComprovat: Boolean = false
    val usuariComprovat: Boolean
        get() = _usuariComprovat

    private var _usuariAfegit: Boolean = false
    val usuariAfegit: Boolean
        get() = _usuariAfegit

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

    fun afegirusuari(nom: String, contrasenya: String) {
        if (nom.isNotEmpty() && contrasenya.isNotEmpty()){
            setUsuari(nom, contrasenya)
            comprovarUsuari()
            if (!_usuariComprovat){
                _usuariAfegit
                users.add(UsuarisModel(nom, contrasenya))
            }
        }
    }
}
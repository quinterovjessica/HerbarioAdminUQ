package co.edu.uniquindio.vc.jq.herbarioadminuq.util

import android.content.Context
import android.content.res.Configuration
import android.os.Build
import java.util.*

const val MIS_PREFERENCIAS = "MisPreferencias"
const val LENGUAJE_DE_PREFERENCIA = "languaje_preferences"
const val LENGUAJE_ES = "es"
const val LENGUAJE_EN = "en"

fun selecionarIdioma(context: Context){
    val preferences =
            context.getSharedPreferences(MIS_PREFERENCIAS,
                    Context.MODE_PRIVATE)
    var idioma = preferences.getString(LENGUAJE_DE_PREFERENCIA,
            LENGUAJE_ES)
    if (idioma.equals(LENGUAJE_EN)){
        idioma = LENGUAJE_ES
    }else{
        idioma = LENGUAJE_EN
    }
    val editor= preferences.edit()
    editor.putString(LENGUAJE_DE_PREFERENCIA, idioma)
    editor.apply()
    cambiarIdioma(context)
}
@Suppress("DEPRECATION")
fun cambiarIdioma(context: Context){
    val preferences =
            context.getSharedPreferences(MIS_PREFERENCIAS,
                    Context.MODE_PRIVATE)
    var idioma = preferences.getString(LENGUAJE_DE_PREFERENCIA,
            LENGUAJE_ES)
    val local= Locale(idioma)
    Locale.setDefault(local)
    val config = Configuration()
    if( Build.VERSION.SDK_INT >= Build.VERSION_CODES.N ){
        config.setLocale(local)
    }else{
        config.locale = local
    }
    context.resources.updateConfiguration(config, null)
}
package co.edu.uniquindio.vc.jq.herbarioadminuq.vo

import android.os.Parcel
import android.os.Parcelable
import java.util.*

/*
permite mostrar la informacion
 */
//llamado explicito al metodo constructor
class Pokemon() : Parcelable {


    var id: String? = null
    var nombre: String? = null
    var tipo: String? = null
    var fechaAparicion: Date? = null
    var descripcion: String? = null
    var urlVideo: String? = null

    constructor(parcel: Parcel) : this() {
        id = parcel.readString()
        nombre = parcel.readString()
        tipo = parcel.readString()
        descripcion = parcel.readString()
        urlVideo = parcel.readString()
    }


    /*
    cosntructor primario con los atributos nombre y tipo, se crea una instancia con
    estos dos atributos
     */
    constructor(nombre: String?, tipo: String?) : this() {
        this.nombre = nombre
        this.tipo = tipo
    }

    /*
    constructor secundario con todos los atributos, permite crear una instancia
    con todos los atributos
     */
    constructor(id: String?, nombre: String?, tipo: String?, fechaAparicion: Date?, descripcion: String?, urlVideo: String?) : this() {
        this.id = id
        this.nombre = nombre
        this.tipo = tipo
        this.fechaAparicion = fechaAparicion
        this.descripcion = descripcion
        this.urlVideo = urlVideo
    }

    companion object CREATOR : Parcelable.Creator<Pokemon> {
        override fun createFromParcel(parcel: Parcel): Pokemon {
            return Pokemon(parcel)
        }

        override fun newArray(size: Int): Array<Pokemon?> {
            return arrayOfNulls(size)
        }
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(nombre)
        parcel.writeString(tipo)
        parcel.writeString(descripcion)
        parcel.writeString(urlVideo)
    }

    override fun describeContents(): Int {
        return 0
    }
}
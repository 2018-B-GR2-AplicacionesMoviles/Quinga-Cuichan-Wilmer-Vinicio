package com.example.viniq.examenpb

import android.os.Parcel
import android.os.Parcelable

class Disquera(
        var nombreDisquera: String,
        var nombreArtista: String,
        var generoMusica: String,
        var numeroTotalDiscos: String,
        var precioDiscos: String) : Parcelable {

    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString()
    ) {
    }


    override fun writeToParcel(parcel: Parcel, flags: Int) {

        parcel.writeString(nombreDisquera)
        parcel.writeString(nombreArtista)
        parcel.writeString(generoMusica)
        parcel.writeString(numeroTotalDiscos)
        parcel.writeString(precioDiscos)
    }

    override fun toString(): String {
        return "${nombreArtista}"

    }

    override fun describeContents(): Int {
        return 0;
    }

    companion object CREATOR : Parcelable.Creator<Disquera> {
        override fun createFromParcel(parcel: Parcel): Disquera {
            return Disquera(parcel)
        }

        override fun newArray(size: Int): Array<Disquera?> {
            return arrayOfNulls(size)

        }

    }
}


package com.syafei.belajarfundamentalaplikasiandroidrecylerview.myrecylerview.data

import android.os.Parcelable

@kotlinx.parcelize.Parcelize
data class Hero(
    var name: String,
    var description: String,
    var photo: String
) : Parcelable

package com.syafei.belajarfundamentalaplikasiandroidrecylerview.jsonparsing

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    val name: String,
    val username: String,
    val company: String,
    val avatar: String,
    val location: String,
    val repository: Int,
    val follower: Int,
    val following: Int
) : Parcelable
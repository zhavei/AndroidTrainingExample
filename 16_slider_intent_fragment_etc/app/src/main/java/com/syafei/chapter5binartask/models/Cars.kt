package com.syafei.chapter5binartask.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Cars(
    val merk: String?,
    val tipe: String?,
    val display: Int?
) : Parcelable

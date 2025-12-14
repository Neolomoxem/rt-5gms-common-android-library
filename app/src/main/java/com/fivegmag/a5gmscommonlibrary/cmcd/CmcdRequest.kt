package com.fivegmag.a5gmscommonlibrary.cmcd

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CmcdRequest(
    var cmcdConfigurations: ArrayList<CmcdConfiguration> = ArrayList()
) : Parcelable

@Parcelize
data class CmcdConfiguration(
    var cmcdType: CmcdType,
    var keys: ArrayList<String>? = null
) : Parcelable

enum class CmcdType {
    REQUEST,
    OBJECT,
    STATUS,
    SESSION
}

package com.trindade.oak.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class AppModel(
    val id: String,
    val dev_name: String,
    val dev_photo: String,
    val category: String,
    val name_app: String,
    val photo_app: String,
    val description: String,
    val app_comments: String,
    val download_link: String,
    val dev_id: String,
    val number_of_downloads: Int,
    val status: String,
    val tag: String
) : Parcelable
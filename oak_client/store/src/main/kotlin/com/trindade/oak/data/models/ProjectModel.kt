package com.trindade.oak.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ProjectModel(
    val project_id: String,
    val project_name_app: String,
    val project_photo_app: String,
    val project_description: String,
    val project_category: String,
    val project_comments: String,
    val project_status: String,
    val project_tag: String,
    val project_download_url: String,
    val project_download_count: Int,
    val project_dev_id: String,
    val project_dev_name: String,
    val project_dev_photo: String
) : Parcelize
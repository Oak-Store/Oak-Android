package com.trindade.oak.data

import com.trindade.oak.R

import com.trindade.oak.data.models.*

interface DataCallback {
    fun onDataReceived(response: List<ProjectModel>)
    fun onError(message: String)
}
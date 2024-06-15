package com.trindade.oak.data

import com.trindade.oak.R

import com.trindade.oak.data.models.AppModel

interface DataCallback {
    fun onDataReceived(response: List<AppModel>)
    fun onError(message: String)
}
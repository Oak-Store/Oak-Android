package com.trindade.oak.data

import android.app.Activity
import android.content.Context

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

import com.trindade.oak.R
import com.trindade.oak.data.models.AppModel
import com.trindade.oak.network.*

class DataRepository(private val context: Context) : RequestListener {

    private var callback: DataCallback? = null

    suspend fun getData(url: String, method: String, callback: DataCallback) {
        this.callback = callback
        
        withContext(Dispatchers.IO) {
            val requestNetwork = RequestNetwork(context)
        
            val headers = HashMap<String, String>()
            headers["Content-Type"] = "application/json"
            requestNetwork.headersSet(headers)
            requestNetwork.startRequestNetwork(method, url, "getAllApps", this@DataRepository)
        }
    }

    override fun onResponse(tag: String, response: String, responseHeader: HashMap<String, String>) {
        val gson = Gson()
        val type = object : TypeToken<List<AppModel>>() {}.type
        val apps: List<AppModel> = gson.fromJson(response, type)
        callback?.onDataReceived(apps)
    }

    override fun onErrorResponse(tag: String, response: String) {
        callback?.onError(response)
    }
}
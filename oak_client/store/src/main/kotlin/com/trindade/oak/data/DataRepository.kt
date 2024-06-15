package com.trindade.oak.data

import android.app.Activity
import android.content.Context

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

import com.trindade.oak.R
import com.trindade.oak.data.models.ProjectModel
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
        val type = object : TypeToken<List<ProjectModel>>() {}.type
        val apps: List<ProjectModel> = gson.fromJson(response, type)
        callback?.onProjectsReceive(apps)
    }

    override fun onErrorResponse(tag: String, response: String) {
        callback?.onError(response)
    }
}
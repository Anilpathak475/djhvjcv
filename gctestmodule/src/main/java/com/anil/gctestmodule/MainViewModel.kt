package com.anil.gctestmodule

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.switchMap
import kaufland.com.hydraapi.HydraApiClient
import kotlinx.coroutines.Dispatchers

class MainViewModel(private val mContext: Context) : ViewModel(), HydraApiClient.HydraServiceCallback {

    private val mHydraApiClient: HydraApiClient by lazy {
        HydraApiClient()
    }

    private val isApiClientConnected = MutableLiveData<Boolean>()
    val dwGroupDate by lazy {
        isApiClientConnected.switchMap {
            liveData(Dispatchers.IO) {
                mHydraApiClient.makeReady()
                val response = mHydraApiClient.findByType("DWGroup")
                emit(response)
            }
        }
    }

    init {
        mHydraApiClient.connectService(app = mContext.applicationContext as Application, callback = this)
    }

    override fun sessionExpired() {
        onServiceDied()
    }

    fun getGroupDetails() = mHydraApiClient.findByTypeAndItemType("TaskItem", "DWG01")
    fun getGroupItem(id:String) = mHydraApiClient.findById( id)


    override fun onServiceConnected() {
        Log.d("Service Status", "onServiceConnected")
        this.isApiClientConnected.postValue(true)
    }

    override fun onServiceDisconnected() {
        Log.d("Service Status", "onServiceDisconnected")
        onServiceDied()

    }

    override fun onServiceDied() {
        mHydraApiClient.connectService(app = mContext.applicationContext as Application, callback = this)
    }

    override fun onCleared() {
        super.onCleared()
        mHydraApiClient.disconnectService()
    }
}
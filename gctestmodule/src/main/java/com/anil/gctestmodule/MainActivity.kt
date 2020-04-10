package com.anil.gctestmodule

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kaufland.com.hydraapi.HydraApiClient
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), HydraApiClient.HydraServiceCallback {
    private val hydraApiClient by lazy { HydraApiClient() }
    private val TAG = "MainActivity"
    private val serverAppUri = "kaufland.com.hydraapi"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        hydraApiClient.connectService(application, this)
    }

    fun returnString()=""
    override fun sessionExpired() {
        Toast.makeText(this, "expired", Toast.LENGTH_SHORT).show()
    }

    override fun onServiceConnected() {
        Toast.makeText(this, "connecty", Toast.LENGTH_SHORT).show()
    }

    override fun onServiceDisconnected() {
        Toast.makeText(this, "Disconnect", Toast.LENGTH_SHORT).show()
    }

    override fun onServiceDied() {
        Toast.makeText(this, "onServiceDied", Toast.LENGTH_SHORT).show()
    }

    private fun init() {

        btn_tiernahrung.setOnClickListener {

        }
    }
}



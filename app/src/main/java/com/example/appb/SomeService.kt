package com.example.appb

import android.app.Service
import android.content.Intent
import android.os.IBinder

import android.util.Log
import com.example.someAidl.ISomeAidlInterface
import com.google.gson.Gson

class SomeService : Service() {

    private val binder = object: ISomeAidlInterface.Stub() {
        override fun getResponse(): String? {
            val json = Gson().toJson(Response("name","description"))
            Log.i("SomeService", "response: $json")
            return json
        }
    }

    override fun onBind(intent: Intent): IBinder {
        return binder
    }
}

data class Response(val name: String, val desc: String)

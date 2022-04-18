package com.example.bf_kotlin_client.utils

import android.content.Context
import android.widget.Toast
import com.android.volley.VolleyError
import com.android.volley.toolbox.*
import com.example.hakaton.dtos.ServerError
import com.google.gson.Gson

class HttpWorker(private var applicationContext: Context) {
    private var volleyQueue = Volley.newRequestQueue(applicationContext)

    private fun defaultErrorFunction(volleyError: VolleyError) {

        if (volleyError.networkResponse == null) {
            Toast.makeText(applicationContext, volleyError.message, Toast.LENGTH_LONG).show()
            return
        }

        var httpCode = volleyError.networkResponse.statusCode

        var dataInJson = volleyError.networkResponse.data.toString(Charsets.UTF_8)

        var data = Gson().fromJson(dataInJson, ServerError::class.java)

        var errorMessage = "$httpCode: ${data.message}"

        Toast.makeText(applicationContext, errorMessage, Toast.LENGTH_LONG).show()
    }

    fun makeStringRequestWithoutBody(
        httpMethod: Int,
        url: String,
        successCallbackFunction: (String) -> Unit,
        httpHeaders: MutableMap<String, String> = hashMapOf(),
        errorCallbackFunction: (VolleyError) -> Unit = ::defaultErrorFunction
    ) {
        var request = object : StringRequest(
            httpMethod,
            url,
            successCallbackFunction,
            errorCallbackFunction
        ) {
            override fun getHeaders(): MutableMap<String, String> {
                return httpHeaders
            }
        }

        volleyQueue.add(request)
    }

    fun makeStringRequestWithBody(
        httpMethod: Int,
        url: String,
        successCallbackFunction: (String) -> Unit,
        body: String,
        httpHeaders: MutableMap<String, String> = hashMapOf(),
        errorCallbackFunction: (VolleyError) -> Unit = ::defaultErrorFunction
    ) {
        var request = object : StringRequest(
            httpMethod,
            url,
            successCallbackFunction,
            errorCallbackFunction
        ) {
            override fun getBodyContentType(): String {
                return "application/json; charset=utf-8"
            }

            override fun getBody(): ByteArray {
                return body.toByteArray()
            }

            override fun getHeaders(): MutableMap<String, String> {
                return httpHeaders
            }

        }
        volleyQueue.add(request)
    }
}
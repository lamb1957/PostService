package com.example.postservice

import android.os.AsyncTask
import android.util.Log
import java.io.*
import java.net.HttpURLConnection
import java.net.URL
import java.net.MalformedURLException
import kotlin.properties.Delegates

class AsyncHttp: AsyncTask<String,Int, Boolean> {
    var urlConnection : HttpURLConnection by Delegates.notNull<HttpURLConnection>()
    var flg: Boolean = false

    var name: String = ""
    var value: Double = 0.0

    constructor(name: String, value: Double) {
        this.name = name
        this.value= value
    }

    override fun doInBackground(vararg content: String?): Boolean {
        var urlinput: String = "http://10.206.0.103/upload/post.php"
        try {
            var url: URL = URL(urlinput)
            urlConnection = url.openConnection() as HttpURLConnection
            urlConnection.requestMethod = "POST"
            urlConnection.doOutput = true

            var postDataSample: String = "name=" + name + "&text=" + value
            var out: OutputStream = urlConnection.outputStream
            out.write(postDataSample.toByteArray())
            out.flush()
            out.close()
            Log.d("test", postDataSample)
            urlConnection.inputStream
            flg = true
        }catch (e: MalformedURLException){
            e.printStackTrace()
        }catch (e: IOException){
            e.printStackTrace()
        }
        return flg
    }

}
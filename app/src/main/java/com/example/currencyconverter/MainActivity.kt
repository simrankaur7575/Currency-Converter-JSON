package com.example.currencyconverter

import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    inner class Download : AsyncTask<String, Void, String>(){

        override fun doInBackground(vararg p0: String?): String {

            var result = ""
            var url : URL
            val httpURLConnection : HttpURLConnection

            try {

                url = URL(p0[0])
                httpURLConnection = url.openConnection() as HttpURLConnection
                val inputStream = httpURLConnection.inputStream
                val inputStreamReader = InputStreamReader(inputStream)

                var data = inputStreamReader.read()

                while (data > 0) {
                    val character = data.toChar()
                    result += character

                    data = inputStreamReader.read()
                }


                return result

            } catch (e: Exception) {
                e.printStackTrace()
                return result
            }



        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)



        }
    }

}

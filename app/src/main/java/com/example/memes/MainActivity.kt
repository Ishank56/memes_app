package com.example.memes

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestListener

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadMeme()
    }
    private fun loadMeme(){
        val progessBar=findViewById<ProgressBar>(R.id.progressBar)
        progessBar.visibility=View.VISIBLE
// ...

// Instantiate the RequestQueue.
        val queue = Volley.newRequestQueue(this)
        val url = "https://meme-api.herokuapp.com/gimme"
        val meme=findViewById<ImageView>(R.id.memeImage)

// Request a string response from the provided URL.
        val jsonObjectRequest= JsonObjectRequest(
            Request.Method.GET,url, null,
            Response.Listener { response ->
                val url=response.getString("url")
                 Glide.with(this).load(url).listener(object :RequestListener<Drawables>).into(meme)                     },
            Response.ErrorListener {

            })
// Add the request to the RequestQueue.
        queue.add(jsonObjectRequest)
    }

    fun sharememe(view: View) {


    }
    fun nextmeme(view: View) {
        loadMeme()

    }
}
package com.example.myuccfinalprojectapplication

import android.app.Activity
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebResourceError
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.Toast
import androidx.annotation.RequiresApi

class Social2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_social2)

        val web2: WebView = findViewById(R.id.wvMedia)
        web2.webViewClient = CustomWebViewClient2(this)
        web2.loadUrl("https://m.facebook.com/381496945527257/")

        val web2Settings = web2.settings
        web2Settings.javaScriptEnabled = true

        val mbtn: Button = findViewById(R.id.mbtn)
        mbtn.setOnClickListener {
            val intent = Intent(this, Media::class.java)
            startActivity(intent)
        }

    }
}
//Allows external website to load within WebView element
class CustomWebViewClient2 internal constructor(private val activity: Activity) :
    WebViewClient() {
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun shouldOverrideUrlLoading(
        view: WebView?,
        request: WebResourceRequest?
    ): Boolean {
        val url: String = request?.url.toString()
        view?.loadUrl(url)
        return true
    }
    override fun shouldOverrideUrlLoading(webView: WebView, url: String): Boolean {
        webView.loadUrl(url)
        return true
    }
    override fun onReceivedError(
        view: WebView,
        request: WebResourceRequest,
        error: WebResourceError
    ) {
        Toast.makeText(activity, "Error! $error", Toast.LENGTH_SHORT).show()
    }
}
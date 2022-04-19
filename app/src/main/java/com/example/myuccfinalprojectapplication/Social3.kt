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

class Social3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_social3)

        val web3: WebView = findViewById(R.id.wvSocialMedia)
        web3.webViewClient = CustomWebViewClient3(this)
        web3.loadUrl("https://twitter.com/uccjamaica")

        val webSettings3 = web3.settings
        webSettings3.javaScriptEnabled = true

        val smbtn: Button = findViewById(R.id.smbtn)
        smbtn.setOnClickListener {
            val intent = Intent(this, Media::class.java)
            startActivity(intent)
         }
    }
}
//Allows external website to load within WebView element
class CustomWebViewClient3 internal constructor(private val activity: Activity) :
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
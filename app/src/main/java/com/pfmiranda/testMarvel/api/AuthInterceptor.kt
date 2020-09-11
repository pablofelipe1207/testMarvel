package com.pfmiranda.testMarvel.api

import okhttp3.Interceptor
import okhttp3.Response
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
import java.util.*

class AuthInterceptor() : Interceptor {

    companion object{
        const val PRIV_KEY = "30ff95d69effc6aa5893b6f6bbc59442c7ad36bb"
        const val PUBLIC_KEY = "bbf4efc95797c41589b33f7bdc7ea146"
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        val ts = Date().getTime().toString()
        val hash = md5(ts+PRIV_KEY+PUBLIC_KEY)

        var req = chain.request()
        val url =
            req.url().newBuilder().addQueryParameter("hash", hash).addQueryParameter("ts", ts).addQueryParameter("apikey", PUBLIC_KEY)
            .build()
        req = req.newBuilder().url(url).build()
        return chain.proceed(req)
    }

    fun md5(s: String): String? {
        val MD5 = "MD5"
        try {
            // Create MD5 Hash
            val digest = MessageDigest
                .getInstance(MD5)
            digest.update(s.toByteArray())
            val messageDigest = digest.digest()

            // Create Hex String
            val hexString = StringBuilder()
            for (aMessageDigest in messageDigest) {
                var h = Integer.toHexString(0xFF and aMessageDigest.toInt())
                while (h.length < 2) h = "0$h"
                hexString.append(h)
            }
            return hexString.toString()
        } catch (e: NoSuchAlgorithmException) {
            e.printStackTrace()
        }
        return ""
    }


}
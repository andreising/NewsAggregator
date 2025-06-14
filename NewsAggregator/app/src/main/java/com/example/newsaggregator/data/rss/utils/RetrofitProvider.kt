package com.example.newsaggregator.data.rss.utils

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import nl.adaptivity.xmlutil.serialization.XML
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

object RetrofitProvider {
    const val BASE_URL = "https://www.theguardian.com"

    fun getRetrofitInstance() = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(
            XML.asConverterFactory(
                "application/xml; charset=UTF8".toMediaType()
            )
        ).build()
}
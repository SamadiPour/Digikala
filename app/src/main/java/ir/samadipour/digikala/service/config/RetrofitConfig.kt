package ir.samadipour.digikala.service.config

import com.facebook.common.internal.ImmutableMap
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitConfig {
    val headers: MutableMap<String, String> = ImmutableMap.of(
        "ApplicationType",
        "AppAndroid",
        "ApplicationVersion",
        "1.9.6-CB",
        "Mobile-Agent",
        "MobileApp/Android/v-47/503eaa6d3af99023"
    )

    private const val url = "https://service2.digikala.com/"

    fun serviceRetrofit(): Retrofit {
        val logger = HttpLoggingInterceptor()
        logger.level = HttpLoggingInterceptor.Level.BASIC

        val okHttpClient = OkHttpClient.Builder()
            .readTimeout(20, TimeUnit.SECONDS)
            .writeTimeout(20, TimeUnit.SECONDS)
            .addInterceptor(logger)

            .build()

        return Retrofit
            .Builder()
            .baseUrl(url)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}
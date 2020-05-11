package les.kasa.android.restclientsample.di

import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import les.kasa.android.restclientsample.BuildConfig
import les.kasa.android.restclientsample.MainViewModel
import les.kasa.android.restclientsample.repository.LogRepository
import les.kasa.android.restclientsample.service.LogApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

const val API_URL = BuildConfig.API_BASE_URL

// ViewModel
val viewModelModule = module {
    viewModel { MainViewModel(get(), androidApplication()) }
}

// Repository
val repositoryModule = module {
    single { LogRepository(get()) }
}

val networkModule = module {
    factory { provideGson() }
    factory { provideOkHttpClient() }
    factory { provideLogApi(get()) }
    single { provideRetrofit(get(), get()) }
}

fun provideGson(): Gson {
    return GsonBuilder()
        .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
        .create()
}

fun provideRetrofit(okHttpClient: OkHttpClient, gson: Gson): Retrofit {
    return Retrofit.Builder().baseUrl(API_URL)
        .client(okHttpClient)
        .addConverterFactory(ScalarsConverterFactory.create())
        .addConverterFactory(
            GsonConverterFactory.create(gson)
        )
        .build()
}

fun provideOkHttpClient(): OkHttpClient {
    return OkHttpClient().newBuilder()
        .addInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        })
        .build()
}

fun provideLogApi(retrofit: Retrofit): LogApiService =
    retrofit.create(LogApiService::class.java)


// モジュール群
val appModules = listOf(viewModelModule, repositoryModule, networkModule)

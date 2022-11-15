package nexlsoft.loginsample.di

import android.content.Context
import com.google.gson.Gson
import nexlsoft.loginsample.repository.remote.ApiService
import nexlsoft.loginsample.repository.remote.RemoteImpl
import nexlsoft.loginsample.repository.remote.RemoteSource
import nexlsoft.loginsample.ui.categories.CategoriesViewModel
import nexlsoft.loginsample.ui.login.LoginViewModel
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val apiModule = module {
    single { provideApiService(retrofit = get(named("Retrofit"))) }
}

internal fun provideApiService(retrofit: Retrofit): ApiService =
    retrofit.create(ApiService::class.java)

val repositoryModule = module {
    single<RemoteSource> { RemoteImpl(get()) }
}


val viewModelModule = module {
    viewModel { CategoriesViewModel(get()) }
    viewModel { LoginViewModel(get()) }
}

val serviceModule = module {
    single { createRetrofit(get(), get()) }
    single { buildOKHttpClient(androidContext(), get()) }
    single { buildGSON() }
}

private fun createRetrofit(gson: Gson, okHttpClient: OkHttpClient): ApiService {
    return Retrofit.Builder()
        .baseUrl("")
        .addConverterFactory(GsonConverterFactory.create(gson))
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .client(okHttpClient)
        .build()
        .create(ApiService::class.java)
}

private fun buildOKHttpClient(context: Context, interceptor: Interceptor): OkHttpClient {
    return OkHttpClient.Builder().apply {
        cache(Cache(context.applicationContext.cacheDir, 10 * 1024 * 1024))
        addInterceptor(interceptor)
        readTimeout(15L, TimeUnit.SECONDS)
        connectTimeout(15L, TimeUnit.SECONDS)
        callTimeout(15L, TimeUnit.SECONDS)
    }.build()
}

private fun buildGSON(): Gson = Gson()

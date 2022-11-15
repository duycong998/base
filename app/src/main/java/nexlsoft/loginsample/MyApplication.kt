package nexlsoft.loginsample

import android.app.Application
import android.util.Log
import io.reactivex.rxjava3.plugins.RxJavaPlugins
import nexlsoft.loginsample.di.repositoryModule
import nexlsoft.loginsample.di.serviceModule
import nexlsoft.loginsample.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        RxJavaPlugins.setErrorHandler { Log.d("##### rxError: ", it.message.toString()) }
        startKoin {
            androidContext(this@MyApplication)
            modules(viewModelModule, repositoryModule, serviceModule)
            printLogger(Level.DEBUG)
        }
    }
}

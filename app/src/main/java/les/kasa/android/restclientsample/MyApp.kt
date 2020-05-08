package les.kasa.android.restclientsample

import android.app.Application
import les.kasa.android.restclientsample.di.appModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.EmptyLogger
import org.koin.core.logger.Level

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            if (BuildConfig.DEBUG) androidLogger(Level.DEBUG) else EmptyLogger()
            androidContext(this@MyApp)
            modules(appModules)
        }
    }
}
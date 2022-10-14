package apps.cz200dev.technictestapp.application

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class TechnicTestApp : Application() {
    override fun onCreate() {
        super.onCreate()
        Timber.plant()
    }
}
package ir.samadipour.digikala.service.config

import android.app.Application
import androidx.lifecycle.ViewModelProvider
import com.facebook.drawee.backends.pipeline.Fresco
import com.facebook.imagepipeline.core.ImagePipelineConfig
import ir.samadipour.digikala.service.utils.InjectUtils
import ir.samadipour.digikala.viewmodel.CategoryViewModel

class MainActivity : Application() {
    override fun onCreate() {
        super.onCreate()
        val config = ImagePipelineConfig.newBuilder(this)
            .setDownsampleEnabled(true)
            .setDiskCacheEnabled(true)
            .build()
        Fresco.initialize(this, config)
    }
}
package com.yitools.rili

import androidx.multidex.MultiDexApplication
import com.simplemobiletools.commons.extensions.checkUseEnglish

class App : MultiDexApplication() {
    override fun onCreate() {
        super.onCreate()
        checkUseEnglish()
    }
}

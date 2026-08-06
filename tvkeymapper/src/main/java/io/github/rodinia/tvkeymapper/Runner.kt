package io.github.rodinia.tvkeymapper

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.provider.Settings

import android.util.Log

class Runner(private val context: Context) {
    fun run(packageName: String, link: String) {

        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        intent.setPackage(packageName)
        context.startActivity(intent)
    }
    fun runPackage(packageName: String) {

        val intent = context.packageManager
        .getLaunchIntentForPackage(packageName)

        if (intent != null) {
            Log.d(TAG, "Launching $packageName")
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(intent)
        } else {
            Log.e(TAG, "No launch intent for $packageName")
        }
    }

    fun runSettings() {
        val intent = Intent(Settings.ACTION_SETTINGS)
        context.startActivity(intent)
    }
}

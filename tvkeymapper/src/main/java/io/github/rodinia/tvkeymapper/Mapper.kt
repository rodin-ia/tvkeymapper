package io.github.rodinia.tvkeymapper

import android.accessibilityservice.AccessibilityService
import android.util.Log
import android.view.KeyEvent
import android.view.accessibility.AccessibilityEvent

const val KEY_FILMIX = KeyEvent.KEYCODE_STEM_1 //NETFLIX key
const val KEY_SMARTTUBE = KeyEvent.KEYCODE_TV_INPUT_COMPOSITE_1 //youtube key 
const val KEY_OTTP = 198 // Okko key code

const val TAG = "mapper"

class Mapper : AccessibilityService() {
    private val keyMappings = mapOf(
        KEY_FILMIX to "net.filmix.filmix",
        KEY_SMARTTUBE to "org.smarttube.stable",
        KEY_OTTP to "es.ottplayer.tv"
   )

    override fun onAccessibilityEvent(event: AccessibilityEvent?) {
        return
    }

    override fun onKeyEvent(event: KeyEvent?): Boolean {
        if (event == null) {
            return false
        }

        Log.v(
            TAG,
            "key=${KeyEvent.keyCodeToString(event.keyCode)} " +
                "code=${event.keyCode} " +
                "scan=${event.scanCode} " +
                "action=${event.action}"
        )
        val packageName = keyMappings[event.keyCode]
        if (packageName != null) {
            if (event.action == KeyEvent.ACTION_DOWN) {
                Runner(this).runPackage(packageName)
            }
            return true
        }
        return super.onKeyEvent(event)
    }

    override fun onInterrupt() {
        return
    }
}




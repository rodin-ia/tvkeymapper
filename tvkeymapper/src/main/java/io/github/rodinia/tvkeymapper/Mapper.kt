package io.github.rodinia.tvkeymapper

import android.accessibilityservice.AccessibilityService
import android.util.Log
import android.view.KeyEvent
import android.view.accessibility.AccessibilityEvent

const val KEY_FILMIX = KeyEvent.KEYCODE_STEM_1
const val KEY_SMARTTUBE = KeyEvent.KEYCODE_TV_INPUT_COMPOSITE_1
const val KEY_OTTP = 198

const val TAG = "mapper"

class Mapper : AccessibilityService() {
    override fun onAccessibilityEvent(event: AccessibilityEvent?) {
        return
    }

    override fun onKeyEvent(event: KeyEvent?): Boolean {
        if (event == null) {
            return false
        }

        Log.v(
            TAG,
            "key=${KeyEvent.keyCodeToString(event.keyCode)} code=${event.keyCode} scan=${event.scanCode} action=${event.action}"
        )
        when (event.keyCode) {

            KEY_FILMIX -> {
                if (event.action == KeyEvent.ACTION_DOWN) {
                    Runner(this).runPackage("net.filmix.filmix")
                }
                return true
            }

            KEY_SMARTTUBE -> {
                if (event.action == KeyEvent.ACTION_DOWN) {
                    Runner(this).runPackage("org.smarttube.stable")
                }
                return true
            }

            KEY_OTTP -> {
                if (event.action == KeyEvent.ACTION_DOWN) {
                    Runner(this).runPackage("es.ottplayer.tv")
                }
                return true
            }
        }

        return super.onKeyEvent(event)
    }

    override fun onInterrupt() {
        return
    }
}




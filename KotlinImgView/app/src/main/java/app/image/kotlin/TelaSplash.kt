package app.image.kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.Window

class TelaSplash : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.requestFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_tela_splash)

        Handler().postDelayed({
            startActivity(Intent(this@TelaSplash, MainActivity::class.java))
            finish()
        }, 3000)
    }
}
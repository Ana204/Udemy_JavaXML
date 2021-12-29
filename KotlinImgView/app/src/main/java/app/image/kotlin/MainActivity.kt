package app.image.kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageLogo = findViewById<ImageView>(R.id.imageLogo)

        val drawableID = R.drawable.kotlin_icon

        var compararID = drawableID;

        imageLogo.setImageResource(drawableID)

        val buttonClique = findViewById<Button>(R.id.buttonClique)

        buttonClique?.setOnClickListener {

            compararID =
                if (compararID == R.drawable.java_logo)
                    R.drawable.kotlin_icon
                else R.drawable.java_logo

            imageLogo.setImageResource(compararID)
        }
    }
}
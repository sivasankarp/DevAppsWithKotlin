package com.teckudos.devappswithkotlin.basic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import com.teckudos.devappswithkotlin.R
import kotlin.random.Random

// xml and activity linked through a process called layout inflammation it triggers when activity
// starts. During Layout Inflammation the view defined in xml files are turned or inflated in to
// kotlin view object. activity can then draw this onscreen and also dynamically modify them.
// Activity extends AppCompatActivity which is subclass of android that gives us access to
// modern android features while providing backward compatibility with older version of android
// Activity do not use constructor for their setup instead series of predefined method are called
// as part of setup one for eg is onCreate() method.
// Context Object allows us to communicate with and get information about current state of android
// operating system. Activity is a subclass of Context so we can use this for context required in
// Toast eg Toast.makeText(this, "button clicked", Toast.LENGTH_SHORT).show()

class MainActivity : AppCompatActivity() {

    lateinit var diceImage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.text = "Let's Roll"
        rollButton.setOnClickListener {
            rollDice()
        }
        diceImage = findViewById(R.id.dice_image)
    }

    private fun rollDice() {
        val drawableResource = when (Random.nextInt(6) + 1) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage.setImageResource(drawableResource)
    }
}

// Gradle is the build tool for android Gradle Android Build Tool
//- what device run your app
//- compile to executable
//- dependency management
//- signing app to play store
//- automated tests
// when we click on run a series of gradle command compile your source code through dependency and
// any associated resource into a android application package(.apk) - resource, compiled code,
// android manifest, others APK file executable format for distributing android applications.
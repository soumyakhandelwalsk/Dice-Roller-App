package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

/**
* This activity allows the user to roll a pair of dice and view the result
* on the screen.
*/
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }
        // so that the screen is not empty when the app is started
        rollDice()
    }
    /**
     * Roll the pair of dice and update the screen with the result.
     */
    private fun rollDice() {
        val dice = Dice(6)
        val diceRoll = dice.roll()
        val diceImage : ImageView = findViewById(R.id.imageView)
        // Choose which dice image to display
        when (diceRoll){
            1 -> diceImage.setImageResource(R.drawable.dice_1)
            2 -> diceImage.setImageResource(R.drawable.dice_2)
            3 -> diceImage.setImageResource(R.drawable.dice_3)
            4 -> diceImage.setImageResource(R.drawable.dice_4)
            5 -> diceImage.setImageResource(R.drawable.dice_5)
            6 -> diceImage.setImageResource(R.drawable.dice_6)
        }
        // so that the content description contains the number that was rolled
        diceImage.contentDescription = diceRoll.toString()
    }
}

/**
 * This class contains the properties and functions of a dice.
 */
class Dice(private val numSides: Int) {
    /**
     * Returns a random number between 1 and the number of sides of the dice (inclusive)
     */
    fun roll(): Int {
        return (1..numSides).random()
    }
}
package student.rvc.edu.randomguess

import android.content.Context
import android.os.Bundle
import android.renderscript.ScriptGroup
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Get random number 1-100000
        var number = ((Math.random() * 100001) + 1) .toInt()
        //Get random number 0-100000
        //var number = (Math.random() * 100001) .toInt()
        //Toast is an easy way to alert user.  Shows up at bottom of app
        Toast.makeText(this, "Number to remember: ${number}", Toast.LENGTH_LONG) .show()
        val txtGuess = findViewById<EditText>(R.id.txtGuess)
        val btnGuess = findViewById<Button>(R.id.btnGuess)
        val btnToast = findViewById<Button>(R.id.btnToast)
        btnGuess.setOnClickListener {
            if (number == txtGuess.text.toString(). toInt())
            {
                hideKeyboard()
                Toast.makeText(this, "Correct, great job remembering.", Toast.LENGTH_LONG) .show()
                txtGuess.setText("")
            }
            else {
                hideKeyboard()
                Toast.makeText(this, "Incorrect, it's not the number shown.", Toast.LENGTH_LONG) .show()
                txtGuess.setText("")
            }
        }
        btnToast.setOnClickListener {
            hideKeyboard()
            number = ((Math.random() * 100001) + 1) .toInt()
            println(number)
            Toast.makeText(this, "Number to remember: ${number}", Toast.LENGTH_LONG) .show()
        }
        //Fire hideKeyboard when user taps outside any text object
        //Place below code right before last right bracket in function onCreate
        findViewById<View>(android.R.id.content).setOnTouchListener { _, event ->
            hideKeyboard()
            false
        }
    }
    fun hideKeyboard() {
        try {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
        }
        catch (e: Exception) {
            //TODO: handle exception
        }
    }
}
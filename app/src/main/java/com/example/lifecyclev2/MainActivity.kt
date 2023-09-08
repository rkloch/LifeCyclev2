package com.example.lifecyclev2

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var userHashMap : HashMap<String, String> = HashMap()



    @SuppressLint("WrongViewCast", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        userHashMap.put("hej@hej.com", "hej")
        userHashMap.put("h@h.com", "h")

        val submitBtn = findViewById<Button>(R.id.submitLogin)
        submitBtn.setOnClickListener(){
            val email = findViewById(R.id.userEmail) as TextView
            val password = findViewById(R.id.userPassword) as TextView
            Log.d("submit", "username:" + email.text)
            Log.d("submit", "password:" + password.text)

            if(userHashMap.containsKey(email.text.toString())) {
                if (userHashMap[email.text.toString()] == password.text.toString()) {
                    Log.d("submit", "success")
                    val intent = Intent(this, UserActivity::class.java)
                    intent.putExtra("user", email.text.toString())
                    startActivity(intent)
                }
                else {
                    var feedbackSumbit = findViewById(R.id.submitFeedback) as TextView
                    feedbackSumbit.text = "Wrong password"
                }
            } else {
                var feedbackSumbit = findViewById(R.id.submitFeedback) as TextView
                feedbackSumbit.text = "Can't find user"
            }


        }

    }
}
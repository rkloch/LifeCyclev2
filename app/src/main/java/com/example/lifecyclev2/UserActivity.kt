package com.example.lifecyclev2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager

class UserActivity : AppCompatActivity() {
    var user = ""
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)
        val b: Bundle? = intent.extras
        user = b?.getString("user").toString()
        val userInfoBtn = findViewById<Button>(R.id.userInfoBtn)
        val userExtraInfo = findViewById<Button>(R.id.userExtraInfoBtn)
        val logoutBtn = findViewById<Button>(R.id.logoutButton)
        val fm: FragmentManager = supportFragmentManager
        val fragment = UserForm()
        fm.beginTransaction().replace(R.id.fragmentContainerView, fragment).commit()


        userInfoBtn.setOnClickListener() {
            val fragment = UserForm()
            fm.beginTransaction().replace(R.id.fragmentContainerView, fragment).commit()

        }
        userExtraInfo.setOnClickListener() {
            val fragment = UserDetailsForm()
            fm.beginTransaction().replace(R.id.fragmentContainerView, fragment).commit()

        }
        logoutBtn.setOnClickListener() {
            val intent = Intent(this, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP)
            startActivity(intent)
        }
    }

}
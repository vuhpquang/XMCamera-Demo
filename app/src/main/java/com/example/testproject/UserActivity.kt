package com.example.testproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_user.*

class UserActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        btn_register.setOnClickListener(this)
        btn_login.setOnClickListener(this)
        btn_modify.setOnClickListener(this)
        btn_forgot.setOnClickListener(this)
        btn_info.setOnClickListener(this)
        btn_save.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.btn_register -> {
                var intent = Intent(this, RegisterActivity::class.java)
                startActivity(intent)
            }
            R.id.btn_login -> {
                var intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
            }
            R.id.btn_modify -> {
                var intent = Intent(this, RegisterActivity::class.java)
                startActivity(intent)
            }
            R.id.btn_forgot -> {
                var intent = Intent(this, ForgotActivity::class.java)
                startActivity(intent)
            }
            R.id.btn_info -> {
                var intent = Intent(this, UserInfoActivity::class.java)
                startActivity(intent)
            }
            R.id.btn_save -> {
                var intent = Intent(this, RegisterActivity::class.java)
                startActivity(intent)
            }

        }
    }
}
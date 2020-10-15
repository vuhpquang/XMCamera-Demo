package com.example.testproject

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_device.*

class DeviceActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_device)

        btn_users.setOnClickListener(this)
        btn_add.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_add -> {
                startActivity(Intent(this, AddByUserActivity::class.java))
            }
            R.id.btn_users -> {
                var intent = Intent(this, DeviceListUsersActivity::class.java)
                startActivity(intent)
            }
        }
    }
}
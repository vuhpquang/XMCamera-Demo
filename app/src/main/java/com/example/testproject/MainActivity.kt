package com.example.testproject

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.testproject.camera.ScanQrActivity
import com.lib.funsdk.support.FunSupport
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_user.setOnClickListener(this)
        btn_device.setOnClickListener(this)
        btn_media.setOnClickListener(this)
        btn_play_url.setOnClickListener(this)
        btn_qr_test.setOnClickListener(this)

        if (!FunSupport.getInstance().hasLogin()
        ) {
//            startActivity(Intent(this, LoginActivity::class.java))
            if (!FunSupport.getInstance().login("quangvupp321", "haphungquangvu")) {
                Toast.makeText(this, R.string.guide_message_error_call, Toast.LENGTH_SHORT).show()
            }
//            startActivity(Intent(this, MultiScreenActivity2::class.java))
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_user -> {
                var intent = Intent(this, UserActivity::class.java)
                var context: Context = this
                context.resources.getString(R.string.app_name)
                startActivity(intent)
            }
            R.id.btn_device -> {
                var intent = Intent(this, DeviceActivity::class.java)
                startActivity(intent)
            }
            R.id.btn_media -> {
                var intent = Intent(this, MediaActivity::class.java)
                startActivity(intent)
            }
            R.id.btn_play_url -> {
                var intent = Intent(this, PlayUrlActivity::class.java)
                startActivity(intent)
            }
            R.id.btn_qr_test -> {
                startActivity(Intent(this, ScanQrActivity::class.java))
            }
        }
    }


}
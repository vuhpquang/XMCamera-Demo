package com.example.testproject

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.common.DialogSavedUsers
import com.example.common.UIFactory
import com.lib.funsdk.support.FunError
import com.lib.funsdk.support.FunSupport
import com.lib.funsdk.support.OnFunLoginListener
import com.lib.funsdk.support.models.FunLoginType
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), View.OnClickListener, OnFunLoginListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btn_login.setOnClickListener(this)
        btn_register.setOnClickListener(this)
        btn_forgot.setOnClickListener(this)
        btnLoginHistory.setOnClickListener(this)

        cb_savepass.isSelected = FunSupport.getInstance().savePasswordAfterLogin
        cb_auto.isSelected = FunSupport.getInstance().autoLogin

        UIFactory.setLeftDrawable(
            this, cb_savepass,
            R.drawable.icon_check, 24, 24
        )
        UIFactory.setLeftDrawable(
            this, cb_auto,
            R.drawable.icon_check, 24, 24
        )

        cb_savepass.setOnClickListener(this)
        cb_auto.setOnClickListener(this)

        cb_savepass.isSelected = FunSupport.getInstance().savePasswordAfterLogin
        cb_auto.isSelected = FunSupport.getInstance().autoLogin

        edt_username.setText(FunSupport.getInstance().savedUserName)
        edt_password.setText(FunSupport.getInstance().savedPassword)

        edt_username.setText("quangvupp321")
        edt_password.setText("haphungquangvu")

        FunSupport.getInstance().loginType = FunLoginType.LOGIN_BY_INTENTT
        FunSupport.getInstance().registerOnFunLoginListener(this)
        tryToLogin(edt_username.text.toString(), edt_password.text.toString())
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_login -> {
                tryToLogin(edt_username.text.toString(), edt_password.text.toString())
            }
            R.id.btn_register -> {
                var intent = Intent(this, RegisterActivity::class.java)
                startActivity(intent)
            }
            R.id.btn_forgot -> {
                var intent = Intent(this, ForgotActivity::class.java)
                startActivity(intent)
            }
            R.id.cb_savepass -> {
                if (cb_savepass.isSelected) {
                    cb_savepass.isSelected = false
                    FunSupport.getInstance().savePasswordAfterLogin = false
                } else {
                    cb_savepass.isSelected = true
                    FunSupport.getInstance().savePasswordAfterLogin = true
                }
            }
            R.id.cb_auto -> {
                if (cb_auto.isSelected) {
                    cb_auto.isSelected = false
                    FunSupport.getInstance().autoLogin = false
                } else {
                    cb_auto.isSelected = true
                    FunSupport.getInstance().autoLogin = true
                }
            }
            R.id.btnLoginHistory -> {
                showLoginHistory()
            }
        }
    }

    private fun showLoginHistory() {
        val dialog = DialogSavedUsers(
            this,
            FunSupport.getInstance().savedUserNames
        ) { userName ->
            val passWord = FunSupport.getInstance().getSavedPassword(userName)
            if (null != passWord && null != edt_username && null != edt_password) {
                edt_username.setText(userName)
                edt_password.setText(passWord)
                btn_login.requestFocus()
            }
        }
        dialog.show()
    }

    private fun tryToLogin(userName: String, passWord: String) {
        if (userName.isEmpty() || passWord.isEmpty()) {
            edt_username.error = "Empty username"
            edt_password.error = "Empty password"
            return
        }
        if (!FunSupport.getInstance().login(userName, passWord)) {
            Toast.makeText(this, R.string.guide_message_error_call, Toast.LENGTH_SHORT).show()
        }
    }

    override fun onLoginSuccess() {
        Toast.makeText(this, R.string.user_register_login_success, Toast.LENGTH_SHORT).show()

//        goToDeviceList()
        goToMainMenu()
    }

    private fun goToMainMenu() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    private fun goToDeviceList() {
        val intent = Intent(this, DeviceListUsersActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun onLoginFailed(errCode: Int?) {
        Toast.makeText(this, "Login Failed" + FunError.getErrorStr(errCode), Toast.LENGTH_SHORT)
            .show()
    }

    override fun onLogout() {

    }

    override fun onDestroy() {

        FunSupport.getInstance().removeOnFunLoginListener(this)
        super.onDestroy()
    }
}
package com.example.testproject

import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import com.lib.funsdk.support.FunError
import com.lib.funsdk.support.FunSupport
import com.lib.funsdk.support.OnFunRegisterListener
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : ActivityDemo(), OnClickListener, OnFunRegisterListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        btnGetVerifyCode.setOnClickListener(this)
        userRegisterBtn.setOnClickListener(this)
        btnUserNameRepeat.setOnClickListener(this)


        // 注册监听(用户注册相关)
        FunSupport.getInstance().registerOnFunRegisterListener(this)
    }

    override fun onDestroy() {
        FunSupport.getInstance().removeOnFunRegisterListener(this)
        super.onDestroy()
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.userRegisterBtn -> {

                // 快速注册
                tryToRegister()
            }
            R.id.btnGetVerifyCode -> {

                // 获取验证码
                tryGetVerifyCode()
            }
            R.id.btnUserNameRepeat ->            //check username repeat
                checkUsername()
        }
    }

    private fun checkUsername() {
        val userName: String = userRegisterUserName.text.toString()
        if (userName.isNotEmpty()) {
            FunSupport.getInstance().checkUserName(userName)
        }
    }

    private fun tryGetVerifyCode() {
        val userName: String = userRegisterUserName.text.toString()
        val emailStr: String = userRegisterEmail.text.toString().trim { it <= ' ' }

        if (userName.isEmpty()) {
            // 用户名为空
            showToast(R.string.user_login_error_emptyusername)
            return
        }

        if (!isEmailValid(emailStr)) {
            // 邮箱不正确
            showToast(R.string.user_login_error_email)
            return
        }

        if (!FunSupport.getInstance().requestEmailCode(emailStr)) {
            showToast(R.string.guide_message_error_call)
        }
    }

    private fun tryToRegister() {
        val userName: String = userRegisterUserName.text.toString()
        val passWord: String = userRegisterPasswd.text.toString()
        val passWordConfirm: String = userRegisterPasswdConfirm.text.toString()

        if (userName.isEmpty()) {
            // 用户名为空
            showToast(R.string.user_login_error_emptyusername)
            return
        }

        if (passWord.isEmpty()) {
            // 密码为空
            showToast(R.string.user_login_error_emptypassword)
            return
        }

        if (passWord != passWordConfirm) {
            showToast(R.string.user_register_error_password_unmatched)
            return
        }

        if (userName.length > 16 || userName.length < 6) {
            showToast(R.string.user_register_error_username_length)
            return
        }

        if (passWord.length < 8) {
            showToast(R.string.user_register_error_password_length)
            return
        }

        // 通过邮箱注册
        val email: String = userRegisterEmail.text.toString().trim { it <= ' ' }
        val verifyCode: String = this.userRegisterVerifyCode.text.toString().trim { it <= ' ' }
        if (email.isEmpty() || !email.contains("@") || !isEmailValid(email)) {
            // 邮箱格式不正确
            showToast(R.string.user_login_error_email)
            return
        }
        if (verifyCode.isEmpty()) {
            // 验证码为空
            showToast(R.string.user_login_error_emptyverifycode)
            return
        }
        if (!FunSupport.getInstance().registerByEmail(
                userName, passWord, verifyCode, email
            )
        ) {
            showToast(R.string.guide_message_error_call)
        }
    }

    private fun isEmailValid(email: String): Boolean {
        val regex = "\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*"
        return email.matches(regex.toRegex())
    }

    override fun onRequestSendCodeSuccess() {
        showToast(R.string.guide_message_request_phone_msg_success)
    }

    override fun onRequestSendCodeFailed(errCode: Int?) {
        showToast(FunError.getErrorStr(errCode))
    }

    override fun onRegisterNewUserSuccess() {
        showToast(R.string.guide_message_register_user_success)
    }

    override fun onRegisterNewUserFailed(errCode: Int?) {
        showToast(FunError.getErrorStr(errCode))
    }

    override fun onUserNameFine() {
        showToast(R.string.guide_message_username_fine)
    }

    override fun onUserNameUnfine(errCode: Int?) {
        showToast(FunError.getErrorStr(errCode))
    }
}
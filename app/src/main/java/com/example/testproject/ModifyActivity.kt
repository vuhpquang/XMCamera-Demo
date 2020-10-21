package com.example.testproject

import android.os.Bundle
import android.text.TextUtils
import android.view.View
import com.lib.funsdk.support.FunError
import com.lib.funsdk.support.FunSupport
import com.lib.funsdk.support.OnFunChangePasswListener
import kotlinx.android.synthetic.main.activity_modify.*

class ModifyActivity : ActivityDemo(), View.OnClickListener, OnFunChangePasswListener {

    var passwordChecker: PasswordChecker? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_modify)

        userChangePasswBtn.setOnClickListener(this)


        passwordChecker = PasswordChecker(this, newPasswd, textGarde)
        FunSupport.getInstance().registerOnFunCheckPasswListener(passwordChecker)
        passwordChecker!!.check()


        FunSupport.getInstance().registerOnFunChangepasswListener(this)
    }

    override fun onDestroy() {
        FunSupport.getInstance().removeOnFunChangePasswListener(this)
        FunSupport.getInstance().removeOnFunCheckPasswListener(passwordChecker)

        super.onDestroy()
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.userChangePasswBtn -> tryToChangePassw()
        }
    }

    private fun tryToChangePassw() {

        val userName: String = userName.text.toString()
        val oldPassw: String = oldPasswd.text.toString()
        val newPassw: String = newPasswd.text.toString()
        val newPasswConfirm: String = newPasswdConfirm.text.toString()

        if (TextUtils.isEmpty(userName)) {
            showToast(R.string.user_change_password_error_emptyusername)
            return
        }

        if (TextUtils.isEmpty(oldPassw) || TextUtils.isEmpty(newPassw) || TextUtils.isEmpty(
                newPasswConfirm
            )
        ) {
            showToast(R.string.user_change_password_error_emptypassw)
            return
        } else if (newPassw.length < 8) {
            showToast(R.string.user_change_password_error_passwtooshort)
            return
        } else if (newPassw != newPasswConfirm) {
            showToast(R.string.user_change_password_error_passwnotequal)
            return
        }

        if (!FunSupport.getInstance().changePassw(userName, oldPassw, newPassw)) {
            showToast(R.string.guide_message_error_call)
        }
    }

    override fun onChangePasswSuccess() {
        showToast(R.string.user_change_password_sucess)
    }

    override fun onChangePasswFailed(errCode: Int?) {
        showToast(FunError.getErrorStr(errCode))
    }
}
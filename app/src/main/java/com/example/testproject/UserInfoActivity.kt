package com.example.testproject

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.lib.funsdk.support.FunError
import com.lib.funsdk.support.FunSupport
import com.lib.funsdk.support.OnFunGetUserInfoListener
import com.lib.funsdk.support.models.FunUserInfo
import kotlinx.android.synthetic.main.activity_user_info.*
import org.json.JSONObject

class UserInfoActivity : AppCompatActivity(), View.OnClickListener, OnFunGetUserInfoListener {
    private var responseCode: String? = null
    private var responseMsg: String? = null
    private var mUserInfo: FunUserInfo? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_info)

        userLogoutBtn.setOnClickListener(this)

        tryToGetUserInfo()


        FunSupport.getInstance().registerOnFunGetUserInfoListener(this)
    }

    private fun tryToGetUserInfo() {
        if (!FunSupport.getInstance().userInfo) {
            Toast.makeText(this, R.string.user_info_not_login, Toast.LENGTH_SHORT).show()
        }
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.userLogoutBtn -> {
                tryToLogout()
            }
        }
    }

    private fun tryToLogout() {
        if (!FunSupport.getInstance().logout()) {
            Toast.makeText(this, R.string.guide_message_error_call, Toast.LENGTH_SHORT).show()
        }
        finish()
    }

    override fun onGetUserInfoSuccess(strUserInfo: String?) {
        mUserInfo = parseJSONTOUserInfo(strUserInfo)
        if (mUserInfo != null) {
            tvUserId.text = mUserInfo!!.userId
            tvUserName.text = mUserInfo!!.userName
            tvUserEmail.text = mUserInfo!!.email
            tvUserPhone.text = mUserInfo!!.mobile_phone
            tvUserSex.text = getSexStr(mUserInfo!!.sex).toString()
            tvUserRegTime.text = mUserInfo!!.reg_time
        } else {
            Toast.makeText(this, responseMsg, Toast.LENGTH_SHORT).show()
        }
    }

    private fun getSexStr(sex: Int): Any {
        return when (sex) {
            0 -> {
                resources.getString(R.string.user_info_sex_man)
            }
            1 -> {
                resources.getString(R.string.user_info_sex_female)
            }
            else -> {
                ""
            }
        }
    }

    private fun parseJSONTOUserInfo(data: String?): FunUserInfo? {
        var userInfoTemp: FunUserInfo? = null

        try {
            val jsonContent = JSONObject(data)
            responseCode = jsonContent.getString("code")
            responseMsg = jsonContent.getString("msg")
            if (responseMsg.equals("success", ignoreCase = true)) {
                val jsonData = jsonContent.getJSONObject("data")
                val user_id = jsonData.optString("id")
                val user_name = jsonData.optString("username")
                val email = jsonData.optString("mail")
                val mobile_phone = jsonData.optString("phone")
                val sex = jsonData.optInt("sex")
                val reg_time = jsonData.optString("reg_time")
                userInfoTemp = FunUserInfo(user_id, user_name, email, mobile_phone, sex, reg_time)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return userInfoTemp
    }

    override fun onGetUserInfoFailed(errCode: Int) {
        Toast.makeText(this, FunError.getErrorStr(errCode), Toast.LENGTH_SHORT).show()
    }

    override fun onLogoutSuccess() {
        finish()
    }

    override fun onLogoutFailed(errCode: Int) {
        Toast.makeText(this, FunError.getErrorStr(errCode), Toast.LENGTH_SHORT).show()
    }
}
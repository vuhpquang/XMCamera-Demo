package com.example.testproject

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.zxing.activity.CaptureActivity
import com.lib.funsdk.support.FunSupport
import com.lib.funsdk.support.models.FunDevType
import com.lib.funsdk.support.models.FunDevice
import kotlinx.android.synthetic.main.activity_add_by_user.*

class AddByUserActivity : AppCompatActivity(), View.OnClickListener,
    AdapterView.OnItemSelectedListener {
    private var mSpinnerDevType: Spinner? = null

    private var mFunDevice: FunDevice? = null
    private var mCurrDevType: FunDevType? = null


    private val mSupportDevTypes = arrayOf(
        FunDevType.EE_DEV_NORMAL_MONITOR,
        FunDevType.EE_DEV_INTELLIGENTSOCKET,
        FunDevType.EE_DEV_SCENELAMP,
        FunDevType.EE_DEV_LAMPHOLDER,
        FunDevType.EE_DEV_CARMATE,
        FunDevType.EE_DEV_BIGEYE,
        FunDevType.EE_DEV_SMALLEYE,
        FunDevType.EE_DEV_BOUTIQUEROTOT,
        FunDevType.EE_DEV_SPORTCAMERA,
        FunDevType.EE_DEV_SMALLRAINDROPS_FISHEYE,
        FunDevType.EE_DEV_LAMP_FISHEYE,
        FunDevType.EE_DEV_MINIONS,
        FunDevType.EE_DEV_MUSICBOX,
        FunDevType.EE_DEV_SPEAKER,
        FunDevType.EE_DEV_LINKCENTER,
        FunDevType.EE_DEV_DASH_CAMERA,
        FunDevType.EE_DEV_POWER_STRIP,
        FunDevType.EE_DEV_FISH_FUN,
        FunDevType.EE_DEV_UFO,
        FunDevType.EE_DEV_IDR,
        FunDevType.EE_DEV_BULLET,
        FunDevType.EE_DEV_DRUM,
        FunDevType.EE_DEV_CAMERA
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_by_user)

        btnScanCode.setOnClickListener(this)
        devAddBtn.setOnClickListener(this)

        // 初始化设备类型选择器
        mSpinnerDevType = findViewById(R.id.spinnerDeviceType) as Spinner
        val spinnerStrs = arrayOfNulls<String>(mSupportDevTypes.size)
        for (i in mSupportDevTypes.indices) {
            spinnerStrs[i] = resources.getString(mSupportDevTypes.get(i).getTypeStrId())
        }
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, spinnerStrs)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        mSpinnerDevType!!.setAdapter(adapter)
        mSpinnerDevType!!.setSelection(0)
        mCurrDevType = mSupportDevTypes.get(0)
        mSpinnerDevType!!.onItemSelectedListener = this
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnScanCode -> {
                startActivityForResult(Intent(this, CaptureActivity::class.java), 1)
            }
            R.id.devAddBtn -> {
                requestDeviceLogin()
            }
        }
    }

    private fun requestDeviceLogin() {
        Toast.makeText(this, "Request device login...", Toast.LENGTH_SHORT).show()
        val devSN: String = editDeviceSN.text.toString().trim { it <= ' ' }

        if (devSN.isEmpty()) {
            Toast.makeText(this, R.string.device_login_error_sn, Toast.LENGTH_SHORT).show()
            return
        }

        mFunDevice = null

        if (null == mFunDevice) {
            // 虚拟一个设备, 只需要序列号和设备类型即可添加
            mFunDevice = FunDevice()
            mFunDevice!!.devSn = devSN
            mFunDevice!!.devName = devSN
            mFunDevice!!.devType = mCurrDevType
            mFunDevice!!.loginName = "admin"
            mFunDevice!!.loginPsw = ""
        }

        // 添加设备之前都必须先登录一下,以防设备密码错误,也是校验其合法性

        // 添加设备之前都必须先登录一下,以防设备密码错误,也是校验其合法性
        FunSupport.getInstance().requestDeviceLogin(mFunDevice)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                //RESULT_OK
                if (null != data) {
                    val deviceSn = data.getStringExtra("result")
                    if (null != deviceSn && null != editDeviceSN) {
                        editDeviceSN.setText(deviceSn)
                    }
                }
            } else if (resultCode == RESULT_CANCELED) {
                //RESULT_CANCELED
                Toast.makeText(this, "Can't get the QR code", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        if (position >= 0 && position < mSupportDevTypes.size) {
            mCurrDevType = mSupportDevTypes[position]
        }
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
//        TODO("Not yet implemented")
    }
}
package com.example.testproject

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.view.View
import android.widget.*
import android.widget.AdapterView.OnItemClickListener
import androidx.appcompat.app.AppCompatActivity
import com.example.common.DialogInputPasswd
import com.google.zxing.activity.CaptureActivity
import com.lib.FunSDK
import com.lib.funsdk.support.*
import com.lib.funsdk.support.models.FunDevType
import com.lib.funsdk.support.models.FunDevice
import com.lib.funsdk.support.models.FunLoginType
import com.lib.sdk.struct.H264_DVR_FILE_DATA
import kotlinx.android.synthetic.main.activity_add_by_user.*

class AddByUserActivity : AppCompatActivity(), View.OnClickListener,
    OnFunDeviceListener, AdapterView.OnItemSelectedListener,
    OnItemClickListener, OnFunDeviceOptListener {

    private var mSpinnerDevType: Spinner? = null

    private var mListViewDev: ListView? = null
    private var mAdapterDev: ListAdapterSimpleFunDevice? = null

    private var mFunDevice: FunDevice? = null
    private var mCurrDevType: FunDevType? = null


    private val MESSAGE_DELAY_FINISH = 0x100

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

        // 初始化设备类型选择器

        // 初始化设备类型选择器
        mSpinnerDevType = findViewById(R.id.spinnerDeviceType) as Spinner
        val spinnerStrs = arrayOfNulls<String>(mSupportDevTypes.size)
        for (i in mSupportDevTypes.indices) {
            spinnerStrs[i] = resources.getString(mSupportDevTypes[i].typeStrId)
        }
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, spinnerStrs)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        mSpinnerDevType!!.adapter = adapter
        mSpinnerDevType!!.setSelection(0)
        mCurrDevType = mSupportDevTypes[0]
        mSpinnerDevType!!.onItemSelectedListener = this

        devAddBtn.setOnClickListener(this)

        btnScanCode.setOnClickListener(this)

        mListViewDev = findViewById(R.id.listOtherDevices) as ListView
        mAdapterDev = ListAdapterSimpleFunDevice(this)
        mListViewDev!!.setAdapter(mAdapterDev)
        if (null != mAdapterDev) {
            mAdapterDev!!.updateDevice(FunSupport.getInstance().lanDeviceList)
        }
        mListViewDev!!.setOnItemClickListener(this)


        // 设置登录方式为互联网方式

        // 设置登录方式为互联网方式
        FunSupport.getInstance().loginType = FunLoginType.LOGIN_BY_INTENTT

        // 监听设备类事件

        // 监听设备类事件
        FunSupport.getInstance().registerOnFunDeviceListener(this)

        // 设备操作类事件(登录是否成功需要)

        // 设备操作类事件(登录是否成功需要)
        FunSupport.getInstance().registerOnFunDeviceOptListener(this)

        if (!FunSupport.getInstance().hasLogin()) {
            // 用户还未登录,需要先登录
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }


    override fun onDestroy() {

        // 注销设备事件监听
        FunSupport.getInstance().removeOnFunDeviceListener(this)
        FunSupport.getInstance().removeOnFunDeviceOptListener(this)
        mHandler?.removeCallbacksAndMessages(null)
        super.onDestroy()
    }


    override fun onResume() {
        super.onResume()
    }


    override fun onClick(v: View) {
        when (v.id) {
            R.id.devAddBtn -> {
                requestDeviceLogin()
            }
            R.id.btnScanCode -> {
                startScanQrCode()
            }
        }
    }

    private val mHandler: Handler? = object : Handler() {
        override fun handleMessage(msg: Message) {
            when (msg.what) {
                MESSAGE_DELAY_FINISH -> {

                    // 启动/打开设备操作界面
                    if (null != mFunDevice) {
//                        DeviceActivitys.startDeviceActivity(
//                            DeviceListLanActivity,
//                            mFunDevice
//                        )
                    }
                    mFunDevice = null
                    finish()
                }
            }
        }
    }

    private fun getSpinnerIndexByDeviceType(type: FunDevType?): Int {
        for (i in mSupportDevTypes.indices) {
            if (type == mSupportDevTypes[i]) {
                return i
            }
        }
        return 0
    }

    // 扫描二维码
    private fun startScanQrCode() {
        val intent = Intent()
        intent.setClass(this, CaptureActivity::class.java)
        startActivityForResult(intent, 1)
    }

    // 设备登录
    private fun requestDeviceLogin() {
        val devSN: String = editDeviceSN.text.toString().trim { it <= ' ' }
        if (devSN.length == 0) {
            Toast.makeText(this, R.string.device_login_error_sn, Toast.LENGTH_SHORT).show()
            return
        }
        mFunDevice = null
//        showWaitDialog()
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
        FunSupport.getInstance().requestDeviceLogin(mFunDevice)
//		for (int i = 10; i < 60; i++) {
//				// 虚拟一个设备, 只需要序列号和设备类型即可添加
//				mFunDevice = new FunDevice();
//				mFunDevice.devSn = "123456789123as" + i;
//				mFunDevice.devName = "12345678912345" + i;
//				mFunDevice.devType = FunDevType.EE_DEV_NORMAL_MONITOR;
//				mFunDevice.loginName = "admin";
//				mFunDevice.loginPsw = "";
//			FunSupport.getInstance().requestDeviceAdd(mFunDevice);
//		}
    }

    private fun requestReloginByPasswd() {
        if (null != mFunDevice) {

//			mFunDevice.loginPsw = passwd;
//            showWaitDialog()
            FunSupport.getInstance().requestDeviceLogin(mFunDevice)
        }
    }

    private fun requestDeviceAdd() {
        if (null != mFunDevice) {
            FunSupport.getInstance().requestDeviceAdd(mFunDevice)
        }
    }

    /**
     * 显示输入设备密码对话框
     */
    private fun showInputPasswordDialog() {
        val inputDialog: DialogInputPasswd = object : DialogInputPasswd(
            this,
            resources.getString(R.string.device_login_input_password),
            "",
            R.string.common_confirm,
            R.string.common_cancel
        ) {
            override fun confirm(editText: String): Boolean {

                //保存密码
                FunDevicePassword.getInstance().saveDevicePassword(
                    mFunDevice!!.getDevSn(),
                    editText
                )
                // 库函数方式本地保存密码
                FunSDK.DevSetLocalPwd(mFunDevice!!.getDevSn(), "admin", editText)
                // 如果设置了使用本地保存密码，则将密码保存到本地文件
                // 重新以新的密码登录
                requestReloginByPasswd()
                return super.confirm(editText)
            }

            override fun cancel() {
                super.cancel()

                // 取消输入密码,直接退出
                finish()
            }
        }
        inputDialog.show()
    }

    override fun onDeviceListChanged() {
        // TODO Auto-generated method stub
    }

    override fun onDeviceStatusChanged(funDevice: FunDevice?) {
        // TODO Auto-generated method stub
    }


    override fun onDeviceAddedSuccess() {
//        hideWaitDialog()
        Toast.makeText(this, R.string.device_opt_add_success, Toast.LENGTH_SHORT).show()

        // 如果需要,在添加设备成功之后,可以更新一次设备列表
        FunSupport.getInstance().requestDeviceList()
    }


    override fun onDeviceAddedFailed(errCode: Int?) {
//        hideWaitDialog()
        Toast.makeText(this, FunError.getErrorStr(errCode), Toast.LENGTH_SHORT).show()
    }


    override fun onDeviceRemovedSuccess() {
        // TODO Auto-generated method stub
    }


    override fun onDeviceRemovedFailed(errCode: Int?) {
        // TODO Auto-generated method stub
    }


    override fun onAPDeviceListChanged() {
        // TODO Auto-generated method stub
    }

    override fun onLanDeviceListChanged() {
        // TODO Auto-generated method stub
    }

    override fun onItemSelected(
        arg0: AdapterView<*>?, arg1: View?, position: Int,
        arg3: Long
    ) {
        if (position >= 0 && position < mSupportDevTypes.size) {
            mCurrDevType = mSupportDevTypes[position]
        }
    }

    override fun onNothingSelected(arg0: AdapterView<*>?) {}


    override fun onItemClick(arg0: AdapterView<*>?, arg1: View?, position: Int, arg3: Long) {
        if (null != mAdapterDev) {
            val funDevice = mAdapterDev!!.getFunDevice(position)
            if (null != funDevice) {
                // 当前选择的设备
                mFunDevice = funDevice
                mCurrDevType = funDevice.devType
                // 在Sipnner中设置当前选择设备的类型
                mSpinnerDevType!!.setSelection(getSpinnerIndexByDeviceType(mCurrDevType))
                // 在EditText中设置当前选择设备的序列号
                editDeviceSN.setText(mFunDevice!!.getDevSn())
            }
        }
    }


    override fun onDeviceLoginSuccess(funDevice: FunDevice?) {
        if (null != mFunDevice && null != funDevice && mFunDevice!!.id == funDevice.id) {
            requestDeviceAdd()
        }
    }


    override fun onDeviceLoginFailed(funDevice: FunDevice?, errCode: Int) {
//        hideWaitDialog()
        Toast.makeText(this, FunError.getErrorStr(errCode), Toast.LENGTH_SHORT).show()

        // 如果账号密码不正确,那么需要提示用户,输入密码重新登录
        if (errCode == FunError.EE_DVR_PASSWORD_NOT_VALID) {
            showInputPasswordDialog()
        }
    }


    override fun onDeviceGetConfigSuccess(
        funDevice: FunDevice?,
        configName: String?, nSeq: Int
    ) {
        // TODO Auto-generated method stub
    }


    override fun onDeviceGetConfigFailed(funDevice: FunDevice?, errCode: Int?) {
        // TODO Auto-generated method stub
    }


    override fun onDeviceSetConfigSuccess(funDevice: FunDevice?, configName: String?) {
        // TODO Auto-generated method stub
    }


    override fun onDeviceSetConfigFailed(
        funDevice: FunDevice?, configName: String?,
        errCode: Int?
    ) {
        // TODO Auto-generated method stub
    }


    override fun onDeviceChangeInfoSuccess(funDevice: FunDevice?) {
        // TODO Auto-generated method stub
    }


    override fun onDeviceChangeInfoFailed(funDevice: FunDevice?, errCode: Int?) {
        // TODO Auto-generated method stub
    }


    override fun onDeviceOptionSuccess(funDevice: FunDevice?, option: String?) {
        // TODO Auto-generated method stub
    }


    override fun onDeviceOptionFailed(
        funDevice: FunDevice?, option: String?,
        errCode: Int?
    ) {
        // TODO Auto-generated method stub
    }


    override fun onDeviceFileListChanged(funDevice: FunDevice?) {
        // TODO Auto-generated method stub
    }


    override fun onDeviceFileListChanged(
        funDevice: FunDevice?,
        datas: Array<H264_DVR_FILE_DATA?>?
    ) {
        // TODO Auto-generated method stub
    }

    override fun onActivityResult(requestCode: Int, responseCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, responseCode, data)
        if (requestCode == 1
            && responseCode == 1
        ) {
            // Demo, 扫描二维码的结果
            if (null != data) {
                val deviceSn = data.getStringExtra("SN")
                if (null != deviceSn && null != editDeviceSN) {
                    editDeviceSN.setText(deviceSn)
                }
            }
        }
    }


    override fun onDeviceFileListGetFailed(funDevice: FunDevice?) {
        // TODO Auto-generated method stub
    }
}
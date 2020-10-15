package com.example.testproject

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.alibaba.fastjson.JSONObject
import com.basic.G
import com.example.testproject.cloud.ActivityDevCloudTest
import com.example.testproject.devices.ActivityGuideDeviceTransCom
import com.lib.MsgContent
import com.lib.funsdk.support.*
import com.lib.funsdk.support.config.JsonConfig
import com.lib.funsdk.support.models.FunDevice
import com.lib.funsdk.support.models.FunLoginType
import com.lib.sdk.struct.H264_DVR_FILE_DATA
import kotlinx.android.synthetic.main.activity_device_list_users.*
import java.util.*

class DeviceListUsersActivity : AppCompatActivity(),
    ListAdapterFunDevice.OnFunDeviceItemClickListener, OnFunDeviceListener, OnFunDeviceOptListener,
    OnAddSubDeviceResultListener {
    private var mAdapter: ListAdapterFunDevice? = null
    private var mDeviceList: MutableList<FunDevice> = ArrayList<FunDevice>()
    private val MESSAGE_REFRESH_DEVICE_STATUS = 0x100
    companion object {
        private val INTERVAL_REFRESH_DEV_STATUS = 3 * 60 * 1000
    }


    private var mSubDeviceSN //子设备序列号
            : String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_device_list_users)

        btn_multi_screen.setOnClickListener {
            startActivity(Intent(this, MultiScreenActivity2::class.java))
        }


        // 不需要连接AP
        mAdapter = ListAdapterFunDevice(this, mDeviceList)
        mAdapter?.setNeedConnectAP(false)
        mAdapter?.setOnFunDeviceItemClickListener(this)
        listViewDevice.setAdapter(mAdapter)

        // 切换到网络访问访问方式

        // 切换到网络访问访问方式
        FunSupport.getInstance().loginType = FunLoginType.LOGIN_BY_INTENTT

        // 监听设备列表类事件

        // 监听设备列表类事件
        FunSupport.getInstance().registerOnFunDeviceListener(this)

        // 监听设备操作类事件(设备重命名时需要)

        // 监听设备操作类事件(设备重命名时需要)
        FunSupport.getInstance().registerOnFunDeviceOptListener(this)

        FunSupport.getInstance().registerOnAddSubDeviceResultListener(this)
        // 判断是否用户已经登录,如果未登录打开登录界面
        // 判断是否用户已经登录,如果未登录打开登录界面
        if (!FunSupport.getInstance().hasLogin()) {
            startLogin()
        }

        // 刷新设备列表

        // 刷新设备列表
        refreshDeviceList()
        btn_test.setOnClickListener{
            val temp_str = FunSupport.getInstance().deviceList[0].cloudState.toString() + "_" +
                    FunSupport.getInstance().deviceList[1].cloudState.toString() + "_" +
                    FunSupport.getInstance().deviceList[2].cloudState.toString() + "_" +
                    FunSupport.getInstance().deviceList[1].cloudExpired.toString()
            var temp_str_2 = FunSupport.getInstance().deviceList[0].cloudExpired.toString() + "_" +
                    FunSupport.getInstance().deviceList[1].cloudExpired.toString() + "_" +
                    FunSupport.getInstance().deviceList[2].cloudExpired.toString() + "_" +
                    FunSupport.getInstance().deviceList[3].cloudExpired.toString()
            temp_str_2 += "\n" + FunSupport.getInstance().deviceList[0].cloudState.toString() + "_" +
                    FunSupport.getInstance().deviceList[1].cloudState.toString() + "_" +
                    FunSupport.getInstance().deviceList[2].cloudState.toString() + "_" +
                    FunSupport.getInstance().deviceList[3].cloudState.toString()
                    Toast.makeText(this, temp_str_2, Toast.LENGTH_LONG).show()
        }
    }

    private fun refreshDeviceList() {
        mDeviceList.clear()

        mDeviceList.addAll(FunSupport.getInstance().deviceList)

        mAdapter!!.notifyDataSetInvalidated()

        mHandler.removeMessages(MESSAGE_REFRESH_DEVICE_STATUS)

        if (mDeviceList.isNotEmpty()) {
            mHandler.sendEmptyMessageDelayed(MESSAGE_REFRESH_DEVICE_STATUS, 100)
        }
    }

    private fun startLogin() {
        val intent = Intent()
        intent.setClass(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun onFunDeviceRenameClicked(funDevice: FunDevice?) {

        // 设备重命名
        val factory = LayoutInflater.from(this)
        val textEntryView: View = factory.inflate(R.layout.activity_newname, null)
        val editDevName = textEntryView.findViewById<View>(R.id.edit) as EditText
        val builder = AlertDialog.Builder(this)
        val alert = builder.setTitle(R.string.device_opt_change_name)
            .setMessage(R.string.device_opt_change_name_tip).setView(textEntryView)
            .setNegativeButton(
                R.string.common_cancel
            ) { dialog, which ->
                // Toast.makeText(ActivityGuideDeviceList.this, "取消保存",
                // Toast.LENGTH_SHORT).show();
            }.setPositiveButton(
                R.string.common_confirm
            ) { dialog, which ->
                val newDevName = editDevName.text.toString()
                if (!FunSupport.getInstance().requestDeviceRename(funDevice, newDevName)) {
                    Toast.makeText(this, R.string.guide_message_error_call, Toast.LENGTH_SHORT).show()
                }
            }.create() // 创建AlertDialog对象

        editDevName.setText(funDevice!!.getDevName())
        alert.show()
    }

    override fun onFunDeviceConnectClicked(funDevice: FunDevice?) {
        //TODO("Not yet implemented")
    }

    override fun onFunDeviceControlClicked(funDevice: FunDevice?) {

        // 打开设备操控界面
        DeviceActivitys.startDeviceActivity(this, funDevice)
    }

    override fun onFunDeviceAlarmClicked(funDevice: FunDevice?) {
//
//        // 设备报警
//        if (null != funDevice) {
//            val intent = Intent()
//            intent.setClass(this, ActivityGuideDeviceAlarmResult::class.java)
//            intent.putExtra("FUN_DEVICE_ID", funDevice.id)
//            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
//            startActivity(intent)
//        }
    }

    override fun onFunDeviceTransComClicked(funDevice: FunDevice?) {
        if (null != funDevice) {
            val intent = Intent()
            intent.setClass(this, ActivityGuideDeviceTransCom::class.java)
            intent.putExtra("FUN_DEVICE_ID", funDevice.id)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
        }
    }

    override fun onFunDeviceRemoveClicked(funDevice: FunDevice?) {

        // 删除设备
        val builder = AlertDialog.Builder(this)
        val alert = builder.setTitle(R.string.device_opt_remove_by_user)
            .setMessage(R.string.device_opt_remove_by_user_tip)
            .setNegativeButton(
                R.string.common_cancel
            ) { dialog, which -> }.setPositiveButton(
                R.string.common_confirm
            ) { dialog, which ->
                if (!FunSupport.getInstance().requestDeviceRemove(funDevice)) {
                    Toast.makeText(this, R.string.guide_message_error_call, Toast.LENGTH_SHORT).show()
                }
            }.create() // 创建AlertDialog对象

        alert.show()
    }

    override fun onFunDevice433AddSub(funDevice: FunDevice?) {
        // TODO Auto-generated method stub

        // TODO Auto-generated method stub
        val jsonObject = JSONObject()
        jsonObject["DeviceType"] = "Relay"
        jsonObject["DeviceMold"] = "Control"
        jsonObject["Operate"] = "Close"
        jsonObject["Freq"] = "433"
        jsonObject["BaudRate"] = "100"
        FunSupport.getInstance()
            .requestDeviceAddSubDev(funDevice, JsonConfig.AddSubDevice, jsonObject.toJSONString())
    }

    override fun onFunDevice433Control(funDevice: FunDevice?) {
        // TODO Auto-generated method stub
//        if (null != mSubDeviceSN && mSubDeviceSN != "") {
//            showWaitDialog();

        // TODO Auto-generated method stub
//        if (null != mSubDeviceSN && mSubDeviceSN != "") {
//            showWaitDialog();
        val jsonObject = JSONObject()
        jsonObject["RFDeviceSN"] = mSubDeviceSN
        jsonObject["DeviceType"] = "Relay"
        jsonObject["Operate"] = "Close"
        jsonObject["Freq"] = "433"
        jsonObject["BaudRate"] = "100"
        FunSupport.getInstance().requestControlSubDevice(
            funDevice,
            JsonConfig.ControlSubDevice,
            jsonObject.toJSONString()
        )
//        }else{
//            Toast.makeText(this, "子设备序列号为空", Toast.LENGTH_SHORT).show();
//        }
    }

    override fun onFunDeviceWakeUp(funDevice: FunDevice?) {
//        val intent = Intent()
//        intent.setClass(this, LowPowerDevActivity::class.java)
//        intent.putExtra("FUN_DEVICE_ID", funDevice!!.id)
//        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
//        startActivity(intent)
    }

    override fun onFunDeviceCloud(funDevice: FunDevice?) {
//        val intent = Intent(this, ActivityDevCloudDate::class.java)
//        intent.putExtra("FUN_DEVICE_ID", funDevice!!.id)
//        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
//        startActivity(intent)
        val intent_tmp = Intent(this, ActivityDevCloudTest::class.java)
        intent_tmp.putExtra("FUN_DEVICE_ID", funDevice!!.id)
        intent_tmp.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent_tmp)
        Log.d("HELLO", "DevID: " + funDevice.id)
    }

    override fun onFunDeviceTest(funDevice: FunDevice?) {
        Log.d("TESTME", "DEVID" + funDevice!!.id)
        Log.d("TESTME", "DEVSN" + funDevice.devSn)
//        val intent = Intent(this, TestActivity::class.java)
//        intent.putExtra("devId", funDevice!!.getDevSn())
//        startActivity(intent)
    }

    override fun onDeviceListChanged() {
        refreshDeviceList()
    }

    override fun onDeviceStatusChanged(funDevice: FunDevice?) {
        if (null != mAdapter) {
            mAdapter!!.notifyDataSetChanged()
        }
    }

    override fun onDeviceAddedSuccess() {
    }

    override fun onDeviceAddedFailed(errCode: Int?) {
    }

    override fun onDeviceRemovedSuccess() {
        Toast.makeText(this, R.string.device_opt_remove_success, Toast.LENGTH_SHORT).show()

        requestToGetDeviceList()
    }

    private fun requestToGetDeviceList() {
        if (!FunSupport.getInstance().requestDeviceList()) {
            Toast.makeText(this, R.string.guide_message_error_call, Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDeviceRemovedFailed(errCode: Int?) {
        Toast.makeText(this, FunError.getErrorStr(errCode), Toast.LENGTH_SHORT).show()
    }

    override fun onAPDeviceListChanged() {
    }

    override fun onLanDeviceListChanged() {
    }

    override fun onDeviceLoginSuccess(funDevice: FunDevice?) {
        //TODO("Not yet implemented")
    }

    override fun onDeviceLoginFailed(funDevice: FunDevice?, errCode: Int?) {
        //TODO("Not yet implemented")
    }

    override fun onDeviceGetConfigSuccess(funDevice: FunDevice?, configName: String?, nSeq: Int) {
        //TODO("Not yet implemented")
    }

    override fun onDeviceGetConfigFailed(funDevice: FunDevice?, errCode: Int?) {
        //TODO("Not yet implemented")
    }

    override fun onDeviceSetConfigSuccess(funDevice: FunDevice?, configName: String?) {

        if (configName == JsonConfig.ControlSubDevice) {
            Toast.makeText(this, "Sub-device setting successfully", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDeviceSetConfigFailed(
        funDevice: FunDevice?,
        configName: String?,
        errCode: Int?
    ) {
        // TODO Auto-generated method stub
        if (configName == JsonConfig.ControlSubDevice) {
            Toast.makeText(this, "Sub-device setting failed", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDeviceChangeInfoSuccess(funDevice: FunDevice?) {
        // 修改设备信息成功

        // 修改设备信息成功
        Toast.makeText(this, R.string.device_opt_change_name_success, Toast.LENGTH_SHORT).show()

        // 如果有需要，重新获取设备列表,以新的设备列表为准,参考以下注释代码
        // requestToGetDeviceList();
        // 一般情况下修改信息成功,刷新显示即可

        // 如果有需要，重新获取设备列表,以新的设备列表为准,参考以下注释代码
        // requestToGetDeviceList();
        // 一般情况下修改信息成功,刷新显示即可
        if (null != mAdapter) {
            //hideWaitDialog()
            mAdapter!!.notifyDataSetInvalidated()
        }
    }

    override fun onDeviceChangeInfoFailed(funDevice: FunDevice?, errCode: Int?) {
        //TODO("Not yet implemented")
    }

    override fun onDeviceOptionSuccess(funDevice: FunDevice?, option: String?) {
        //TODO("Not yet implemented")
    }

    override fun onDeviceOptionFailed(funDevice: FunDevice?, option: String?, errCode: Int?) {
        //TODO("Not yet implemented")
    }

    override fun onDeviceFileListChanged(funDevice: FunDevice?) {
        //TODO("Not yet implemented")
    }

    override fun onDeviceFileListChanged(
        funDevice: FunDevice?,
        datas: Array<out H264_DVR_FILE_DATA>?
    ) {
        //TODO("Not yet implemented")
    }

    override fun onDeviceFileListGetFailed(funDevice: FunDevice?) {
        //TODO("Not yet implemented")
    }

    override fun onAddSubDeviceFailed(funDevice: FunDevice?, msgContent: MsgContent?) {
        if (msgContent!!.str == JsonConfig.AddSubDevice) {
            Toast.makeText(this, "Sub-device adding failed", Toast.LENGTH_SHORT).show()
        }
//        hideWaitDialog()
    }

    override fun onAddSubDeviceSuccess(funDevice: FunDevice?, msgContent: MsgContent?) {
        if (msgContent!!.str == JsonConfig.AddSubDevice) {
            val jsonObject: JSONObject
            jsonObject = JSONObject.parse(G.ToString(msgContent.pData)) as JSONObject
            mSubDeviceSN = jsonObject["RFDeviceSN"] as String?
            println("zyy------------mSubDeviceSN    $mSubDeviceSN")
            Toast.makeText(this, "Sub-device adding successfully", Toast.LENGTH_SHORT).show()
        }
//        hideWaitDialog()
    }

    private val mHandler: Handler = object : Handler() {
        override fun handleMessage(msg: Message) {
            when (msg.what) {
                MESSAGE_REFRESH_DEVICE_STATUS -> {
                    FunSupport.getInstance().requestAllDeviceStatus()

                    // 3分钟之后再次获取状态
                    removeMessages(MESSAGE_REFRESH_DEVICE_STATUS)
                    sendEmptyMessageDelayed(
                        MESSAGE_REFRESH_DEVICE_STATUS,
                        INTERVAL_REFRESH_DEV_STATUS.toLong()
                    )
                }
            }
        }
    }

    override fun onDestroy() {
        FunSupport.getInstance().removeOnFunDeviceListener(this)

        FunSupport.getInstance().removeOnFunDeviceOptListener(this)
        FunSupport.getInstance().removeOnAddSubDeviceResultListener(this)
        super.onDestroy()
    }
}
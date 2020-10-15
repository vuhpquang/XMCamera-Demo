package com.example.testproject

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.common.DialogInputPasswd
import com.example.common.UIFactory
import com.lib.FunSDK
import com.lib.funsdk.support.FunDevicePassword
import com.lib.funsdk.support.FunError
import com.lib.funsdk.support.FunSupport
import com.lib.funsdk.support.OnFunDeviceOptListener
import com.lib.funsdk.support.config.ChannelSystemFunction
import com.lib.funsdk.support.config.OPPTZControl
import com.lib.funsdk.support.config.OPPTZPreset
import com.lib.funsdk.support.config.SystemInfo
import com.lib.funsdk.support.models.FunDevType
import com.lib.funsdk.support.models.FunDevice
import com.lib.funsdk.support.models.FunStreamType
import com.lib.funsdk.support.utils.MyUtils
import com.lib.funsdk.support.widget.FunVideoView
import com.lib.sdk.struct.H264_DVR_FILE_DATA
import kotlinx.android.synthetic.main.activity_multi_screen.*

class MultiScreenActivity : AppCompatActivity(),
    MediaPlayer.OnPreparedListener,
    MediaPlayer.OnErrorListener,
    MediaPlayer.OnInfoListener,
    View.OnClickListener,
    OnFunDeviceOptListener {

    private var mFunDevice: FunDevice? = null
    private var mFunDevice_2: FunDevice? = null
    private var mFunVideoView: FunVideoView? = null
    private var mFunVideoView_2: FunVideoView? = null
    private var mChannelCount = 0
    private var mCanToPlay = false
    var NativeLoginPsw: String? = null
    private var isGetSysFirst = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_multi_screen)

        val devId = intent.getIntExtra("FUN_DEVICE_ID", -1662663230) //Default value is exact device
//        val devSn = "5af6b3254f2d1a41"
        val devId_2 = 1844285342
        if (FunSupport.getInstance().findDeviceById(devId) == null || !FunSupport.getInstance()
                .hasLogin() || FunSupport.getInstance().findDeviceById(devId_2) == null
        ) {
            startLogin()
        }
        mFunDevice = FunSupport.getInstance().findDeviceById(devId)
        mFunDevice_2 = FunSupport.getInstance().findDeviceById(devId_2)
        if (null == mFunDevice || null == mFunDevice_2) {
            finish()
            return
        }

        mFunVideoView = findViewById<View>(R.id.funVideoView) as FunVideoView
        if (mFunDevice!!.devType == FunDevType.EE_DEV_LAMP_FISHEYE) {
            // 鱼眼灯泡,设置鱼眼效果
            mFunVideoView?.setFishEye(true)
        }
        mFunVideoView!!.setOnPreparedListener(this)
        mFunVideoView!!.setOnErrorListener(this)
        mFunVideoView!!.setOnInfoListener(this)

        mFunVideoView_2 = findViewById<View>(R.id.funVideoView_2) as FunVideoView
        if (mFunDevice_2!!.devType == FunDevType.EE_DEV_LAMP_FISHEYE) {
            // 鱼眼灯泡,设置鱼眼效果
            mFunVideoView_2?.setFishEye(true)
        }
        mFunVideoView_2!!.setOnPreparedListener(this)
        mFunVideoView_2!!.setOnErrorListener(this)
        mFunVideoView_2!!.setOnInfoListener(this)

        mCanToPlay = false
        FunSupport.getInstance().registerOnFunDeviceOptListener(this)
        if (!mFunDevice!!.hasLogin() || !mFunDevice!!.hasConnected()
            || !mFunDevice_2!!.hasLogin() || !mFunDevice_2!!.hasConnected()) {
            loginDevice()
        } else {
            requestSystemInfo()
            requestChannelSystemFunction()
        }
    }

    private fun startLogin() {
        val intent = Intent()
        intent.setClass(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun onPrepared(mp: MediaPlayer?) {
//        TODO("Not yet implemented")
    }

    override fun onError(mp: MediaPlayer?, what: Int, extra: Int): Boolean {

        // 播放失败
        Toast.makeText(
            this,
            resources.getString(R.string.media_play_error) + " : "
                    + FunError.getErrorStr(extra), Toast.LENGTH_SHORT
        ).show()

        if ((FunError.EE_TPS_NOT_SUP_MAIN == extra
                    || FunError.EE_DSS_NOT_SUP_MAIN == extra)
        ) {
            // 不支持高清码流,设置为标清码流重新播放
            if (null != mFunVideoView) {
                mFunVideoView!!.streamType = FunStreamType.STREAM_SECONDARY
                playRealMedia(mFunVideoView, mFunDevice)
            }
            if (null != mFunVideoView_2) {
                mFunVideoView_2!!.streamType = FunStreamType.STREAM_SECONDARY
                playRealMedia(mFunVideoView_2, mFunDevice_2)
            }
        }

        return true
    }

    override fun onInfo(mp: MediaPlayer?, what: Int, extra: Int): Boolean {
        if (what == MediaPlayer.MEDIA_INFO_BUFFERING_START) {
            textVideoStat.setText(R.string.media_player_buffering)
            textVideoStat.visibility = View.VISIBLE
        } else if (what == MediaPlayer.MEDIA_INFO_BUFFERING_END) {
            textVideoStat.visibility = View.GONE
        }
        return true
    }

    override fun onClick(v: View?) {
//        if (v!!.id >= 1000 &&  v.id < 1000 + mChannelCount) {
//            mFunDevice!!.CurrChannel = v.id - 1000
//            mFunVideoView!!.stopPlayback()
//            mFunVideoView_2!!.stopPlayback()
//            playRealMediaAll()
//        }
//        when (v.id) {
//            1101 -> {
//                startDevicesPreview()
//            }
//            else -> {
//            }
//        }
    }

    private fun playRealMedia(funViewVideo : FunVideoView?, funDevice: FunDevice?) {
        playRealMediaPlay(funViewVideo, funDevice)
    }

    private fun startDevicesPreview() {
//        Intent intent = new Intent();
//        intent.putExtra("FUNDEVICE_ID", mFunDevice.getId());
//        intent.setClass(this, ActivityGuideDevicePreview.class);
//        startActivityForResult(intent, 0);
    }

    private fun playRealMediaPlay(funViewVideo : FunVideoView?, funDevice: FunDevice?) {


        // 显示状态: 正在打开视频...
        textVideoStat.setText(R.string.media_player_opening)
        textVideoStat.visibility = View.VISIBLE
        textVideoStat_2.setText(R.string.media_player_opening)
        textVideoStat_2.visibility = View.VISIBLE

        if (mFunDevice!!.isRemote) {
            funViewVideo!!.setRealDevice(funDevice!!.getDevSn(), funDevice.CurrChannel)
        } else {
            val deviceIp = FunSupport.getInstance().deviceWifiManager.gatewayIp
            funViewVideo!!.setRealDevice(deviceIp, funDevice!!.CurrChannel)
        }

        // 打开声音

        // 打开声音
        funViewVideo.setMediaSound(true)
    }

    override fun onResume() {
        if (mCanToPlay) {
            playRealMediaAll()
        }
        playRealMediaAll()
        super.onResume()
    }

    private fun playRealMediaAll() {
        playRealMedia(mFunVideoView, mFunDevice)
        playRealMedia(mFunVideoView_2, mFunDevice_2)
    }

    override fun onDestroy() {

        FunSupport.getInstance().removeOnFunDeviceOptListener(this)
        super.onDestroy()
    }

    override fun onDeviceLoginSuccess(funDevice: FunDevice?) {
        println("TTT---->>>> loginsuccess")

        if (null != mFunDevice && null != funDevice) {
            if (mFunDevice!!.id == funDevice.id) {

                // 登录成功后立刻获取SystemInfo
                // 如果不需要获取SystemInfo,在这里播放视频也可以:playRealMedia();
                requestSystemInfo()
                //请求系统通道能力级
                requestChannelSystemFunction()
            }
        }
    }

    private fun requestChannelSystemFunction() {
        val channelSystemFunction = ChannelSystemFunction()
        FunSupport.getInstance().requestDeviceCmdGeneral(mFunDevice, channelSystemFunction)
    }

    private fun requestSystemInfo() {
        FunSupport.getInstance().requestDeviceConfig(mFunDevice, SystemInfo.CONFIG_NAME)
    }

    override fun onDeviceLoginFailed(funDevice: FunDevice?, errCode: Int?) {

        // 设备登录失败
//        hideWaitDialog();
        Toast.makeText(this, FunError.getErrorStr(errCode), Toast.LENGTH_SHORT).show()

        // 如果账号密码不正确,那么需要提示用户,输入密码重新登录

        // 如果账号密码不正确,那么需要提示用户,输入密码重新登录
        if (errCode == FunError.EE_DVR_PASSWORD_NOT_VALID) {
            if (null != mFunDevice) {
                NativeLoginPsw = "123"
                onDeviceSaveNativePws()
                loginDevice()
            }
//            showInputPasswordDialog()
        }
    }

    override fun onDeviceGetConfigSuccess(funDevice: FunDevice?, configName: String?, nSeq: Int) {
        var channelCount = 0
        if (SystemInfo.CONFIG_NAME == configName) {
            if (!isGetSysFirst) {
                return
            }

            // 更新UI
            //此处为示例如何取通道信息，可能会增加打开视频的时间，可根据需求自行修改代码逻辑
            if (funDevice!!.channel == null) {
                FunSupport.getInstance().requestGetDevChnName(funDevice)
                requestSystemInfo()
                requestChannelSystemFunction()
                return
            }
            channelCount = funDevice.channel.nChnCount
            // if (channelCount >= 5) {
            // channelCount = 5;
            // }
            if (channelCount > 1) {
                mChannelCount = channelCount
                addChannelBtn(channelCount)
            }

//            hideWaitDialog();

            // 设置允许播放标志
            mCanToPlay = true
            isGetSysFirst = false
            Toast.makeText(this, "" + getType(funDevice.netConnectType), Toast.LENGTH_SHORT).show()

            // 获取信息成功后,如果WiFi连接了就自动播放
            // 此处逻辑客户自定义
            if (MyUtils.detectWifiNetwork(this)) {
                playRealMediaAll()
            } else {
                Toast.makeText(
                    this,
                    R.string.meida_not_auto_play_because_no_wifi,
                    Toast.LENGTH_SHORT
                ).show()
            }
        } else if (OPPTZPreset.CONFIG_NAME == configName) {
        } else if (OPPTZControl.CONFIG_NAME == configName) {
            Toast.makeText(applicationContext, R.string.user_set_preset_succeed, Toast.LENGTH_SHORT)
                .show()

            // 重新获取预置点列表
//			requestPTZPreset();
        } else if (ChannelSystemFunction.CONFIG_NAME == configName) {
        }
    }

    private fun getType(i: Int): Any {
        return when (i) {
            0 -> "P2P"
            1 -> "Forward"
            2 -> "IP"
            5 -> "RPS"
            else -> ""
        }
    }

    private fun addChannelBtn(channelCount: Int) {
        val m = UIFactory.dip2px(this, 5f)
        val p = UIFactory.dip2px(this, 3f)

        for (i in 0 until channelCount) {
            val btn = Button(this)
            btn.id = 1000 + i
            btn.setTextColor(resources.getColor(R.color.theme_color))
            btn.setPadding(p, p, p, p)
            val layoutParams = LinearLayout.LayoutParams(
                UIFactory.dip2px(this, 40f),
                UIFactory.dip2px(this, 40f)
            )
            layoutParams.setMargins(m, m, m, m)
            btn.layoutParams = layoutParams
            btn.text = i.toString()
            btn.setOnClickListener(this)
        }
    }

    override fun onDeviceGetConfigFailed(funDevice: FunDevice?, errCode: Int?) {
        Toast.makeText(this, FunError.getErrorStr(errCode), Toast.LENGTH_SHORT).show()
        if (errCode == -11406) {
            funDevice!!.invalidConfig(OPPTZPreset.CONFIG_NAME)
        }
    }

    override fun onDeviceSetConfigSuccess(funDevice: FunDevice?, configName: String?) {
//        TODO("Not yet implemented")
    }

    override fun onDeviceSetConfigFailed(
        funDevice: FunDevice?,
        configName: String?,
        errCode: Int?
    ) {
        if (OPPTZControl.CONFIG_NAME == configName) {
            Toast.makeText(applicationContext, R.string.user_set_preset_fail, Toast.LENGTH_SHORT)
                .show()
        }
    }

    override fun onDeviceChangeInfoSuccess(funDevice: FunDevice?) {
//        TODO("Not yet implemented")
    }

    override fun onDeviceChangeInfoFailed(funDevice: FunDevice?, errCode: Int?) {
//        TODO("Not yet implemented")
    }

    override fun onDeviceOptionSuccess(funDevice: FunDevice?, option: String?) {
//        TODO("Not yet implemented")
    }

    override fun onDeviceOptionFailed(funDevice: FunDevice?, option: String?, errCode: Int?) {
//        TODO("Not yet implemented")
    }

    override fun onDeviceFileListChanged(funDevice: FunDevice?) {
//        TODO("Not yet implemented")
    }

    override fun onDeviceFileListChanged(
        funDevice: FunDevice?,
        datas: Array<out H264_DVR_FILE_DATA>?
    ) {
//        TODO("Not yet implemented")
    }

    override fun onDeviceFileListGetFailed(funDevice: FunDevice?) {
//        TODO("Not yet implemented")
    }

    private fun showInputPasswordDialog() {
        val inputDialog: DialogInputPasswd = object : DialogInputPasswd(
            this,
            resources.getString(R.string.device_login_input_password), "", R.string.common_confirm,
            R.string.common_cancel
        ) {
            override fun confirm(editText: String): Boolean {
                // 重新以新的密码登录
                if (null != mFunDevice) {
                    NativeLoginPsw = editText
                    onDeviceSaveNativePws()

                    // 重新登录
                    loginDevice()
                }
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

    private fun loginDevice() {
        FunSupport.getInstance().requestDeviceLogin(mFunDevice)
    }

    private fun onDeviceSaveNativePws() {
        FunDevicePassword.getInstance().saveDevicePassword(
            mFunDevice!!.getDevSn(),
            NativeLoginPsw
        )
        // 库函数方式本地保存密码
        if (FunSupport.getInstance().saveNativePassword) {
            FunSDK.DevSetLocalPwd(mFunDevice!!.getDevSn(), "admin", NativeLoginPsw)
        }
    }
}
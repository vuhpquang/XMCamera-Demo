package com.example.testproject

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
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
import com.lib.funsdk.support.widget.FunVideoView
import com.lib.sdk.struct.H264_DVR_FILE_DATA
import kotlinx.android.synthetic.main.activity_multi_screen.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CameraFragment_1.newInstance] factory method to
 * create an instance of this fragment.
 */
class CameraFragment_1 : Fragment(), MediaPlayer.OnPreparedListener, MediaPlayer.OnErrorListener,
    MediaPlayer.OnInfoListener, OnFunDeviceOptListener {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null


    private var mFunDevice: FunDevice? = null
    private var mFunVideoView: FunVideoView? = null
    private var mChannelCount = 0
    private var mCanToPlay = false
    var NativeLoginPsw: String? = null
    private var isGetSysFirst = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view : View = inflater.inflate(R.layout.fragment_camera_1, container, false)
        init(view)
        return view
    }

    private fun init(view: View) {
        val devId = 1844285342
        if (FunSupport.getInstance().findDeviceById(devId) == null || !FunSupport.getInstance()
                .hasLogin()
        ) {
            startLogin()
        }
        mFunDevice = FunSupport.getInstance().findDeviceById(devId)
        if (null == mFunDevice) {
            return
        }

        mFunVideoView = view.findViewById<View>(R.id.funVideoView) as FunVideoView
        if (mFunDevice!!.devType == FunDevType.EE_DEV_LAMP_FISHEYE) {
            // 鱼眼灯泡,设置鱼眼效果
            mFunVideoView?.setFishEye(true)
        }
        mFunVideoView!!.setOnPreparedListener(this)
        mFunVideoView!!.setOnErrorListener(this)
        mFunVideoView!!.setOnInfoListener(this)

        mCanToPlay = false
        FunSupport.getInstance().registerOnFunDeviceOptListener(this)
        if (!mFunDevice!!.hasLogin() || !mFunDevice!!.hasConnected()) {
            loginDevice()
        } else {
            requestSystemInfo()
            requestChannelSystemFunction()
        }
    }

    private fun requestChannelSystemFunction() {
        val channelSystemFunction = ChannelSystemFunction()
        FunSupport.getInstance().requestDeviceCmdGeneral(mFunDevice, channelSystemFunction)
    }

    private fun requestSystemInfo() {
        FunSupport.getInstance().requestDeviceConfig(mFunDevice, SystemInfo.CONFIG_NAME)
    }

    private fun startLogin() {
        val intent = Intent()
        intent.setClass(activity!!, LoginActivity::class.java)
        startActivity(intent)
    }

    private fun loginDevice() {
        FunSupport.getInstance().requestDeviceLogin(mFunDevice)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment CameraFragment_1.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CameraFragment_1().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onPrepared(mp: MediaPlayer?) {
//        TODO("Not yet implemented")
    }

    override fun onError(mp: MediaPlayer?, what: Int, extra: Int): Boolean {

        // 播放失败
//        Toast.makeText(
//            activity,
//            resources.getString(R.string.media_play_error) + " : "
//                    + FunError.getErrorStr(extra), Toast.LENGTH_SHORT
//        ).show()

        if ((FunError.EE_TPS_NOT_SUP_MAIN == extra
                    || FunError.EE_DSS_NOT_SUP_MAIN == extra)
        ) {
            // 不支持高清码流,设置为标清码流重新播放
            if (null != mFunVideoView) {
                mFunVideoView!!.streamType = FunStreamType.STREAM_SECONDARY
                playRealMedia(mFunVideoView, mFunDevice)
            }
        }

        return true
    }

    private fun playRealMedia(funViewVideo : FunVideoView?, funDevice: FunDevice?) {


        // 显示状态: 正在打开视频...
//        textVideoStat.text = "Opening"
//        textVideoStat.visibility = View.VISIBLE

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

    override fun onInfo(mp: MediaPlayer?, what: Int, extra: Int): Boolean {
        if (what == MediaPlayer.MEDIA_INFO_BUFFERING_START) {
            textVideoStat.setText(R.string.media_player_buffering)
            textVideoStat.visibility = View.VISIBLE
        } else if (what == MediaPlayer.MEDIA_INFO_BUFFERING_END) {
            textVideoStat.visibility = View.GONE
        }
        return true
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

    override fun onDeviceLoginFailed(funDevice: FunDevice?, errCode: Int?) {

        // 设备登录失败
//        hideWaitDialog();
//        Toast.makeText(activity, FunError.getErrorStr(errCode), Toast.LENGTH_SHORT).show()

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
//                addChannelBtn(channelCount)
            }

//            hideWaitDialog();

            // 设置允许播放标志
            mCanToPlay = true
            isGetSysFirst = false
//            Toast.makeText(activity, "" + getType(funDevice.netConnectType), Toast.LENGTH_SHORT).show()

            // 获取信息成功后,如果WiFi连接了就自动播放
            // 此处逻辑客户自定义

            playRealMedia(mFunVideoView, mFunDevice)
//            if (MyUtils.detectWifiNetwork(activity)) {
//                playRealMedia(mFunVideoView, mFunDevice)
//            } else {
////                Toast.makeText(
////                    activity,
////                    R.string.meida_not_auto_play_because_no_wifi,
////                    Toast.LENGTH_SHORT
////                ).show()
//            }
        } else if (OPPTZPreset.CONFIG_NAME == configName) {
        } else if (OPPTZControl.CONFIG_NAME == configName) {
//            Toast.makeText(activity, R.string.user_set_preset_succeed, Toast.LENGTH_SHORT)
//                .show()

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

    override fun onDeviceGetConfigFailed(funDevice: FunDevice?, errCode: Int?) {
//        Toast.makeText(activity, FunError.getErrorStr(errCode), Toast.LENGTH_SHORT).show()
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
//            Toast.makeText(activity, R.string.user_set_preset_fail, Toast.LENGTH_SHORT)
//                .show()
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
}
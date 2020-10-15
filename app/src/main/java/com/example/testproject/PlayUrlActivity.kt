package com.example.testproject

import android.media.MediaPlayer
import android.media.MediaPlayer.OnErrorListener
import android.media.MediaPlayer.OnPreparedListener
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.util.Log
import android.view.View
import android.widget.SeekBar
import com.lib.funsdk.support.FunError
import com.lib.funsdk.support.models.FunDevice
import com.lib.funsdk.support.widget.FunVideoView
import com.lib.sdk.struct.OPRemoveFileJP
import com.xm.ui.widget.ButtonCheck
import com.xm.ui.widget.ButtonCheck.OnButtonClickListener
import kotlinx.android.synthetic.main.activity_play_url.*
import java.text.SimpleDateFormat
import java.util.*

open class PlayUrlActivity : ActivityDemo(), OnPreparedListener, OnErrorListener, View.OnClickListener,
    SeekBar.OnSeekBarChangeListener {
    private var funDevice: FunDevice? = null
//    private var userId = 0
    private var playHandle = 0
    private var mVideoView: FunVideoView? = null
    private val MESSAGE_REFRESH_PROGRESS = 0x100
    private val MESSAGE_SEEK_PROGRESS = 0x101
    private val MESSAGE_SET_IMAGE = 0x102

    private var MaxProgress = 0
    private val mPosition = 0
    private val mOPRemoveFileJP: OPRemoveFileJP? = null
    private val btnPlayState: ButtonCheck? = null

//    private val mRecordByFileAdapter: DeviceCameraRecordFileAdapter? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play_url)
        initView()
        initData()
    }

    private fun initData() {
        val intent = intent
        if (intent == null) {
            finish()
            return
        }
//        userId = FunSDK.GetId(userId, this)
    }

    private fun initView() {
        mVideoView = findViewById<FunVideoView>(R.id.funRecVideoView)
        mVideoView!!.setOnPreparedListener(this)
        mVideoView!!.setOnErrorListener(this)

        //播放和暂停
        btn_play.setOnButtonClick(OnButtonClickListener { buttonCheck, b ->
            if (mVideoView!!.isPlaying) {
                mVideoView!!.pause()
            } else {
                mVideoView!!.resume()
            }
            true
        })
        btn_link_1.setOnClickListener(this)
        btn_link_2.setOnClickListener(this)
        btn_link_3.setOnClickListener(this)
        btn_link_4.setOnClickListener(this)

        videoProgressSeekBar.setOnSeekBarChangeListener(this)
    }

    private fun playRecordVideoByURL(url: String) {
        mVideoView!!.stopPlayback()
        mVideoView!!.playRecordByURL(
            url
        )
        mVideoView!!.setMediaSound(true)
        refreshPlayInfo()
    }

    override fun onPrepared(mp: MediaPlayer?) {
        refreshPlayInfo()
        val path = mVideoView!!.captureImage(null)
        val message = Message.obtain()
        message.what = MESSAGE_SET_IMAGE
        message.obj = path
//        mHandler.sendMessageDelayed(message, 200)
        btn_play.btnValue = 1
    }

    override fun onError(mp: MediaPlayer?, what: Int, extra: Int): Boolean {
        showToast(
            resources.getString(R.string.media_play_error) + " : "
                    + FunError.getErrorStr(extra)
        )
        return true
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_link_1 -> {
                playRecordVideoByURL("http://42.118.242.152:3000/mp4/1579264144253.mp4")
            }
            R.id.btn_link_2 -> {
                playRecordVideoByURL("http://42.118.242.189:3000/1572090299620.mp4")
            }
            R.id.btn_link_3 -> {
                playRecordVideoByURL("http://42.118.242.152:3000/motion/motion.h264")
            }
            R.id.btn_link_4 -> {
                playRecordVideoByURL("http://42.118.242.189:3001/14.32.26-14.32.57[M][@332a][0].h264")
            }
        }
    }

    private fun refreshPlayInfo() {
//        if (byFile) {
//            mSeekBar.setEnabled(false);
//        } else {
//            mSeekBar.setEnabled(true);
//        }
        val startTm = mVideoView!!.startTime
        val endTm = mVideoView!!.endTime
        MaxProgress = endTm - startTm
        Log.i("startTm", "TTTT----$startTm")
        Log.i("endTm", "TTTT----$endTm")
        Log.i("MaxProgress", "TTT----$MaxProgress")
        if (startTm > 0 && endTm > startTm) {
            val sdf = SimpleDateFormat("HH:mm:ss", Locale.ENGLISH)
            videoProgressCurrentTime.text = sdf.format(Date(startTm.toLong() * 1000))
            videoProgressDurationTime.text = sdf.format(Date(endTm.toLong() * 1000))
            videoProgressSeekBar.max = endTm - startTm
            videoProgressSeekBar.progress = 0
            videoProgressArea.visibility = View.VISIBLE
            resetProgressInterval()
        } else {
//            videoProgressArea.visibility = View.GONE
            cleanProgressInterval()
        }
    }

    private fun resetProgressInterval() {
        if (null != mHandler) {
            mHandler!!.removeMessages(MESSAGE_REFRESH_PROGRESS)
            mHandler!!.sendEmptyMessageDelayed(MESSAGE_REFRESH_PROGRESS, 500)
        }
    }

    private fun cleanProgressInterval() {
        mHandler?.removeMessages(MESSAGE_REFRESH_PROGRESS)
    }

    private var mHandler: Handler? = object : Handler() {
        override fun handleMessage(msg: Message) {
            when (msg.what) {
                MESSAGE_REFRESH_PROGRESS -> {
                    refreshProgress()
                    resetProgressInterval()
                }
                MESSAGE_SEEK_PROGRESS -> {
                    seekRecordVideo(msg.arg1)
                }
                MESSAGE_SET_IMAGE -> {
//                    if (mRecordByFileAdapter != null) {
//                        mRecordByFileAdapter.setBitmapTempPath(msg.obj as String)
//                    }
                }
            }
        }
    }

    private fun refreshProgress() {
        val posTm = mVideoView!!.position
        if (posTm > 0) {
            val sdf = SimpleDateFormat("HH:mm:ss", Locale.ENGLISH)
            videoProgressCurrentTime.text = sdf.format(Date(posTm.toLong() * 1000))
            Log.i("TTTT", "TTTT----" + sdf.format(Date(posTm.toLong() * 1000)))
            videoProgressSeekBar.setProgress(posTm - mVideoView!!.startTime)
        }
    }

    private fun seekRecordVideo(progress: Int) {
        if (null != mVideoView) {
            val seekPos = mVideoView!!.startTime + progress
            mVideoView!!.seek(seekPos)
        }
    }

    override fun onDestroy() {


        // 停止视频播放
        if (null != mVideoView) {
            mVideoView!!.stopPlayback()
        }

        // 5. 退出注销监听

        if (null != mHandler) {
            mHandler!!.removeCallbacksAndMessages(null)
            mHandler = null
        }

        super.onDestroy()
    }

    override fun onProgressChanged(
        seekBar: SeekBar?, progress: Int,
        fromUser: Boolean
    ) {
        if (fromUser) {
            if (null != mHandler) {
                mHandler!!.removeMessages(MESSAGE_SEEK_PROGRESS)
                val msg = Message()
                msg.what = MESSAGE_SEEK_PROGRESS
                msg.arg1 = progress
                mHandler!!.sendMessageDelayed(msg, 300)
            }
        }
    }

    override fun onStartTrackingTouch(seekBar: SeekBar?) {
        //TODO("Not yet implemented")
    }

    override fun onStopTrackingTouch(seekBar: SeekBar?) {
        //TODO("Not yet implemented")
    }
}
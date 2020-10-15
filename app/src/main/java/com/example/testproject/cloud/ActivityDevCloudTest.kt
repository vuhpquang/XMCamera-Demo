package com.example.testproject.cloud

import android.content.Intent
import android.os.Bundle
import android.os.Message
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testproject.LoginActivity
import com.example.testproject.R
import com.lib.EUIMSG
import com.lib.FunSDK
import com.lib.IFunSDKResult
import com.lib.MsgContent
import com.lib.cloud.CloudDirectory
import com.lib.funsdk.support.FunSupport
import com.lib.funsdk.support.models.FunDevice
import com.lib.sdk.bean.cloudmedia.CloudMediaDatesBean
import com.lib.sdk.bean.cloudmedia.CloudMediaDatesBean.CloudDate
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class ActivityDevCloudTest : AppCompatActivity(), View.OnClickListener, IFunSDKResult {
    private lateinit var rcCloudDate: RecyclerView
    private lateinit var ivPreDate: ImageView
    private lateinit var ivNextDate: ImageView
    private lateinit var tvDate: TextView
    private lateinit var calendar: Calendar
    private lateinit var format: SimpleDateFormat
    private var userId: Int = 0
    private lateinit var funDevice: FunDevice
    private var cloudDates: MutableList<CloudDate>? = null
    private lateinit var adapter: CloudDateAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dev_cloud_test)
        initView()
        initData()
    }

    private fun initView() {

        rcCloudDate = findViewById(R.id.rc_cloud_date)
        ivPreDate = findViewById<ImageView>(R.id.pre_date_iv)
        ivNextDate = findViewById<ImageView>(R.id.next_date_iv)
        tvDate = findViewById<TextView>(R.id.date_select_tv)

        ivPreDate.setOnClickListener(this)
        ivNextDate.setOnClickListener(this)

        rcCloudDate.layoutManager = LinearLayoutManager(this)
        if (!FunSupport.getInstance().hasLogin()) {
            startLogin()
        }
    }

    private fun startLogin() {
        val intent = Intent()
        intent.setClass(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun initData() {
        val intent = intent
        if (intent == null) {
            finish()
            return
        }
        val devId = intent.getIntExtra("FUN_DEVICE_ID", -1662663230) //Default value is exact device
//        val devSn = "5af6b3254f2d1a41"
        if (FunSupport.getInstance().findDeviceById(devId) == null
            || !FunSupport.getInstance().hasLogin()
        ) {
            startLogin()
        }
        funDevice = FunSupport.getInstance().findDeviceById(devId)
        userId = FunSDK.GetId(userId, this)
        calendar = Calendar.getInstance()
        format = SimpleDateFormat("yyyy-MM")
        tvDate.setText(format.format(calendar.getTime()))
        adapter = CloudDateAdapter()
        rcCloudDate.adapter = adapter

        searchCloudByMonth();
    }

    private fun searchCloudByMonth() {
        val times = FunSDK.ToTimeType(
            intArrayOf(
                calendar[Calendar.YEAR],
                calendar[Calendar.MONTH] + 1,
                calendar[Calendar.DAY_OF_MONTH], 0, 0, 0
            )
        )
//        Toast.makeText(this, "times: " + times, Toast.LENGTH_SHORT).show()
        CloudDirectory.SearchMediaByMoth(userId, funDevice.getDevSn(), 0, "Main", times, 0)
//        synchronized(calendar) {
//            val times = FunSDK.ToTimeType(
//                intArrayOf(
//                    calendar[Calendar.YEAR],
//                    calendar[Calendar.MONTH] + 1,
//                    calendar[Calendar.DAY_OF_MONTH], 0, 0, 0
//                )
//            )
//            CloudDirectory.SearchMediaByMoth(userId, funDevice.getDevSn(), 0, "Main", times, 0)
//        }
    }


    private inner class CloudDateAdapter : RecyclerView.Adapter<CloudDateAdapter.ViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            return ViewHolder(
                LayoutInflater.from(this@ActivityDevCloudTest)
                    .inflate(R.layout.item_simple_list, null)
            )
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val cloudDate: CloudDate = cloudDates!![position]
            if (cloudDate != null) {
                holder.tvDate.text = cloudDate.time
            }
            holder.itemView.setOnClickListener {
                try {
                    format = SimpleDateFormat("yyyy-MM-dd")
                    val data: Date = format.parse(cloudDate.time)
                    Toast.makeText(this@ActivityDevCloudTest, "Data: " + data, Toast.LENGTH_SHORT).show()
                    val intent = Intent( this@ActivityDevCloudTest,ActivityDevCloudPlayBack::class.java)
                    intent.putExtra("year", data.getYear() + 1900);
                    intent.putExtra("month", data.getMonth());
                    intent.putExtra("day", data.getDate());
                    intent.putExtra("FUN_DEVICE_ID", funDevice.id);
                    startActivity(intent);
                } catch (e: ParseException) {
                    e.printStackTrace()
                }
            }
        }

        override fun getItemCount(): Int {
            return if (cloudDates != null) cloudDates!!.size else 0
        }

        inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            var tvDate: TextView

            init {
                tvDate = itemView.findViewById(R.id.tv_item_name)
            }
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.pre_date_iv -> {
                calendar.add(Calendar.MONTH, -1)
                format = SimpleDateFormat("yyyy-MM")
                tvDate.text = format.format(calendar.time)
                searchCloudByMonth()
            }
            R.id.next_date_iv -> {
                calendar.add(Calendar.MONTH, +1)
                format = SimpleDateFormat("yyyy-MM")
                tvDate.text = format.format(calendar.time)
                searchCloudByMonth()
            }
        }
    }

    override fun OnFunSDKResult(message: Message, msgContent: MsgContent): Int {
        if (message.what == EUIMSG.MC_SearchMediaByMoth) {
            val cloudMediaDatesBean = CloudMediaDatesBean()
            cloudMediaDatesBean.parseJson(msgContent.str)
            cloudDates = cloudMediaDatesBean.dateTimes
            adapter.notifyDataSetChanged()
        }
        return 0
    }

    fun openCloudServer(view: View?) {
//        Intent it = new Intent(this, CloudWebActivity.class);
//        it.putExtra("FUN_DEVICE_ID",funDevice.getId());
//        if (cloudDates != null && !cloudDates.isEmpty()) {
//            it.putExtra("searchDate",cloudDates.get(0).getTime());
//        }
//        startActivity(it);
    }
}
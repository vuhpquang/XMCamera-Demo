package com.example.testproject.camera

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.SparseArray
import android.view.SurfaceHolder
import android.view.SurfaceView
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.example.testproject.R
import com.google.android.gms.vision.CameraSource
import com.google.android.gms.vision.Detector
import com.google.android.gms.vision.barcode.Barcode
import com.google.android.gms.vision.barcode.BarcodeDetector
import java.io.IOException


class ScanQrActivity : AppCompatActivity() {
    private val REQUEST_CAMERA = 1
    private lateinit var mCameraPreview: SurfaceView
    private lateinit var mBarcodeDetector: BarcodeDetector
    private lateinit var mCameraSource: CameraSource

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
        setContentView(R.layout.activity_scan_qr)
        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)


        mCameraPreview = findViewById(R.id.camera_view)

        mBarcodeDetector = BarcodeDetector.Builder(this).setBarcodeFormats(Barcode.QR_CODE).build()

        mCameraSource = CameraSource.Builder(this, mBarcodeDetector).setFacing(
            CameraSource.CAMERA_FACING_BACK
        )
            .setRequestedFps(35.0f)
            .setAutoFocusEnabled(true)
            .build()


        mCameraPreview.holder.addCallback(object : SurfaceHolder.Callback {
            override fun surfaceCreated(surfaceHolder: SurfaceHolder) {
                try {
                    if (ActivityCompat.checkSelfPermission(
                            this@ScanQrActivity,
                            Manifest.permission.CAMERA
                        ) != PackageManager.PERMISSION_GRANTED
                    ) {
                        // TODO: Consider calling
                        //    ActivityCompat#requestPermissions
                        // here to request the missing permissions, and then overriding
                        //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                        //                                          int[] grantResults)
                        // to handle the case where the user grants the permission. See the documentation
                        // for ActivityCompat#requestPermissions for more details.
                        return
                    }
                    mCameraSource.start(mCameraPreview.holder)
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }

            override fun surfaceChanged(surfaceHolder: SurfaceHolder, i: Int, i1: Int, i2: Int) {}
            override fun surfaceDestroyed(surfaceHolder: SurfaceHolder) {
                mCameraSource.stop()
            }
        })

        mBarcodeDetector.setProcessor(object : Detector.Processor<Barcode> {
            override fun release() {}
            override fun receiveDetections(detections: Detector.Detections<Barcode?>) {
                val barcodes: SparseArray<Barcode?>? = detections.detectedItems
                if (barcodes != null && barcodes.size() > 0) {
                    Toast.makeText(
                        this@ScanQrActivity, "Hello: " + barcodes.valueAt(0)?.displayValue,
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        })
    }
}
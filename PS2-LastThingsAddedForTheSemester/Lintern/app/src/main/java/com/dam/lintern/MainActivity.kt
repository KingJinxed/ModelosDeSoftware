package com.dam.lintern


import android.R
import android.content.Context
import android.hardware.camera2.CameraAccessException
import android.hardware.camera2.CameraManager
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    protected override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn = findViewById(R.id.button) as Button
        val imageView = findViewById(R.id.imageView) as ImageView

        val cameraManager = getSystemService(Context.CAMERA_SERVICE) as CameraManager
        val cameraId = arrayOf<String?>(null)

        val encendido = booleanArrayOf(false)

        btn.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                //todo lo que pongas aquí va a hacerse cuando presiones el botón

                if (!encendido[0]) {
                    try {
                        cameraId[0] = cameraManager.getCameraIdList()[0]
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                            cameraManager.setTorchMode(
                                cameraId[0]!!,
                                true
                            ) //el true hace que nuestra linterna se encienda
                            imageView.setImageResource(R.drawable.off)
                            encendido[0] = true
                        }
                    } catch (e: CameraAccessException) {
                        e.printStackTrace()
                    }
                } else {
                    try {
                        cameraId[0] = cameraManager.getCameraIdList()[0]
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                            cameraManager.setTorchMode(
                                cameraId[0]!!,
                                false
                            ) //el false hace que nuestra linterna se apague
                            imageView.setImageResource(R.drawable.on)
                            encendido[0] = false
                        }
                    } catch (e: CameraAccessException) {
                        e.printStackTrace()
                    }
                }
            }
        })
    }
}
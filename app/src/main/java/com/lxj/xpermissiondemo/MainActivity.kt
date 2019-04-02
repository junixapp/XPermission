package com.lxj.xpermissiondemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.lxj.xpermission.PermissionConstants
import com.lxj.xpermission.XPermission
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_storage.setOnClickListener {
            XPermission.create(this, PermissionConstants.STORAGE)
                .callback(object : XPermission.SimpleCallback{
                    override fun onGranted() {
                        toast("获取到了storage权限")
                    }
                    override fun onDenied() {
                        toast("获取storage权限失败！！！")
                    }
                })
                .request()
        }

        btn_write_setting.setOnClickListener {
            XPermission.create(this).requestWriteSettings(object : XPermission.SimpleCallback{
                override fun onGranted() {
                    toast("获取到了写入Setting权限")
                }

                override fun onDenied() {
                    toast("获取写入Setting权限失败！！！")
                }

            })
        }

        btn_overlay.setOnClickListener {
            XPermission.create(this).requestDrawOverlays(object : XPermission.SimpleCallback{
                override fun onGranted() {
                    toast("获取到了Overlay权限")
                }

                override fun onDenied() {
                    toast("获取Overlay权限失败！！！")
                }

            })
        }
        btn_permissions.setOnClickListener {
            XPermission.create(this).launchAppDetailsSettings()
        }


    }

    fun toast(msg: String){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}

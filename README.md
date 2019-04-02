# XPermission
一行代码进行权限申请，用回调处理结果，轻量无依赖！从androidUtilsCode的PermissionUtil改良而来，适配全面屏！

## Demo
![](/screenshot/demo.gif)


## 使用
首先添加依赖：
```groovy
implementation 'com.lxj:xpermission:0.0.1'
```

- 申请权限
```kotlin
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
```

- 申请修改Setting权限
```kotlin
XPermission.create(this).requestWriteSettings(object : XPermission.SimpleCallback{
            override fun onGranted() {
                toast("获取到了写入Setting权限")
            }

            override fun onDenied() {
                toast("获取写入Setting权限失败！！！")
            }

        })
```

- 申请Overlay权限
```kotlin
XPermission.create(this).requestDrawOverlays(object : XPermission.SimpleCallback{
            override fun onGranted() {
                toast("获取到了Overlay权限")
            }

            override fun onDenied() {
                toast("获取Overlay权限失败！！！")
            }

        })
```

- 启动权限详情界面
```kotlin
XPermission.create(this).launchAppDetailsSettings()
```

package com.wl.kaiyanmvvm

import android.content.Context
import com.kingja.loadsir.callback.SuccessCallback
import com.kingja.loadsir.core.LoadSir
import com.tencent.mmkv.MMKV
import com.wl.kaiyanmvvm.app.weight.loadCallBack.EmptyCallback
import com.wl.kaiyanmvvm.app.weight.loadCallBack.ErrorCallback
import com.wl.kaiyanmvvm.app.weight.loadCallBack.LoadingCallback
import me.hgj.jetpackmvvm.BaseApp
import kotlin.properties.Delegates

/**
 * @author: bruce
 * @project: KaiyanMvvm
 * @package: com.wl.kaiyanmvvm
 * @description: https://github.com/hegaojian/JetpackMvvm
 * @date: 2020/6/5
 * @time:  16:34
 */
class App : BaseApp() {

    companion object{
      var CONTEXT : Context by Delegates.notNull()
    }

    override fun onCreate() {
        super.onCreate()
        CONTEXT=applicationContext

        //保存sp数据位置
        MMKV.initialize(this.filesDir.absolutePath + "/mmkv")

        //界面加载管理 初始化
        LoadSir.beginBuilder()
            .addCallback(LoadingCallback())//加载
            .addCallback(ErrorCallback())//错误
            .addCallback(EmptyCallback())//空
            .setDefaultCallback(SuccessCallback::class.java)//设置默认加载状态页
            .commit()

    }

}
package com.wl.kaiyanmvvm.app.weight.loadCallBack


import com.kingja.loadsir.callback.Callback
import com.wl.kaiyanmvvm.R


class ErrorCallback : Callback() {

    override fun onCreateView(): Int {
        return R.layout.layout_error
    }
}

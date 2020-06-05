package com.wl.kaiyanmvvm.ui.splash

import android.content.ClipData.newIntent
import android.content.Intent
import android.graphics.Typeface
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.AnimationSet
import android.view.animation.ScaleAnimation
import androidx.core.os.HandlerCompat.postDelayed
import com.wl.kaiyanmvvm.MainActivity
import com.wl.kaiyanmvvm.R
import com.wl.kaiyanmvvm.app.base.BaseActivity
import com.wl.kaiyanmvvm.databinding.ActivitySplashBinding
import kotlinx.android.synthetic.main.activity_splash.*
import me.hgj.jetpackmvvm.BaseViewModel

/**
 * @author: bruce
 * @project: KaiyanMvvm
 * @package: com.wl.kaiyanmvvm.ui.splash
 * @description: 启动页
 * @date: 2020/6/5
 * @time:  16:40
 */
class SplashActivity : BaseActivity<BaseViewModel, ActivitySplashBinding>(){
    override fun layoutId(): Int {
        return R.layout.activity_splash
    }

    override fun initView() {
        val font : Typeface = Typeface.createFromAsset(this.assets,"fonts/Lobster-1.4.otf")
        tv_name_english.typeface = font
        tv_english_intro.typeface = font
    }

    override fun createObserver() {
        setAnimation()
    }

    private fun setAnimation() {
        val alphaAnimation = AlphaAnimation(0.1f,1.0f)
        alphaAnimation.duration = 2000
        val scaleAnimation = ScaleAnimation(0.1f,1.0f,0.1f,1.0f,
            ScaleAnimation.RELATIVE_TO_SELF,0.5f,
            ScaleAnimation.RELATIVE_TO_SELF,0.5f)
        scaleAnimation.duration =2000
        val animationSet = AnimationSet(true)
        animationSet.addAnimation(alphaAnimation)
        animationSet.addAnimation(scaleAnimation)
        animationSet.duration = 2000
        iv_icon_splash.startAnimation(animationSet)
        animationSet.setAnimationListener(object : Animation.AnimationListener{
            override fun onAnimationRepeat(animation: Animation?) {

            }

            override fun onAnimationStart(animation: Animation?) {

            }

            override fun onAnimationEnd(animation: Animation?) {
                startActivity(Intent(this@SplashActivity, MainActivity::class.java))
                finish()
                //带点渐变动画
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            }
        })
    }

}
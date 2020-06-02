package com.example.glide

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val option = RequestOptions()
            .placeholder(R.drawable.google)  // 加載時的圖片
            .error(R.drawable.error)   // 加載錯誤時的圖片
            .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC) //

        Glide.with(this)
            .load("https://i.imgur.com/nuhO4UU.jpeg")
            .apply(option)  // 可重複呼叫 衝突時採用最後宣告的
            .listener(mRequestlistener) //監聽
            .into(imageView)  //.submit() 可以阻塞線程


    }


}

object mRequestlistener : RequestListener<Drawable> {

    override fun onResourceReady(
        resource: Drawable?,
        model: Any?,
        target: Target<Drawable>?,
        dataSource: DataSource?,
        isFirstResource: Boolean
    ): Boolean {

        return true
    }

    override fun onLoadFailed(
        e: GlideException?,
        model: Any?,
        target: Target<Drawable>?,
        isFirstResource: Boolean
    ): Boolean {
        Log.d("error", "" + e?.printStackTrace())
        return false
    }


}




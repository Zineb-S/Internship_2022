package com.example.cmcapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class CarModelActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_car_model)

        val BrandDetailsImg = findViewById<ImageView>(R.id.BrandDetailsImageView)
        val BrandNameDetailsTxt = findViewById<TextView>(R.id.BrandNameDetailsTextView)
        val CarModelImg = findViewById<ImageView>(R.id.ModelCarImageView)
        val CarModelTxt = findViewById<TextView>(R.id.ModelCarTextView)
        val brandPic = intent.getIntExtra("BrandImage",0)
        val brandName = intent.getStringExtra("BrandName")

        BrandNameDetailsTxt.text = brandName
        BrandDetailsImg.setImageResource(brandPic)


        CarModelImg.setOnClickListener {
            val goToBrandModels = Intent(this@CarModelActivity, HomePageActivity::class.java)


            startActivity(goToBrandModels)
        }

    }
}
package com.example.cmcapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CarBrandActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        displayBrands()
    }

    private fun displayBrands() {
        val recyclerView = findViewById<RecyclerView>(R.id.brandsRecyclerView)
        recyclerView.layoutManager = GridLayoutManager(applicationContext, 3)


        val brand1 = Brand("Audi", R.drawable.audi)
        val brand2 = Brand("Chevrolet", R.drawable.chevrolet)
        val brand3 = Brand("Dacia", R.drawable.dacia)
        val brand4 = Brand("Fiat", R.drawable.fiat)
        val brand5 = Brand("Ford", R.drawable.ford)
        val brand6 = Brand("Honda", R.drawable.honda)
        val brand7 = Brand("Hyundai", R.drawable.hyundai)
        val brand8 = Brand("Kia", R.drawable.kia)
        val brand9 = Brand("Peugeot", R.drawable.peugeot)
        val brand10 = Brand("Toyota", R.drawable.toyota)
        val brand11 = Brand("Volvo", R.drawable.volvo)

        brandList.add(brand1)
        brandList.add(brand2)
        brandList.add(brand3)
        brandList.add(brand4)
        brandList.add(brand5)
        brandList.add(brand6)
        brandList.add(brand7)
        brandList.add(brand8)
        brandList.add(brand9)
        brandList.add(brand10)
        brandList.add(brand11)
        brandList.add(brand2)
        brandList.add(brand3)
        brandList.add(brand4)
        brandList.add(brand5)
        brandList.add(brand1)
        val brandAdapter = BrandAdapter(brandList)

        brandAdapter.setOnItemClickListener(object : BrandAdapter.OnItemClickListener {
            override fun onItemClick(position: Int) {
                println("here")
                val goToBrandModels = Intent(this@CarBrandActivity, CarModelActivity::class.java)
                goToBrandModels.putExtra("BrandName", brandList[position].BrandName)
                goToBrandModels.putExtra("BrandImage", brandList[position].BrandImage)

                startActivity(goToBrandModels)


            }

        })
        // assign the adapter to the recycler view
        runOnUiThread {
            recyclerView.adapter = brandAdapter


        }
    }
}
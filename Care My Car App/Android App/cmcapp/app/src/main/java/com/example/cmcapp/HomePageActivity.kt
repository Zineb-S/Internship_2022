package com.example.cmcapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.replace
import com.example.cmcapp.databinding.ActivityHomePageBinding
import com.example.cmcapp.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView
import com.google.android.material.navigation.NavigationView

class HomePageActivity : AppCompatActivity() {
    private lateinit var binding : ActivityHomePageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomePageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(Parts())


       binding.bottomNavigationView.setOnItemSelectedListener {

           when(it.itemId){
               R.id.parts -> replaceFragment(Parts())
               R.id.services -> replaceFragment(Servicces())
               R.id.reservations -> replaceFragment(Reservations())
               R.id.account -> replaceFragment(Account())
               else     -> {}
           }
           true

       }
    }

    private fun replaceFragment(fragment: Fragment){

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout,fragment)
        fragmentTransaction.commit()
        }
}
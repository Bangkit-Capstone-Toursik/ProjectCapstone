package com.bangkit.tursik

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.bangkit.tursik.databinding.ActivityMainBinding
import com.bangkit.tursik.ui.fragment.explore.ExploreFragment
import com.bangkit.tursik.ui.fragment.home.HomeFragment
import com.bangkit.tursik.ui.fragment.people.PeopleFragment
import com.bangkit.tursik.ui.fragment.wishlist.WishlistFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(HomeFragment())



        binding.navigation.setOnItemSelectedListener{

            when(it.itemId){
                R.id.fr_home -> replaceFragment(HomeFragment())
                R.id.fr_explore -> replaceFragment(ExploreFragment())
                R.id.fr_wishlist -> replaceFragment(WishlistFragment())
                R.id.fr_people -> replaceFragment(PeopleFragment())

                else ->{

                }
            }
            true
        }
    }

    private fun replaceFragment(fragment : Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.buttom_nav,fragment)
        fragmentTransaction.commit()
    }
}
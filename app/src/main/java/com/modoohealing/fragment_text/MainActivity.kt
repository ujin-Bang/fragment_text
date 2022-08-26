package com.modoohealing.fragment_text

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.modoohealing.fragment_text.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        val homeFragment = HomeFragment()
        val moreFragment = MoreFragment()
        val myPageFragment = MyPageFragment()
        val usersFragment = UsersFragment()
        binding.bottomNavi.setOnItemSelectedListener {
            when(it.itemId){
                R.id.home -> changeFragment(homeFragment)
                    R.id.users -> changeFragment(moreFragment)
                R.id.myPage -> changeFragment(myPageFragment)
                R.id.seeMore -> changeFragment(usersFragment)
            }
            true
        }

    }
    fun changeFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }
}
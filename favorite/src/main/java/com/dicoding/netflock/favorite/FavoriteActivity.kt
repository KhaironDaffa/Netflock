package com.dicoding.netflock.favorite

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dicoding.netflock.favorite.databinding.ActivityFavoriteBinding

class FavoriteActivity : AppCompatActivity() {

    private lateinit var favoriteBinding: ActivityFavoriteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        favoriteBinding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(favoriteBinding.root)

        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        favoriteBinding.viewPager.adapter = sectionsPagerAdapter
        favoriteBinding.tabs.setupWithViewPager(favoriteBinding.viewPager)

        supportActionBar?.elevation = 0f
    }
}
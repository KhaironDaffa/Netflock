package com.dicoding.netflock

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import com.dicoding.netflock.databinding.ActivityHomeBinding
import com.dicoding.netflock.movies.MoviesFragment
import com.dicoding.netflock.tvshow.TvShowFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activityHomeBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(activityHomeBinding.root)

        val moviesFragment = MoviesFragment()
        val tvShowFragment = TvShowFragment()

        makeCurrentFragment(moviesFragment)

        activityHomeBinding.bottomNav.setOnItemSelectedListener { id ->
            when (id) {
                R.id.navMovies -> makeCurrentFragment(moviesFragment)
                R.id.navShows -> makeCurrentFragment(tvShowFragment)
            }
        }

        supportActionBar?.elevation = 0f
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
    }

    private fun makeCurrentFragment(fragment: Fragment) {

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flWrapper, fragment)
            commit()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_options, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.menuFavorite -> {
                val uri = Uri.parse("netflock://favorite")
                startActivity(Intent(Intent.ACTION_VIEW, uri))
            }
        }

        return true
    }
}
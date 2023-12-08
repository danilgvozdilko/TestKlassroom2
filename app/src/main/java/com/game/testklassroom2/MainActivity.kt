package com.game.testklassroom2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.game.testklassroom2.databinding.ActivityMainBinding
import com.game.testklassroom2.ui.MenuFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        openFragment()
    }

    private fun openFragment() {
        val fragment = MenuFragment()
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.container_fragment, fragment).commit()
    }

}
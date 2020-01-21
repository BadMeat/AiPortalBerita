package com.dolan.aiportalberita

import android.os.Bundle
import android.view.Menu
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.setupWithNavController
import com.leinardi.android.speeddial.SpeedDialActionItem
import com.leinardi.android.speeddial.SpeedDialView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), SpeedDialView.OnActionSelectedListener {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//
//        speed_dial.addActionItem(
//            SpeedDialActionItem.Builder(R.id.berandaFragment, R.drawable.ic_broken_image).create()
//        )
//
//        speed_dial.setOnActionSelectedListener(this)

        navController = Navigation.findNavController(this, R.id.fragment)
//        nav_bot.setupWithNavController(navController)
//        NavigationUI.setupActionBarWithNavController(this, navController)

//        val fragment =
//            supportFragmentManager.findFragmentById(R.id.berandaFragment) as BerandaFragment
//        fragment.stopTimer()
    }

    //
//    override fun onSupportNavigateUp(): Boolean {
//        return NavigationUI.navigateUp(navController, null)
//
//    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_search, menu)
        return super.onCreateOptionsMenu(menu)
    }

    fun showNavigation() {
//        nav_bot.visible()
    }

    fun hideNavigation() {
//        nav_bot.invisible()
    }

    fun hideToolbar() {
        supportActionBar?.hide()
    }

    fun showToolbar() {
        supportActionBar?.show()
    }

    override fun onActionSelected(actionItem: SpeedDialActionItem?): Boolean {
        when (actionItem?.id) {
            R.id.berandaFragment -> {
                Toast.makeText(this, "HALOOO", Toast.LENGTH_SHORT).show()
                return true
            }
        }
        return false
    }
}

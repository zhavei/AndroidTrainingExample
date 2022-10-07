package com.syafei.chapter5binartask

import android.content.Intent
import android.content.IntentFilter
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import com.syafei.chapter5binartask.broadcastReceiver.AirPlaneModeChangedReciver
import com.syafei.chapter5binartask.databinding.ActivityMainBinding
import com.syafei.chapter5binartask.fragment.FragmentTwo

class MainActivity : AppCompatActivity(), Communicator {
    lateinit var binding: ActivityMainBinding
    private lateinit var bottomNavigationView: BottomNavigationView
    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView
    lateinit var receiver: AirPlaneModeChangedReciver

    private lateinit var listener: NavController.OnDestinationChangedListener

    companion object {
        val KEY_FRAGSECOND = "fragment_second"
        val KEY_IMAGE = "image-key"
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //broadcast receiver on airplanemode Changed
        onAirPlaneModeChanged()

        //setupWithNavController
        drawerLayout = binding.drawerLayout
        bottomNavigationView = binding.bottomNavigationView
        navigationView = binding.navigationviewDrawer
        navController = findNavController(R.id.fragment_container_view)

        //appBarConfigForBottomNavigation
        appBarConfiguration = AppBarConfiguration(
            setOf
                (
                R.id.firstFragment,
                R.id.secondFragment,
                R.id.tridhFragment
            )
        )

        //setupAppbar for drawerlayout
        appBarConfiguration = AppBarConfiguration(navController.graph, drawerLayout)
        navigationView.setupWithNavController(navController)

        //for bottom navigation
        bottomNavigationView.setupWithNavController(navController)

        //actionbar
        setupActionBarWithNavController(navController, appBarConfiguration)

        listener =
            NavController.OnDestinationChangedListener { controller, destination, arguments ->
                if (destination.id == R.id.secondFragment) {
                    supportActionBar?.setBackgroundDrawable(ColorDrawable(getColor(R.color.purple_500)))
                } else if (destination.id == R.id.fragmentTwo2) {
                    supportActionBar?.setBackgroundDrawable(ColorDrawable(getColor(android.R.color.holo_green_dark)))
                }
            }
    }

    private fun onAirPlaneModeChanged() {
        receiver = AirPlaneModeChangedReciver()
        IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED).also {
            registerReceiver(receiver, it)
        }
    }

    /*override fun editextData(editextData: String) {
        *//*val bundle = Bundle()
        bundle.putString(KEY_FRAGSECOND, editextData)*//*

        val transaction = this.supportFragmentManager.beginTransaction()
        val fragmentTwo = FragmentTwo()

        //fragmentTwo.arguments = bundle

        fragmentTwo.arguments = bundleOf(
            KEY_FRAGSECOND to editextData,
            KEY_IMAGE to R.drawable.gunung
        )

        // to pass data to fragment B and open it
        transaction.replace(R.id.fragmentSecond, fragmentTwo).commit()
    }*/

    override fun editextData(editextData: String, imageView: Int) {
        /*val bundle = Bundle()
        bundle.putString(KEY_FRAGSECOND, editextData)*/

        val transaction = this.supportFragmentManager.beginTransaction()
        val fragmentTwo = FragmentTwo()

        //fragmentTwo.arguments = bundle
        fragmentTwo.arguments = bundleOf(
            KEY_FRAGSECOND to editextData,
            KEY_IMAGE to R.drawable.gunung
        )

        // to pass data to fragment fragmentTwo and open it a.k.a replace view fragment
        transaction.replace(R.id.fragmentSecond, fragmentTwo).commit()
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.fragment_container_view)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    override fun onResume() {
        super.onResume()
        navController.addOnDestinationChangedListener(listener)
        Toast.makeText(this, "MainActivity Resumed", Toast.LENGTH_SHORT).show()
    }

    override fun onPause() {
        super.onPause()
        navController.removeOnDestinationChangedListener(listener)
        Toast.makeText(this, "MainActivity Paused", Toast.LENGTH_SHORT).show()
    }

    override fun onStop() {
        super.onStop()
        onAirPlaneModeChanged()

        //handle memory leak on broadcast receiver
        unregisterReceiver(receiver)
    }
}
package com.utsman.binarapp1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.viewpager.widget.ViewPager
import com.utsman.binarapp1.fragment.AccountFragment
import com.utsman.binarapp1.fragment.HomeFragment

class MainActivity : AppCompatActivity() {

    companion object {
        // static constant
        const val INTENT_KEY = "key" // ini statis
        const val FRAGMENT_COUNT = "fragment_count"
    }
    override fun onStart() {
        super.onStart()
        println("binar main -------> onstart")
    }

    override fun onPause() {
        super.onPause()
        println("binar main -------> onpause")
    }

    override fun onResume() {
        super.onResume()
        println("binar main -------> onresume")
    }

    override fun onDestroy() {
        super.onDestroy()
        println("binar main -------> ondestroy")
    }

    private var fragmentCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        println("binar main -------> oncreate")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonIntent: Button = findViewById(R.id.btn_intent)
        buttonIntent.setOnClickListener {
            val intentChat = Intent(this, ChatActivity::class.java)
            val stringAnu = "anu"
            val bundle = bundleOf(INTENT_KEY to stringAnu) // ini hardcode
            intentChat.putExtras(bundle)
            startActivity(intentChat)
        }

        val buttonFragment: Button = findViewById(R.id.btn_fragment)
        buttonFragment.setOnClickListener {
            attachHomeFragment()
        }

        setupViewPager()


        val bundle = intent.extras
        val name = bundle?.getString("name")
        val age = bundle?.getInt("age")

        val tvBundleResult: TextView = findViewById(R.id.tv_bundle_result)
        tvBundleResult.text = name + " " + age.toString()

        tvBundleResult.setOnClickListener {
            val intent = Intent(this, ChatActivity::class.java)
            bundle?.let { intent.putExtras(it) }
            startActivity(intent)
        }
    }

    private fun attachHomeFragment() {
        val homeFragment = HomeFragment()
        homeFragment.arguments = bundleOf("fragment_count" to fragmentCount)

        val containerId = R.id.fragment_container
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(containerId, homeFragment)
        fragmentTransaction.commit()

        fragmentCount += 1
    }

    private fun setupViewPager() {
        val vpSlider: ViewPager = findViewById(R.id.vp_slider)
        val vpAdapter = SliderAdapter(supportFragmentManager)

        val homeFragment = HomeFragment()
        val accountFragment = AccountFragment()
        val fragmentList = listOf(
            homeFragment, accountFragment, AccountFragment(), AccountFragment(), AccountFragment(), AccountFragment(), AccountFragment(),
            AccountFragment()
        )
        vpAdapter.addFragmentList(fragmentList)
        vpSlider.adapter = vpAdapter
        vpSlider.offscreenPageLimit = 10

        // set posisi halaman
        //vpSlider.setCurrentItem(2, true)
    }

    override fun onStop() {
        super.onStop()
        println("binar main -------> onstop")
    }

    override fun onRestart() {
        super.onRestart()
        println("binar main -------> onrestart")
    }
}
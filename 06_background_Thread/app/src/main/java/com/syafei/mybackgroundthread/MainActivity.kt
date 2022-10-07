package com.syafei.mybackgroundthread

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.syafei.mybackgroundthread.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.concurrent.Executors

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val executor = Executors.newSingleThreadExecutor()
        val handler = Handler(Looper.getMainLooper())

        binding.btnStart.setOnClickListener {

            /*executor.execute {
                try {
                    for (i in 0..10) {
                        Thread.sleep(500)
                        val percentace = i * 10
                        handler.post {
                            if (percentace == 100) {
                                binding.tvStatus.setText(R.string.task_completed)
                            } else {
                                binding.tvStatus.text =
                                    String.format(getString(R.string.compressing), percentace)
                            }
                        }
                    }
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
            }*/

            lifecycleScope.launch(Dispatchers.Default) {
                try {
                    for (i in 0..10) {
                        delay(500)
                        val percentace = i * 10
                        withContext(Dispatchers.Main) {
                            if (percentace == 100) {
                                binding.tvStatus.setText(R.string.task_completed)
                            } else {
                                binding.tvStatus.text =
                                    String.format(getString(R.string.compressing), percentace)
                            }
                        }
                    }
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
            }
        }

    }
}
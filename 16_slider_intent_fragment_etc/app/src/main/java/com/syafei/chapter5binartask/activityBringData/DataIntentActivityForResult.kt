package com.syafei.chapter5binartask.activityBringData

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.syafei.chapter5binartask.databinding.ActivityDataIntentForResultBinding

class DataIntentActivityForResult : AppCompatActivity() {

    private var _binding: ActivityDataIntentForResultBinding? = null
    private lateinit var binding: ActivityDataIntentForResultBinding

    companion object {
        const val EXTRA_SELECTED_VALUE = "extra_selected_value"
        const val RESULT_CODE = 110
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityDataIntentForResultBinding.inflate(layoutInflater)
        binding = requireNotNull(_binding)
        setContentView(binding.root)

        getResult()
    }

    private fun getResult() {
        binding.run {
            btnDataIntentActivityResult.setOnClickListener {
                if (rgDataintentactivityforresult.checkedRadioButtonId > -1 ) { // -1 means empty selection radio button
                    var value = 0
                    when (rgDataintentactivityforresult.checkedRadioButtonId) {
                        rbDataIntentActivityResult1.id -> value = 50
                        rbDataIntentActivityResult2.id -> value = 100
                        rbDataIntentActivityResult3.id -> value = 150
                        rbDataIntentActivityResult4.id -> value = 200
                    }
                    val resulIntent = Intent()
                    resulIntent.putExtra(EXTRA_SELECTED_VALUE, value)
                    setResult(RESULT_CODE, resulIntent)
                    finish()
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
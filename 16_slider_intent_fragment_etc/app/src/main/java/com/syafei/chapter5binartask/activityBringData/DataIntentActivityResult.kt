package com.syafei.chapter5binartask.activityBringData

import android.content.Intent
import android.os.Bundle
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.syafei.chapter5binartask.databinding.ActivityDataIntentResultBinding

class DataIntentActivityResult : AppCompatActivity() {
    var _binding: ActivityDataIntentResultBinding? = null
    private lateinit var binding: ActivityDataIntentResultBinding

    private val resultLauncher: ActivityResultLauncher<Intent> = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == DataIntentActivityForResult.RESULT_CODE && result.data != null) {
            val selectedValue =
                result.data?.getIntExtra(DataIntentActivityForResult.EXTRA_SELECTED_VALUE, 0)
            binding.tvDataIntentActivityResult.text = "Hasil : $selectedValue"
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityDataIntentResultBinding.inflate(layoutInflater)
        binding = requireNotNull(_binding)
        setContentView(binding.root)

        binding.btnDataIntentActivityResult.setOnClickListener {
            val moveForResultIntent =
                Intent(this@DataIntentActivityResult, DataIntentActivityForResult::class.java)
            resultLauncher.launch(moveForResultIntent)
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}
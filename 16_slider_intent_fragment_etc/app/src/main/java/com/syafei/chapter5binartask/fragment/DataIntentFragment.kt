package com.syafei.chapter5binartask.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.syafei.chapter5binartask.R
import com.syafei.chapter5binartask.databinding.FragmentDataIntentFragmentBinding

class DataIntentFragment : Fragment(), View.OnClickListener {

    var _binding: FragmentDataIntentFragmentBinding? = null
    lateinit var binding: FragmentDataIntentFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDataIntentFragmentBinding.inflate(inflater, container, false)
        binding = requireNotNull(_binding)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnDataIntentFragment.setOnClickListener(this@DataIntentFragment)

    }

    override fun onClick(view: View?) {
        if (view?.id == R.id.btn_data_intent_fragment) {
            val mDataIntentMoveFragment = DataIntentMoveFragment()
            val mFragmentManager = parentFragmentManager
            mFragmentManager.beginTransaction().apply {
                replace(
                    R.id.fragment_on_activity_dataintent,
                    mDataIntentMoveFragment,
                    DataIntentMoveFragment::class.java.simpleName
                )
                    .addToBackStack(null)
                    .commit()
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
package com.syafei.chapter5binartask.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.syafei.chapter5binartask.R
import com.syafei.chapter5binartask.databinding.FragmentDataIntentMoveFragmentBinding

class DataIntentMoveFragment : Fragment(), View.OnClickListener {

    private var _binding: FragmentDataIntentMoveFragmentBinding? = null
    private lateinit var binding: FragmentDataIntentMoveFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDataIntentMoveFragmentBinding.inflate(inflater, container, false)
        binding = requireNotNull(_binding)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            btnDataIntentMoveFragment.setOnClickListener(this@DataIntentMoveFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onClick(view: View?) {
        if (view?.id == R.id.btn_data_intent_move_fragment){
            val eTDataIntentMoveFragment = binding.etDataIntentMoveFragment.text.toString()

            val mDetailsDataIntentMoveFragment = DetailsDataIntentMoveFragment()

            val mBundle = Bundle()
            mBundle.putString(DetailsDataIntentMoveFragment.EXTRA_NAME, eTDataIntentMoveFragment)
            val description = "kategori ini berisi produk-produk lifestyle"

            mDetailsDataIntentMoveFragment.arguments = mBundle
            mDetailsDataIntentMoveFragment.description = description

            val mFragmentManager = parentFragmentManager
            mFragmentManager.beginTransaction().apply {
                replace(
                    R.id.fragment_on_activity_dataintent,
                    mDetailsDataIntentMoveFragment,
                    DetailsDataIntentMoveFragment::class.java.simpleName
                ).addToBackStack(null).commit()
            }

        }
    }

}
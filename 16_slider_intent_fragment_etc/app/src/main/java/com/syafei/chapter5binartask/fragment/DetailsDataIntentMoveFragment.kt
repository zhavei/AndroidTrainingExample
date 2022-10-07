package com.syafei.chapter5binartask.fragment

import android.content.Intent
import android.os.Bundle
import android.provider.ContactsContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.syafei.chapter5binartask.activityBringData.OpenProfileActivity
import com.syafei.chapter5binartask.databinding.FragmentDetailsDataIntentMoveFragmentBinding

class DetailsDataIntentMoveFragment : Fragment() {

    private var _binding: FragmentDetailsDataIntentMoveFragmentBinding? = null
    private lateinit var binding: FragmentDetailsDataIntentMoveFragmentBinding

    var description: String? = null

    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_DESCRIPTION = "extra_description"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailsDataIntentMoveFragmentBinding.inflate(inflater, container, false)
        binding = requireNotNull(_binding)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (savedInstanceState != null) {
            val descFromBundle = savedInstanceState.getString(EXTRA_DESCRIPTION)
            description = descFromBundle
        }

        if (arguments != null) {
            val categoryName = arguments?.getString(EXTRA_NAME)
            binding.apply {
                tvFragmentDetailsDataIntentMoveFragment.text = categoryName
                tvDescFragmentDetailsDataIntentMoveFragment.text = description
            }
        }

        binding.btnProfileFragmentDetailsDataIntentMoveFragment.setOnClickListener {
            val mIntent = Intent(requireActivity(), OpenProfileActivity::class.java)
            startActivity(mIntent)
        }

        binding.btnDialogFragmentDetailsDataIntentMoveFragment.setOnClickListener {

            val mOptionDialogFragment = OptionDialogFragment()

            // OptionDialogFragment adalah child dari DetailsDataIntentMoveFragment method show() akan memangil childnya
            val mFragmentManager = childFragmentManager
            mOptionDialogFragment.show(
                mFragmentManager,
                OptionDialogFragment::class.java.simpleName
            )
        }
    }

    /*
    Gunakan method ini jika kita ingin menjaga data agar tetap aman ketika terjadi config changes (portrait - landscape)
     */
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(EXTRA_DESCRIPTION, description)
    }

    /*
    Kode yang akan dijalankan ketika option dialog dipilih ok
    */
    internal var optionDialogListener: OptionDialogFragment.OnOptionDialogListener =
        object : OptionDialogFragment.OnOptionDialogListener {
            override fun onOptionChosen(text: String?) {
                Toast.makeText(activity, text, Toast.LENGTH_SHORT).show()
                println("test toast coach chosen")
            }
        }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
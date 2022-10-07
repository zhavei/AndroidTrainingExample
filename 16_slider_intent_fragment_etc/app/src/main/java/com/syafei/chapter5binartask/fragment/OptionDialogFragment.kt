package com.syafei.chapter5binartask.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.syafei.chapter5binartask.R
import com.syafei.chapter5binartask.databinding.FragmentOptionDialogBinding

class OptionDialogFragment : DialogFragment() {

    private var _binding: FragmentOptionDialogBinding? = null
    private lateinit var binding: FragmentOptionDialogBinding

    private var optionDialogListener: OnOptionDialogListener? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOptionDialogBinding.inflate(inflater, container, false)
        binding = requireNotNull(_binding)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnChoseOptionsFragmentOptionDialog.setOnClickListener {
            val chekedRadioButtonId = binding.rgOptionsFragmentOptionDialog.checkedRadioButtonId
            if (chekedRadioButtonId != -1) {
                val coach: String? = when (chekedRadioButtonId) {
                    R.id.rb_saf_options_fragment_option_dialog -> binding.rbSafOptionsFragmentOptionDialog.text.toString().trim()
                    R.id.rb_aceloti_options_fragment_option_dialog -> binding.rbAcelotiOptionsFragmentOptionDialog.text.toString().trim()
                    R.id.rb_mou_options_fragment_option_dialog -> binding.rbMouOptionsFragmentOptionDialog.text.toString().trim()
                    R.id.rb_tenha_options_fragment_option_dialog -> binding.rbTenhaOptionsFragmentOptionDialog.text.toString().trim()
                    else -> null
                }
                //clik listener memakai interface
                optionDialogListener?.onOptionChosen(coach)
                dialog?.dismiss()
            }
        }

        binding.btnCloseOptionsFragmentOptionDialog.setOnClickListener {
            dialog?.cancel()
        }

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        /*
        Saat attach maka set optionDialogListener dengan listener dari detailCategoryFragment
        */
        val fragment = parentFragment

        if (fragment is DetailsDataIntentMoveFragment) {
            this.optionDialogListener = fragment.optionDialogListener
        }

        println("on attach di panggil uhuy")
    }

    override fun onDetach() {
        super.onDetach()
        this.optionDialogListener = null
    }

    interface OnOptionDialogListener {
        fun onOptionChosen(text: String?)
    }

}
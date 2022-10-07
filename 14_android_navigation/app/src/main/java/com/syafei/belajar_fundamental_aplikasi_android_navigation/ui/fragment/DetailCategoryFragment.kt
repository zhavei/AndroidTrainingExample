package com.syafei.belajar_fundamental_aplikasi_android_navigation.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.syafei.belajar_fundamental_aplikasi_android_navigation.R
import com.syafei.belajar_fundamental_aplikasi_android_navigation.databinding.FragmentDetailCategoryBinding

class DetailCategoryFragment : Fragment() {

    private var _binding: FragmentDetailCategoryBinding? = null
    private lateinit var binding: FragmentDetailCategoryBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailCategoryBinding.inflate(inflater, container, false)
        binding = requireNotNull(_binding)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /**with regular bundle()**/
        /*val dataName = arguments?.getString(CategoryFragment.EXTRA_NAME)
        val dataDesc = arguments?.getLong(CategoryFragment.EXTRA_STOCK)
        binding.tvCategoryName.text = dataName
        binding.tvCategoryDescription.text = "Stock : $dataDesc"*/

        val dataName = DetailCategoryFragmentArgs.fromBundle(arguments as Bundle).name
        val dataDesc = DetailCategoryFragmentArgs.fromBundle(arguments as Bundle).stock

        binding.tvCategoryName.text = dataName
        binding.tvCategoryDescription.text = "stockie: $dataDesc"

        binding.btnDetailToHomey.setOnClickListener { view ->
            view.findNavController().navigate(R.id.action_detailCategoryFragment_to_homeFragment)
            //Navigation.createNavigateOnClickListener(R.id.action_detailCategoryFragment_to_homeFragment)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
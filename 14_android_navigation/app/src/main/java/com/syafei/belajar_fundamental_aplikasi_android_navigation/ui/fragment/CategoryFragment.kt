package com.syafei.belajar_fundamental_aplikasi_android_navigation.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.syafei.belajar_fundamental_aplikasi_android_navigation.databinding.FragmentCategoryBinding

class CategoryFragment : Fragment() {

    private var _binding: FragmentCategoryBinding? = null
    private lateinit var binding: FragmentCategoryBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentCategoryBinding.inflate(inflater, container, false)
        binding = requireNotNull(_binding)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /**intent with bundle**/
        /*binding.btnFragmentCategory.setOnClickListener { view ->
            val mBundle = Bundle()
            mBundle.putString(EXTRA_NAME, "bebek beteyoy")
            mBundle.putLong(EXTRA_STOCK, 7)
            view.findNavController().navigate(R.id.action_categoryFragment_to_detailCategoryFragment, mBundle)
        }*/
        /**intent with save args**/
        binding.btnFragmentCategory.setOnClickListener { view ->
            val toDetailFragment =
                CategoryFragmentDirections.actionCategoryFragmentToDetailCategoryFragment()
            toDetailFragment.name = "Life Style"
            toDetailFragment.stock = 152
            view.findNavController().navigate(toDetailFragment)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object{
        val EXTRA_NAME = "extra_name"
        val EXTRA_STOCK = "extra_stock"
    }


}
package com.syafei.belajar_fundamental_aplikasi_android_navigation.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.syafei.belajar_fundamental_aplikasi_android_navigation.R
import com.syafei.belajar_fundamental_aplikasi_android_navigation.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private  var _binding : FragmentHomeBinding? = null
    private lateinit var binding: FragmentHomeBinding

    //inflate manual
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding = requireNotNull(_binding)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnToCategoryHome.setOnClickListener {
            /*Navigation.createNavigateOnClickListener(R.id.action_homeFragment_to_categoryFragment2)*/
            view -> view.findNavController().navigate(R.id.action_homeFragment_to_categoryFragment2)
            Log.d("home fragment", "test Click Listener")

        }

        binding.btnToProfileHome.setOnClickListener {
            view -> view.findNavController().navigate(R.id.action_homeFragment_to_profileActivity)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
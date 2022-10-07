package com.syafei.chapter5binartask

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.syafei.chapter5binartask.adapters.RecyclerFragmentAdapter
import com.syafei.chapter5binartask.adapters.SliderAdapter
import com.syafei.chapter5binartask.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    //private var binding: FragmentFirstBinding? = null
    private lateinit var binding: FragmentFirstBinding

    /*with viewBinding set to null because the view isnt created while  Fragment constructed instead it will reference while onCreateView created*/
    private var vpSlider: ViewPager? = null
    private var recyclerview: RecyclerView? = null

    //private lateinit var vpSlider: ViewPager //no viewBinding

    //recyclerView
    // private var layoutManager : RecyclerView.LayoutManager? = null
    //private var adapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        //val view = inflater.inflate(R.layout.fragment_first, container, false)
        binding = FragmentFirstBinding.inflate(inflater, container, false)

        //vpSlider = view.findViewById(R.id.vp_first_fragment)
        vpSlider = binding.vpFirstFragment
        val vpAdapter = SliderAdapter(childFragmentManager) //adaptermanager for fragment

        val secondFragment = SecondFragment()
        val tridhFragment = TridhFragment()

        val fragmentList = listOf(secondFragment, tridhFragment)

        vpAdapter.addFragmentList(fragmentList)
        vpSlider?.adapter = vpAdapter
        vpSlider?.offscreenPageLimit = 3

        //return view
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //recyclerview decorations
        val devider = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
        //recyclerview = view.findViewById(R.id.rv_first_fragment)

        // recyclerview devider decoration
        val divider = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
        recyclerview = binding.rvFirstFragment
        recyclerview?.apply {
            addItemDecoration(divider)
            layoutManager = LinearLayoutManager(activity)
            adapter = RecyclerFragmentAdapter(context)
        }
    }
}
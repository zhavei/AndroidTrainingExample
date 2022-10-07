package com.syafei.chapter5binartask

import android.content.Intent
import android.content.Intent.ACTION_DIAL
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.syafei.chapter5binartask.activityBringData.DataIntentActivity
import com.syafei.chapter5binartask.activityBringData.DataIntentActivityResult
import com.syafei.chapter5binartask.activityBringData.DataIntentActivityTree
import com.syafei.chapter5binartask.activityBringData.DataIntentActivityTwo
import com.syafei.chapter5binartask.databinding.FragmentSecondBinding
import com.syafei.chapter5binartask.models.Cars


class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private lateinit var binding: FragmentSecondBinding

    private lateinit var communicator: Communicator

    companion object {
        const val INTENT_KEY_1 = "intent_1"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        /*// Inflate the layout for this fragment
        binding = FragmentSecondBinding.inflate(inflater)
        val btn = binding?.btSecondfrag
        val editText = binding?.etSecondfrag
        communicator = activity as Communicator
        btn?.setOnClickListener {
            communicator.editextData(editText?.text.toString(), id) //id means refer to an id

            //communicator.editextData(editText?.text.toString())
            //communicator.imageView(id)
        }*/


        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        binding = requireNotNull(_binding)
        return binding.root

        /*val view = inflater.inflate(R.layout.fragment_second, container, false)
        val btn : Button = view.findViewById(R.id.bt_secondfrag)
        val editText: EditText = view.findViewById(R.id.tv_fragmenttwo)*/

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Inflate the layout for this fragment
        val btn = binding.btSecondfrag
        val editText = binding.etSecondfrag
        communicator = activity as Communicator
        btn.setOnClickListener {
            communicator.editextData(
                editText.text.toString(), id) //id means refer to an id but wich id?

            /* //communicator.editextData(editText?.text.toString())
                //communicator.imageView(id)*/
        }

        //navigate with nav controler
        val textView = binding.tvSecondFragment
        textView.setOnClickListener {
            val action = SecondFragmentDirections.naviSecondFragmentToFragmentTwo(56)
            //this navigate to frgmentTwo
            Navigation.findNavController(view).navigate(action)
        }

        binding.run {
            btnSecondfragTodataIntent.setOnClickListener {
                val intent = Intent(context, DataIntentActivity::class.java)
                startActivity(intent)
            }
            btnSecondfragTodataIntent2.setOnClickListener {
                val intent2 = Intent(context, DataIntentActivityTwo::class.java)
                intent2.putExtra(
                    INTENT_KEY_1,
                    "ini intent bawa data putString dari fragment seconds"
                )
                startActivity(intent2)
            }
            btnSecondfragTodataIntent3.setOnClickListener {
                val dataCars = Cars(
                    "honda",
                    "civic",
                    R.drawable.gunung
                )
                val intent3 = Intent(context, DataIntentActivityTree::class.java)
                intent3.putExtra(INTENT_KEY_1, dataCars)
                startActivity(intent3)
            }

            btnSecondfragTodataIntent4.setOnClickListener {
                val telephone = "085888636395"
                val telIntent = Intent(ACTION_DIAL, Uri.parse("tel:$telephone"))
                startActivity(telIntent)
            }

            btnDataIntentActivityResult.setOnClickListener {
                val intent4 = Intent(context, DataIntentActivityResult::class.java)
                startActivity(intent4)
            }

        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
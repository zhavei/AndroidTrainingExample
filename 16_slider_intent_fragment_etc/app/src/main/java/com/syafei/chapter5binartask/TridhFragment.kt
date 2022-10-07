package com.syafei.chapter5binartask

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment

class TridhFragment : Fragment() {

    private val sharedPrefsFile = "sharedPrefLearning"

    companion object {
        val ID_KEY = "id_key"
        val ID_NAME = "id_name"
        val ID_DEFAULT_KEY = 0
        val ID_DEFAULT_NAME = "empty"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_tridh, container, false)
        val btnSave: Button = view.findViewById(R.id.btnSave)
        val btnLoad: Button = view.findViewById(R.id.btnView)
        val btnClear: Button = view.findViewById(R.id.btnClear)
        val etInput: EditText = view.findViewById(R.id.etInputId)
        val etInputName: EditText = view.findViewById(R.id.etInputName)
        val tvShowName: TextView = view.findViewById(R.id.tvShowName)
        val tvShowId: TextView = view.findViewById(R.id.tvShowId)

        val sharedPreferences: SharedPreferences? =
            activity?.getSharedPreferences(sharedPrefsFile, Context.MODE_PRIVATE)

        btnSave.setOnClickListener {

            if (etInput.text.toString().trim().isNotEmpty() && etInputName.text.toString().trim()
                    .isNotEmpty()
            ) {
                val id: Int = Integer.parseInt((etInput.text.toString()))
                val name: String = etInputName.text.toString()
                val sharfEditor: SharedPreferences.Editor? = sharedPreferences?.edit()
                sharfEditor?.putInt(ID_KEY, id)
                sharfEditor?.putString(ID_NAME, name)
                sharfEditor?.apply()
                Toast.makeText(context, "Data Saved", Toast.LENGTH_SHORT).show()
            } else {
                etInput.error = "field cannot be empty"
                etInputName.error = "field cannot be empty"
                Toast.makeText(context, "isi datanya gan, kaga danta ente", Toast.LENGTH_SHORT)
                    .show()
            }

        }

        btnLoad.setOnClickListener {
            val sharedIdValue = sharedPreferences?.getInt(ID_KEY, ID_DEFAULT_KEY)
            val sharedNameValue = sharedPreferences?.getString(ID_NAME, ID_DEFAULT_NAME)

            if (sharedIdValue == 0 && sharedNameValue.equals(ID_DEFAULT_NAME)) {
                tvShowName.setText("name: $sharedNameValue").toString()
                tvShowId.setText("id: $sharedIdValue").toString()
                Toast.makeText(context, "Data View Kosong", Toast.LENGTH_SHORT).show()
            } else {
                tvShowName.text = sharedNameValue.toString()
                tvShowId.text = sharedIdValue.toString()
                Toast.makeText(context, "Data Di Tampilkuen", Toast.LENGTH_SHORT).show()
            }
        }

        btnClear.setOnClickListener {
            val editor = sharedPreferences?.edit()
            editor?.clear()
            editor?.apply()
            etInput.setText("")
            etInputName.setText("")
            tvShowName.setText("")
            tvShowId.setText("")
            Toast.makeText(context, "Data dihapouskuen", Toast.LENGTH_SHORT).show()
        }

        return view
    }
}
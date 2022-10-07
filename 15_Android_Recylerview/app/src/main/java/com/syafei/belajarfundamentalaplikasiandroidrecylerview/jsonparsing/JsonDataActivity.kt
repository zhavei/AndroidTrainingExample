package com.syafei.belajarfundamentalaplikasiandroidrecylerview.jsonparsing

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.syafei.belajarfundamentalaplikasiandroidrecylerview.R
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException
import java.nio.charset.Charset


class JsonDataActivity : AppCompatActivity() {

    var userName: ArrayList<String> = ArrayList()
    var name: ArrayList<String> = ArrayList()
    var avatar: ArrayList<String> = ArrayList()
    var company: ArrayList<String> = ArrayList()
    var location: ArrayList<String> = ArrayList()
    var repository: ArrayList<Int> = ArrayList()
    var followers: ArrayList<Int> = ArrayList()
    var following: ArrayList<Int> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_json_data)

        val recyclerView = findViewById<RecyclerView>(R.id.rv_jsondata)
        val linearLayoutManager = LinearLayoutManager(applicationContext)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = linearLayoutManager

        try {
            val obj = JSONObject(loadJSONFromAsset())
            val userArray = obj.getJSONArray("users")
            for (i in 0 until userArray.length()) {
                val userDetail = userArray.getJSONObject(i)
                userName.add(userDetail.getString("username"))
                name.add(userDetail.getString("name"))
                avatar.add(userDetail.getString("avatar"))
                company.add(userDetail.getString("company"))
                location.add(userDetail.getString("location"))
                repository.add(userDetail.getInt("repository"))
                followers.add(userDetail.getInt("follower"))
                following.add(userDetail.getInt("following"))
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }

        val costumAdapter = CostumAdapter(
            this@JsonDataActivity,
            userName,
            name,
            avatar,
            company,
            location,
            repository,
            followers,
            following
        )
        recyclerView.adapter = costumAdapter

    }

    private fun loadJSONFromAsset(): String {
        val json: String?
        try {
            val inputStream = assets.open("githubuser.json")
            val size = inputStream.available()
            val buffer = ByteArray(size)
            val charset: Charset = Charsets.UTF_8
            inputStream.read(buffer)
            inputStream.close()
            json = String(buffer, charset)
        } catch (ex: IOException) {
            ex.printStackTrace()
            return ""
        }
        return json
    }

    /*private fun readSampleJSON(): Unit {
        val file_name = "githubuser.json"
        val bufferReader = application.assets.open(file_name).bufferedReader()
        val data = bufferReader.use {
            it.readText()
        }

        val jsonObject = JSONObject(data)

        val name = jsonObject.getString("name")
        val age = jsonObject.getInt("age")
        val height = jsonObject.getDouble("height")

        Log.d("readSampleJSON", "name : $name || age : $age || height: $height")
    }*/


    /*private fun readArrayOfJsonObject(): Unit {

        val bufferReader = application.assets.open("githubuser.json").bufferedReader()
        val json_string = bufferReader.use {
            it.readText()
        }
        val jsonArray = JSONArray(json_string);

        for (i in 0..jsonArray.length() - 1) {
            val jsonObject: JSONObject = jsonArray.getJSONObject(i)

            val name = jsonObject.getString("name")
            val version = jsonObject.getString("version")

            Log.d("readArrayOfJsonObject", "name: $name || version : $version  \n")
        }
    }*/

}
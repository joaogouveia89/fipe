package io.github.joaogouveia89.fipe

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.github.joaogouveia89.fipe.network.Brand
import io.github.joaogouveia89.fipe.network.FipeApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    private val api = FipeApi()

    private val brandsTitle by lazy {
        findViewById<TextView>(R.id.brands_title)
    }

    private val callback = object : Callback<List<Brand?>?>{
        override fun onResponse(call: Call<List<Brand?>?>, response: Response<List<Brand?>?>) {
            val brands = response.body()

            if (brands != null) {
                brandListAdapter.submitList(brands)
                brandsTitle.text = "Brands(${brands.size})"
            }else{
                Log.i("JOAODEBUG", "brands is null")
            }
        }

        override fun onFailure(call: Call<List<Brand?>?>, t: Throwable) {
            Log.i("JOAODEBUG", "FAIL")
        }

    }

    private val brandListAdapter = BrandListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val brands = api.fetchBrands()

        brands?.enqueue(callback)

        val recycler = findViewById<RecyclerView>(R.id.brands_list)

        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        recycler.addItemDecoration(
            DividerItemDecoration(
                baseContext,
                layoutManager.orientation
            )
        )

        recycler.adapter = brandListAdapter
    }

}
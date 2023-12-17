package io.github.joaogouveia89.fipe.brands

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.github.joaogouveia89.fipe.R
import io.github.joaogouveia89.fipe.network.Brand
import io.github.joaogouveia89.fipe.network.FipeApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BrandListFragment : Fragment() {

    private val api = FipeApi()
    private val brandListAdapter = BrandListAdapter()

    private val callback = object : Callback<List<Brand?>?> {
        override fun onResponse(call: Call<List<Brand?>?>, response: Response<List<Brand?>?>) {
            val brands = response.body()

            if (brands != null) {
                brandListAdapter.submitList(brands)

                (requireActivity() as AppCompatActivity).supportActionBar?.title = getString(R.string.brands_list_size, brands.size)
            }else{
                Log.i("JOAODEBUG", "brands is null")
            }
        }

        override fun onFailure(call: Call<List<Brand?>?>, t: Throwable) {
            Log.i("JOAODEBUG", "FAIL")
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_brand_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val brands = api.fetchBrands()

        brands?.enqueue(callback)

        val recycler = view.findViewById<RecyclerView>(R.id.brands_list)

        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        recycler.apply {
            addItemDecoration(DividerItemDecoration(
                context,
                layoutManager.orientation
            ))

            adapter = brandListAdapter
        }
    }
}
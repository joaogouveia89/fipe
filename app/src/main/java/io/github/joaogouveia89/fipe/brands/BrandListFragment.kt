package io.github.joaogouveia89.fipe.brands

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import io.github.joaogouveia89.fipe.OnListItemSelected
import io.github.joaogouveia89.fipe.R
import io.github.joaogouveia89.fipe.databinding.FragmentBrandListBinding
import io.github.joaogouveia89.fipe.fiperesult.FipeResultListAdapter
import io.github.joaogouveia89.fipe.ktx.addVerticalDivider
import io.github.joaogouveia89.fipe.ktx.setTitle
import io.github.joaogouveia89.fipe.network.FipeApi
import io.github.joaogouveia89.fipe.network.models.FipeResult
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BrandListFragment : Fragment() {

    private var binding: FragmentBrandListBinding? = null

    private val api = FipeApi()
    private val brandListAdapter = FipeResultListAdapter(object : OnListItemSelected {
        override fun onSelected(item: FipeResult) {
            val action =
                BrandListFragmentDirections.actionBrandListFragmentToBrandModelsFragment(item)
            findNavController().navigate(action)
        }
    })

    private val callback = object : Callback<List<FipeResult?>?> {
        override fun onResponse(
            call: Call<List<FipeResult?>?>,
            response: Response<List<FipeResult?>?>
        ) {
            val brands = response.body()

            if (brands != null) {
                brandListAdapter.submitList(brands)

                setTitle(getString(R.string.brands_list_size, brands.size))
            } else {
                Log.i("JOAODEBUG", "brands is null")
            }
        }

        override fun onFailure(call: Call<List<FipeResult?>?>, t: Throwable) {
            Log.i("JOAODEBUG", "FAIL")
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =
            DataBindingUtil.inflate(layoutInflater, R.layout.fragment_brand_list, container, false)

        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val brands = api.fetchBrands()

        brands?.enqueue(callback)

        binding?.apply {
            adapter = brandListAdapter
            brandsList.addVerticalDivider()
        }
    }
}
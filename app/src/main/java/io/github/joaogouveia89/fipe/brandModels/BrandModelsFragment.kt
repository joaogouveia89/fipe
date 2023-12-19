package io.github.joaogouveia89.fipe.brandModels

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.github.joaogouveia89.fipe.OnListItemSelected
import io.github.joaogouveia89.fipe.R
import io.github.joaogouveia89.fipe.fiperesult.FipeResultListAdapter
import io.github.joaogouveia89.fipe.ktx.setTitle
import io.github.joaogouveia89.fipe.network.FipeApi
import io.github.joaogouveia89.fipe.network.models.BrandModels
import io.github.joaogouveia89.fipe.network.models.FipeResult
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BrandModelsFragment : Fragment() {

    private val args: BrandModelsFragmentArgs by navArgs()
    private val api = FipeApi()

    private val callback = object : Callback<BrandModels?> {
        override fun onResponse(call: Call<BrandModels?>, response: Response<BrandModels?>) {
            val brandsModels = response.body()

            if (brandsModels != null) {
                brandModelsListAdapter.submitList(brandsModels.models)

                setTitle(
                    getString(
                        R.string.brands_models_list_size,
                        args.brand.name,
                        brandsModels.models.size
                    )
                )
            } else {
                Log.i("JOAODEBUG", "brands is null")
            }
        }

        override fun onFailure(call: Call<BrandModels?>, t: Throwable) {
            Log.i("JOAODEBUG", "FAIL ${t.message}")
        }

    }

    private val brandModelsListAdapter = FipeResultListAdapter(object : OnListItemSelected {
        override fun onSelected(brandModel: FipeResult) {
            val action =
                BrandModelsFragmentDirections.actionBrandModelsFragmentToModelYearsFragment(
                    args.brand,
                    brandModel
                )
            findNavController().navigate(action)
        }
    })

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_brand_models, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setTitle(getString(R.string.brands_models_list, args.brand.name))

        val brandModels = api.fetchBrandModels(args.brand.code.toInt())

        brandModels?.enqueue(callback)

        val recycler = view.findViewById<RecyclerView>(R.id.brand_models_list)

        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        recycler.apply {
            addItemDecoration(
                DividerItemDecoration(
                    context,
                    layoutManager.orientation
                )
            )

            adapter = brandModelsListAdapter
        }
    }
}
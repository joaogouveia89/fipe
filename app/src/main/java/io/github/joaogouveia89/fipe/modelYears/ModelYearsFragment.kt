package io.github.joaogouveia89.fipe.modelYears

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import io.github.joaogouveia89.fipe.OnListItemSelected
import io.github.joaogouveia89.fipe.R
import io.github.joaogouveia89.fipe.databinding.FragmentModelYearsBinding
import io.github.joaogouveia89.fipe.fiperesult.FipeResultListAdapter
import io.github.joaogouveia89.fipe.ktx.addVerticalDivider
import io.github.joaogouveia89.fipe.ktx.setTitle
import io.github.joaogouveia89.fipe.network.FipeApi
import io.github.joaogouveia89.fipe.network.models.FipeResult
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ModelYearsFragment : Fragment() {

    private val api = FipeApi()
    private val args: ModelYearsFragmentArgs by navArgs()
    private var binding: FragmentModelYearsBinding? = null

    private val brandListAdapter = FipeResultListAdapter(object : OnListItemSelected {
        override fun onSelected(modelYear: FipeResult) {
            val action =
                ModelYearsFragmentDirections.actionModelYearsFragmentToModelDetailsFragment(
                    args.brand,
                    args.brandModel,
                    modelYear
                )
            findNavController().navigate(action)
        }
    })

    private val callback = object : Callback<List<FipeResult?>?> {
        override fun onResponse(
            call: Call<List<FipeResult?>?>,
            response: Response<List<FipeResult?>?>
        ) {
            val brandsModelsYears = response.body()

            if (brandsModelsYears != null) {
                brandListAdapter.submitList(brandsModelsYears)

                setTitle(
                    getString(
                        R.string.brands_models_years_list_size,
                        args.brandModel.name,
                        brandsModelsYears.size
                    )
                )
            } else {
                Log.i("JOAODEBUG", "brands is null")
            }
        }

        override fun onFailure(call: Call<List<FipeResult?>?>, t: Throwable) {
            Log.i("JOAODEBUG", "FAIL ${t.message}")
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_model_years, container, false)

        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setTitle(getString(R.string.brands_models_years_list))

        val brandModelYears =
            api.fetchBrandModelYears(args.brand.code.toInt(), args.brandModel.code)

        brandModelYears?.enqueue(callback)

        binding?.apply {
            adapter = brandListAdapter
            brandModelYearsList.addVerticalDivider()
        }
    }
}
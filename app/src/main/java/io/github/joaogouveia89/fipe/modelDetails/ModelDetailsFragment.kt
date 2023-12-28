package io.github.joaogouveia89.fipe.modelDetails

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import io.github.joaogouveia89.fipe.R
import io.github.joaogouveia89.fipe.ktx.setTitle
import io.github.joaogouveia89.fipe.network.FipeApi
import io.github.joaogouveia89.fipe.network.models.ModelDetails
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ModelDetailsFragment : Fragment() {

    private val api = FipeApi()

    private val args: ModelDetailsFragmentArgs by navArgs()

    private val viewModel: ModelDetailsViewModel by viewModels()

    private val modelName: TextView by lazy {
        requireView().findViewById(R.id.model_name)
    }

    private val modelBrand: TextView by lazy {
        requireView().findViewById(R.id.model_brand)
    }

    private val modelYear: TextView by lazy {
        requireView().findViewById(R.id.model_year)
    }

    private val modelFipeCode: TextView by lazy {
        requireView().findViewById(R.id.model_fipecode)
    }

    private val modelReferenceMonth: TextView by lazy {
        requireView().findViewById(R.id.model_referencemonth)
    }

    private val modelFuel: TextView by lazy {
        requireView().findViewById(R.id.model_fuel)
    }

    private val modelValue: TextView by lazy {
        requireView().findViewById(R.id.model_value)
    }

    private val callback = object : Callback<ModelDetails?> {
        override fun onResponse(call: Call<ModelDetails?>, response: Response<ModelDetails?>) {
            Log.i("JOAODEBUG", response.body().toString())
            response.body()?.let {
                modelName.text = it.model
                modelBrand.text = it.brand
                modelYear.text = it.year.toString()
                modelFuel.text = it.fuel
                modelFipeCode.text = it.fipeCode
                modelReferenceMonth.text = it.referenceMonth
                modelValue.text = it.value
            }
        }

        override fun onFailure(call: Call<ModelDetails?>, t: Throwable) {
            TODO("Not yet implemented")
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_model_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setTitle(getString(R.string.model_details))

        val modelDetails =
            api.fetchModelDetails(
                args.brand.code.toInt(),
                args.brandModel.code,
                args.brandModelYear.code
            )

        modelDetails?.enqueue(callback)
    }
}
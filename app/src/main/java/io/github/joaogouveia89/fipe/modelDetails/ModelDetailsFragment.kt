package io.github.joaogouveia89.fipe.modelDetails

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.navArgs
import io.github.joaogouveia89.fipe.FipeFragment
import io.github.joaogouveia89.fipe.R
import io.github.joaogouveia89.fipe.databinding.FragmentModelDetailsBinding
import io.github.joaogouveia89.fipe.ktx.setTitle
import io.github.joaogouveia89.fipe.network.models.ModelDetails
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ModelDetailsFragment : FipeFragment() {

    private val args: ModelDetailsFragmentArgs by navArgs()

    private var binding: FragmentModelDetailsBinding? = null

    private val callback = object : Callback<ModelDetails?> {
        override fun onResponse(call: Call<ModelDetails?>, response: Response<ModelDetails?>) {
            Log.i("JOAODEBUG", response.body().toString())
            response.body()?.let {
                binding?.modelDetails = it
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
        binding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.fragment_model_details,
            container,
            false
        )

        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setTitle(getString(R.string.model_details))

        val modelDetails =
            fipeApi.fetchModelDetails(
                args.brand.code.toInt(),
                args.brandModel.code,
                args.brandModelYear.code
            )

        modelDetails?.enqueue(callback)
    }
}
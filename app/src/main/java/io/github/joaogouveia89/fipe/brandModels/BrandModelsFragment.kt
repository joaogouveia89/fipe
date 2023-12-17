package io.github.joaogouveia89.fipe.brandModels

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import io.github.joaogouveia89.fipe.R
import io.github.joaogouveia89.fipe.ktx.setTitle

class BrandModelsFragment : Fragment() {

    private val args: BrandModelsFragmentArgs by navArgs()

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

        view.findViewById<TextView>(R.id.test).text = args.brand.toString()
    }
}
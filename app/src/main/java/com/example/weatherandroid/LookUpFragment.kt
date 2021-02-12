package com.example.weatherandroid

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.weatherandroid.ViewModels.WeatherViewModel
import com.example.weatherandroid.databinding.FragmentLookUpBinding
import org.koin.android.viewmodel.ext.android.viewModel

class LookUpFragment : Fragment() {

    val newsViewModel: WeatherViewModel by viewModel()

    private var _binding: FragmentLookUpBinding? = null
    private val binding get() = _binding!!  //read only variable
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLookUpBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val k = newsViewModel.newsListLiveData.value
        Log.d("GOLD", "onViewCreated: $k")
//        findNavController().navigate(R.id.action_lookUpFragment_to_weatherListFragment)
    }


}
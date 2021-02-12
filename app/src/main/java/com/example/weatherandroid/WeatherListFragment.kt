package com.example.weatherandroid

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.weatherandroid.ViewModels.WeatherViewModel
import com.example.weatherandroid.databinding.FragmentWeatherListBinding
import org.koin.android.viewmodel.ext.android.viewModel

class WeatherListFragment : Fragment() {

    val weatherViewModel: WeatherViewModel by viewModel()

    private var _binding: FragmentWeatherListBinding? = null
    private val binding get() = _binding!!  //read only variable
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWeatherListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


//            findNavController().navigate(R.id.action_weatherListFragment_to_detailsFragment)

    }

}
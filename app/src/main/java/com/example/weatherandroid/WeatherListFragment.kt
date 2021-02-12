package com.example.weatherandroid

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import androidx.fragment.app.Fragment
import com.example.weatherandroid.ViewModels.WeatherViewModel
import com.example.weatherandroid.databinding.FragmentWeatherListBinding
import org.koin.android.viewmodel.ext.android.viewModel

class WeatherListFragment : Fragment() {

    val weatherViewModel: WeatherViewModel by viewModel()
    var listItems = arrayOf("Cloudy", "Rainy", "Sunny")


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

        val listView = binding.listview
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, listItems)
        listView.adapter = adapter



        listView.setOnItemClickListener { parent, view, position, id ->
            Toast.makeText(requireContext(), listItems[position], LENGTH_LONG).show()
        }

//            findNavController().navigate(R.id.action_weatherListFragment_to_detailsFragment)

    }

}
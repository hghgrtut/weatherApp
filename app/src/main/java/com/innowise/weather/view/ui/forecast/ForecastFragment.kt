package com.innowise.weather.view.ui.forecast

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.innowise.weather.databinding.FragmentForecastBinding
import com.innowise.weather.view.activity.ProgressBarActivity
import com.innowise.weather.view.ui.SharedViewModel

class ForecastFragment : Fragment() {

    private val viewModel: SharedViewModel by activityViewModels()
    private var _binding: FragmentForecastBinding? = null
    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentForecastBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding.list) {
            layoutManager = LinearLayoutManager(context)
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
            viewModel.forecast.observe(viewLifecycleOwner, {
                (requireActivity() as ProgressBarActivity).hideProgressBar()
                adapter = ForecastAdapter(it.forecastList)
            })
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
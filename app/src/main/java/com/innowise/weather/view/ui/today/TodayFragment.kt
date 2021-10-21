package com.innowise.weather.view.ui.today

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.innowise.weather.R
import com.innowise.weather.databinding.FragmentTodayBinding
import com.innowise.weather.model.forecast.Forecast
import com.innowise.weather.model.forecast.concreteforecast.ConcreteForecast
import com.innowise.weather.view.activity.ProgressBarActivity
import com.innowise.weather.view.ui.SharedViewModel
import kotlin.math.roundToInt

class TodayFragment : Fragment() {

    private val viewModel: SharedViewModel by activityViewModels()
    private var _binding: FragmentTodayBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTodayBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.forecast.observe(viewLifecycleOwner,{ forecastList ->
            (requireActivity() as ProgressBarActivity).hideProgressBar()
            binding.city.text = forecastList.getCity()
            val forecast = forecastList.weatherList.first()
            displayWeather(forecast)
            binding.share.setOnClickListener {
                val intent = Intent(Intent.ACTION_SEND)
                intent.putExtra(Intent.EXTRA_TEXT, forecast.toString())
                intent.type = "text/plain"
                startActivity(intent)
            }
        })
    }

    private fun displayWeather(forecast: ConcreteForecast) {
        with(binding) {
            picture.setImageResource(forecast.getPictureRes())
            val temperat: Int = forecast.main.temperature.roundToInt()
            overview.text = getString(R.string.overview_today, temperat, forecast.getOverview())
            listOf(icFeelLike, icPressure, icRainProbability, icWind, icGust).makeVisible()
            listOf(separatorTop, separatorBottom, share).makeVisible()
            val probability = forecast.rainProbability.roundToInt()
            rainProbability.text = getString(R.string.probability, probability)
            val feels = forecast.main.temperatureLike.roundToInt()
            feelLike.text = getString(R.string.degrees, feels)
            pressure.text = getString(R.string.pressure, forecast.main.pressure)
            wind.text = getString(R.string.wind_speed, forecast.wind.speed.roundToInt())
            gust.text = getString(R.string.wind_speed, forecast.wind.gust.roundToInt())
        }
    }

    private fun List<View>.makeVisible() = forEach { it.visibility = View.VISIBLE }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
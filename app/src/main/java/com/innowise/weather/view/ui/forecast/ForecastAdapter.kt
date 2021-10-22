package com.innowise.weather.view.ui.forecast

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.innowise.weather.R
import com.innowise.weather.databinding.ItemBinding
import com.innowise.weather.model.forecast.concreteforecast.ConcreteForecast
import kotlin.math.roundToInt

class ForecastAdapter(private val forecastList: List<ConcreteForecast>) :
    RecyclerView.Adapter<ForecastAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val forecast = forecastList[position]
        val (date, time) = forecast.dateTime.split(' ')
        holder.day.apply {
            if (time.split(':').first() < "03") {
                visibility = View.VISIBLE
                text = date
            } else { visibility = View.GONE } }
        holder.time.text = time
        holder.picture.setImageResource(forecast.getPictureRes())
        holder.overview.text = forecast.getOverview()
        holder.temperature.text = forecast.main.temperature.roundToInt().toString()
    }

    override fun getItemCount(): Int = forecastList.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding: ItemBinding = ItemBinding.bind(view)
        val day = binding.day
        val overview = binding.overview
        val picture = binding.picture
        val temperature = binding.temperature
        val time = binding.time
    }
}
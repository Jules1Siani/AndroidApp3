package com.louiserennick.treasurehunapp

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class TreasureHuntViewModel: ViewModel(){
    private val _currentStep = MutableStateFlow(0)
    val currecntStep : StateFlow<Int> = _currentStep

    val locations = listOf (
        "City Hall",
        "Sunrise Cafe",
        "Maple Bookstore",
        "Artisan Gallery",
        "Downtown Pizza",
        "TechZone",
        "Green Market",
        "Central Library",
        "Music Vinyls",
        "History Museum",
        "City Park Pavilion",
        "Craft Boutique",
        "Urban Bikes",
        "Coffee & Co.",
        "Art Street",
        "Cinema Palace",
        "Toy Universe",
        "City Gardens",
        "Chocolate House",
        "Bubble Tea Station"

    )
    // need to get a map of the city and make it a static ping
    // save it as city_map.png and place in your drawables
    fun nextLocation(){
        if(_currentStep.value < locations.size - 1){
            _currentStep.value++
        }
    }
}

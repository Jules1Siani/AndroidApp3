package com.louiserennick.treasurehunapp

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class TreasureHuntViewModel: ViewModel(){
    private val _currentStep = MutableStateFlow(0)
    val currecntStep : StateFlow<Int> = _currentStep

    val locations = listOf (
        "City Hall",
        "Cafe Delight",
        "Book Store",
        "Gallery 5",
        "Pizza Place",
        "Tech World",
        "Green Grocers",
        "Library Lane",
        "The Vinyl shop",
        "Museum Corner",
        "Park Pavilion",
        "Craft Corner",
        "Bike Depot",
        "Coffee works",
        "Art Alley",
        "Movie Place",
        "Toy Town",
        "Park",
        "choca Factory",
        "Bubble Tea Bar",
        "Flower Shop",
        "Treasure Chest - Final Stop"

    )
    // need to get a map of the city and make it a static ping
    // save it as city_map.png and place in your drawables
    fun nextLocation(){
        if(_currentStep.value < locations.size - 1){
            _currentStep.value++
        }
    }
}

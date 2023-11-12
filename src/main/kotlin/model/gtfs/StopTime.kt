package model.gtfs

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class StopTime(
    @SerialName("trip_id") val tripId: String,
    @SerialName("arrival_time") val arrivalTime: String? = null,
    @SerialName("departure_time") val departureTime: String,
    @SerialName("stop_id") val stopId: String,
    @SerialName("stop_sequence") val stopSequence: Int,
    @SerialName("stop_headsign") val stopHeadsign: String? = null,
    @SerialName("pickup_type") val pickupType: Int? = null,
    @SerialName("drop_off_type") val dropOffType: Int? = null,
    @SerialName("shape_dist_traveled") val shapeDistTraveled: Double? = null,
    val timepoint: Int? = null,
)
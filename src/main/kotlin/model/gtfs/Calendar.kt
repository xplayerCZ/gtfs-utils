package model.gtfs

import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import model.gtfs.subtype.CalendarAvailability

@Serializable
data class Calendar(
    @SerialName("service_id") val serviceId: String,
    val monday: CalendarAvailability = CalendarAvailability.UNAVAILABLE,
    val tuesday: CalendarAvailability = CalendarAvailability.UNAVAILABLE,
    val wednesday: CalendarAvailability = CalendarAvailability.UNAVAILABLE,
    val thursday: CalendarAvailability = CalendarAvailability.UNAVAILABLE,
    val friday: CalendarAvailability = CalendarAvailability.UNAVAILABLE,
    val saturday: CalendarAvailability = CalendarAvailability.UNAVAILABLE,
    val sunday: CalendarAvailability = CalendarAvailability.UNAVAILABLE,
    @SerialName("start_date") val startDate: LocalDate,
    @SerialName("end_date") val endDate: LocalDate,
)
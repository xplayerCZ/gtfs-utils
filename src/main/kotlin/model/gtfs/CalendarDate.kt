package model.gtfs

import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import model.gtfs.subtype.ExceptionType

@Serializable
class CalendarDate(
    @SerialName("service_id") val serviceId: String,
    val date: LocalDate,
    @SerialName("exception_type") val exceptionType: ExceptionType,
) {
}
package model.gtfs

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class Agency(
    @SerialName("agency_name") val name: String,
    @SerialName("agency_id") val id: String = name,
    @SerialName("agency_url") val url: String,
    @SerialName("agency_timezone") val timezone: String,
    @SerialName("agency_lang") val lang: String? = null,
    @SerialName("agency_phone") val phone: String? = null,
    @SerialName("agency_fare_url") val fareUrl: String? = null,
    @SerialName("agency_email") val email: String? = null,
)
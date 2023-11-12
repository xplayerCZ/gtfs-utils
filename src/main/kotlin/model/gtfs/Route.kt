package model.gtfs

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import model.gtfs.subtype.RouteType

@Serializable
data class Route(
    @SerialName("route_id") val id: String,
    @SerialName("agency_id") val agencyId: String? = null,
    @SerialName("route_short_name") val shortName: String,
    @SerialName("route_long_name") val longName: String,
    @SerialName("route_desc") val description: String? = null,
    @SerialName("route_type") val type: RouteType = RouteType.BUS,
    @SerialName("route_url") val url: String? = null,
    @SerialName("route_color") val color: String? = null,
    @SerialName("route_text_color") val textColor: String? = null,
    @SerialName("route_sort_order") val sortOrder: Int? = null,
    @SerialName("continuous_pickup") val continuousPickup: Int? = null,
    @SerialName("continuous_drop_off") val continuousDropOff: Int? = null,
)
package model.gtfs.subtype

import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

@Serializable(with = RouteTypeSerializer::class)
enum class RouteType(val value: Int) {
    TRAM(0),
    SUBWAY(1),
    RAIL(2),
    BUS(3),
    FERRY(4),
    CABLE_TRAM(5),
    AERIAL_LIFT(6),
    FUNICULAR(7),
    TROLLEYBUS(11),
    MONORAIL(12),
}

class RouteTypeSerializer : KSerializer<RouteType> {
    override val descriptor = PrimitiveSerialDescriptor("RouteTypeSerializer", PrimitiveKind.INT)

    override fun deserialize(decoder: Decoder): RouteType {
        return when (decoder.decodeInt()) {
            0 -> RouteType.TRAM
            1 -> RouteType.SUBWAY
            2 -> RouteType.RAIL
            3 -> RouteType.BUS
            4 -> RouteType.FERRY
            5 -> RouteType.CABLE_TRAM
            6 -> RouteType.AERIAL_LIFT
            7 -> RouteType.FUNICULAR
            11 -> RouteType.TROLLEYBUS
            12 -> RouteType.MONORAIL
            else -> throw IllegalArgumentException("Unknown route type")
        }
    }

    override fun serialize(encoder: Encoder, value: RouteType) {
        encoder.encodeInt(value.value)
    }
}

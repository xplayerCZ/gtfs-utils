package model.gtfs.subtype

import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

@Serializable(with = LocationTypeSerializer::class)
enum class LocationType(val value: Int) {
    STOP(0),
    STATION(1),
    ENTRANCE(2),
    GENERIC_NODE(3),
    BOARDING_AREA(4),
}

class LocationTypeSerializer : KSerializer<LocationType> {
    override val descriptor = PrimitiveSerialDescriptor("LocationTypeSerializer", PrimitiveKind.INT)

    override fun deserialize(decoder: Decoder): LocationType {
        return when (decoder.decodeInt()) {
            0 -> LocationType.STOP
            1 -> LocationType.STATION
            2 -> LocationType.ENTRANCE
            3 -> LocationType.GENERIC_NODE
            4 -> LocationType.BOARDING_AREA
            else -> throw IllegalArgumentException("Unknown location type")
        }
    }

    override fun serialize(encoder: Encoder, value: LocationType) {
        encoder.encodeInt(value.value)
    }
}
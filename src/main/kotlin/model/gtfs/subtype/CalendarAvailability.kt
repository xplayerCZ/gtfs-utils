package model.gtfs.subtype

import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

@Serializable(with = CalendarAvailabilitySerializer::class)
enum class CalendarAvailability(val value: Int){
    AVAILABLE(1),
    UNAVAILABLE(0);

    val isAvailable get() = this == AVAILABLE
    val isUnavailable get() = this == UNAVAILABLE
}

class CalendarAvailabilitySerializer : KSerializer<CalendarAvailability> {
    override val descriptor = PrimitiveSerialDescriptor("CalendarAvailabilitySerializer", PrimitiveKind.INT)

    override fun deserialize(decoder: Decoder): CalendarAvailability {
        return when (decoder.decodeInt()) {
            1 -> CalendarAvailability.AVAILABLE
            0 -> CalendarAvailability.UNAVAILABLE
            else -> throw IllegalArgumentException("Unknown calendar availability")
        }
    }

    override fun serialize(encoder: Encoder, value: CalendarAvailability) {
        encoder.encodeInt(value.value)
    }
}

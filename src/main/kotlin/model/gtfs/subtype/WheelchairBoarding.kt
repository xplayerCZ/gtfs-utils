package model.gtfs.subtype

import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

@Serializable(with = WheelchairBoardingSerializer::class)
enum class WheelchairBoarding(val value: Int) {
    UNKNOWN(0),
    POSSIBLE(1),
    NOT_POSSIBLE(2),
}

class WheelchairBoardingSerializer : KSerializer<WheelchairBoarding> {
    override val descriptor = PrimitiveSerialDescriptor("WheelchairBoardingSerializer", PrimitiveKind.INT)

    override fun deserialize(decoder: Decoder): WheelchairBoarding {
        return when (decoder.decodeInt()) {
            0 -> WheelchairBoarding.UNKNOWN
            1 -> WheelchairBoarding.POSSIBLE
            2 -> WheelchairBoarding.NOT_POSSIBLE
            else -> throw IllegalArgumentException("Unknown wheelchair boarding")
        }
    }

    override fun serialize(encoder: Encoder, value: WheelchairBoarding) {
        encoder.encodeInt(value.value)
    }
}
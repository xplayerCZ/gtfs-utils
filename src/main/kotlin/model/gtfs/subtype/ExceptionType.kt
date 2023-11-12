package model.gtfs.subtype

import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

@Serializable(with = ExceptionTypeSerializer::class)
enum class ExceptionType(val value: Int) {
    ADDED(1),
    REMOVED(2);

    val isAdded get() = this == ADDED
    val isRemoved get() = this == REMOVED
}

class ExceptionTypeSerializer : KSerializer<ExceptionType> {
    override val descriptor = PrimitiveSerialDescriptor("ExceptionTypeSerializer", PrimitiveKind.INT)

    override fun deserialize(decoder: Decoder): ExceptionType {
        return when (decoder.decodeInt()) {
            1 -> ExceptionType.ADDED
            2 -> ExceptionType.REMOVED
            else -> throw IllegalArgumentException("Unknown exception type")
        }
    }

    override fun serialize(encoder: Encoder, value: ExceptionType) {
        encoder.encodeInt(value.value)
    }
}

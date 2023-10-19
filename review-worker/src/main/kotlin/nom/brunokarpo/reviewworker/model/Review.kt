package nom.brunokarpo.reviewworker.model

import java.util.UUID

data class Review(
    val id: UUID = UUID.randomUUID(),
    val orderId: UUID,
    val partnerId: UUID,
    val customerId: UUID,
    val score: Int
)
package nom.brunokarpo.reviewworker.repository

import nom.brunokarpo.reviewworker.model.Review
import java.util.UUID

interface ReviewRepository {

    fun save(review: Review)
    fun findByOrderId(orderId: UUID): Review?
}

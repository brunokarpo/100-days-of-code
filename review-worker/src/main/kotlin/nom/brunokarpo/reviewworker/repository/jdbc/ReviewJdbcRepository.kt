package nom.brunokarpo.reviewworker.repository.jdbc

import nom.brunokarpo.reviewworker.model.Review
import nom.brunokarpo.reviewworker.repository.ReviewRepository
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
class ReviewJdbcRepository(
    private val jdbcTemplate: NamedParameterJdbcTemplate
): ReviewRepository {
    override fun save(review: Review) {
        val sql = """
            INSERT INTO review (order_id, partner_id, customer_id, score) values
            (:orderId, :partnerId, :customerId, :score);
        """.trimIndent()
        val params = mapOf(
            "orderId" to review.orderId.toString(),
            "partnerId" to review.partnerId.toString(),
            "customerId" to review.customerId.toString(),
            "score" to review.score
        )

        jdbcTemplate.update(sql, params)
    }

    override fun findByOrderId(orderId: UUID): Review? {
        val sql = """
            SELECT 
                id,
                order_id,
                partner_id,
                customer_id,
                score
            FROM review
            WHERE order_id = :orderId
        """.trimIndent()
        val params = mapOf("orderId" to orderId.toString())
        return jdbcTemplate.query(sql, params) { rs, _ ->
            Review(
                id = rs.getObject("id", UUID::class.java),
                orderId = UUID.fromString(rs.getString("order_id")),
                customerId = UUID.fromString(rs.getString("customer_id")),
                partnerId = UUID.fromString(rs.getString("partner_id")),
                score = rs.getInt("score")
            )
        }.first()
    }
}
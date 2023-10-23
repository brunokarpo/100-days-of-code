package nom.brunokarpo.reviewworker.repository.jdbc

import nom.brunokarpo.reviewworker.model.Review
import nom.brunokarpo.reviewworker.repository.JdbcDatabaseIT
import nom.brunokarpo.reviewworker.repository.ReviewRepository
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.jdbc.Sql
import org.springframework.test.context.jdbc.SqlGroup
import java.util.UUID

@SqlGroup(
    Sql(value = ["/sql/load-reviews.sql"], executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD),
    Sql(value = ["/sql/clean-database.sql"], executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
)
class ReviewJdbcRepositoryIT : JdbcDatabaseIT() {

    @Autowired
    private lateinit var sut: ReviewRepository

    @Test
    fun `should save a new review`() {
        val review = Review(
            orderId = UUID.randomUUID(),
            customerId = UUID.randomUUID(),
            partnerId = UUID.randomUUID(),
            score = 5
        )

        sut.save(review)
    }

    @Test
    fun `should load review by order id`() {
        val result = sut.findByOrderId(UUID.fromString("26c48447-390a-463b-ba40-9c019a7e7780"))

        result.apply {
            assertNotNull(this)
            assertEquals(5, this!!.score)
            assertEquals("26c48447-390a-463b-ba40-9c019a7e7780", this.orderId.toString())
            assertEquals("f42a25f4-2acd-494b-9ae4-2c6dbcfb6d91", this.partnerId.toString())
            assertEquals("a1364327-093d-4a06-b1d8-10c280659b0c", this.customerId.toString())
        }
    }
}
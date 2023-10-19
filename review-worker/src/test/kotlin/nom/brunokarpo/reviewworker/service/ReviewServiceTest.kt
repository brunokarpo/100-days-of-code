package nom.brunokarpo.reviewworker.service

import io.mockk.Runs
import io.mockk.every
import io.mockk.just
import io.mockk.mockk
import io.mockk.slot
import io.mockk.verify
import nom.brunokarpo.reviewworker.model.Review
import nom.brunokarpo.reviewworker.publishers.ReviewPublisher
import nom.brunokarpo.reviewworker.repository.ReviewRepository
import nom.brunokarpo.reviewworker.service.exceptions.ReviewDuplicatedException
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.util.UUID

class ReviewServiceTest {

    private var reviewRepositoryMock = mockk<ReviewRepository> {
        every {
            save(any())
        } just Runs
        every {
            findByOrderId(any())
        } returns null
    }

    private var reviewPublisherMock = mockk<ReviewPublisher> {
        every {
            publish(any())
        } just Runs
    }

    private lateinit var sut: ReviewService

    @BeforeEach
    fun setUp() {
        sut = ReviewService(
            reviewRepository = reviewRepositoryMock,
            reviewPublisher = reviewPublisherMock
        )
    }

    @Test
    fun `should save a new valid Review`() {
        val review = Review(
            orderId = UUID.randomUUID(),
            customerId = UUID.randomUUID(),
            partnerId = UUID.randomUUID(),
            score = 5
        )

        val slotReview = slot<Review>()

        sut.create(review)

        verify(exactly = 1) {
            reviewRepositoryMock.save(capture(slotReview))
        }

        Assertions.assertEquals(review, slotReview.captured)
    }

    @Test
    fun `should publish review created`() {
        val review = Review(
            orderId = UUID.randomUUID(),
            customerId = UUID.randomUUID(),
            partnerId = UUID.randomUUID(),
            score = 5
        )

        val slotReview = slot<Review>()

        sut.create(review)

        verify {
            reviewPublisherMock.publish(capture(slotReview))
        }

        Assertions.assertEquals(review, slotReview.captured)
    }

    @Test
    fun `should not save the Review if exists previous review saved`() {
        val review = Review(
            orderId = UUID.randomUUID(),
            customerId = UUID.randomUUID(),
            partnerId = UUID.randomUUID(),
            score = 5
        )

        every {
            reviewRepositoryMock.findByOrderId(any())
        } returns review

        assertThrows<ReviewDuplicatedException> {
            sut.create(review)
        }
    }
}
package nom.brunokarpo.reviewworker.service

import nom.brunokarpo.reviewworker.model.Review
import nom.brunokarpo.reviewworker.repository.ReviewRepository
import nom.brunokarpo.reviewworker.service.exceptions.ReviewDuplicatedException

class ReviewService(
    private val reviewRepository: ReviewRepository
) {
    fun create(review: Review) {
        reviewRepository.findByOrderId(review.orderId)?.let { throw ReviewDuplicatedException() }
        reviewRepository.save(review)
    }
}
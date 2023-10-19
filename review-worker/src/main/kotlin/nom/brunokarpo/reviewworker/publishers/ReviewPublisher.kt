package nom.brunokarpo.reviewworker.publishers

import nom.brunokarpo.reviewworker.model.Review

interface ReviewPublisher {

    fun publish(review: Review)
}

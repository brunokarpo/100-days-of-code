package nom.brunokarpo.reviewworker

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ReviewWorkerApplication

fun main(args: Array<String>) {
	runApplication<ReviewWorkerApplication>(*args)
}

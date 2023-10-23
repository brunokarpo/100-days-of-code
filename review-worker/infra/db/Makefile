.PHONY: start
start:
	docker container run --name review-db --rm --detach \
		--env POSTGRES_DB=review-worker \
		--env POSTGRES_USER=review-worker-app \
		--env POSTGRES_PASSWORD=review-worker-app \
		--publish 5432:5432 \
		postgres:16.0-alpine

stop:
	docker container stop review-db || echo "Database not running"


.PHONY: migrate
migrate:
	$(MAKE) _run command=migrate

.PHONY: migrate
validate:
	$(MAKE) _run command=validate

_run:
	docker run --rm --name review-migration \
		--volume ${CURDIR}/conf:/flyway/conf \
		--volume ${CURDIR}/migrations:/flyway/sql \
		--network host \
		flyway/flyway:9.22.2 -configFiles=/flyway/conf/.conf-local $(command)
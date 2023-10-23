MVN=./mvnw

.PHONY: java
java:
	java -version

.PHONY: build
build:
	$(MVN) clean install


## Database section
.PHONY: db-start
db-start:
	$(MAKE) -C infra/db start

.PHONY: db-stop
db-stop:
	$(MAKE) -C infra/db stop

.PHONY: db-migrate
db-migrate:
	$(MAKE) -C infra/db migrate
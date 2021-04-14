setup:
	./gradlew wrapper --gradle-version 6.8.3

clean:
	./gradlew clean

build: clean
	./gradlew build

build-lint: lint
	./gradlew build

install: build-lint
	./gradlew install test

run-dist:
	./build/install/java-package/bin/java-package

run:
	./gradlew run

lint: build
	./gradlew checkstyleMain checkstyleTest

check-updates:
	./gradlew dependencyUpdates

build-run: build run

help: install
	./build/install/app/bin/app -h

test: install
	./gradlew test


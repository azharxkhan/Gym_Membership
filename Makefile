MVN = mvn

.PHONY: clean compile test package run

# Clean the target directory
clean:
	$(MVN) clean

# Compile the source code
compile:
	$(MVN) compile

# Run unit tests
test:
	$(MVN) test

# Package the application into a JAR
package:
	$(MVN) package

# Run the application (assuming you have a main class defined)
run:
	$(MVN) exec:java -Dexec.mainClass="gymApp.MainClass"

# Build Docker image
docker-build:
	docker build -t gymapp .

# Run Docker container
docker-run:
	docker run -it -p 8080:8080 gymapp

# Stop and remove all running containers (optional, in case it's needed)
docker-clean:
	docker rm -f $$(docker ps -aq)

# Delete all Docker images
docker-delete-images:
	docker rmi -f $$(docker images -q)
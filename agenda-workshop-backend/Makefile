start-stack: package
	docker-compose up --build --force-recreate -d
stop-stack:
	docker-compose down
package:
	mvn package
rebuild-app:
	docker-compose stop -t 1 $(APP)
	mvn clean
	mvn package
	docker-compose restart redis
	docker-compose build $(APP)
	docker-compose create $(APP)
	docker-compose start $(APP)
install-canonical-model:
	mvn install -pl canonical-model
local-api-publish: package
	docker-compose build
tail-logs:
	docker logs -f $(shell docker ps -aqf name=agenda-api)
hot-deploy:
	docker-compose stop -t 1 agenda-api
	mvn clean
	mvn package
	docker-compose build agenda-api
	docker-compose create agenda-api
	docker-compose start agenda-api

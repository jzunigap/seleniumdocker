FROM openjdk:8u191-jre-alpine3.8

RUN apk add curl jq

#Workspace
WORKDIR /usr/share/udemy

#ADD .jar under target from host
#into this image
ADD target/selenium-docker.jar 			selenium-docker.jar
ADD target/selenium-docker-tests.jar 	selenium-docker-tests.jar
ADD target/libs							libs

# In case of any other dependency  like csv./ .json /.xls
#please add that as well

#ADD Suite files
ADD book-flight-module.xml		book-flight-module.xml
ADD search-module.xml 			search-module.xml

#ADD health  check script
ADD healthcheck.sh 				healthcheck.sh
#BROWSER
#HUB_HOST
#MODULE

#ESTO SE AGREGARA EN EL HEALTCHECK FILE
#ENTRYPOINT java -cp  selenium-docker.jar:selenium-docker-tests.jar:libs/* -DBROWSER=$BROWSER -DHUB_HOST=$HUB_HOST org.testng.TestNG $MODULE

ENTRYPOINT sh healthcheck.sh


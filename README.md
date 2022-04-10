## Requirements

For building and running the application you need:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3](https://maven.apache.org)

## Running the application locally
You can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```

## About the Service

The service is just a Sensor API REST service that stores data in collections internally.
We have not used any DataBase for now due to time limitations but it can be implemented.
More interestingly, you can start calling some of the operational endpoints (see full list below) like ```/sensors```  
and ```/sensors/getAverage``` (these are available on **port 8080**)



Here is what this little application demonstrates: 
* The application allows you to register sensors by id.
* Once a sensor has been registered, the application can receive new metric values
* The application allows querying sensor data.

Here are some endpoints you can call:

# Create a sensor resource

```
POST /sensors
Accept: application/json
Content-Type: application/json

{
   "sensorId":"abd",
   "countryName":"Ireland",
   "cityName":"Dublin",
   "temperature": 97,
   "humidity" : 63,
   "date": "2022-04-10"
}

RESPONSE: HTTP 200 (Created)
```

# Get information about sensors/particular sensor by Id
```
http://localhost:8080/sensors
http://localhost:8091/sensors/{id}
```

# Update a sensor resource

```
PUT /sensors
Accept: application/json
Content-Type: application/json

{
   "sensorId":"abd",
   "countryName":"Ireland",
   "cityName":"Dublin",
   "temperature": 92,
   "humidity" : 63,
   "date": "2022-04-10"
}

RESPONSE: HTTP 200 (No Content)
```

# Delete a sensor resource
```
DELETE /sensors/{id}
RESPONSE: HTTP 200 (No Content)
```

# Get average of all temprature and humidity present at that moment
```
GET /sensors/getAverage
```
# Improvements
* Query sensor data by Date range (code present but not working for now)
* Use DataBase for persistent storgae
* Write test cases
* Implement exception handling
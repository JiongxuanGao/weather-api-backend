# weather-api-backend
This is the repo for WeatherAPI - backend

## Hello message API
WHen you call
```
localhost:8081/hello?name=XXX
```
it will responde you a salute message.

## Weather info API
WHen you call
```
localhost:8081/weather?city=XXX
```
it will responde you the weather info of this city.

Below is the response structure:
```java
public class WeatherInfo {
	// true, if the request is successful; otherwise false.
	private boolean result;
	private String cityName;
	private String updatedTime;
	private String weather;
	private String temperature;
	private String windSpeed;
```

You can also import the Postman collection and try it out!

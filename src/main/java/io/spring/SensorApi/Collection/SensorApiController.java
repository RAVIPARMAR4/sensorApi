package io.spring.SensorApi.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class SensorApiController {

  @Autowired
  private SensorApiService sensorApiService;

  @RequestMapping(method = RequestMethod.GET,value = "/sensors")
  public List<SensorApi> getSensorData() {
    return sensorApiService.getAllSensorData();
  }

  @RequestMapping(method = RequestMethod.POST,value = "/sensors")
  public void addSensorData(@RequestBody SensorApi sensorApiDto) {
    sensorApiService.addSensor(sensorApiDto);
  }

  @RequestMapping(method = RequestMethod.GET,value = "/sensors/{id}")
  public Optional<SensorApi> getSensor(@PathVariable String id)
  {
    return sensorApiService.getSensorById(id);
  }

  //Returns the average of all temprature and humidity present at that moment
  @RequestMapping(method = RequestMethod.GET, value = "/sensors/getAverage")
  public Map<String,Double> getAverageFromApi() {
    return sensorApiService.getAverageSensorApi();
  }

  @RequestMapping(method = RequestMethod.PUT, value = "/sensors")
  public void updateData(@RequestBody  SensorApi id)
  {
     sensorApiService.updateSensorData(id);
  }

  @RequestMapping(method = RequestMethod.DELETE, value = "/sensors/{id}")
  public void deleteSensorDataById(@PathVariable String id) {
    sensorApiService.deleteSensorData(id);
  }

  //not working date range
  @RequestMapping("/sensors/{date1}/{date2}")
  public List<SensorApi> getSensorInRange(@PathVariable String date1, @PathVariable String date2)
  {
    String pattern = "yyyy-MM-dd";
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
    Date startDate = new Date();
    Date endDate = new Date();
    try {
       startDate = simpleDateFormat.parse(date1);
      endDate = simpleDateFormat.parse(date2);
    }
    catch (ParseException p) {

    }
    return sensorApiService.getSensorByDateRange(startDate,endDate);

  }
  
}

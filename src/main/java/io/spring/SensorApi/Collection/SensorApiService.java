package io.spring.SensorApi.Collection;

import com.sun.org.apache.bcel.internal.generic.ARETURN;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static com.fasterxml.jackson.databind.type.LogicalType.DateTime;


@Service
public class SensorApiService {

  @Autowired
  private SensorApiRepository sensorApiRepository;

  List<SensorApi> sensorApis;


  public List<SensorApi> getAllSensorData() {
    List<SensorApi> sensorApis = new ArrayList<>();
    sensorApiRepository.findAll().forEach(sensorApis::add);
    return sensorApis;
  }

  public void addSensor(SensorApi sensorApi) {

    sensorApiRepository.save(sensorApi);
  }

  public Optional<SensorApi> getSensorById(String id)
  {
    return sensorApiRepository.findById(id);
  }

  public List<SensorApi> getSensorByDateRange(Date startDate, Date endDate) {
   return sensorApiRepository.getAllSensorByDay(startDate, endDate);
  }

  public Map<String, Double> getAverageSensorApi() {
    List<SensorApi> sensorApis = new ArrayList<>();
    sensorApiRepository.findAll().forEach(sensorApis::add);
   double avgTemperature = 0;
   double avgHumidity = 0;
   int count = 0;

    for (SensorApi s : sensorApis) {
      avgTemperature += s.getTemperature();
      avgHumidity += s.getHumidity();
      count++;
    }
    avgTemperature = avgTemperature/count;
    avgHumidity = avgHumidity/count;
    Map<String,Double> result = new HashMap<>();
    result.put("Average Temperature: ",avgTemperature);
    result.put("Average Humidity: ", avgHumidity);

    return result;
  }

  public void updateSensorData(SensorApi id) {
    sensorApiRepository.save(id);
  }

  public void deleteSensorData(String id) {
    sensorApiRepository.deleteById(id);
  }
}

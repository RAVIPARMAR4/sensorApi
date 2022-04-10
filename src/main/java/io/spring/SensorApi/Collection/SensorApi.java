package io.spring.SensorApi.Collection;

import com.sun.istack.NotNull;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SensorApi {
  @Id
  private String sensorId;
  private String countryName;
  private String cityName;
  private double temperature;
  private double humidity;
  private Date date;

  public SensorApi() {

  }

  public SensorApi(String sensorId, String countryName, String cityName
      , double temperature, double humidity, Date date) {
    this.sensorId = sensorId;
    this.countryName = countryName;
    this.cityName = cityName;
    this.temperature = temperature;
    this.humidity = humidity;
    this.date = date;
  }

  public String getSensorId() {
    return sensorId;
  }

  public String getCountryName() {
    return countryName;
  }

  public String getCityName() {
    return cityName;
  }

  public double getTemperature() {
    return temperature;
  }

  public double getHumidity() {
    return humidity;
  }

  public Date getDate() {
    return date;
  }

  public void setSensorId(String sensorId) {
    this.sensorId = sensorId;
  }

  public void setCountryName(String countryName) {
    this.countryName = countryName;
  }

  public void setCityName(String cityName) {
    this.cityName = cityName;
  }

  public void setTemperature(double temperature) {
    this.temperature = temperature;
  }

  public void setHumidity(double humidity) {
    this.humidity = humidity;
  }

  public void setDate(Date date) {
    this.date = date;
  }
}

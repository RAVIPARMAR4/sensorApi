package io.spring.SensorApi.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface SensorApiRepository extends CrudRepository<SensorApi,String> {

  @Query(value = "SELECT * FROM SensorApi WHERE date >= :startDate AND date <= :endDate", nativeQuery = true)
  List<SensorApi> getAllSensorByDay(@Param("startDate") Date startDate,@Param("endDate") Date endDate);

}

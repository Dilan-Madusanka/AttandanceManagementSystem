package com.attandance.repo;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.attandance.domain.Attndance;

public interface ReportRepositary{
	@Query("FROM Attndance att t WHERE att.createdDate >= :startDate AND att.createdDate<=:endDate") 
    List<Attndance> getWeeklyReports(@Param("startDate") Date startDate,@Param("endDate") Date endDate);
}

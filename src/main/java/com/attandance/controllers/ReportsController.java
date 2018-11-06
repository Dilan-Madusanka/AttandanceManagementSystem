package com.attandance.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.attandance.domain.Attndance;
import com.attandance.domain.Department;
import com.attandance.domain.Employee;
import com.attandance.dto.WeeklyReportDTO;
import com.attandance.myException.ResourceNotFoundException;
import com.attandance.repo.AttandanceRepo;
import com.attandance.repo.EmployeeRepositary;
import com.attandance.repo.ReportRepositary;

@RestController
@RequestMapping("/attaendanceAPI")
public class ReportsController {
	
	@Autowired
	ReportRepositary reportRepositary;
	@Autowired
	EmployeeRepositary employeeRepositary;
	@Autowired
	AttandanceRepo attandanceRepo;
	
	@PostMapping("/weeklyreport")
	public List<WeeklyReportDTO> getWeeklyReport(@RequestParam("startDate") String sstartDate,
								@RequestParam("endDate") String sendDate) {
		
		List<WeeklyReportDTO> main=new ArrayList<WeeklyReportDTO>();
		Date endDate=null;;
		Date startDate=null;
		try {
			startDate=new SimpleDateFormat("dd/MM/yyyy").parse(sstartDate); 
			endDate = new SimpleDateFormat("dd/MM/yyyy").parse(sendDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		List<Attndance> attndanceList=reportRepositary.getWeeklyReports(startDate, endDate);
		
		for(Attndance attndance:attndanceList) {
			WeeklyReportDTO row= new WeeklyReportDTO();
			Employee employee=employeeRepositary.findById(attndance.getEmployeeId()).orElseThrow(() -> new ResourceNotFoundException("Employee", "id", attndance.getEmployeeId()));
			row.setEmployName(employee.getEmployName());
			row.setDate( attndance.getCreatedDate().toString());
			
			main.add(row);
			
		}
		return main;
	}
	
	@PostMapping("/missing_time_card_report")
	public List<WeeklyReportDTO> getAllMissingTimeCardReport() {
		List<WeeklyReportDTO> main=new ArrayList<WeeklyReportDTO>();
		for(Attndance attndance:attandanceRepo.findAll()) {
			WeeklyReportDTO row= new WeeklyReportDTO();
			if(attndance.getCreatedTime()==null) {
				Employee employee=employeeRepositary.findById(attndance.getEmployeeId()).orElseThrow(() -> new ResourceNotFoundException("Employee", "id", attndance.getEmployeeId()));
				row.setEmployName(employee.getEmployName());
				row.setDate( attndance.getCreatedDate().toString());
			}
			main.add(row);
		}
		return main;
	}

}

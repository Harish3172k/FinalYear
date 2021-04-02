package com.health.monitor.controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.health.monitor.bean.PatientRecord;
import com.health.monitor.response.AllStorageResponse;
import com.health.monitor.response.PatientStorageResponse;
import com.health.monitor.response.StorageResponse;
import com.health.monitor.util.DBUtil;

@RestController
public class RestApiController {
	
	//Data receiving from hardware
	@GetMapping(path = "/store")
	ResponseEntity<?> getOxyData(@RequestParam double inRate,@RequestParam double outRate,@RequestParam double temp,@RequestParam double heartRate, @RequestParam int id_ref) throws Exception
	{
		Connection conn = DBUtil.getDBConnection();
		ResultSet result;
		int id;
		String sql = "INSERT INTO test(inRate,outRate,heartRate,temp,id_ref) VALUES(?,?,?,?,?)";
		PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		stmt.setDouble(1, inRate);
		stmt.setDouble(2, outRate);
		stmt.setDouble(3, heartRate);
		stmt.setDouble(4, temp);
		stmt.setInt(5,id_ref);
		stmt.executeUpdate();
		result = stmt.getGeneratedKeys();
		if(result.next())
		{
			id = result.getInt(1);
		}
		else
		{
			throw new Exception("Error in storing");
		}
		return new ResponseEntity<StorageResponse>(new StorageResponse(id,inRate,outRate,temp,String.valueOf(new Date(System.currentTimeMillis())),heartRate,id_ref), HttpStatus.OK);
	}
	
	@GetMapping(path = "/get",produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String getStoredData() throws Exception
	{
		Connection conn = DBUtil.getDBConnection();
		ResultSet result;
		PreparedStatement stmt;
		String sql = "select * from test";
		stmt = conn.prepareStatement(sql);
		result = stmt.executeQuery();
		String ans = "<html><head><style>\ntable,th,td {\nborder: 1px solid black\n}</style><title>Dummy page</title></head><body>";
		ans += "<table style=\"width:100%\"><tr><th>ID</th><th>inRate</th><th>outRate</th><th>heartRate</th><th>Temperature</th><th>Date</th><th>ID_REF</th></tr>";
		while(result.next())
		{
			ans += "<tr>\n";
			ans += "<td>"+String.valueOf(result.getInt(1))+"</td>";
			ans += "<td>"+String.valueOf(result.getDouble(2))+"</td>";
			ans += "<td>"+String.valueOf(result.getDouble(3))+"</td>";
			ans += "<td>"+String.valueOf(result.getDouble(4))+"</td>";
			ans += "<td>"+String.valueOf(result.getDouble(5))+"</td>";
			ans += "<td>"+String.valueOf(result.getDate(6))+"</td>";
			ans += "<td>"+String.valueOf(result.getInt(7))+"</td>";
			ans += "</tr>";
		}
		ans+="</table></body></html>";
		return ans;
	}
	
	@GetMapping(path="/", produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String getRoot() throws Exception
	{
		return "<html><head><title>Home Page</title></head><body><h1>Welcome to the home page of virtual healthcare assistant</h1></body></html>";
	}
	
	@PostMapping(path="/storePatient",produces="application/json",consumes="application/json")
	ResponseEntity<?> storePatient(@RequestBody PatientRecord record) throws Exception
	{
		Connection conn = DBUtil.getDBConnection();
		ResultSet result;
		int id;
		String sql = "INSERT INTO patient_record(name,age,male,currSmoker,cigsPerDay,bpMeds,prevStroke,prevHyp,diab,totchol,bmi,glucose,tenYearCHD,id_ref) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		stmt.setString(1, record.getName());
		stmt.setInt(2, record.getAge());
		stmt.setInt(3, record.getMale());
		stmt.setInt(4, record.getCurrSmoker());
		stmt.setInt(5, record.getCigsPerDay());
		stmt.setInt(6, record.getBpMeds());
		stmt.setInt(7, record.getPrevStroke());
		stmt.setInt(8, record.getPrevHyp());
		stmt.setInt(9, record.getDiab());
		stmt.setDouble(10, record.getTotchol());
		stmt.setDouble(11, record.getBMI());
		stmt.setDouble(12, record.getGlucose());
		stmt.setInt(13, record.getTenYearCHD());
		stmt.setInt(14, record.getId_ref());
		stmt.executeUpdate();
		result = stmt.getGeneratedKeys();
		if(result.next())
		{
			id = result.getInt(1);
		}
		else
		{
			throw new Exception("Error in storing");
		}
		return new ResponseEntity<PatientStorageResponse>(new PatientStorageResponse(id,record.getId_ref(),record.getName()), HttpStatus.OK);
	}
	@GetMapping(path="/getLast2daysRecords")
	ResponseEntity<?> getLast2daysRecords(@RequestParam int id_ref) throws Exception {
		Connection conn = DBUtil.getDBConnection();
		ResultSet result;
		PreparedStatement stmt;
		String sql = "select * from test where id_ref="+String.valueOf(id_ref);
		stmt = conn.prepareStatement(sql);
		result = stmt.executeQuery();
		List<StorageResponse> lst = new ArrayList<StorageResponse>();
		while(result.next())
		{
			lst.add(new StorageResponse(result.getInt(1), result.getDouble(2), result.getDouble(3), result.getDouble(5), String.valueOf(result.getDate(6)), result.getDouble(4), result.getInt(7)));
		}
		return new ResponseEntity<AllStorageResponse>(new AllStorageResponse(lst),HttpStatus.OK);
	}
}

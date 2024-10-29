package com.qn.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Car {
	private String username;
	private String carModel;
	private String carType;
	private String carRegistrationNumber;
	private String serviceRequest;
	private String serviceStatus;
	private Connection con;
	public Car(String username, String carModel, String carType, String carRegistrationNumber, String serviceRequest,
			String serviceStatus) {
		super();
		this.username = username;
		this.carModel = carModel;
		this.carType = carType;
		this.carRegistrationNumber = carRegistrationNumber;
		this.serviceRequest = serviceRequest;
		this.serviceStatus = serviceStatus;
	}
	public Car() {
		super();
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getCarModel() {
		return carModel;
	}
	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}
	public String getCarType() {
		return carType;
	}
	public void setCarType(String carType) {
		this.carType = carType;
	}
	public String getCarRegistrationNumber() {
		return carRegistrationNumber;
	}
	public void setCarRegistrationNumber(String carRegistrationNumber) {
		this.carRegistrationNumber = carRegistrationNumber;
	}
	public String getServiceRequest() {
		return serviceRequest;
	}
	public void setServiceRequest(String serviceRequest) {
		this.serviceRequest = serviceRequest;
	}
	public String getServiceStatus() {
		return serviceStatus;
	}
	public void setServiceStatus(String serviceStatus) {
		this.serviceStatus = serviceStatus;
	}
	@Override
	public String toString() {
		return "Car [username=" + username + ", carModel=" + carModel + ", carType=" + carType
				+ ", carRegistrationNumber=" + carRegistrationNumber + ", serviceRequest=" + serviceRequest
				+ ", serviceStatus=" + serviceStatus + "]";
	}
	{
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			con= DriverManager.getConnection("jdbc:mysql://localhost:3306/car_service_system","root","root");
			
		}catch(Exception e) {
			e.printStackTrace();			
		}
	}
	public int carregister() {
		try {
			String s="insert into car values(?,?,?,?,?,?)";
			PreparedStatement pstmt=con.prepareStatement(s);
			pstmt.setString(1, username);
			pstmt.setString(2, carModel); 
			pstmt.setString(3, carType);
			pstmt.setString(4, carRegistrationNumber);
			pstmt.setString(5, serviceRequest);
			pstmt.setString(6, serviceStatus);
			
			int rows=pstmt.executeUpdate();
			return rows;
			
			
			
		}
			catch(SQLException e){
				e.printStackTrace();
				
			}
		return 0;
	}
	public int carDetails() {
		try {
			String s="insert into car values(?,?,?,?,?,?)";
			PreparedStatement pstmt=con.prepareStatement(s);
			pstmt.setString(1, username);
			pstmt.setString(2, carModel); 
			pstmt.setString(3, carType);
			pstmt.setString(4, carRegistrationNumber);
			pstmt.setString(5, "NA");
			pstmt.setString(6, "NA");
			int rows=pstmt.executeUpdate();
			return rows;
		}
			catch(SQLException e){
				e.printStackTrace();
			}
		return 0;
	}
	public int serviceRequest() {
		try {
			String s = "update car set servicerequest=?, servicestatus=? where username=? and carregistrationnumber=?";
			PreparedStatement ps = con.prepareStatement(s);
			ps.setString(1, serviceRequest);
			ps.setString(2, "pending");
			ps.setString(3, username);
			ps.setString(4, carRegistrationNumber);
			int rows = ps.executeUpdate();
			return rows;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	public String serviceStatus() {
		try {
		String s="select * from car where car_registration_number=? and username=?";
		PreparedStatement ps = con.prepareStatement(s);
		ps.setString(1, carRegistrationNumber);
		ps.setString(2, username);
		ResultSet res=ps.executeQuery();
		if(res.next()) {
			return res.getString(6);
	}
		}
	catch(Exception e) {
		e.printStackTrace();
	}
	return null;
    }
	public ArrayList<Car> viewCustomers() {
		try {
			String s="select * from car";
			PreparedStatement pstmt=con.prepareStatement(s);
			ResultSet res=pstmt.executeQuery();
			ArrayList<Car> carDetails=new ArrayList<>();
			while(res.next()) {
				username=res.getString(1);
				carModel=res.getString(2);
				carType=res.getString(3);
				carRegistrationNumber=res.getString(4);
				serviceRequest=res.getString(5);
				serviceStatus=res.getString(6);
				carDetails.add(new Car(username,carModel,carType,carRegistrationNumber,serviceRequest,serviceStatus));
			}
			return carDetails;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}

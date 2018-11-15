package com.crosscode.ConsumerDB.demo.consumer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.crosscode.ConsumerDB.bean.IPRepository;
import com.crosscode.ConsumerDB.bean.IpAddress;

@Service
public class Consume {
	@Value(value = "${ip_address}")
	private String ipvalue;
	@Autowired
	IPRepository iprepo;

	public List<IpAddress> getUser(){
		System.out.println("===========================================");
		System.out.println((List<IpAddress>)iprepo.findAll().get(0));
		System.out.println("===========================================");
		return (List<IpAddress>) iprepo.findAll();
	}
	public void crosscode() throws IOException{
		//iprepo.get
		URL conURL = new URL("http://"+ipvalue+":8080/Producer-0.0.1-snapshot/hello");
		//URL conURL = new URL("http://"+ipvalue+":8082/hello");
		HttpURLConnection conn = null;
		try {
			conn = (HttpURLConnection)conURL.openConnection();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		conn.setDoOutput(true);
		conn.setRequestMethod("GET");
		if (conn.getResponseCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ conn.getResponseCode());
		}

		BufferedReader br = new BufferedReader(new InputStreamReader(
			(conn.getInputStream())));

		String output;
		System.out.println("Output from Server .... \n");
		while ((output = br.readLine()) != null) {
			System.out.println(output);
		}

		conn.disconnect();
		
		// logger.info("queueName {} m.getBody() {}::    
		// ",queueName, m.getBody());
	}
	public void testConsume() throws IOException{
		URL conURL = new URL("http://"+ipvalue+":8080/Producer-0.0.1-snapshot/hello1");
		//URL conURL = new URL("http://"+ipvalue+":8082/hello1");
		HttpURLConnection conn = null;
		try {
			conn = (HttpURLConnection)conURL.openConnection();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		conn.setDoOutput(true);
		conn.setRequestMethod("GET");
		if (conn.getResponseCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ conn.getResponseCode());
		}

		BufferedReader br = new BufferedReader(new InputStreamReader(
			(conn.getInputStream())));

		String output;
		System.out.println("Output from Server .... \n");
		System.out.println("For Second Method Called \n");
		while ((output = br.readLine()) != null) {
			System.out.println(output);
		}
		conn.disconnect();
		
	}
	
	public void showTime()
	{
		  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		   LocalDateTime now = LocalDateTime.now();  
		   System.out.println(dtf.format(now));  
	}
}

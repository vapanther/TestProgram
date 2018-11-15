package com.crosscode.ConsumerDB.demo.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ProtocolException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crosscode.ConsumerDB.demo.consumer.Consume;

@RestController
public class SampleController {

   @Autowired
   Consume consume;
	
	@RequestMapping("/consume")
    public String index() throws IOException {
    	
		try {
			consume.getUser();
			consume.crosscode();
			consume.showTime();
		} catch (ProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return "hi this is tomcat";
    	//System.out.println("my Anme us bjhbd");
       
        		
    }
    
}
package com.crosscode.ConsumerDB.demo.controller2;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ProtocolException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crosscode.ConsumerDB.demo.consumer.Consume;

@RestController
public class ControllerCall {

	@Autowired
	Consume consume;

	@RequestMapping("/consume1")
	public String index() throws IOException {

		try {
			consume.testConsume();
		} catch (ProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "hi this is tomcat 2 called ";

	}

}

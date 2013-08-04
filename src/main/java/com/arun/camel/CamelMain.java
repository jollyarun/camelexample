package com.arun.camel;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class CamelMain {

	public void fileComponentExample() throws Exception {

		/* Creating the camel context */
		DefaultCamelContext camelContext = new DefaultCamelContext();
		camelContext.addRoutes(new RouteBuilder() {

			@Override
			public void configure() throws Exception {
				from("file:camel/test1").to("file:camel/test2");

			}
		});

		/* Starting the context */
		camelContext.start();
		System.out
				.println("Context started...Start Putting your files...Quick quick");
		System.out.println("Im going to add this here to see how i can compare it against git");
		Thread.sleep(60000);
		System.out.println("Context stopped");

	}

	public void pingGoogleExample() throws Exception {

		DefaultCamelContext camelContext = new DefaultCamelContext();
		camelContext.addRoutes(new RouteBuilder() {

			@Override
			public void configure() throws Exception {

				from("timer://foo?fixedRate=true&delay=0&period=10000").to(
						"http://www.google.com").to(
						"file:camel/google/test.html?autoCreate=true");
			}
		});

		camelContext.start();
		System.out.println("Camel Context started...");
		Thread.sleep(60000);
		System.out.println("Context stopped...");
	}

	public static void main(String[] args) throws Exception {

		CamelMain camelMain = new CamelMain();
		camelMain.pingGoogleExample();
	}
}

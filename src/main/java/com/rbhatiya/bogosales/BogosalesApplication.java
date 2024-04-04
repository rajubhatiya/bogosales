package com.rbhatiya.bogosales;

import com.rbhatiya.bogosales.service.BogoAssignmentExample;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BogosalesApplication {
	public static void main(String[] args) {
		SpringApplication.run(BogosalesApplication.class, args);

		System.out.println("----Rule1----");
		BogoAssignmentExample.bogoAssignmentRule1();
		System.out.println("\n\n----Rule2----");
		BogoAssignmentExample.bogoAssignmentRule2();
		System.out.println("\n\n----Rule3----");
		BogoAssignmentExample.bogoAssignmentRule3();

	}
}

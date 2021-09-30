package cab.invoice;
import org.junit.jupiter.api.BeforeEach;
import java.util.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class InvoiceServiceTest {
	InvoiceGenerator invoiceGenerator = null;
	@BeforeEach
	public void setUp() throws Exception{
		invoiceGenerator = new InvoiceGenerator();
	}

	@Test
	public void givenDistanceAndTime_ShouldReturnTotalFare() {
		double distance = 2.0;
		int time = 5;
		double fare = invoiceGenerator.calculateFare("premium",distance,time);
		assertEquals(40,fare,0.0);
	}

	@Test
	public void givenLessDistanceAndTime_ShouldReturnMinimumFare() {
		double distance = 0.1;
		int time = 1;
		double fare = invoiceGenerator.calculateFare("normal",distance,time);
		assertEquals(5,fare,0.0);
	}
	@Test
	public void givenLessDistanceAndTim_ShouldReturnMinimumFare() {
		double distance = 0.1;
		int time = 1;
		double fare = invoiceGenerator.calculateFare("normal",distance,time);
		assertEquals(5,fare,0.0);
	}

	@Test
	public void givenLessDistanceAndTim_ShouldReturnMinimumFae() {
		double distance = 0.1;
		int time = 1;
		double fare = invoiceGenerator.calculateFare("normal",distance,time);
		assertEquals(5,fare,0.0);
	}

	@Test
	public void givenMultipleRide_ShouldReturnInvoiceSummary() {
		Ride[] user1rides = { new Ride(2.0,5),
				new Ride(0.1,1),
				new Ride(2,10)
		};
		Ride[] user2rides = { new Ride(3.0,5),
				new Ride(0.1,2)
		};
		Ride[] user3rides = { new Ride(2.0,10),
				new Ride(0.1,1)
		};
		Map<Integer,Ride[]> rideRepository = new HashMap<>();
		rideRepository.put(101, user1rides);
		rideRepository.put(102, user2rides);
		rideRepository.put(103, user3rides);
		int userID = 101;
		String rideCategory = "normal";
		InvoiceSummary summary = invoiceGenerator.calculateFare(rideCategory,rideRepository.get(userID));
		InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(3,60.0);
		assertEquals(expectedInvoiceSummary,summary);
	}

	@Test
	public void givenMultipleRide_ShouldReturnInvoiceSummaryForPremiumRides() {
		Ride[] user1rides = { new Ride(2.0,5),
				new Ride(0.1,1),
				new Ride(2,10)
		};
		Ride[] user2rides = { new Ride(3.0,5),
				new Ride(0.1,2)
		};
		Ride[] user3rides = { new Ride(2.0,10),
				new Ride(0.1,1)
		};
		Map<Integer,Ride[]> rideRepository = new HashMap<>();
		rideRepository.put(101, user1rides);
		rideRepository.put(102, user2rides);
		rideRepository.put(103, user3rides);
		int userID = 101;
		String rideCategory = "premium";
		InvoiceSummary summary = invoiceGenerator.calculateFare(rideCategory,rideRepository.get(userID));
		InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(3,110.0);
		assertEquals(expectedInvoiceSummary,summary);
	}
	@Test
	public void givenMultileRide_ShouldReturnInvoiceSummaryForPremiumRides() {
		Ride[] user1rides = { new Ride(2.0,5),
				new Ride(0.1,1),
				new Ride(2,10)
		};
		Ride[] user2rides = { new Ride(3.0,5),
				new Ride(0.1,2)
		};
		Ride[] user3rides = { new Ride(2.0,10),
				new Ride(0.1,1)
		};
		Map<Integer,Ride[]> rideRepository = new HashMap<>();
		rideRepository.put(101, user1rides);
		rideRepository.put(102, user2rides);
		rideRepository.put(103, user3rides);
		int userID = 101;
		String rideCategory = "premium";
		InvoiceSummary summary = invoiceGenerator.calculateFare(rideCategory,rideRepository.get(userID));
		InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(3,110.0);
		assertEquals(expectedInvoiceSummary,summary);
	}
}



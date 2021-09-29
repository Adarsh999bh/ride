package cab.invoice;

public class InvoiceGenerator {

	private static final int COST_PER_TIME = 1;
	private static final double MINIMUM_COST_PER_KILOMETER = 10.0;
	private static final double MINIMUM_FARE = 5;

	private static final int COST_PER_TIME_PREMIUM = 2;
	private static final double MINIMUM_COST_PER_KILOMETER_PREMIUM = 15.0;
	private static final double MINIMUM_FARE_PREMIUM = 20;

	public double calculateFare(String rideCategory,double distance, int time) {
		if(rideCategory.equals("premium")) {
			double totalFare = distance * MINIMUM_COST_PER_KILOMETER_PREMIUM + time * COST_PER_TIME_PREMIUM;
			return Math.max(totalFare,MINIMUM_FARE_PREMIUM);
		}else {
			double totalFare = distance * MINIMUM_COST_PER_KILOMETER + time * COST_PER_TIME;
			return Math.max(totalFare,MINIMUM_FARE);
		}
	}

	public InvoiceSummary calculateFare(String rideCategory,Ride[] rides) {
		double totalFare = 0;
		for(Ride ride:rides) {
			totalFare += this.calculateFare(rideCategory,ride.distance,ride.time);
		}
		return new InvoiceSummary(rides.length,totalFare);
	}

}

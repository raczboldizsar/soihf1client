package cinema;

import javax.xml.ws.BindingProvider;

import seatreservation.CinemaService;
import seatreservation.ICinema;
import seatreservation.ICinemaLockCinemaException;

public class Program {

	public static void main(String[] args) {
		CinemaService cinemaService = new CinemaService();   
		ICinema cinema = cinemaService.getICinemaHttpSoap11Port();   
		BindingProvider bp = (BindingProvider)cinema;  
		// Set the URL of the service:  
		bp.getRequestContext().put(     
				BindingProvider.ENDPOINT_ADDRESS_PROPERTY,     
				"http://localhost:8080/WebService_VE9C1P/Cinema");  
		String result = null;
		try {
			result = cinema.lock(null, 0);
		} catch (ICinemaLockCinemaException e) {
			e.printStackTrace();
		}   
		System.out.println(result); 
	}
	
}

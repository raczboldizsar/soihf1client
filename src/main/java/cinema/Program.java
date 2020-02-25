package cinema;

import javax.xml.ws.BindingProvider;

import seatreservation.ArrayOfSeat;
import seatreservation.CinemaService;
import seatreservation.ICinema;
import seatreservation.ICinemaBuyCinemaException;
import seatreservation.ICinemaGetAllSeatsCinemaException;
import seatreservation.ICinemaGetSeatStatusCinemaException;
import seatreservation.ICinemaInitCinemaException;
import seatreservation.ICinemaLockCinemaException;
import seatreservation.ICinemaReserveCinemaException;
import seatreservation.ICinemaUnlockCinemaException;
import seatreservation.Seat;

public class Program {

	public static void main(String[] args) {
		ICinema cinema = connect(args[0]);
		Seat seat = new Seat();
		seat.setRow(args[1]);
		seat.setColumn(args[2]);
		try {
			switch (args[3]) {
			case "Lock":
				cinema.lock(seat, 1);
				break;
			case "Reserve":
				String lockId = cinema.lock(seat, 1);
				cinema.reserve(lockId);
				break;
			case "Buy":
				String lockId2 = cinema.lock(seat, 1);
				cinema.buy(lockId2);
				break;

			default:
				break;
			}
		} catch (ICinemaLockCinemaException | ICinemaReserveCinemaException | ICinemaBuyCinemaException e) {
			e.printStackTrace();
		}
	}

	private static void testServer() {
		String url = "http://localhost:8080/WebService_VE9C1P/Cinema";

		ICinema cinema = connect(url);

		try {
			cinema.init(10, 20);
		} catch (ICinemaInitCinemaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			System.out.println(cinema.getAllSeats());
		} catch (ICinemaGetAllSeatsCinemaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Seat s = new Seat();
		s.setRow("Z");
		s.setColumn("50");
		try {
			System.out.println(cinema.getSeatStatus(s));
		} catch (ICinemaGetSeatStatusCinemaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		s.setRow("C");
		s.setColumn("13");
		try {
			System.out.println(cinema.getSeatStatus(s));
		} catch (ICinemaGetSeatStatusCinemaException e22) {
			// TODO Auto-generated catch block
			e22.printStackTrace();
		}
		s.setRow("H");
		s.setColumn("5");
		try {
			System.out.println(cinema.lock(s, 5));
		} catch (ICinemaLockCinemaException e21) {
			// TODO Auto-generated catch block
			e21.printStackTrace();
		}
		s.setRow("H");
		s.setColumn("2");
		try {
			System.out.println(cinema.lock(s, 5));
		} catch (ICinemaLockCinemaException e20) {
			// TODO Auto-generated catch block
			e20.printStackTrace();
		}
		s.setRow("H");
		s.setColumn("18");
		try {
			System.out.println(cinema.lock(s, 5));
		} catch (ICinemaLockCinemaException e19) {
			// TODO Auto-generated catch block
			e19.printStackTrace();
		}
		s.setRow("F");
		s.setColumn("8");
		String lockId = null;
		try {
			lockId = cinema.lock(s, 3);
		} catch (ICinemaLockCinemaException e18) {
			// TODO Auto-generated catch block
			e18.printStackTrace();
		}
		try {
			System.out.println(cinema.getSeatStatus(s));
		} catch (ICinemaGetSeatStatusCinemaException e17) {
			// TODO Auto-generated catch block
			e17.printStackTrace();
		}
		try {
			cinema.unlock(lockId);
		} catch (ICinemaUnlockCinemaException e16) {
			// TODO Auto-generated catch block
			e16.printStackTrace();
		}
		try {
			System.out.println(cinema.getSeatStatus(s));
		} catch (ICinemaGetSeatStatusCinemaException e15) {
			// TODO Auto-generated catch block
			e15.printStackTrace();
		}
		try {
			System.out.println(cinema.lock(s, 3));
		} catch (ICinemaLockCinemaException e14) {
			// TODO Auto-generated catch block
			e14.printStackTrace();
		}
		s.setRow("E");
		s.setColumn("7");
		String lockId2 = null;
		try {
			lockId2 = cinema.lock(s, 3);
		} catch (ICinemaLockCinemaException e13) {
			// TODO Auto-generated catch block
			e13.printStackTrace();
		}
		try {
			cinema.reserve(lockId2);
		} catch (ICinemaReserveCinemaException e12) {
			// TODO Auto-generated catch block
			e12.printStackTrace();
		}
		try {
			System.out.println(cinema.getSeatStatus(s));
		} catch (ICinemaGetSeatStatusCinemaException e11) {
			// TODO Auto-generated catch block
			e11.printStackTrace();
		}
		try {
			System.out.println(cinema.lock(s, 5));
		} catch (ICinemaLockCinemaException e10) {
			// TODO Auto-generated catch block
			e10.printStackTrace();
		}
		s.setRow("G");
		s.setColumn("9");
		String lockId3 = null;
		try {
			lockId3 = cinema.lock(s, 3);
		} catch (ICinemaLockCinemaException e9) {
			// TODO Auto-generated catch block
			e9.printStackTrace();
		}
		try {
			cinema.buy(lockId3);
		} catch (ICinemaBuyCinemaException e8) {
			// TODO Auto-generated catch block
			e8.printStackTrace();
		}
		try {
			System.out.println(cinema.getSeatStatus(s));
		} catch (ICinemaGetSeatStatusCinemaException e7) {
			// TODO Auto-generated catch block
			e7.printStackTrace();
		}
		try {
			System.out.println(cinema.lock(s, 5));
		} catch (ICinemaLockCinemaException e6) {
			// TODO Auto-generated catch block
			e6.printStackTrace();
		}
		try {
			cinema.init(10, 20);
		} catch (ICinemaInitCinemaException e5) {
			// TODO Auto-generated catch block
			e5.printStackTrace();
		}
		s.setRow("A");
		s.setColumn("4");
		try {
			System.out.println(cinema.lock(s, 1));
		} catch (ICinemaLockCinemaException e4) {
			// TODO Auto-generated catch block
			e4.printStackTrace();
		}
		s.setRow("H");
		s.setColumn("5");
		String lockId4 = null;
		try {
			lockId4 = cinema.lock(s, 1);
		} catch (ICinemaLockCinemaException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		try {
			cinema.reserve(lockId4);
		} catch (ICinemaReserveCinemaException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		s.setRow("D");
		s.setColumn("12");
		String lockId5 = null;
		try {
			lockId5 = cinema.lock(s, 1);
		} catch (ICinemaLockCinemaException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			cinema.buy(lockId5);
		} catch (ICinemaBuyCinemaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static ICinema connect(String url) {
		CinemaService cinemaService = new CinemaService();
		ICinema cinema = cinemaService.getICinemaHttpSoap11Port();
		BindingProvider bp = (BindingProvider) cinema;
		// Set the URL of the service:

		bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, url);
		return cinema;
	}

}

package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservations;

public class Program {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Room Number");
		int roomNumber = sc.nextInt();
		System.out.print("Check-in: dd/mm/yyyy");
		Date checkin = sdf.parse(sc.next());
		System.out.print("Check-out: dd/mm/yyyy");
		Date checkout = sdf.parse(sc.next());
		
		if (!checkout.after(checkin)) {
			System.out.println("Error in Reservation: Check-out date must be after check-in date");
		}
		else {
			Reservations reservation = new Reservations(roomNumber, checkin, checkout);
			System.out.println("Reservation: " + reservation);
			
			System.out.println();
			System.out.print("Enter data to update the reservation");
			System.out.print("Check-in: dd/mm/yyyy");
			checkin = sdf.parse(sc.next());
			System.out.print("Check-out: dd/mm/yyyy");
			checkout = sdf.parse(sc.next());
			

			String error = reservation.updateDates(checkin, checkout);			
			if (error != null) {
				System.out.println("Error in Reservation: " + error);
			}
			else {
				System.out.println("Reservation: " + reservation);
			}

		
		}
		
		sc.close();

	}

}

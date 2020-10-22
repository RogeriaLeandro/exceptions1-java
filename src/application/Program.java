package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservations;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.print("Room Number");
			int roomNumber = sc.nextInt();
			System.out.print("Check-in: dd/mm/yyyy");
			Date checkin = sdf.parse(sc.next());
			System.out.print("Check-out: dd/mm/yyyy");
			Date checkout = sdf.parse(sc.next());
			
			Reservations reservation = new Reservations(roomNumber, checkin, checkout);
			System.out.println("Reservation: " + reservation);
			
			System.out.println();
			System.out.print("Enter data to update the reservation");
			System.out.print("Check-in: dd/mm/yyyy");
			checkin = sdf.parse(sc.next());
			System.out.print("Check-out: dd/mm/yyyy");
			checkout = sdf.parse(sc.next());
	
			reservation.updateDates(checkin, checkout);			
			System.out.println("Reservation: " + reservation);
		}
		catch (ParseException e) {
			System.out.println("Invalid Date Format");
		}
		catch (DomainException e) {
			System.out.println("Error in Reservation" + e.getMessage());
		}
		catch (RuntimeException e) {
			System.out.println("Unexpected Error");
		}
		
		sc.close();

	}

}

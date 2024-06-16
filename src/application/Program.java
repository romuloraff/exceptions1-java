package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Número do quarto: ");
		int number = sc.nextInt();
		System.out.print("Check-in data (dd/MM/YYYY): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Check-out data (dd/MM/YYYY): ");
		Date checkOut = sdf.parse(sc.next());
		
		if (!checkOut.after(checkIn)) {
			System.out.println("A data de check-out deve ser posterior ao check-in: ");
			
		}
		else {
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reserva: " + reservation);
			
			System.out.println();
			System.out.println("Insira os dados para atualizar a reserva: ");
			System.out.print("Check-in data (dd/MM/YYYY): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-out data (dd/MM/YYYY): ");
			checkOut = sdf.parse(sc.next());
			
			Date now = new Date();
			if (checkIn.before(now) || checkOut.before(now)) {
				System.out.println("Erro na reserva: As datas de reserva para atualização devem ser datas futuras");
			}
			else if (!checkOut.after(checkIn)) {
				System.out.println("Erro na reserva: A data de check-out deve ser posterior ao check-in: ");
			}
			else {
				reservation.updateDates(checkIn, checkOut);
				System.out.println("Reserva: " + reservation);
			}
       	
		}
		sc.close();
	}

}

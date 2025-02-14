package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

import model.entities.Reserva;
import model.exceptions.DomainException;

public class Aplicacao {
    public static void main(String[] args){
        try {
            Scanner sc = new Scanner(System.in);
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            System.out.print("Numero do quarto: ");
            Integer numeroQuarto = sc.nextInt();
            sc.nextLine();

            System.out.print("Data de Check-In (dd/MM/yyyy): ");
            LocalDate checkIn = LocalDate.parse(sc.nextLine(), fmt);

            System.out.print("Data de Check-out (dd/MM/yyyy): ");
            LocalDate checkOut = LocalDate.parse(sc.nextLine(), fmt);

            Reserva reserva1 = new Reserva(numeroQuarto, checkIn, checkOut);
            System.out.print(reserva1);

            System.out.println("\nEntre com as informações para atualizar a reserva:");
            System.out.print("Data de Check-In (dd/MM/yyyy): ");
            LocalDate novoCheckIn = LocalDate.parse(sc.nextLine(),fmt);

            System.out.print("Data de Check-out (dd/MM/yyyy): ");
            LocalDate novoCheckOut = LocalDate.parse(sc.nextLine(),fmt);

            reserva1.atualizarData(novoCheckIn,novoCheckOut);
            System.out.print(reserva1);
        }
        catch(InputMismatchException e){
            System.out.println("Numero de quarto invalido.");
        }
        catch (DateTimeParseException e){
            System.out.println("Formato de data invalido.");
        }
        catch (DomainException e){
            System.out.println("Erro na reserva: " + e.getMessage());
        }

    }
}

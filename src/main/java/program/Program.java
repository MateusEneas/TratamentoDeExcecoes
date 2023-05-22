package program;

import model.entities.Reserva;
import model.exceptions.DomainExceptions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            System.out.print("Numero do quarto: ");
            int numero = sc.nextInt();
            System.out.print("Data de entrada (DD/MM/YYYY): ");
            Date dataEntrada = sdf.parse(sc.next());
            System.out.print("Data de saida (DD/MM/YYYY): ");
            Date dataSaida = sdf.parse(sc.next());

            Reserva reserva = new Reserva(numero, dataEntrada, dataSaida);
            System.out.println("Reserva: " + reserva);

            System.out.println();
            System.out.println("Entre com a alteração da data: ");
            System.out.print("Data de entrada (DD/MM/YYYY): ");
            dataEntrada = sdf.parse(sc.next());
            System.out.print("Data de saida (DD/MM/YYYY): ");
            dataSaida = sdf.parse(sc.next());

            reserva.alterarData(dataEntrada, dataSaida);
            System.out.println("Reserva: " + reserva);
        }
        catch (ParseException e) {
            System.out.println("Data inválida");
        }
        catch (DomainExceptions e) {
            System.out.println(e.getMessage());
        }
        catch (RuntimeException e) {
            System.out.println("Erro inesperado!");
        }
        sc.close();
    }
}

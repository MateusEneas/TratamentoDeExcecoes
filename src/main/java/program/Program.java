package program;

import entities.Reserva;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) throws ParseException {

        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Numero do quarto: ");
        int numero = sc.nextInt();
        System.out.print("Data de entrada (DD/MM/YYYY): ");
        Date dataEntrada = sdf.parse(sc.next());
        System.out.print("Data de saida (DD/MM/YYYY): ");
        Date dataSaida = sdf.parse(sc.next());

        if (!dataSaida.after(dataEntrada)) {
            System.out.println("Erro na reserva: Data de entrada não pode ser depois da data de saída!");
        }
        else {
            Reserva reserva = new Reserva(numero, dataEntrada, dataSaida);
            System.out.println("Reserva: " + reserva);

            System.out.println();
            System.out.println("Entre com a alteração da data: ");
            System.out.print("Data de entrada (DD/MM/YYYY): ");
            dataEntrada = sdf.parse(sc.next());
            System.out.print("Data de saida (DD/MM/YYYY): ");
            dataSaida = sdf.parse(sc.next());

            String error = reserva.alterarData(dataEntrada, dataSaida);
            if (error != null) {
                System.out.println("Erro na reserva: " + error);
            }
            else {
                System.out.println("Reserva: " + reserva);
            }
        }
        sc.close();
    }
}

package model.entities;

import model.exceptions.DomainExceptions;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {

    private Integer numeroQuarto;
    private Date dataEntrada;
    private Date dataSaida;

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Reserva() {
    }

    public Reserva(Integer numeroQuarto, Date dataEntrada, Date dataSaida) {
        if (!dataSaida.after(dataEntrada)) {
            throw new DomainExceptions("Erro na reserva: Data de entrada não pode ser depois da data de saída!");
        }
        this.numeroQuarto = numeroQuarto;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
    }

    public Integer getNumeroQuarto() {
        return numeroQuarto;
    }

    public void setNumeroQuarto(Integer numeroQuarto) {
        this.numeroQuarto = numeroQuarto;
    }

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public Date getDataSaida() {
        return dataSaida;
    }

    public long duration() {
        long diff = dataSaida.getTime() - dataEntrada.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }

    public void alterarData (Date dataEntrada, Date dataSaida) {
        Date agora = new Date();
        if (dataEntrada.before(agora) || dataSaida.before(agora)) {
            throw new DomainExceptions("A data de reserva tem que ser futura!");
        }
        if (!dataSaida.after(dataEntrada)) {
            throw new DomainExceptions("Erro na reserva: Data de entrada não pode ser depois da data de saída!");
        }
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
    }

    @Override
    public String toString() {
        return "Quarto "
                + numeroQuarto
                + ", data de entrada: "
                + sdf.format(dataEntrada)
                + ", data de saída: "
                + sdf.format(dataSaida)
                + ", "
                + duration()
                + " noites";
    }
}

package model.entities;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import model.exceptions.DomainException;

public class Reserva {
    private Integer numeroQuarto;
    private LocalDate checkIn;
    private LocalDate checkOut;
    DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Reserva(Integer numeroQuarto, LocalDate checkIn, LocalDate checkOut) throws DomainException{
        if(checkOut.isBefore(checkIn)){
            throw new DomainException("A data de check-out deve ser depois da data de check-in.");
        }
        this.numeroQuarto = numeroQuarto;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Integer getNumeroQuarto() {
        return numeroQuarto;
    }

    public void setNumeroQuarto(Integer numeroQuarto) {
        this.numeroQuarto = numeroQuarto;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(LocalDate checkIn) {
        this.checkIn = checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(LocalDate checkOut) {
        this.checkOut = checkOut;
    }

    public long duracao(){
        Duration duracao = Duration.between(getCheckIn().atStartOfDay(), getCheckOut().atStartOfDay());
        return duracao.toDays();
    }

    public void atualizarData(LocalDate checkIn, LocalDate checkOut) throws DomainException{

        if(checkIn.isBefore(getCheckIn()) || checkOut.isBefore(getCheckOut())){
            throw new DomainException("Datas de reservas devem ser para datas futuras.");
        }
        if(checkOut.isBefore(checkIn)){
            throw new DomainException("A data de check-out deve ser depois da data de check-in.");
        }
        setCheckOut(checkOut);
        setCheckIn(checkIn);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Reserva: Quarto " + numeroQuarto
                + ", Check-In: " + checkIn.format(fmt)
                + ", Check-out: " + checkOut.format(fmt)
                + ", " + duracao() + " noites."
        );

        return sb.toString();
    }
}

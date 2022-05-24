package hu.leczildiko.tictactoefx.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;



public class Game {
    private LocalDateTime start;
    private String winner;

    private Double length;

    public Game(LocalDateTime start, String winner, Double length) {
        this.start = start;
        this.winner = winner;
        this.length = length;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }



        @Override
        public String toString() {

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");


            return "Játék{" +
                    "Kezdete: " + start.format(formatter) +
                    ", Győztes: '" + winner +
                    ", Játék hossza: "+String.format("%.2f", length)+ " másodperc"+ '\'' +
                    '}';
        }


}

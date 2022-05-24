package hu.leczildiko.tictactoefx;
import hu.leczildiko.tictactoefx.model.Game;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class JdbcDao {

    private static final String DATABASE_URL = "jdbc:mysql://sql11.freemysqlhosting.net:3306/sql11494994?useSSL=false";
    private static final String DATABASE_USERNAME = "sql11494994";
    private static final String DATABASE_PASSWORD = "fzT9fTRkmd";
    private static final String INSERT_QUERY = "INSERT INTO game (start, winner, gamelength) VALUES (?, ?, ?)";
    private static final String SELECT_QUERY = "SELECT * FROM game";



    public void insertRecord(Game game) {


        try (Connection connection = DriverManager
                .getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);

             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUERY)) {
            preparedStatement.setString(1, game.getStart().toString());
            preparedStatement.setString(2, game.getWinner());
            preparedStatement.setDouble(3, game.getLength());


            preparedStatement.executeUpdate();
        } catch (SQLException e) {

            System.out.println(e.toString());
        }
    }

    public List<Game> getAllGames() {

        List<Game> gameList = new ArrayList<>();


        try (Connection connection = DriverManager
                .getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);


             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_QUERY)) {

            ResultSet resultSet = preparedStatement.executeQuery();


            while (resultSet.next()) {

                String start = resultSet.getString("start");
                String winner = resultSet.getString("winner");
                Double gamelength = resultSet.getDouble("gamelength");

                gameList.add(new Game(LocalDateTime.parse(start), winner, gamelength));
            }


        } catch (SQLException e) {
            // print SQL exception information

            System.out.println(e.toString());
        }
        System.out.println(gameList);
        return gameList;
    }
}







package org.example.repositories;

import org.example.models.UserModel;
import org.example.utilities.DB;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.LinkedList;
import java.util.List;

public class UserRepository {

    @NotNull
    public static List<UserModel> returnUsers(String userStatus) throws Exception {
        var query = "SELECT * FROM users WHERE userStatus = ?";
        try (var connection = DB.connection();
             var statement = connection.prepareStatement(query);) {
            statement.setString(1, userStatus);
            try (var resultSet = statement.executeQuery();) {
                LinkedList<UserModel> users = new LinkedList<>();
                while (resultSet.next()) {
                    var userID = resultSet.getInt("userID");
                    var fullName = resultSet.getString("fullName");
                    var email = resultSet.getString("email");
                    var password = resultSet.getString("password_hash");
                    var qualification = resultSet.getString("qualification");
                    var statusReturned = resultSet.getString("userStatus");
                    var campusID = resultSet.getInt("campusID");
//                    TODO: Remove returning the password
                    users.add(new UserModel(userID, fullName, email, password, qualification, statusReturned, campusID));
                }
                return users;
            }
        }
    }

    //    return user by email and password match
    public static UserModel returnUserByEmailPassword(String email, String password) throws Exception {
        String query = "SELECT * FROM users " +
                " WHERE email = ? AND password_hash = ?; ";

        try (var connection = DB.connection();
             var statement = connection.prepareStatement(query);) {
            statement.setString(1, email);
            statement.setString(2, password);

            try (var resultSet = statement.executeQuery();) {
                resultSet.next();
                var id = resultSet.getInt("userID");
                var fullName = resultSet.getString("fullName");
                var emailSet = resultSet.getString("email");
                var password_hash = resultSet.getString("password_hash");
                var qualification = resultSet.getString("qualification");
                var userStatus = resultSet.getString("userStatus");
                var campusID = resultSet.getInt("campusID");

                return new UserModel(id, fullName, emailSet, password_hash, qualification, userStatus, campusID);

            }
        }
    }


    // Creating a user
    @NotNull
    @Contract("_, _, _, _, _, _ -> new")
    public static UserModel createUser(String fullName, String email,
                                       String password_hash, String qualification,
                                       String userStatus, int campus) throws Exception {
        var createUserQuery = "INSERT INTO users(fullName, email, password_hash, qualification, userStatus, campusID) VALUES (?, ?, ?, ?, ?, ?);";

        try (var connection = DB.connection();
             var statementCreateUser = connection.prepareStatement(createUserQuery);) {
            statementCreateUser.setString(1, fullName);
            statementCreateUser.setString(2, email);
            statementCreateUser.setString(3, password_hash);
            statementCreateUser.setString(4, qualification);
            statementCreateUser.setString(5, userStatus);
            statementCreateUser.setInt(6, campus);
            statementCreateUser.executeUpdate();
            var returnUserQuery = "SELECT * FROM users " +
                    "ORDER BY userID DESC " +
                    "LIMIT 1";

            try (var statementReturnLast = connection.prepareStatement(returnUserQuery);
                 var resultSet = statementReturnLast.executeQuery();) {
                resultSet.next();
                var id = resultSet.getInt("userID");
                return new UserModel(id, fullName, email, password_hash, qualification, userStatus, campus);
            }
        }

    }
}

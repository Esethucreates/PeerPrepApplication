package org.example.utilities;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.Connection;
import java.sql.DriverManager;


public class DB {
    private static final Dotenv dotenv = Dotenv.configure().directory("src/vars/.env").load();

    public static Connection connection() throws Exception{
        var dbURl = dotenv.get("DB_URL");
        var dbUSERNAME = dotenv.get("DB_USERNAME");
        var dbPASSWORD = dotenv.get("DB_PASSWORD");
        return DriverManager.getConnection(dbURl, dbUSERNAME,dbPASSWORD);

    }

}

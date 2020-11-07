package main;

import org.flywaydb.core.Flyway;

import java.io.IOException;
import java.util.Arrays;

public class FlywayMigrate {
    public static void main(String[] args) throws IOException {
        // Create the Flyway instance and point it to the database
        Flyway flyway = Flyway.configure().dataSource("jdbc:postgresql://course-db1.cbp2hye5u6cf.us-east-1.rds.amazonaws.com:5432/postgres", "postgres", "qwerty007")
                .load();

        // Start the migration
        flyway.repair();
        flyway.migrate();


    }
}

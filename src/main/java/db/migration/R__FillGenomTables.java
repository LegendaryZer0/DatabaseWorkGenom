package db.migration;

import com.google.common.collect.HashMultiset;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class R__FillGenomTables /*extends BaseJavaMigration*/
{
    static int batchСursor=0;
    static int batchSize=100;
    private static final String URL = "jdbc:postgresql://course-db1.cbp2hye5u6cf.us-east-1.rds.amazonaws.com:5432/postgres";
    private static final String USER = "postgres";
    private static final String PASSWORD = "qwerty007";
    private static  String[] array;
    private static ArrayList<String> arrayList = new ArrayList<>(100);

    //language=SQL
    private static final String SQL_ADD_GENOM1="INSERT INTO \"genom1\" VALUES (?)";
    //language=SQL
    private static final String SQL_ADD_GENOM2="INSERT INTO \"genom2\" VALUES (?)";

    public static void main( String[] args ) throws IOException {
     /*   Flyway flyway = Flyway.configure().dataSource(URL, USER, PASSWORD).load();*/







    }




    public static void prepareData(File file,int length) throws IOException {
        int a =16;
        int b =a*4;
        int c = a*b;
        LineIterator it = FileUtils.lineIterator(file, "UTF-8");
        try {
            while (it.hasNext()) {
                String line = it.nextLine();
                for(int i =0;i<line.length()-length+1;i++){
                    arrayList.add(line.substring(i,i+length));
                }



            }
        } finally {
            LineIterator.closeQuietly(it);
        }




    }






    public static void insertData(String SQL){
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            arrayList.forEach(x->{
                try {
                    preparedStatement.setString(1, x);
                    if(batchСursor<batchSize) {
                        preparedStatement.addBatch();
                        batchСursor++;
                    }else {
                        preparedStatement.executeBatch();
                        batchСursor=0;
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                    throwables.getNextException();
                    throwables.printStackTrace();
                }
            });
            preparedStatement.executeBatch();
            System.out.println("дошёл до конца");




        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

/*
    @Override
    public void migrate(Context context) throws Exception {
        File file1 = new File("src/main/resources/Genome_1-1.txt");
        File file2 = new File("src/main/resources/Genome_2-1.txt");

        prepareData(file1,9);
        insertData(SQL_ADD_GENOM1);
        prepareData(file2,9);
        insertData(SQL_ADD_GENOM2);

    }*/
}





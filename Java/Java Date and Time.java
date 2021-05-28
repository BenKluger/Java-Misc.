//https://www.hackerrank.com/challenges/java-date-and-time/problem


import java.time.*; 
import java.time.temporal.*;
class Result {

    /*
     * Complete the 'findDay' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. INTEGER month
     *  2. INTEGER day
     *  3. INTEGER year
     */
     
     

    public static String findDay(int month, int day, int year) {
        int m = month, d = day, y = year;
        LocalDate localDate = LocalDate.of(y, m, d); 
            return localDate.getDayOfWeek().toString();
           
    }

}


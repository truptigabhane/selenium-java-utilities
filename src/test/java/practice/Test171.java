package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test171 
{
	public static void main(String[] args) throws Exception
	{
		//1. Connect to DB as per DB technology used by DEV team
		Class.forName("com.mysql.jdbc.Driver"); //for MySQL server
		Connection con=DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/batch264","root","admin");
		//2. insert data into a table
		Statement st1=con.createStatement(); 
		st1.executeUpdate("insert into search_words(word) values('magnitia');");
		//3. update data in a table
		Statement st2=con.createStatement(); 
		st2.executeUpdate("update search_words set word='magnitiait' where word='magnitia';");
		//4. Get data from DB table using SQL query
		Statement st3=con.createStatement();  
		ResultSet res=st3.executeQuery("select * from search_words;");
		while(res.next()) //goto each row in result set sequentially
		{
			String value=res.getString(2); //take 2nd column(word) value in that row
			System.out.println(value);
		}
		//5. delete data from a table
		Statement st4=con.createStatement(); 
		st4.executeUpdate("delete from search_words where word='magnitiait';");
		//disconnect from DB
		con.close();
	}
}

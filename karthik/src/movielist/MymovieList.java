package movielist;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

public class MymovieList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String url = "jdbc:sqlite:/C:\\Users\\dell\\Desktop\\coding\\db\\moviedb.db";
		try {
			//creating database
			Connection con = DriverManager.getConnection(url);
			System.out.println("Database connected");
			
			//creating table
			Statement st=con.createStatement();
			st.executeUpdate("create table favmovies (name varchar(20),actor varchar(20),actress varchar(20),release int(10),director varchar(20))");
			System.out.println("Table created");
			
			//inserting data into the table
			st.executeUpdate("insert into favmovies values('Jersey','Nani','Shraddha Srinath',2019,'Gowtam Tinnanuri')");
			st.executeUpdate("insert into favmovies values('Bajrangi Bhaijaan','Salman Khan','Kareena Kapoor',2015,'Kabir Khan')");
			st.executeUpdate("insert into favmovies values('Arya','Allu Arjun','Anu Mehta',2004,'Sukumar')");
			System.out.println("Data  Inserted into the movies table");
			
			ResultSet rs=st.executeQuery("select * from favmovies");
			
			System.out.println("\nMy favourite movies are:");
			System.out.println();
			System.out.println("Movie Name | "+ "Actor  |"+"Actress | "+" year of release | "+" Director ");
			while(rs.next())
			{
				System.out.println(rs.getString(1)+"  | "+rs.getString(2)+"  | "+rs.getString(3)+" |   "+rs.getInt(4)+"  | "+rs.getString(5));
			}
			
		
			System.out.println();
			ResultSet rs1=st.executeQuery("select name from favmovies where actor='Nani'");
			while(rs1.next())
			{
				System.out.println("The movie name is: "+rs1.getString(1));
			}
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}

	}

}

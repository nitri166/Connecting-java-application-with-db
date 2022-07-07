import java.sql.*;
import java.util.Scanner;
public class connect_java_final {
	public static void main(String[] args) throws Exception{
		String url ="jdbc:mysql://localhost:3306/neetika";
		String uname = "root";
		
		String pass = "neetika";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,uname,pass);
		Statement st = con.createStatement();
		PreparedStatement p = null;
		//batch1
		System.out.println("Enter the no of entries to be done in table");
		
		Scanner sc1= new Scanner(System.in); 
		int n = sc1.nextInt();
		for(int i = 1;i<=n;i++) 
		{
			Scanner sc2= new Scanner(System.in);
			System.out.print("Enter name ");  
			String name= sc2.nextLine();
			System.out.print("Enter clg name "); 
			String clgname = sc2.nextLine();
			
			System.out.print("Enter marks1 ");
			
			double marks1 = sc2.nextDouble();
			System.out.print("Enter marks2 ");
			double marks2 = sc2.nextDouble();
			
			
			System.out.print("Enter marks3 ");
			double marks3 = sc2.nextDouble();
			System.out.print("Enter tech_marks ");
			double tech_marks = sc2.nextDouble();
		
			String result ;
			double total_marks = marks1+marks2+ marks3+tech_marks;
			if(total_marks<35) {
				result = "Rejected";
			}else {
				result = "Selected";
			}
		
		
		
		
		
		
		    if(marks1 >=0 && marks1<=10 && marks2 >=0 && marks2<=10 && marks3 >=0 && marks3<=10 && tech_marks>=0 && tech_marks<=20){
		    	String sql ="insert into newtable values(?,?,?,?,?,?,?,?)";
		    	p = con.prepareStatement(sql);
        
      
		        //System.out.println("Hogaya kaam");
		    	p.setString(1,name);
		    	p.setString(2,clgname );
		    	p.setDouble(3,marks1);
		    	p.setDouble(4,marks2);
		    	p.setDouble(5,marks3);
		    	p.setDouble(6,tech_marks);
		    	p.setDouble(7, total_marks);
		    	p.setString(8, result);
       
        
        
		    	p.addBatch();
		    	p.executeBatch();
		    }
		    else {
		    	System.out.println("Out of bound entry");
		    }
			}
		
		
		
			    
		
		/*
		String sql = "Select *, Rank() over (Order By TechnicalRoundMarks Desc) Rank_ from newtable";
		p = con.prepareStatement(sql);
		
        ResultSet rs = p.executeQuery();
        
        String userData = "";
        while(rs.next()){
        	userData =  rs.getString(1)+" : "+rs.getString(2)+" : "+ rs.getDouble(3)+" : "+ rs.getDouble(4)+" : "+ rs.getDouble(5)+" : "+ rs.getDouble(6)+" : "+ rs.getDouble(7)+" : "+ rs.getString(8)+" : "+rs.getInt(9);
    		System.out.println(userData);
            
        }
        
		
		//System.out.println("Hogaya kaam");
		
		
	 */
		
		
		
		
		
				
		
		       
		        
		
        
        
        
       st.close();
       con.close();
	}
}

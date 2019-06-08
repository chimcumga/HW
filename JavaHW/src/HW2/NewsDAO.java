package HW2;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import HW2.ConnectionUtils;
import HW2.News;
import HW2.INewsDAO;



	public class NewsDAO extends ConnectionUtils implements INewsDAO {
		
		public static Scanner sc = new Scanner(System.in);

		@Override
		public void addNews() {
			// TODO Auto-generated method stub
	    Connection conn = null;
			 try {
		conn = getMyConnection();
	    Statement stt = conn.createStatement();
	    
			 System.out.println("Nhap ID News: ");
		     int IdNews = sc.nextInt();
		     System.out.println("Nhap ID category: ");
		     int IdCategory = sc.nextInt();
		     System.out.println("Nhap Names: ");
		     String name = sc.nextLine();
		     System.out.println("Nhap Description: ");
		     String description = sc.nextLine();
		     System.out.println("Nhap Details: ");
		     String detail = sc.nextLine();
		     System.out.println("Nhap Image: ");
		     String image = sc.nextLine();
		     System.out.println("Nhap Date: ");
		     String date = sc.nextLine();
		     System.out.println("Nhap ID User: ");
		     int IdUsers = sc.nextInt();
			 String sql = "insert into news values("+IdNews+",'"+IdCategory+"','"+ name+"','"+description+"','"+detail+"','"+image +"','"+date +"','"+IdUsers+"')";
			 System.out.println(sql);
			} catch(Exception e) {
				e.printStackTrace();
			}
			
		}

		@Override
		public void showNews() {
			// TODO Auto-generated method stub
		Connection conn = null;

			try {
		conn = getMyConnection();
		Statement stt = conn.createStatement();
		String show = "Select * From News";
		ResultSet rs = stt.executeQuery(show);	
		System.out.println("ID				IDCategory				Name				Description					Detail				Date	 		Image			UserID");

		while(rs.next()) {
						int IdNews = rs.getInt("IDNew");
						int IdCategory = rs.getInt("IDCategory");
						String name = rs.getString("Name");
						String description = rs.getString("Description");
						String detail = rs.getString("Detail");
						Date   date = (Date) rs.getDate("Date");
						String image = rs.getString("Image");
						String IdUser = rs.getString("UserID");
						
						System.out.println("%-5s %-5s %-20s %-30s %-20s %-10s %-10s %-5s \n" +IdNews +IdCategory +name	+description +detail +image +date +IdUser);

					}
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		
		@Override
		public void editNews() {
			// TODO Auto-generated method stub
			
			Connection conn = null;
			try {
						
			 conn = getMyConnection();
			 Statement stt = conn.createStatement();
			 

			 System.out.println("Nhap ID News: ");
		     int IdNews = sc.nextInt();
		     System.out.println("Nhap ID category: ");
		     int IdCategory = sc.nextInt();
		     System.out.println("Nhap Names: ");
		     String name = sc.nextLine();
		     System.out.println("Nhap Description: ");
		     String description = sc.nextLine();
		     System.out.println("Nhap Details: ");
		     String detail = sc.nextLine();
		     System.out.println("Nhap Image: ");
		     String image = sc.nextLine();
		     System.out.println("Nhap Date: ");
		     String date = sc.nextLine();
		     System.out.println("Nhap ID User: ");
		     int IdUsers = sc.nextInt();
		     
					News n = new News( IdNews,IdCategory, name, description, detail, image, date, IdUsers);
					String edit ="update news set "+"NewID=" +n.getNewID()+"',"+"CategoryID=',"+n.getCategoryID()+"',"+"Name=',"+n.getName()+"',"
							     +"description=',"+n.getDescription()+"',"+"detail=',"+n.getDetail()+"',"+"image=',"+n.getImage()+"',"
							    		 +"date=',"+n.getDate()+"',"+"UserID=',"+n.getUserID();
																						
					stt.executeUpdate(edit);	
					} catch (Exception e) {
						
						e.printStackTrace();
					}
					
				}		
			

		@Override
		public void deleteNews() {
			// TODO Auto-generated method stub
			
			Connection conn = null;
			try {
				conn = getMyConnection();
				Statement stt = conn.createStatement();
				System.out.println("Ten bai xoa: ");
				String name = sc.nextLine();
				String del = "Delete from News where Name "+"'"+name+"'";
				stt.execute(del);
				
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
/*	@Override
		public void findNews() {
			// TODO Auto-generated method stub
			
			
		}
		
	}
	*/
	public void menu(){	
	// TODO Auto-generated method stub
	do {	
		System.out.println("MENU");
		System.out.println("1.Add News");
		System.out.println("2.Show News  ");
		System.out.println("3.Edit News");
		System.out.println("4.Delete News");
		System.out.println("5.Find News");
		System.out.println("0.Exit");
		System.out.println("=========================");
		System.out.println("Nhap:");
		int s = sc.nextInt();
		switch(s) {
		case 1:
			addNews();
			break;
		case 2:
			showNews();
			break;
		case 3:
			editNews();
			break;
		case 4:
			deleteNews();
			break;
		case 5:
			findNews();
			break;
		case 0:
			break;

		default:
			System.out.println("moi ban nhap lai:");
			break;
		}	
	}while (true);
	}

	@Override
	public void findNews() {
		// TODO Auto-generated method stub
		
	}}
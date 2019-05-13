package HW;

public interface EmployeeDAO {
	
	public void addEmployee();
	public void showEmployee();
	public Employee searchByName(String nameInput);
	public void updateEmployeeByName(String nameInput, Double newSalary);
	

}

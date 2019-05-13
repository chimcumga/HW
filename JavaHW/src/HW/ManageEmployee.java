
package HW;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author TechCare
 *
 */
public class ManageEmployee implements EmployeeDAO {
	public static Scanner scanner = new Scanner(System.in);
	public static int inputNumber = 0;
	public static int employeeNo = 0;
	static ArrayList<Employee> empArr = new ArrayList<>();
	//public static Employee[] employees;// bt: khong dung kieu mang, thay bang kieu khac
	public static boolean isEndProgram = false;
	public static void main(String[] args) {
		showMenu();
		System.out.println("The program end!!!");
	}
	

	public static void showMenu() {
		EmployeeDAO employeeDAO = new ManageEmployee();
		do {
			if (isEndProgram) {
				break;
			}
			System.out.println("Choose one numbers below : ");
			System.out.println("1: Create  new Employees");
			System.out.println("2: Show the existing Employees");
			System.out.println("4: Search employee by name");
			System.out.println("5: Update employee by name");
			System.out.println("3: exit");
			System.out.println("-------------------------------");
			System.out.println("Type your input number : ");
			inputNumber = scanner.nextInt();
			switch (inputNumber) {
			case 1:
				employeeDAO.addEmployee();
				askForContinue();
				break;
			case 2:
				if (employeeDAO != null && empArr.size() > 0) {
					employeeDAO.showEmployee();
				} else {
					System.out.println("Please add new employee first!");
					System.out.println("-------------------------------");
				}
				askForContinue();
				break;
			case 3:
				break;
			case 4:
				System.out.println("Please input name to search : ");
				String nameInput = scanner.next();
				Employee employee = employeeDAO.searchByName(nameInput);
				System.out.println("-----Thong tin tim kiem --------");
				System.out.println(employee.id + " " + employee.name + " " + employee.salary);
				askForContinue();
			case 5:
				System.out.println("Please input name to update : ");
				String nameInputUpdate = scanner.next();
				System.out.println("Please input new salary : ");
				double newSalary = scanner.nextDouble();
				/*String fullName = "nguyen tam thanh";
				if (fullName.contains(nameInputUpdate)) {
					//do somethings
				}*/
				employeeDAO.updateEmployeeByName(nameInputUpdate, newSalary);
				askForContinue();
			default:
				System.out.println("your input number is wrong, please input again!");
				System.out.println("-------------------------------");
				showMenu();
			}

		} while (inputNumber != 3);
	}
	
@Override
	public void addEmployee() {
		System.out.println("How many employee you want to create? : ");
		employeeNo = scanner.nextInt();
		//empArr = new Employee[empNo]
	//	employees = new Employee[employeeNo];
		for (int i = 0; i < employeeNo; i++) {
			System.out.println("Please input the information of employee[" + (i + 1) + "] : ");
			System.out.println("Name : ");
			String name = scanner.next();
			System.out.println("Salary : ");
			double salary = scanner.nextDouble();
			System.out.println("Age : ");
			int age = scanner.nextInt();
			System.out.println("Job name : ");
			String jobName = scanner.next();
			Employee employee = new Employee(name, i + 1, salary, age, true, new Job(i + 1, jobName));
			empArr.add(employee);
	}}
	@Override
	public void showEmployee() {
		System.out.println("----------------List of employee-----------");
		System.out.println("ID Name             Salary    Job name");
		for (int i = 0; i < empArr.size(); i++) {
			for  (Employee employee : empArr) {
				System.out.println(employee.getId() + "       " + employee.getName() + "       " + employee.getSalary() + "       "+ employee.getAge() + "       "+ employee.isMarried() +"       " + employee.job.name);
		}
		}
	} 

	@Override
	public Employee searchByName(String nameInput) {
		Employee employee = null;
		for (int i = 0; i< empArr.size(); i++) {
			if (nameInput.equals(empArr.get(i).getName())) {
				employee = empArr.get(i);
				break;
			}
		}
		return employee;
	}
	
	@Override
	public void updateEmployeeByName(String nameInput, Double newSalary) {
		for (int i = 0; i< empArr.size(); i++) {
			if (nameInput.equals(empArr.get(i).getName())) {
				empArr.get(i).salary = newSalary;
				break;
			}
		}
	}
	
	public static void askForContinue() {
		System.out.println("Do you want to continue? (Press 3 to end proram, 0 to come back menu) : ");
		int inputNo = scanner.nextInt();
		switch (inputNo) {
		case 0:
			showMenu();
			break;
		case 3:
			isEndProgram = true;
			break;
		default:
			break;
		}
	}
}
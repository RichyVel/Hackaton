package application;

//this is the class that binds to selected services
import application.model.Employee;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.cloudant.client.api.CloudantClient;
import com.cloudant.client.api.Database;
import com.cloudant.client.api.model.Response;

@Component
public class EmployeeApiBinding {

	@Autowired
	// CloudantClient client;
	private Database database;

	public ApiResponseMessage<Employee> createEmployee(Employee employee) {
		Response resp = database.save(employee);
		return new ApiResponseMessage<>(resp.getStatusCode(), "", null);

	}

	public ApiResponseMessage<Employee> deleteEmployee(Long id) {

		String query = "{\"employeeId\":" + id.toString() + "}";
		List<Employee> employee = database.findByIndex(query, Employee.class);
		database.remove(employee.get(0));
		//database.remove("employeeId",id.toString());
		//database.deleteIndex(id.toString(), "employeeId");
		
		return new ApiResponseMessage<>(HttpStatus.INTERNAL_SERVER_ERROR, "not yet implemented", null);
	}

	public ApiResponseMessage<Employee> getEmployee(Long id) {
		String query = "{\"employeeId\":" + id.toString() + "}";
		List<Employee> employee = database.findByIndex(query, Employee.class);

		return new ApiResponseMessage<>(!employee.isEmpty() ? HttpStatus.OK : HttpStatus.NOT_FOUND, "",
				!employee.isEmpty() ? employee.get(0) : null);
	}

	public ApiResponseMessage<Employee> updateEmployee(Employee employee) {
		String query = "{\"employeeId\":" + employee.getEmployeeId() + "}";
		List<Employee> employees = database.findByIndex(query, Employee.class);
		employee.set_id(employees.get(0).get_id());
		employee.set_rev(employees.get(0).get_rev());
		database.update(employee);
		
		return new ApiResponseMessage<>(HttpStatus.NOT_FOUND, "", null);
	}
}

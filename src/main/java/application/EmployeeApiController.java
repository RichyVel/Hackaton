package application;
//this is the new package generation for spring with service bindings
import application.model.Employee;

import io.swagger.annotations.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import javax.validation.constraints.*;
import javax.validation.Valid;
@javax.annotation.Generated(value = "com.ibm.mobile.sdkgen.platform.JavaSpringBindingsConfig", date = "2019-01-26T19:20:01.818Z")

@Controller
public class EmployeeApiController implements EmployeeApi {

    @Autowired
	private EmployeeApiBinding services;

    private final ObjectMapper objectMapper;

    public EmployeeApiController(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public ResponseEntity<Employee> createEmployee(@ApiParam(value = "Employee data"  )  @Valid @RequestBody Employee employee,
        @RequestHeader(value = "Accept", required = false) String accept) throws Exception {


        ApiResponseMessage<Employee> result = services.createEmployee(employee);

        if (accept != null && accept.contains("application/json")) {
        	return new ResponseEntity<Employee>(result.getData(), result.getCode());
        }

        return new ResponseEntity<Employee>(HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Employee> deleteEmployee(@ApiParam(value = "Employee id to delete",required=true ) @PathVariable("id") Long id,
        @RequestHeader(value = "Accept", required = false) String accept) throws Exception {


        ApiResponseMessage<Employee> result = services.deleteEmployee(id);

        if (accept != null && accept.contains("application/json")) {
        	return new ResponseEntity<Employee>(result.getData(), result.getCode());
        }

        return new ResponseEntity<Employee>(HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Employee> getEmployee(@ApiParam(value = "Employee id to retrieve details",required=true ) @PathVariable("id") Long id,
        @RequestHeader(value = "Accept", required = false) String accept) throws Exception {


        ApiResponseMessage<Employee> result = services.getEmployee(id);

        if (accept != null && accept.contains("application/json")) {
        	return new ResponseEntity<Employee>(result.getData(), result.getCode());
        }

        return new ResponseEntity<Employee>(HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Employee> updateEmployee(@ApiParam(value = "Employee data"  )  @Valid @RequestBody Employee employee,
        @RequestHeader(value = "Accept", required = false) String accept) throws Exception {


        ApiResponseMessage<Employee> result = services.updateEmployee(employee);

        if (accept != null && accept.contains("application/json")) {
        	return new ResponseEntity<Employee>(result.getData(), result.getCode());
        }

        return new ResponseEntity<Employee>(HttpStatus.BAD_REQUEST);
    }

}

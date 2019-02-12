package application;

//import org.springframework;
import org.springframework.data.mongodb.repository.MongoRepository;

import application.model.Employee;

public interface Iemployee extends  MongoRepository<Employee, Long> {

}

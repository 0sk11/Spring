package mvc.quest11;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmployeeController11 {
	List<Employee> list= Arrays.asList(
			new Employee(1,"Tony",2346574L),
			new Employee(2,"Steve",857186L),
			new Employee(3,"Thor",52524524L),
			new Employee(4,"Natasha",4556363L),
			new Employee(5,"Bruce",5344668L),
			new Employee(6,"Barton",8786456L),
			new Employee(7,"Sam",28674687L),
			new Employee(8,"Bucky",8458864L),
			new Employee(9,"Wanda",97721654L),
			new Employee(10,"Peter",2767875L),
			new Employee(11,"Vision",54758786L),
			new Employee(12,"Strange",5445453L),
			new Employee(13,"Quill",5875757L)
			);

	@RequestMapping(value="/report/pdf", method=RequestMethod.GET)
	public ModelAndView employeePdf(HttpServletRequest req, HttpServletResponse res) {
		
		String type= req.getParameter("type");
		
		if(type!=null && type.equals("pdf"))
			return new ModelAndView(new PdfView(), "employeeList", list);
		
		return new ModelAndView("Quest11/EmployeeListReport", "employeeList", list);
	}
}

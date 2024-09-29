package com.spring.orm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entities.Student;

public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext context=new ClassPathXmlApplicationContext("com/spring/orm/ORMconfig.xml");
    	StudentDao studentDao =context.getBean("studentDao", StudentDao.class);
    	/*Student student = new Student(); 
		student.setStudentId(789);
		student.setStudentName("Uiol");
		student.setStudentCity("lop");
		int r =studentDao.insert(student); 
		//System.out.println("Done "+r);*/
		
		/* 
		 * pls check
		 * 
		 * डाला था पर टेबल create नही हूॅआ 
		 * <prop key="hibernate.hbm2dll.auto">update</prop>
		 * 
		 */
    	
    	 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	 boolean choice=true;
    	 while(choice) {
    		 System.out.println("Press 1 for adding Student");
    		 System.out.println("Press 2 for display All Student");
    		 System.out.println("Press 3 for display Single Student");
    		 System.out.println("Press 4 for delete Single Students");
    		 System.out.println("Press 5 for delete All Students");
    		 System.out.println("Press 6 for Update Single Students");
    		 System.out.println("Press 7 for Update All Students");
    		 System.out.println("Press 8 for Exit");
    		 System.out.println("***************************");
     		 System.out.println();
    		 
    		 try {
    			 int input = Integer.parseInt(br.readLine());
    			 switch(input)
    			 {
    		     	 case 1:
    		     		 //for adding Student
    		     		 System.out.println("Enter Student details");
    		     		 System.out.println("Enter Student Id");
    		     		 int id=Integer.parseInt(br.readLine());
   		     		     System.out.println("Enter Student Name");
   		     		     String name=br.readLine();
		     		     System.out.println("Enter Student City");
		     		     String city=br.readLine();
                         Student stud=new Student(id, name, city);		     		 
    		     		 int r=studentDao.insert(stud);
    		     		 System.out.println(name+" student added");
    		     		 System.out.println("***************************");
    		     		 System.out.println();
    		     		 
    				  break;
    		     	case 2:
    		     		//for display All Student
    		     		System.out.println("List of all Students");
    		     		System.out.println();
    		     		List<Student> studList=studentDao.getAllStudents();
    		     		for(Student student:studList) {
    		     			System.out.println();
    		     			System.out.println(student);
    		     			System.out.println("____________________");
    		     		}
    		     		System.out.println("***************************");
   		     		    System.out.println();
   		     		 
      				  break;
    		     	case 3:
    		     		//for display Single Student
    		     		System.out.println("List of single Student");
    		     		System.out.println();
    		     		System.out.println("Enter Student Id");
   		     		    int studentId=Integer.parseInt(br.readLine());
   		     		    Student stud1=studentDao.getStudent(studentId);
   		     		    System.out.println();
	     			    System.out.println(stud1);
	     			    System.out.println("____________________");
   		     		    
      				  break;
    		     	case 4:
    		     		//for delete Single Students
    		     		System.out.println("Delete single Student");
    		     		System.out.println();
    		     		System.out.println("Enter Student Id");
   		     		    int stud2=Integer.parseInt(br.readLine());
   		     		    Student studObj=studentDao.getStudent(stud2);
    		     		studentDao.delete(studObj);
    		     		System.out.println(studObj.getStudentName()+" deleted");
      				  break;
    		     	case 5:
    		     		//for delete All Students
    		     		System.out.println("Deleted List of all Students");
    		     		System.out.println();
    		     		studentDao.deleteAll();
      				  break;
    		     	case 6:
    		     		//for Update Single Students
    		     		//for delete Single Students
    		     		System.out.println("Update single Student");
    		     		System.out.println();
    		     		System.out.println("Enter Student Id");
   		     		    int stud3=Integer.parseInt(br.readLine());
   		     		    System.out.println("Enter Student New Name");
		     		    String studNewName=br.readLine();
   		     		    Student studObjOri=studentDao.getStudent(stud3);
   		     		    studObjOri.setStudentName(studNewName);
    		     		studentDao.update(studObjOri);
    		     		System.out.println(studObjOri.getStudentName()+" updated");
    		     		
      				  break;
    		     	case 7:
    		     		//for Update All Students
      				  break;
    		     	case 8:
    		     		choice=false;
    		     		break;
    		     		
    			 }
    			 
    		 }catch(Exception e) {
    			 System.out.println("Invalid Input");
    			 System.out.println(e);
    		 }
    	 }
    	 System.out.println("Thanks");
    }
}

/*
 Exception for transcation management
Exception in thread "main" org.springframework.dao.InvalidDataAccessApiUsageException: Write operations are not allowed in read-only mode (FlushMode.MANUAL): Turn your Session into FlushMode.COMMIT/AUTO or remove 'readOnly' marker from transaction definition.
	at org.springframework.orm.hibernate5.HibernateTemplate.checkWriteOperationAllowed(HibernateTemplate.java:1046)
	at org.springframework.orm.hibernate5.HibernateTemplate.lambda$save$11(HibernateTemplate.java:614)
	at org.springframework.orm.hibernate5.HibernateTemplate.doExecute(HibernateTemplate.java:367)
	at org.springframework.orm.hibernate5.HibernateTemplate.executeWithNativeSession(HibernateTemplate.java:334)
	at org.springframework.orm.hibernate5.HibernateTemplate.save(HibernateTemplate.java:613)
	at com.spring.orm.dao.StudentDaoImpl.insert(StudentDaoImpl.java:26)
	at com.spring.orm.App.main(App.java:19)


*/
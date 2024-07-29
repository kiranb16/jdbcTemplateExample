package com.NelsonIQ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.NelsonIQ.Dao.UserDao;

@SpringBootApplication
public class SpringJdbcExampleApplication implements CommandLineRunner {
	@Autowired
	private UserDao userDao;

	public static void main(String[] args) {
		SpringApplication.run(SpringJdbcExampleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
	  	System.out.println(" row created :"+userDao.createTable());
		//creating user
		//this.createUser();
		
		//delete user
		//this.deleteUser();
		
		//update User
		this.updateUser();
	}
 
	public void createUser() throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter UserId : ");
		Integer userId= Integer.parseInt(br.readLine());
		System.out.println("Enter name : ");
		String name= br.readLine();
		System.out.println("Enter age : ");
		Integer age= Integer.parseInt(br.readLine());
		System.out.println("Enter city : ");
		String  city= br.readLine();
		int i=this.userDao.insertUser(userId, name, age, city);
		System.out.println(i+" user added");
	}
	
	public void deleteUser() throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter UserId : ");
		Integer userId= Integer.parseInt(br.readLine());
		int i=this.userDao.deleteUser(userId);
		System.out.println(i +" user deleted");
		
	}
	
	public void updateUser() throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter UserId : ");
		Integer userId= Integer.parseInt(br.readLine());
		System.out.println("Enter name : ");
		String name= br.readLine();
		System.out.println("Enter age : ");
		Integer age= Integer.parseInt(br.readLine());
		System.out.println("Enter city : ");
		String  city= br.readLine();
		int i=this.userDao.upadateUser(userId, name, age, city);
		System.out.println(i +" user update");
		
	}
}











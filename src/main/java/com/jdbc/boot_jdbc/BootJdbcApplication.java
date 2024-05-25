package com.jdbc.boot_jdbc;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jdbc.boot_jdbc.Dao.UserDao;

@SpringBootApplication
public class BootJdbcApplication implements CommandLineRunner {

	@Autowired
	private UserDao userDao;

	public static void main(String[] args) {
		SpringApplication.run(BootJdbcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// create table
		System.out.println(this.userDao.createTable());

		//// insert user
		// this.insertUser();

		//// update user
		// this.updateUser();

		//// delete user
		// this.deleteUser();

	}

	private void deleteUser() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter user id to delete : ");
		int id = sc.nextInt();
		System.out.println("Deleted : "+this.userDao.delete(id));
	}

	private void updateUser() {
		Scanner s = new Scanner(System.in);

		System.out.print("Enter user Id : ");
		int id = s.nextInt();

		System.out.print("Enter user name : ");
		String name = s.next();

		System.out.print("Enter user age : ");
		int age = s.nextInt();

		System.out.print("Enter user city : ");
		String city = s.next();

		int update = this.userDao.update(id, name, age, city);
		System.out.println("Updated : " + update);
	}

	private void insertUser() {
		Scanner s = new Scanner(System.in);
		
		System.out.print("Enter user Id : ");
		int id = s.nextInt();

		System.out.print("Enter user name : ");
		String name = s.next();

		System.out.print("Enter user age : ");
		int age = s.nextInt();

		System.out.print("Enter user city : ");
		String city = s.next();

		int insertion = this.userDao.insertUser(id, name, age, city);
		System.out.println("Insertion : "+ insertion);
	}

}

package com.iboxpay.zeng.learn;

import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * 
 * The class PreidcateConsumerDemo.
 *
 * Description: JDK 1.8 Preidcate/Consumer Demo
 *
 */
public class PreidcateConsumerDemo {

	public static Student updateStudentFee(Student student, Predicate<Student> predicate,
			Consumer<Student> consumer) {

		/**
		 * 1. predicate对应下面（1.）中的条件，predictate.test测试传入的student是否符合这个条件
		 * 2. consumer对应下面(2.)中的赋值内容，consumer.accept表示将传入student执行这个赋值
		 */
		if (predicate.test(student)) {
			consumer.accept(student);
		}
		return student;
	}

	public static void main(String[] args) {
		Student student1 = new Student("Ashok", "Kumar", 9.5);
		/**
		 * 1. student -> student.grade > 8.5 赋值给 predicate,表示一个条件,用于以上（1.）判断
		 * 2. student -> student.feeDiscount = 30.0 赋值给consumer，表示一个赋值,用于以上（2.）设置值
		 */
		student1 =
				updateStudentFee(student1, student -> student.grade > 8.5,
						student -> student.feeDiscount = 30.0);
		student1.printFee();

		Student student2 = new Student("Rajat", "Verma", 8.0);
		student2 =
				updateStudentFee(student2, student -> student.grade >= 8,
						student -> student.feeDiscount = 20.0);
		student2.printFee();

	}

}

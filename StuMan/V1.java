package StuMan;
import java.util.*;
interface selectC{
	public boolean chongfu(Student[] a,int o);
}
abstract class Person{
	long id;
	String name;
	int age;
}
class Student extends Person{
	float score;
}
class SM implements selectC{
	Scanner scan  = new Scanner(System.in);
	Random ran = new Random();
	public void add(Student[] a,int o) {
		System.out.println("输入学生ID：");
		a[o].id = scan.nextLong();
		if(!chongfu(a,o)) {
			System.out.println("学号重复,请重新选择");
			return;
		}
		System.out.println("输入学生姓名：");
		scan.nextLine();
		a[o].name = scan.nextLine();
		System.out.println("输入学生年龄：");
		a[o].age = scan.nextInt();
		System.out.println("输入学生成绩：");
		a[o].score = scan.nextFloat();
	}
	public void show(Student[] a,int o) {
		for(int i=0;i<o;i++) {
			System.out.println("第"+(i+1)+"位学生学号："+a[i].id+",姓名："+a[i].name+",年龄："+a[i].age+",成绩："+a[i].score);
		}
		System.out.println("***************************");
	}
	public boolean chongfu(Student[] a,int o) {
		for(int i=0;i<o;i++) {
			for(int j=i+1;j<a.length;j++) {
				if(a[i].id == a[j].id) {
					return true;
				}
			}
		}
		return false;
	}
	public Student select(Student[] a,String n,int o) {
		for(int i=0;i<o;i++) {
			if(a[i].name.equals(n)) return a[i];
		}
		return null;
	}
	public void delete(Student[] a,String n,int o) {
		int j=0;
		for(int i=0;i<o;i++) {
			if(!a[i].name.equals(n)) {
				a[j] = a[i];
				j++;
			}
		}
		if(j!=o) System.out.println("删除成功");
		else System.out.println("删除失败，未找到该姓名");
	}
	public void xiugai(Student[] a,String n,int o) {
		for(int i=0;i<o;i++) {
			if(a[i].name.equals(n)) {
				System.out.println("输入学生ID：");
				a[i].id = scan.nextLong();
				System.out.println("输入学生姓名：");
				a[i].name = scan.nextLine();
				System.out.println("输入学生年龄：");
				a[i].age = scan.nextInt();
				System.out.println("输入学生成绩：");
				a[i].score = scan.nextFloat();
			}
			else System.out.println("未找到该姓名，请核对后输入");
		}
	}
}
class Worker extends Person{
	float money;
	String work;
}
public class V1 {
	public static void main(String args[]) {
		while(true) {
		System.out.println("学校信息管理程序");
		System.out.println("1.学生信息管理");
		System.out.println("2.工人信息管理");
		System.out.println("3.退出系统");
		int z = 0;
		int j=0;//退出内层标志
		Student[] stu = new Student[10];
		int o=0;
		SM sm = new SM();
		Scanner scan = new Scanner(System.in);
		z = scan.nextInt();
		if(z == 1) {
			while(j!=-1) {
			System.out.println("1.增加学生信息");
			System.out.println("2.列出全部学生信息");
			System.out.println("3.查询学生信息");
			System.out.println("4.删除学生信息");
			System.out.println("5.修改学生信息");
			System.out.println("6.返回上一级");
			stu[o] = new Student();
			int s = scan.nextInt();
			if(s == 1) {
				sm.add(stu,o);
				o++;
			}if(s == 2) {
				sm.show(stu,o);
			}if(s == 3) {
				System.out.println("请输入要查询的学生姓名");
				scan.nextLine();
				String n = scan.nextLine();
				Student stu1 = sm.select(stu,n,o);
				System.out.println("学生学号："+stu1.id+",姓名："+stu1.name+",年龄："+stu1.age+",成绩："+stu1.score);
			}if(s == 4) {
				System.out.println("请输入要删除的学生姓名");
				scan.nextLine();
				String n = scan.nextLine();
				sm.delete(stu,n,o);
				o--;
			}if(s == 5) {
				System.out.println("请输入要修改的学生姓名");
				scan.nextLine();
				String n = scan.nextLine();
				sm.xiugai(stu,n,o);
			}
			if(s == 6) {
				j = -1;
			}
			}
		}
		if(z==3) {
			System.exit(0);
		}
		}
	}
}

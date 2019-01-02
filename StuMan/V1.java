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
		System.out.println("����ѧ��ID��");
		a[o].id = scan.nextLong();
		if(!chongfu(a,o)) {
			System.out.println("ѧ���ظ�,������ѡ��");
			return;
		}
		System.out.println("����ѧ��������");
		scan.nextLine();
		a[o].name = scan.nextLine();
		System.out.println("����ѧ�����䣺");
		a[o].age = scan.nextInt();
		System.out.println("����ѧ���ɼ���");
		a[o].score = scan.nextFloat();
	}
	public void show(Student[] a,int o) {
		for(int i=0;i<o;i++) {
			System.out.println("��"+(i+1)+"λѧ��ѧ�ţ�"+a[i].id+",������"+a[i].name+",���䣺"+a[i].age+",�ɼ���"+a[i].score);
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
		if(j!=o) System.out.println("ɾ���ɹ�");
		else System.out.println("ɾ��ʧ�ܣ�δ�ҵ�������");
	}
	public void xiugai(Student[] a,String n,int o) {
		for(int i=0;i<o;i++) {
			if(a[i].name.equals(n)) {
				System.out.println("����ѧ��ID��");
				a[i].id = scan.nextLong();
				System.out.println("����ѧ��������");
				a[i].name = scan.nextLine();
				System.out.println("����ѧ�����䣺");
				a[i].age = scan.nextInt();
				System.out.println("����ѧ���ɼ���");
				a[i].score = scan.nextFloat();
			}
			else System.out.println("δ�ҵ�����������˶Ժ�����");
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
		System.out.println("ѧУ��Ϣ�������");
		System.out.println("1.ѧ����Ϣ����");
		System.out.println("2.������Ϣ����");
		System.out.println("3.�˳�ϵͳ");
		int z = 0;
		int j=0;//�˳��ڲ��־
		Student[] stu = new Student[10];
		int o=0;
		SM sm = new SM();
		Scanner scan = new Scanner(System.in);
		z = scan.nextInt();
		if(z == 1) {
			while(j!=-1) {
			System.out.println("1.����ѧ����Ϣ");
			System.out.println("2.�г�ȫ��ѧ����Ϣ");
			System.out.println("3.��ѯѧ����Ϣ");
			System.out.println("4.ɾ��ѧ����Ϣ");
			System.out.println("5.�޸�ѧ����Ϣ");
			System.out.println("6.������һ��");
			stu[o] = new Student();
			int s = scan.nextInt();
			if(s == 1) {
				sm.add(stu,o);
				o++;
			}if(s == 2) {
				sm.show(stu,o);
			}if(s == 3) {
				System.out.println("������Ҫ��ѯ��ѧ������");
				scan.nextLine();
				String n = scan.nextLine();
				Student stu1 = sm.select(stu,n,o);
				System.out.println("ѧ��ѧ�ţ�"+stu1.id+",������"+stu1.name+",���䣺"+stu1.age+",�ɼ���"+stu1.score);
			}if(s == 4) {
				System.out.println("������Ҫɾ����ѧ������");
				scan.nextLine();
				String n = scan.nextLine();
				sm.delete(stu,n,o);
				o--;
			}if(s == 5) {
				System.out.println("������Ҫ�޸ĵ�ѧ������");
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

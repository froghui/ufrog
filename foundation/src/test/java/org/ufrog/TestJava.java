package org.ufrog;

public class TestJava {
	public static void main(String[] args) {
		try{
			int a = 39 / 2;
			System.out.println(a);
			System.out.println((float)3/(float)4);
			return;
		}finally{
			System.out.println("shoudl be executed.");
		}

	}
}

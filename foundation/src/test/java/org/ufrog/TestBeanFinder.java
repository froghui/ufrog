package org.ufrog;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;

public class TestBeanFinder {
	private int value;
	
	

	public static void main(String[] args) {
		Class beanClass = TestBeanFinder.class;
		try {
	      BeanInfo info = Introspector.getBeanInfo(beanClass);
      } catch (IntrospectionException e) {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
      }
	}



	public int getValue() {
	   return value;
   }



	public void setValue(int value) {
	   this.value = value;
   }
}

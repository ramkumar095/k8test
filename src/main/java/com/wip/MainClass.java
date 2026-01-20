package com.wip;

public class MainClass {

	public int add(int... number) {
		int result=0;
		for(int i : number) {
			result = result +i;
		}		
		return result;
	}
	
	public int multiply(int a, int b) {
		return a*b;
	}

	public static void main(String[] args) {
		System.out.println("Java within Kubernetes K8 Jenkins-- Maven Project!!!");

	}

}
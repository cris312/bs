package com.bs.service;

public class updatePersonThread extends Thread{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		RelationService rs = new RelationService();
		for(int i=1;i<=2028;i++){
			System.out.println("~~~~"+i);
			rs.getRelationByPersonId3(i);
		}
	}
}

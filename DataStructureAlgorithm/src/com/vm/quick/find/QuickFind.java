package com.vm.quick.find;

public class QuickFind {
	private int[] qfArray; 
	
	public QuickFind(int n){
		qfArray = new int[n];
		for (int index = 0; index< qfArray.length; index++){
			qfArray[index]=index;
			
		}
		printArray();
	}
	
	public void union(int p, int q){
		int indexp = qfArray[p];
		int indexq =  qfArray[q];
		for (int index = 0; index< qfArray.length; index++){
			int elementIndex = qfArray[index];
			if(indexq == elementIndex){
				qfArray[index] = indexp;
			}
			
		}
		
		
		printArray();
	}
	
	public void connected (int p, int q){
		
		if(qfArray[p] == qfArray[q]){
			System.out.println("Nodes "+p+" and "+q+" are connected");
			
		}else{
			System.out.println("Nodes "+p+" and "+q+" are not connected");
		}
		
		
		
	}
	private void printArray(){
		System.out.println("******************************************************************");
		for (int index = 0; index< qfArray.length; index++){
			System.out.print(qfArray[index]+" | ");
			
		}
		System.out.println();
		System.out.println("******************************************************************");
	}
	
	
	public static void main(String[] args) {
		QuickFind qf= new QuickFind(10);
		qf.union(0, 1);
		qf.union(4, 5);
		qf.union(2, 3);
		qf.union(2, 4);
		qf.connected(0, 1);
		qf.connected(2, 4);
		qf.connected(2, 7);
		qf.connected(6, 8);
	}
}

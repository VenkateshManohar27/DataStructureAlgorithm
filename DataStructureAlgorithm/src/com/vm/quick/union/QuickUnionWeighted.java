package com.vm.quick.union;

public class QuickUnionWeighted {
	private int[] arr;
	private int[] size;
	
	public QuickUnionWeighted(int n) {
		arr = new int[n];
		size = new int[n];
		for (int index = 0; index< arr.length; index++){
			arr[index]=index;
			size[index]= 1;
		}
		printArray();
	}
	
	public int root(int index){
		while(index != arr[index]){
			index = arr[index];
		}
		return index;
	}
	
	public void union(int p, int q){
		System.out.println("Union "+p+" and "+q+" is");
		int rootp = root(p);
		int rootq = root(q);
		int sizep = size[rootp];
		int sizeq = size[rootq];
		if(sizep < sizeq){
			arr[rootp] = rootq;
			size[rootq]+=sizep;
		}else{
			arr[rootq] = rootp;
			size[rootp]+=sizeq;
		}
		//arr[rootp] = rootq;
		printArray();
	}
	
	public void find(int p, int q){
		boolean flag = false;
		flag = (root(p) == root(q));
		if(flag){
			System.out.println("Nodes "+p+" and "+q+" are connected");
			
		}else{
			System.out.println("Nodes "+p+" and "+q+" are not connected");
		}
	}
	
	public int find(int i){
		int max = i;
		while(i != arr[i]){
			i = arr[i];
			if (max < i){
				max =i;
			}
		}
		System.out.println("Max element is :" +max);
		return max;
	}
	
	private void printArray(){
		System.out.println("******************************************************************");
		for (int index = 0; index< arr.length; index++){
			System.out.print(size[index]+" | ");
			
		}
		System.out.println();
		for (int index = 0; index< arr.length; index++){
			System.out.print(arr[index]+" | ");
			
		}
		System.out.println();
		System.out.println("******************************************************************");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QuickUnionWeighted quw= new QuickUnionWeighted(10);
		quw.union(3, 4);
		quw.union(4, 9);
		quw.union(8, 0);
		quw.union(2, 3);
		quw.union(5, 6);
		quw.union(5, 9);
		
		quw.union(7, 3);
		quw.union(4, 8);
		quw.union(6, 1);
		quw.find(0, 1);
		quw.find(2, 4);
		quw.find(2, 7);
		quw.find(6, 8);
		quw.find(0);
		quw.find(2);
	}
}

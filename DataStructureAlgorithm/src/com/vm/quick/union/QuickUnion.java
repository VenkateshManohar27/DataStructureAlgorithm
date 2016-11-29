package com.vm.quick.union;

public class QuickUnion {
	private int[] arr;
	public QuickUnion(int n) {
		arr = new int[n];
		for (int index = 0; index< arr.length; index++){
			arr[index]=index;
			
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
		arr[rootp] = rootq;
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
			System.out.print(arr[index]+" | ");
			
		}
		System.out.println();
		System.out.println("******************************************************************");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QuickUnion qu= new QuickUnion(10);
		qu.union(3, 4);
		qu.union(4, 9);
		qu.union(8, 0);
		qu.union(2, 3);
		qu.union(5, 6);
		qu.union(5, 9);
		
		qu.union(7, 3);
		qu.union(4, 8);
		qu.union(6, 1);
		qu.find(0, 1);
		qu.find(2, 4);
		qu.find(2, 7);
		qu.find(6, 8);
		qu.find(0);
		qu.find(2);
	}

}

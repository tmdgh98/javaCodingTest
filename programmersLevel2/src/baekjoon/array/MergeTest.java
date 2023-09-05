package baekjoon.array;

public class MergeTest {
	static int [] a = {4,6,7,2,4,6,8,1,2,9};
	static int[] temp;
	public static void main(String[] args) {
		temp = new int[a.length];
		print(a);
		merge(0,a.length-1);
		print(a);
	}
	
	public static void merge(int start, int end) {
		if(start!=end) {
			int mid = (start+end)/2;
			merge(start,mid);
			merge(mid+1,end);
			
			int p = start;
			int q = mid+1;
			int index = p;
			
			while(p<=mid || q <= end) {
				if(q>end || (p<=mid && a[p] < a[q])) {
					temp[index] = a[p];
					index++;
					p++;
				}else {
					temp[index] = a[q];
					index++;
					q++;
				}
			}
			for(int i = start; i <= end; i++) {
				a[i] = temp[i];
			}
		}
		
	}
	public static void print(int[] a) {
		for(int i : a) {
			System.out.print(i+" ");
		}
		System.out.println("");
	}
}

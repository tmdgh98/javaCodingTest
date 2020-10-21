package orning;

public class MergeSort1020 {
	static int[] arr = {5,6,8,1,2,9,10,4,56,24,26,5};
	static int[] temp = new int[arr.length];
	public static void main(String[] args) {
		merge(0,arr.length-1);
		for(int a : arr) {
			System.out.print(a+" ");
		}
		System.out.println();
		merge2(0, arr.length-1);
		for(int a : arr) {
			System.out.print(a+" ");
		}
	}
	public static void merge(int a, int b) {
		if(a<b) {
			int mid = (a+b)/2;
			
			merge(a,mid);
			merge(mid+1,b);
			
			int p = a;
			int q = mid+1;
			int n = a;
			while(p<=mid||q<=b) {
				if(q>b||(p<=mid&&arr[p]<arr[q])) {
					temp[n++] = arr[p++];
				}else {
					temp[n++] = arr[q++];
				}
			}
	
			
			for (int i = a; i <= b; i++) {
				arr[i] = temp[i];
			}
		}
	}
	
	public static void merge2(int a, int b) {
		if(a<b) {
			int mid = (a+b)/2;
			merge2(a,mid);
			merge2(mid+1,b);
			
			int i = a;
			int j = mid+1;
			int n = a;
			while(i<=mid||j<=b) {
				if(j>b||(i<=mid&&arr[i]>arr[j])) {
					temp[n++] = arr[i++];
				}else {
					temp[n++] = arr[j++];
				}
			}
			
			for (int k = a; k < b+1; k++) {
				arr[k] = temp[k];
			}
		}
		
	}
}

package programmersLevel2;

import java.util.LinkedList;
import java.util.Queue;

public class Test {
	public static void main(String[] args)
    {
        Function(5);
    }
 
    public static void Function(int num)
    {
        if(num == 0)
        {
            return;
        }
        else
        {
            System.out.println("반갑습니다");
             Function(num - 1);
        }
    }
}

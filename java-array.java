import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;
public class bebegerl {
    
    public static void main(String[] args) {
		int array[] = new int[10];
		Random rand = new Random();
		Scanner scan = new Scanner(System.in);
		int c, pos, newele, search, num=0;
		System.out.println("Random Array Elements");
		for (c = 0; c < array.length; c++)
		{
			array[c] = rand.nextInt(51);
		}
		System.out.println(Arrays.toString(array));
		System.out.print("Enter the position where you want to insert element:");
        pos = scan.nextInt();
        System.out.print("Enter new Element:");
        newele = scan.nextInt();
        for(c = (array.length-1); c >= (pos-1); c--);
        {
            array[c+1] = array[c];
        }
        array[pos-1] = newele;
        System.out.print("After inserting:");
        System.out.println(Arrays.toString(array));
        System.out.print("Search for the element:");
        search = scan.nextInt();
        for(c = 0; c < array.length; c++)
        {
            if(array[c] == search)
            {
                num = 1;
                break;
            }
            else
            {
                num = 0;
            }
        }
        if(num == 1)
        {
            System.out.println("Element found at position:"+(c + 1));
        }
        else
        {
            System.out.println("Element not found");
        }
 
    }
}

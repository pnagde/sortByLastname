package begin;
import java.util.*;
public class MyClass {
		
	public static void sortByLastname(String[] names) {
		int n=names.length;
		for (int i = 0; i < names.length; i++) {
			for (int j = i+1; j < names.length; j++) {
				int start=names[i].lastIndexOf(' ');
				int start2=names[j].lastIndexOf(' ');
				String lname=names[i].substring(start+1);
				String l2name=names[j].substring(start2+1);
				if(lname.compareToIgnoreCase(l2name)<0) 
				{
					String temp=names[i];
					names[i]=names[j];
					names[j]=temp;
				}
				else if(lname.compareToIgnoreCase(l2name)==0)
				{
					String fname=names[i].substring(0,start-1);
					String f2name=names[j].substring(0,start2-1);
					if(fname.compareToIgnoreCase(f2name)<0)
					{
						String temp=names[i];
						names[i]=names[j];
						names[j]=temp;
					}
				}
				}
			}
		
	}
	public static boolean check(String name) 
	{
		boolean lname=false;
		if(name.contains(" ")) 
		{
			lname=true;
		}
		return lname;
	}
	
	public static void main(String[] args) 
	{
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		String[] names=new String[n];
		scan.nextLine();
		for (int i = 0; i <n; i++) 
		{
			String temp=scan.nextLine();
			if(!check(temp)) {
				System.out.println("That looks like incomplete name. Do you want to continue?");
				String option=scan.nextLine();
				if(option.equalsIgnoreCase("Yes") || option.equalsIgnoreCase("Y")) {
					names[i]=temp;
				}else {
					System.out.print(temp+" ");
					String lname=scan.nextLine();
					temp = temp+" "+lname;
					names[i]=temp;
				}
			}else {
				names[i]=temp;
			}
		}
		sortByLastname(names);
		for (String string : names) {
			System.out.println(string);
		}
}
}

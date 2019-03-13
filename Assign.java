package 알고리즘;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Assign {
	static String [] word = new String[1000000];
	static String [] property = new String[1000000];
	static String [] content = new String[1000000];
	static String [] temp = new String[1000000];
	static int count = 0;
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		while(true)
		{
			System.out.print("$ ");
			String message = scan.next();
			if (message.contentEquals("read"))
			{String msg = scan.next();
				read(msg);}
			else if (message.contentEquals("find"))
			{String msg = scan.nextLine();
			msg=msg.replaceAll("'", "").replaceAll(" ","");
			int index = find(msg,0,count-1);
			if(index==-1) {
				System.out.println("Not Found.");
				System.out.println("- - -");
				System.out.println(word[index+1] + " "+property[index+1]);
			}
			else {
				if(msg.equalsIgnoreCase(temp[index]))
				{int i=index-1;
				int j=index+1;
				int k;
					while(true)
					{if(msg.equalsIgnoreCase(temp[i]))
						if(i>0)
							i--;
						else 
							break;
					else 
						break;}
					while(true)
					{if(msg.equalsIgnoreCase(temp[j]))
						j++;
					else 
						break;
					}
					if(i==0)
						k=i+j;
					else {i+=1;
					k=i-j;}
					System.out.println("Found "+ k +" Item");
					for(;i<j;i++)
					{
						System.out.println(word[i] + " "+property[i]+" "+content[i]);
					}
				}
				else {
					System.out.println("Not Found.");
					System.out.println(word[index-1] + " "+property[index-1]);
					System.out.println("- - -");
					System.out.println(word[index+1] + " "+property[index+1]);
				}
			}
				}
			else if (message.contentEquals("size"))
			{size();}
			else if (message.contentEquals("exit"))
			{break;}
		}
		scan.close();
	}
public static void read(String str) {
	try {
		Scanner infile = new Scanner(new File(str));
		while(infile.hasNext()) {
			String buffer = infile.nextLine();
			if(!buffer.contentEquals(""))
			{word[count]=buffer.substring(0, buffer.indexOf("(")-1);
			property[count]=buffer.substring(buffer.indexOf("(")-1,buffer.indexOf(")")+1);
			content[count]=buffer.substring(buffer.indexOf(")")+1);
			temp[count]=buffer.substring(0, buffer.indexOf("(")-1).replaceAll("'","").replaceAll(" ","");
			count++;}
		}
		infile.close();
	}
	catch(FileNotFoundException e) {System.out.println("No file");
	System.exit(0);}
	}
public static void size() {
System.out.print(count);
System.out.println();
}
public static int find(String str,int start,int end) {
	int middle = (start+end)/2;
	if(start>end)
		return end;
	else if (str.equalsIgnoreCase(temp[middle]))
		return middle;
	else if(str.compareToIgnoreCase(temp[middle]) > 0)
        start = middle + 1;
    else
        end = middle - 1;
	return find(str,start,end);
}
}

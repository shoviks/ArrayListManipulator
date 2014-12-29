//Shovik Shyamsundar
//UGA ID: 8102527180
import java.util.ArrayList;

public class ArrayListManipulator {
	
	
	
	public static void main(String[] args){
		
		//ArrayListManipulator object declared
		ArrayListManipulator manip = new ArrayListManipulator();
		
		
		/*
		 * Example for #1
		 */
		
		//Three ArrayLists declared
		ArrayList <Object> embedded = new ArrayList<Object>();
		ArrayList <Character> a = new ArrayList<Character>();
		ArrayList <Character> b = new ArrayList<Character>();
		
		//Two elements added to a
		a.add('a');
		a.add('b');
		
		//One element added to b
		b.add('c');
		
		//Four elements added to embedded including ArrayLists a and b
		embedded.add(1);
		embedded.add(a);
		embedded.add(2);
		embedded.add(b);
		
		//Prints an int indicating how many embedded lists are in the ArrayList embedded
		System.out.println(manip.number_embed(embedded));
		
		
		/*
		 * Example for #2
		 */
		
		//Declaration of two ArrayLists
		ArrayList <Character> charList1 = new ArrayList <Character>(); 
		ArrayList <Character> charList2 = new ArrayList <Character>();
		
		//Characters added to ArrayList charList1
		charList1.add('a');
		charList1.add('b');
		charList1.add('c');
		charList1.add('d');
		
		//Characters added to ArrayList charList2
		charList2.add('b');
		charList2.add('d');
		charList2.add('j');
		
		//Set difference calculated
		manip.my_difference(charList1, charList2);
		
		
		/*
		 * Example for #3
		 */
		
		//ArrayList declared
		ArrayList <Object> occur = new ArrayList <Object>();
		
		//Nine elements added to occur including two old ArrayLists
		occur.add('a');
		occur.add('a');
		occur.add('b');
		occur.add(charList1);
		occur.add('c');
		occur.add('c');
		occur.add('d');
		occur.add('d');
		occur.add(charList2);
		
		//Occurrences of each element calculated
		manip.occurences(occur);
		
		
		/*
		 * Example for #4
		 */
		
		//ArrayList of type Integer declared
		ArrayList <Integer> List = new ArrayList<Integer>();
		
		//Integers added to ArrayList List
		List.add(5);
		List.add(4);
		List.add(3);
		List.add(3);
		List.add(4);
		List.add(5);
		
		//Prints "T" if palindrome, "F" if not
		System.out.println(manip.my_palindrome(List));
		
		
		/*
		 * Example for #5
		 */
		
		//Declaration of ArrayList sub
		ArrayList <Object> sub = new ArrayList<Object>();
		
		//Three elements added to sub
		sub.add('a');
		sub.add('b');
		sub.add('c');
		
		//Powersets of ArrayList sub calculated
		manip.subsets(sub);
		
	}
	@SuppressWarnings("unchecked")
	public int number_embed(ArrayList <Object> list)
	{
		int count = 0;//counter variable
		
		for (int i = 0; i < list.size(); i++)
		{
			if (list.get(i).getClass() == ArrayList.class)//if element is an ArrayList
			{
				count++;
				number_embed((ArrayList<Object>) list.get(i));//recursion
			}
				
		}
		return count;
			
	}

	public void my_difference(ArrayList <Character> list1, ArrayList <Character> list2)
	{
		ArrayList <Character> common = new ArrayList <Character>();
		ArrayList <Character> difference = new ArrayList <Character>();
		
		//Double for-loop compares elements of list1 and list2 together and if they are the same
		//and not contained with ArrayList common then they are added to ArrayList common. 
		//Common becomes an ArrayList with the common elements of list1 and list2.
		for (int i = 0; i <list1.size(); i++)
		{
			for (int j = 0; j <list2.size(); j++)
			{
				if(list1.get(i)==list2.get(j))
				{
					if (!common.contains(list1.get(i)))
						common.add(list1.get(i));
				}
			}
		}
		//Compares ArrayList common and ArrayList list1 and adds any remaining elements from ArrayList
		//list1 that are not in ArrayList list2 to ArrayList difference.
		for (int k = 0; k < list1.size(); k++)
		{
			if (!common.contains(list1.get(k)))
				difference.add(list1.get(k));
				
		}
		
		//Prints out set difference in proper format
		System.out.print("(");
		for (int i = 0; i < difference.size(); i++)
		{
	
			if (i < (difference.size() - 1))
				System.out.print(difference.get(i) + ", ");
			else
				System.out.print(difference.get(i) + ")");
		}
		System.out.println("");
	}
	public <T> void occurences(ArrayList <T> list)
	{
		//ArrayList common declared
		ArrayList <T> common = new ArrayList <T>();
		
		//Removes repeating elements from list and puts them in ArrayList common
		for (int i = 0; i <list.size(); i++)
		{
			for (int j = 0; j <list.size(); j++)
			{
				if(list.get(i)==list.get(j))
				{
					if (!common.contains(list.get(i)))
						common.add(list.get(i));
				}
			}
		}
		
		int count;//counter variable
		
		int[] occur = new int[list.size()];//Array declared, keeps track of occurrences of each element
		
		//Double for loop that compares elements from common and list 
		//if elements match then counter variable is increased
		for (int k = 0; k < common.size(); k++)
		{
			count = 0;
			for (int j = 0; j < list.size(); j++)
			{
				if (common.get(k) == list.get(j))
				{
					//Ups count if it finds match
					count++;
				}
			}
			//The number of occurrences of each element in list becomes
			//an element of an array
			occur[k] = count;
		}
		
		//Prints out occurrences of each element in list in proper format
		System.out.print("(");
		for (int l = 0; l < common.size(); l++)
		{
			System.out.print("(" + common.get(l) + " " + occur[l] + ")");
		}
		System.out.println(")");
	}
	public <T> String my_palindrome(ArrayList <T> list)
	{
		//Declaration of ArrayList reverse
		ArrayList <T> reverse = new ArrayList<T>();
		
		//Adds elements of list to reverse in reverse order
		for (int i = list.size()- 1; i >= 0; i--)
		{
			reverse.add(list.get(i));
		}

		int count = 0;//counter variable
		
		//Compares list and reverse by increasing count variable by every time
		//an element matches.  At the end count should equal list.size()
		for (int j = 0; j < list.size(); j++)
		{
			if (list.get(j)==reverse.get(j))
			{
				count++;
			}
		}
		if (count == list.size())
			return "T";
		else
			return "F";
		
		
	}
	public void subsets(ArrayList <Object> list)
	{
		ArrayList <Object> ps = new ArrayList <Object>();//Declaration of ArrayList ps
		ps.add(new ArrayList<Object>());//ps now contains empty ArrayList
		getPset(list.toArray(), new ArrayList<Object>(), ps, list.size(), 0);//Private method getPset called
		System.out.println(ps);
		
	}
	private void getPset(Object[] input, ArrayList <Object> subset, ArrayList <Object> powerset, int n, int start)
	{
		//Generates subsets using recursion by removing one element at a time
		//and focusing on the others
		for (int i = start; i < n; i++)
		{
			Object obj = input[i];
			subset.add(obj);
			powerset.add(new ArrayList<Object>(subset));
			if (i < n - 1)
				getPset(input, subset, powerset, n, i+1);//Recursive call
			subset.remove(obj);//Removes element
		}
	}
	
}

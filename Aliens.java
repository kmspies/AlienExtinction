import java.util.Random;
import java.util.ArrayList;

class Aliens
{
//idea of this program is to replicate the Alien extinction riddle by populating an array with the integer 1, each 1 representing an alien
//each iteration, each alien (or 1)has a 25% chance to die, 25% chance to do nothing, 25% chance to replicate, and 25% chance to replicate twice
//the program calculates the number of times out of 1000s trials the alien population died out, printing that to log

//update: gonna want an arraylist so i can pop aliens off the end if the population shrank during one particular day (loop)



	public static void main(String[]args)
	{
	Random rand = new Random();
	int fails=0;
		for(int i=0;i<1000;i++)
		{
			ArrayList<Integer> alienArray = new ArrayList<Integer>();
			alienArray.add(1);			
			
			//assume population is safe once over 50 aliens are present(not entirely accurate i suppose)
			//this while will calculate indefinitely (wont take long) for one population, until it dies or goes above my threshold of 50
			while(alienArray.size()<50 &&alienArray.size()>0)
			{
				//int newRecruits=1;
				for(int x=0;x<alienArray.size();x++)
				{
					int n = rand.nextInt(4)+1;
					if(n==1) alienArray.remove(alienArray.size()-1);
					if(n==3) alienArray.add(1);
					if(n==4){
						alienArray.add(1);
						alienArray.add(1);
					}
				}

				if(alienArray.size()<1)
				{
					fails++;
					System.out.println("population failed: "+fails + "times");
				}
			}
			System.out.println(alienArray.toString());
		
		}
		int y = 1000-fails;
		System.out.println("number of extinctions: "+fails);
		System.out.println("number of successful populations: "+ y);
		//int extinctionChance = fails/1000;
		//System.out.println(extinctionChance);
	}
			
}
import java.util.*;
class HitandBlow{
	public static void main(String args[]){
		Scanner n = new Scanner(System.in);
		String p = "Y";

		while(p.equals("Y")){
			String allPos[] = printUnique(1,5555);
			int r = 0;
			int suc =allPos.length;
			while(r >=0 && suc > 1){
				System.out.print("Input the guessedNumber:");
				char c[] = n.next().toCharArray();
				System.out.print("Input the output \n(1A2B for 12,0A3B for 3):");
				r = n.nextInt();
				System.out.println("Possible guess:");
				suc = guessOutput(allPos,suc,c,r);
			}
			System.out.print("Again?Y/N:");
			p = n.next();
		}
	}

	public static int guessOutput(String [] allPos,int suc,char [] c, int r){
		int cnt = 0;

		int allScore[] = new int [allPos.length];
		int all = suc;
		int success = 0;
		for(int i = 0 ; i < all ; i++){

			char allPosC[] = allPos[i].toCharArray();
			allScore[i] = 0;
			boolean bo[] = new boolean[6];
			boolean boD[] = new boolean[6];
			for(int j = 0 ; j< allPosC.length ;j++){
				if(allPosC[j] == c[j]){
					allScore[i] += 9;
				}
				bo[Character.getNumericValue(allPosC[j])] = true;
			}
			for(int j = 0 ; j< allPosC.length ;j++){
				if(bo[Character.getNumericValue(c[j])] && !boD[Character.getNumericValue(c[j])]){
					boD[Character.getNumericValue(c[j])] = true;
					allScore[i] += 1;
				}
			}
			if(allScore[i] == r){
				allPos[success] = allPos[i];
				System.out.println(allPos[success]);
				if(i > 0){
					allPos[i] ="0000";
				}
				success++;
			}
		}
		all = success;
		return success;
	}
	public static String[] printUnique(int l, int r)
	{
		String allPos[] = new String[360];
		int cnt = 0;
		for (int i=l ; i<=r ; i++)
		{
			int num = i;
			boolean visited[] = new boolean[10];
			int k = 0;
			for( k = 0 ; k < Math.ceil(Math.log10(r)); k++){
				if (visited[num % 10])
					break;

				visited[num%10] = true;
				if (num%10 > 5)
					break;
				num = num/10;

			}
			if (num == 0 && k == Math.ceil(Math.log10(r))){
				String s = Integer.toString(i);
				int temp = i;
				while(temp < 1000){
					s = "0" + s;
					temp *=10;
				}
				allPos[cnt] = s;
				cnt++;
			}

		}
		return allPos;
	}
}
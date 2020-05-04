
public class Test {
	public static int globalDepth = 2;
	public static int localDepthlow = 2;
	public static int arr[] = new int[100];
	public static int noofbuckets = 4;
	// we have considered bfr for each bucket = 2
	// we have considered hash function to be K mod 10
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bucket[] bucks = new Bucket[100];
        for(int q=0; q<100; q++){bucks[q]=new Bucket();}
        arr[0]=0;
        arr[1]=1;
        arr[2]=2;
        arr[3]=3;

        bucks = Functions.addElement(32, bucks);
        System.out.println("Entry 1 : ");
        Functions.printAllStoredData(globalDepth, bucks);
        bucks = Functions.addElement(28, bucks);
        System.out.println("---------------------------------------------");
        System.out.println("Entry 2 : ");
        Functions.printAllStoredData(globalDepth, bucks);
        bucks = Functions.addElement(43, bucks);
        System.out.println("---------------------------------------------");
        System.out.println("Entry 3 : ");
        Functions.printAllStoredData(globalDepth, bucks);
        bucks = Functions.addElement(15, bucks);
        System.out.println("---------------------------------------------");
        System.out.println("Entry 4 : ");
        Functions.printAllStoredData(globalDepth, bucks);
        bucks = Functions.addElement(66, bucks);
        System.out.println("---------------------------------------------");
        System.out.println("Entry 5 : ");
        Functions.printAllStoredData(globalDepth, bucks);
        bucks = Functions.addElement(27, bucks);
        System.out.println("---------------------------------------------");
        System.out.println("Entry 6 : ");
        Functions.printAllStoredData(globalDepth, bucks);
        bucks = Functions.addElement(86, bucks);
        System.out.println("---------------------------------------------");
        System.out.println("Entry 7 : ");
        Functions.printAllStoredData(globalDepth, bucks);
        bucks = Functions.addElement(54, bucks);
        System.out.println("---------------------------------------------");
        System.out.println("Entry 8 : ");
        Functions.printAllStoredData(globalDepth, bucks);
        System.out.println("---------------------------------------------");
        bucks = Functions.addElement(35, bucks);
        System.out.println("Final hashing scheme : ");
        Functions.printAllStoredData(globalDepth, bucks);
        System.out.println("---------------------------------------------");
	}

}

public class Functions {
    
    public static Bucket[] addElement(int value, Bucket[] bucks)
        {
    		int maxdepth = (int)Math.pow(2, (int)(Test.globalDepth));
            int position = Test.arr[(value%10) % (maxdepth)];
           
            if(!bucks[position].isFull())
                {
                    if(!bucks[position].getElemOne().getIsFull())
                        {
                            bucks[position].getElemOne().setValue(value);
                            bucks[position].getElemOne().setIsFull(true);
                        }
                    else 
                        {
                            bucks[position].getElemTwo().setValue(value);
                            bucks[position].getElemTwo().setIsFull(true);
                        }
                }
            else
                {   
                     bucks = collisionDetected(bucks, value, position);
                }
            
            return bucks;
        }
    
    public static Bucket[] collisionDetected(Bucket[] buckets, int value, int probBucket)
        {
    		int maxdepth = (int)Math.pow(2, (int)(Test.globalDepth));
    		int position = Test.arr[(value%10) % (maxdepth)];
        
            if(buckets[position].getLocalDepth()<Test.globalDepth)
                {
                    buckets = splitBucket(buckets, value, probBucket);
                    System.out.println("Splitting of bucket number: " + probBucket + " happens");
                }
            else
                    {
                        doubleDirectory(buckets);
                        System.out.println("Incrementing global depth by one unit");
                        buckets = addElement(value, buckets);
                    }
         
            return buckets;
        }
    
    public static void doubleDirectory(Bucket[] buckets)
        {
            Test.globalDepth = Test.globalDepth + 1;
            int arrayLen = (int)Math.pow(2, Test.globalDepth);
            
            for(int q=0; q<arrayLen; q++)
            {
                if(q<((int) Math.pow(2, (Test.globalDepth-1))))
                    {
                        Test.arr[q]= Test.arr[q];
                    }else
                        {
                            Test.arr[q] = Test.arr[q-(int) Math.pow(2, (Test.globalDepth-1))];
                        }
            }
        }
    
    public static Bucket[] splitBucket(Bucket[] buckets, int value, int probBucket)
        {
                        int temp1a = buckets[probBucket].getElemOne().getValue();
                        int temp2a = buckets[probBucket].getElemTwo().getValue();
                        //set both positions to being empty
                        buckets[probBucket].getElemOne().setIsFull(false);
                        buckets[probBucket].getElemTwo().setIsFull(false);
                        int prevdepth = buckets[probBucket].getLocalDepth();
                        buckets[probBucket].setLocalDepth(prevdepth+1);
                        
                        int x=0;
                        for(int i=0;i<100;i++) {
                        	if(Test.arr[i]==probBucket) {
                        		x=i;
                        		break;
                        	}
                        }
                        x = x + (int)Math.pow(2, prevdepth);
                        Test.arr[x]=Test.noofbuckets;
                        Test.noofbuckets = Test.noofbuckets + 1;
                        
                        //add elements back into the array
                        buckets = addElement(temp1a, buckets);
                        buckets = addElement(temp2a, buckets);
                        buckets = addElement(value, buckets); 
        
            return buckets;
        }
    
    
    
    public static void printAllStoredData(int globalDepth, Bucket[] bucks)
        {
            int loopLen = (int) Math.pow(2, globalDepth);               
                    
            for(int i=0; i<loopLen; i++)
                {
                	System.out.println("The key number "+i+" points to bucket number : " + Test.arr[i]);
                }
            for(int i=0;i<Test.noofbuckets;i++) {
                if(bucks[i].getElemOne().getIsFull())
                {
                    System.out.println("In bucket "+i+", element one contains: "+bucks[i].getElemOne().getValue());
                }
                if(bucks[i].getElemTwo().getIsFull())
                {
                    System.out.println("In bucket "+i+", element two contains: "+bucks[i].getElemTwo().getValue());
                }
                System.out.println("Local depth of bucket "+i+" : "+bucks[i].getLocalDepth());
            }
        }
    
}

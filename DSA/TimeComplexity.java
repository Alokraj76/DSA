public class TimeComplexity
{
    public static void main(String[] args) 
    {
        double now = System.currentTimeMillis();
        TimeComplexity demo = new TimeComplexity();
        System.out.println((demo.findSum(99999)));
        System.out.println("Time taken - "+ (System.currentTimeMillis()-now)+" millisec ");
    }    
    public int findSum(int n)
    {
        //  return (n*(n+1))/2; //its takes 0.0 millsec for same number.
        int sum =0;
        for(int i=1;i<=n;i++)
        {
            sum +=i;
        }
        return sum; // it takes 34.0 millsec for same number.
    }
}

class palindrom 
{
	public static void main(String[] args) 
	{
		int n=121;
		int temp=n;
		int c=0;
		while(n>0)
		{
			int a=n%10;
			c=c*10+a;
			n=n/10;
		}
		if(c==temp)
		{
			System.out.println("palindrom");
		}
		else
		{
			System.out.println("not a palindrom");
		}
	}
}

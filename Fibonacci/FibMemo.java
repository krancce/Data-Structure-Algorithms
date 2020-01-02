public class FibMemo{

  public static int Fib(int n){
    int[] memo = new int[n+1];
    return FibMemo(n,memo);
  }

  public static int FibMemo(int n, int[] memo){
    int result;
    if(memo[n] != 0){
      return memo[n];
    }
    if(n==1 | n==2){
      result = 1;
    }else{
      result = FibMemo(n-1,memo)+FibMemo(n-2,memo);
    }
    return result;
  }

  public static void main(String[] args) {
    long startTime = System.nanoTime();
    System.out.println(Fib(35));
    long endTime = System.nanoTime();
    long totalTime = endTime-startTime;
    System.out.println("RunTime : "+totalTime);
  }
}

public class BottomUp{

  public static int BottomUp(int n){
    if(n==1|n==2){
      return 1;
    }else{
      int[] bottom_up = new int[n+1];
      bottom_up[1] = 1;
      bottom_up[2] = 1;
      for(int i=3; i<n+1; i++){
        bottom_up[i] = bottom_up[i-1]+bottom_up[i-2];
      }
      return bottom_up[n];
    }
  }

  public static void main(String[] args) {
    long startTime = System.nanoTime();
    System.out.println(BottomUp(35));
    long endTime = System.nanoTime();
    long totalTime = endTime-startTime;
    System.out.println("RunTime : "+totalTime);
  }
}

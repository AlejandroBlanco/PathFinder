public class Tracker {

  public synchronized void newSearcher() {
    alive++;
  }

  public synchronized void searcherFinished() {
    alive--;
    if(alive == 0) notify();
  }

  public synchronized void trailFound(Trail t) {
    alive--;
    solutions[count++] = t;
    if(alive == 0) notify();
  }

  public synchronized int waitAllFinished() {
    while(alive != 0)
      try {
        wait();
      }catch (InterruptedException e) {// ignore
   	  
      }
    return count;
  }

  public synchronized Trail giveTrail (int n) {
    if(n < count) return solutions[n];
    else return solutions[0];
  }

  public synchronized int numberOfSolutions () {
   return count;
  }



  private int alive = 0;
  private Trail[] solutions= new Trail[100];
    // Initial size (code not shown to grow the array).
  private int count = 0;

}

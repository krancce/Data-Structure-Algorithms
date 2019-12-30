import java.util.ArrayList;

public class PriorityQueue{
  ArrayList<Integer> minHeap = new ArrayList();
  //present minimum-treeheap using ArrayList
  int size = 0;
  //set the initial size of the PQ to 0

  public void push(int value){
    int position = size;
    minHeap.add(value);
    //insert value at the end of the PQ

    while(position > 0){
    //keep looping until position reaching the root
      int parent = (position+1)/2-1;
      //find the parent-position of the current position
      if(minHeap.get(parent) > minHeap.get(position)){
        //when parent node has a bigger value than the value in current position
        swap(parent,position);
        position = parent;
      }else{
        break;
      }
    }
    size++;
  }

  public int pop(){
    if(size == 0) throw new IllegalStateException();
    //throw exception if the heap is empty
    int toReturn = minHeap.get(0);
    //store the return value
    minHeap.set(0,minHeap.get(size-1));
    //put the last element of the PQ at root
    int position = 0;
    //set a pointer to the root
    while(position > size/2){
    //keep looping until the position reaches at the parent of the last level node
      int leftChild = position*2+1;
      int rightChild = position*2+2;
      if(rightChild < size & minHeap.get(rightChild) < minHeap.get(position)){
        //if the current position value is biggerb than its right-child
        swap(rightChild,position);
        position = rightChild;
      }else if(leftChild < size & minHeap.get(leftChild) < minHeap.get(position)){
        //if the current position value is biggerb than its left-child
        swap(leftChild,position);
        position = leftChild;
      }else{
        break;
      }
    }
    minHeap.set(size-1,null);
    size--;
    return toReturn;
  }

  public void swap(int x,int y){
    int tmp = minHeap.get(x);
    minHeap.set(x,minHeap.get(y));
    minHeap.set(y,tmp);
  }

  public int size(){
    return size;
  }

  public int get(int index){
    return minHeap.get(index);
  }
}

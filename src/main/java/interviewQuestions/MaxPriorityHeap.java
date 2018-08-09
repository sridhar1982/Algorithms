package interviewQuestions;

import java.util.Arrays;

/**
 *
 */
public class MaxPriorityHeap {

    public static void main(String[] args) {

        MaxPriorityHeap heap = new MaxPriorityHeap();
        heap.offer(1);
        heap.offer(2);
        heap.offer(3);
        heap.offer(4);
        heap.offer(5);
        heap.offer(6);
        heap.offer(7);

        System.out.println(heap);
        System.out.println(heap.size);

        int s = heap.size;

        for (int i = 0; i< s; i++) {
            System.out.println(heap.size);
            heap.poll();
        }

    }

    int size = 0;
    int[] data = new int[100];

    public boolean offer(int val) {
        int hole = size+1;
        data[hole] = val;
        percolateUp(hole);
        size++;
        return true;
    }


    public int poll() {
        if (isEmpty()) {
            throw new RuntimeException("heap is empty");
        }
        int val = data[1];
        data[1]=data[size];
        percolateDown(1);
        size--;
        return val;


    }

    public int peek(){
        if (!isEmpty()) {
            return data[size];
        }
        else {
            throw new RuntimeException("heap is empty");
        }
    }

    public boolean isEmpty() {
        return size==0;
    }

    private void percolateUp(int index){
        int hole = index;
        int temp = data[hole];
        int parent = hole/2;
        while (parent > 0) {
            if (temp < data[parent]) {
                return;
            }
            data[hole] = data[parent];
            hole=parent;
            parent = parent/2;
        }
        data[hole] = temp;
    }

    private void percolateDown(int hole) {
        int temp = data[hole];
        int child = hole * 2;
        while (child <= size) {
            if (child!=size && data[child] < data[child + 1]) {
                child++;
            }
            if (temp < data[child]){
                data[hole] = data[child];
            }
            else {
                break;
            }
            child = 2* child;
            hole = child/2;
        }
        data[hole] = temp;
    }

    public String toString(){
        int[] temp = Arrays.copyOfRange(data, 1, size+1);
        return Arrays.toString(temp);
    }



}

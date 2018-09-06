import java.util.Arrays;

/**
 * create N stacks out of a single array
 */
public class Nstacks {

    public static void main(String[] args) {

//        NStack nStack = new NStack(3, 1);
//        System.out.println(nStack.isEmpty());
//        nStack.push(1,11);
//        nStack.push(1,12);
//        nStack.push(1, 13);
//
//        System.out.println(nStack.isFull());
//        nStack.print();
//
//        System.out.println("**********");
//        System.out.println(nStack.pop(1));
//        System.out.println("**********");
//        nStack.print();
//        System.out.println(nStack.push(1,14));
//        nStack.print();

        NStack nStack1 = new NStack(10, 2);
        nStack1.push(1,1);
        nStack1.push(2, 100);
        nStack1.print();
        System.out.println("**********");
        System.out.println(nStack1.pop(1));
        nStack1.print();
        nStack1.push(2,200);
        nStack1.push(2, 300);



    }
}



class NStack {

        //keep track of size of size
        int size = 0;

        int numOfStacks;
        //holds data
        int[] data;
        //next position on data array where next data from push command should go into
        int free;
        //keep tracks of prevIndex so after a pop, it gets updated to one index before
        int[] prevIndex;
        //pointer to top of each stack, pop command just retrives the values on this index from data array
        int[] topOfStack;

        public NStack(int arrLength, int n) {
            //since zero based index
            numOfStacks = n - 1;
            data = new int[arrLength];
            free=0;
            topOfStack = new int[n];
            prevIndex = new int[arrLength];
            for (int i=0; i<arrLength; i++)
                prevIndex[i]=i+1;
            prevIndex[arrLength-1]=-1;
            for (int i =0; i<topOfStack.length; i++)
                topOfStack[i]=-1;
        }

        public boolean push(int stackNo, int val) {
            if (isFull()) {
                throw new RuntimeException("stack overflow");
            }
            stackNo-=1;
            int currentTop = topOfStack[stackNo];
            int temp = free;
            data[temp] = val;
            int nextIndex = prevIndex[temp];
            prevIndex[temp] = currentTop;
            topOfStack[stackNo] = temp;
            free = nextIndex;

            size++;
            return true;
        }

        public int pop(int stackNo) {
            stackNo-=1;
            if (isEmpty()) {
                throw new RuntimeException("under overflow");
            }

            int currentTop = topOfStack[stackNo];
            topOfStack[stackNo] = prevIndex[currentTop];
            prevIndex[currentTop] = free;
            free = currentTop;


            size--;

            return data[currentTop];
        }

        //free gets updated each time, once reached end of array, free will be -1
        public boolean isFull() {
            return free==-1;
        }

        public boolean isEmpty(){
            return size==0;
        }

        public void print() {
            System.out.println("no of stacks -> " + (numOfStacks + 1));
            System.out.println("free -> " + free);
            System.out.println("data -> " +  Arrays.toString(data));
            System.out.println("prevIndex -> " + Arrays.toString(prevIndex));
            System.out.println("top of Stack " + Arrays.toString(topOfStack));
        }
    }


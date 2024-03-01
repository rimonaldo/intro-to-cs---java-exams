package T2017.A84;

public class IntList {
    private IntNode _head;

    public IntList() {
        _head = null;
    }

    public int length() {
        int count = 0;
        IntNode current = _head;
        while (current != null) {
            count++;
            current = current.getNext();
        }
        return count;
    }


    // overall whats the methods doing:
    // suming up list values from head to k (not including k)
    // if k is bigger than list length --> false
    // if we are still in list :

    // while p is in the list:
    // check if the sum == p (starts at the k'th elemtn now) --> proceed
    // else we returning false
    // we are decreasing the value of "behind" value (initialized at head) 
    // and adding the value of p element
    // than we proceed p and behind values to the next element
    // and we keep repeating the loop 
    
    // if we finished list --> we return true

    public boolean what(int k) {
        // initialise intNode p as head
        // and behind as p
        IntNode p = _head, behind = p;
        // we gonna sum ____
        int sum = 0;

        // for i = 0 --> k
        for (int i = 0; i < k; i++) {
            // base case if p is out of list --> false
            if (p == null)
                return false;

            // add to sum value of p
            sum += p.getValue();
            // p proceeds in the list
            p = p.getNext();
        }

        // if we did k steps and still in the list we continue
        // and now p is the k'th element in the list

        // while p is in the list
        while (p != null) {
            // if sum is not the value of p --> bye bye
            if (sum != p.getValue())
                return false;
            
            // if sum == the value 
            // we will decrease the value of behind and add the value of p
            sum = sum - behind.getValue() + p.getValue();

            // move behind forward
            behind = behind.getNext();
            // move p forward
            p = p.getNext();
        }
        return true;
    }

    public int secret() {
        int k;
        for (k = 1; k < this.length(); k++) {
            if (this.what(k)) {
                return k;
            }
        }
        return -1;
    }
}

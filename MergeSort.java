public class MergeSort {
    
    private int[] array;
    private int compare_index1,compare_index2,partition,curr_size, y;

    public MergeSort(int[] array) {
        this.array = array;
        curr_size=1;
        ///curr_ind=0;
        partition=-1;
        compare_index1 = 0;
        compare_index2 = 1;
        y=0;
    }

    public int [] sortOnlyOneItem() {
        // merge(0,0,1);
        // merge(2,2,3);
        // merge(4, 4, 5);
        // merge(6, 6, 7);
        // merge(0,1,3);
        // merge(4,5,7);
        // merge(0, 3, 7);

        compare_index1=y;
        compare_index2=y + curr_size+1;
        partition=y + curr_size;
       for (int i=0; i<29; i += 2*curr_size){
           int mid = Math.min(i + curr_size - 1, 29);
           int right_end = Math.min(i + 2*curr_size - 1, 29);
           ///compare_index1=i;
           ///compare_index2=mid+1;
           ///partition=mid;
           merge(i, mid, right_end);
       }
        curr_size*=2;
        y++;
        if(curr_size>=30)
            curr_size=1;
        return array;
    }
    void merge(int l, int m, int r){
        int i, j, k;
        int n1 = m - l + 1;
        int n2 = r - m;

        int L[] = new int[n1];
        int R[] = new int[n2];

        for (i = 0; i < n1; i++)
            L[i] = array[l + i];
        for (j = 0; j < n2; j++)
            R[j] = array[m + 1+ j];

        i = 0;
        j = 0;
        k = l;
        while (i < n1 && j < n2){
            if (L[i] <= R[j]){
                array[k] = L[i];
                i++;
                ///compare_index1++;
            }
            else{
                array[k] = R[j];
                j++;
                ///compare_index2++;
            }
            k++;
        }

        while (i < n1){
            array[k] = L[i];
            i++;
            ///compare_index1++;
            k++;
        }

        while (j < n2){
            array[k] = R[j];
            j++;
            ///compare_index2++;
            k++;
        }
    }



    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }
    
    public int getcurrSize() {
        return curr_size;
    }
    
    public void setcurrSize(int array_index) {
        this.curr_size = array_index;
    }
    public void setY(int index) {
        this.y = index;
    }
    public int getY() {
        return y;
    }
    public int getCompareIndex1() {
        return compare_index1;
    }

    public void setCompareIndex1(int compare_index) {
        this.compare_index1 = compare_index;
    }
    public int getCompareIndex2() {
        return compare_index2;
    }

    public void setCompareIndex2(int compare_index2) {
        this.compare_index2 = compare_index2;
    }
    public int getPartition() {
        return partition;
    }

    public void setPartition(int compare_index) {
        this.partition = compare_index;
    }
}
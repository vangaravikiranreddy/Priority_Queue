import java.util.ArrayList;

public class PriorityQueueServices {
    private ArrayList<Integer> list = new ArrayList<>();
    public void BuildMinPriorityQueue(ArrayList<Integer> input)
    {
        list = input;

        int N=list.size();
        int index = (N+1)/2;
        while(index >= 0)
        {
            int leftIndex = (2 * index)+1;
            int rigtIndex = (2 * index)+2;
            int tempIndex = index;
            while(leftIndex < N)
            {
                if(rigtIndex >= N)
                {
                    if(list.get(tempIndex) > list.get(leftIndex))
                    {
                        swap(tempIndex, leftIndex);
                    }
                    break;
                }
                if(list.get(tempIndex) <= list.get(leftIndex) && list.get(tempIndex) <= list.get(rigtIndex))
                {
                    break;
                }
                if(list.get(tempIndex) > list.get(leftIndex) && list.get(leftIndex) <= list.get(rigtIndex))
                {
                    swap(tempIndex, leftIndex);
                    tempIndex = leftIndex;
                }
                else
                {
                    swap(tempIndex, rigtIndex);
                    tempIndex = rigtIndex;
                }
                leftIndex = (2 * tempIndex) + 1;
                rigtIndex = (2 * tempIndex) + 2;
            }
            index--;
        }
    }
    public void swap(int index1, int index2) {
        int temp = list.get(index1);
        list.set(index1, list.get(index2));
        list.set(index2, temp);
    }
    public void delete() {
        int index = 0;

        int lastIndex = list.size() - 1;

        list.set(index, list.get(lastIndex));

        int size = list.size();

        while (index < size) {
            int leftIndex = (2 * index) + 1;
            int rightIndex = (2 * index) + 2;

            if (leftIndex >= size && rightIndex >= size) {
                return;
            }
            if (rightIndex == size) {
                if (list.get(index) > list.get(leftIndex)) {
                   swap(index, leftIndex);
                   index = leftIndex;
                } else {
                    break;
                }
            } else {
                if (list.get(index) <= list.get(leftIndex) && list.get(index) <= list.get(leftIndex)) {
                   break;
                } else if (list.get(leftIndex) <= list.get(rightIndex)) {
                    swap(index, leftIndex);
                    index = leftIndex;
                } else {
                    swap(index, rightIndex);
                    index = rightIndex;
                }
            }
        }
    }
    public void insert(int value)
    {
        list.add(value);
        int i = list.size()-1;
        while(i>0 && list.get((i-1)/2) > list.get(i))
        {
            int temp = list.get((i-1)/2);
            list.set((i-1)/2, list.get(i));
            list.set(i,temp);
            i = (i-1)/2;
        }
    }
    public int getMinValue() {
        return list.get(0);
    }
}

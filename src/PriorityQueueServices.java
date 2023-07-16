import java.util.ArrayList;

public class PriorityQueueServices {
    private ArrayList<Integer> list = new ArrayList<>();
    public void BuildMinPriorityQueue(ArrayList<Integer> input)
    {
        list = input;

        int N=list.size();
        int i=(N+1)/2;
        while(i >= 0)
        {
            int lc=(2*i)+1;
            int rc=(2*i)+2;
            int temp=i;
            while(lc < N)
            {
                if(rc >= N)
                {
                    if(list.get(temp) > list.get(lc))
                    {
                        int d = list.get(temp);
                        list.set(temp,list.get(lc));
                        list.set(lc,d);
                    }
                    break;
                }
                if(list.get(temp) <= list.get(lc) && list.get(temp) <= list.get(rc))
                {
                    break;
                }
                if(list.get(temp) > list.get(lc) && list.get(lc) <= list.get(rc))
                {
                    int d = list.get(temp);
                    list.set(temp,list.get(lc));
                    list.set(lc,d);
                    temp=lc;
                }
                else
                {
                    int d=list.get(temp);
                    list.set(temp,list.get(rc));
                    list.set(rc,d);
                    temp=rc;
                }
                lc=2*temp+1;
                rc=2*temp+2;
            }
            i--;
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

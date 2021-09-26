public class Solution {
    public ArrayList<Integer> dNums(ArrayList<Integer> A, int B) {
        java.util.Map<Integer,Integer> a = new java.util.HashMap<>();
        java.util.ArrayList<Integer> out = new java.util.ArrayList<>();
        int i=0;
        for(i=0;i<B&&i<A.size();i++){
            if(!a.containsKey(A.get(i)))
                a.put(A.get(i),1);
            else{
                a.put(A.get(i),a.get(A.get(i))+1);
            }
        }
        out.add(a.keySet().size());
        for(;i<A.size();i++){
            if(a.get(A.get(i-B))-1==0)
                a.remove(A.get(i-B));
            else
                a.put(A.get(i-B),a.get(A.get(i-B))-1);
           if(!a.containsKey(A.get(i)))
                a.put(A.get(i),1);
            else
                a.put(A.get(i),a.get(A.get(i))+1);
            out.add(a.keySet().size());
        }
        return out;
    }
}

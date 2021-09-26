public class MaxSumComb {
    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B, int C) {
        java.util.PriorityQueue<Integer> pq= new java.util.PriorityQueue();
        java.util.ArrayList<Integer> out=new java.util.ArrayList<Integer>();
        
        int d=C;
        for(int i=0;i<A.size();i++){
            for(int j=0;j<B.size();j++){
                if(d>0){
                    pq.offer(A.get(i)+B.get(j));
                    d--;
                }
                else{
                    if(pq.peek()>A.get(i)+B.get(j))
                        continue;
                    else{
                        pq.poll();
                        pq.offer(A.get(i)+B.get(j));
                    }
                }
            }
        }

        while(!pq.isEmpty()){
            out.add(pq.poll());
        }
        Collections.sort(out,Collections.reverseOrder());
        return out; 
    }
    
}

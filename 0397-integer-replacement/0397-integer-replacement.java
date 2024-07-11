class Solution {
    public int integerReplacement(int n) {
        HashSet<Long>set = new HashSet<>();
        Queue<Long>q=new LinkedList<>();
        q.add(n*1l);
        int lvl=0;
        while(!q.isEmpty()){
            int p = q.size();
            for(int i = 0;i<p;i++){
                long temp = q.poll();
                if(set.contains(temp)) continue;
                set.add(temp);
                if(temp==1){
                    return lvl;
                }
                if(temp%2==0){
                    q.add(temp/2);
                }else{
                    q.add(temp+1);
                    q.add(temp-1);
                }
            }
            lvl++;
        }
        return 0;
    }
}
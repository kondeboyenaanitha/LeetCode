class AllOne {
    
    Map<String,Integer> freqMap;
    TreeMap<Integer,Set<String>> treeMap;
    public AllOne() {
        freqMap=new HashMap<>();
        treeMap=new TreeMap<>();
    }
    
    public void inc(String key) {
        freqMap.putIfAbsent(key,0);
        int currFreq=freqMap.get(key);
        if(treeMap.containsKey(currFreq)&&treeMap.get(currFreq).contains(key)){
            treeMap.get(currFreq).remove(key);
            if(treeMap.get(currFreq).isEmpty())
                treeMap.remove(currFreq);
        }
        freqMap.put(key,currFreq+1);
        treeMap.putIfAbsent(currFreq+1,new HashSet<>());
        treeMap.get(currFreq+1).add(key);
    }
    
    public void dec(String key) {
        int currFreq=freqMap.get(key);
        treeMap.get(currFreq).remove(key);
        if(treeMap.get(currFreq).isEmpty())
            treeMap.remove(currFreq);
        freqMap.put(key,currFreq-1);
        if(currFreq-1>0){
            treeMap.putIfAbsent(currFreq-1,new HashSet<>());
            treeMap.get(currFreq-1).add(key);
        }
    }
    
    public String getMaxKey() {
        if(treeMap.isEmpty())
            return "";
        for(String s:treeMap.get(treeMap.lastKey()))
             return s;
        return "";
    }
    
    public String getMinKey() {
        if(treeMap.isEmpty())
            return "";
        for(String s:treeMap.get(treeMap.firstKey()))
             return s;
        return "";
    }
}
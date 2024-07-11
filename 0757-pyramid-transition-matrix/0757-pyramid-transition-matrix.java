class Solution {
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        HashMap<String, List<Character>> map = new HashMap<>();
        HashSet<String> invalidBottoms = new HashSet<>();
        for (String s : allowed){
            String b = s.substring(0, 2);
            char up = s.charAt(2);
            if(!map.containsKey(b)) map.put(b, new ArrayList<>());
            map.get(b).add(up);
        }

        return pyramidHelper(bottom, map, invalidBottoms);
    }

    private boolean pyramidHelper(String bottom, HashMap<String, List<Character>> map, HashSet<String> invalidBottoms){
        if (bottom.length() == 2){
            return map.containsKey(bottom);
        }

        if(invalidBottoms.contains(bottom)) return false;

        List<String> potentialBottoms = new ArrayList<>();
        getPotentialBottoms("", bottom, 0, map, potentialBottoms);
        for (String b : potentialBottoms){
            boolean res = pyramidHelper(b, map, invalidBottoms);
            if (res) return res;
        }

        invalidBottoms.add(bottom);
        return false;        
    }

    private void getPotentialBottoms(String bsf, String bottom, int idx, HashMap<String, List<Character>> map, List<String> potentialBottoms){
        if (idx == bottom.length() - 2){
            String s = bottom.substring(idx, bottom.length());
            if (!map.containsKey(s)){
                return;
            }

            List<Character> list = map.get(s);
            for (char suffix : list){
                potentialBottoms.add(bsf + suffix);
            }

            return;
        }

        String s = bottom.substring(idx, idx+2);
        if (!map.containsKey(s)) return;
        for (char suffix : map.get(s)){
            getPotentialBottoms(bsf + suffix, bottom, idx + 1, map, potentialBottoms);
        }
    }
}
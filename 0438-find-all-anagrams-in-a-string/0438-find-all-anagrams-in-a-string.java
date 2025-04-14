class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ls = new ArrayList<Integer>();

        HashMap<Character, Integer> mp = new HashMap<Character, Integer>();

        int m = p.length();
        int n = s.length();

        if(n<m) {
            return ls;
        }
        for(int i=0; i<m; i++) {
            if(mp.containsKey(p.charAt(i))) {
                mp.put(p.charAt(i), mp.get(p.charAt(i))+1);
            } else {
                mp.put(p.charAt(i), 1);
            }
        }
      HashMap<Character, Integer> smp = new HashMap<Character, Integer>();

        for(int i=0; i<m; i++) {
            if(smp.containsKey(s.charAt(i))) {
                smp.put(s.charAt(i), smp.get(s.charAt(i))+1);
            } else {
                smp.put(s.charAt(i), 1);
            }
        }      
        if(smp.equals(mp)) {
            ls.add(0);
        }
        for(int i=m; i<n; i++) {
            smp.put(s.charAt(i-m), smp.get(s.charAt(i-m))-1);
            if(smp.get(s.charAt(i-m))==0) {
                smp.remove(s.charAt(i-m));
            }
            if(smp.containsKey(s.charAt(i))) {
                smp.put(s.charAt(i), smp.get(s.charAt(i))+1);
            } else {
                smp.put(s.charAt(i), 1);
            }
            if(smp.equals(mp)) {
                ls.add(i-m+1);
            }

        }

        return ls;
    }
}
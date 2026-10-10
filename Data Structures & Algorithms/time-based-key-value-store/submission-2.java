class TimeMap {

    record Val(String value, int timestamp){}
    Map<String, ArrayList<Val>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        var list = map.getOrDefault(key, new ArrayList<>());
        list.add(new Val(value, timestamp));
        map.put(key, list);
    }

    public String get(String key, int timestamp) {
        ArrayList<Val> vals = map.get(key);
        if(vals == null) return "";

        int left = 0;
        int right = vals.size() - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(vals.get(mid).timestamp == timestamp) return vals.get(mid).value;
            if(vals.get(mid).timestamp > timestamp) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if(right < 0) return "";
        
        return vals.get(right).value;

    }
}

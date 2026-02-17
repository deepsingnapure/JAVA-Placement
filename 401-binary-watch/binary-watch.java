class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> result = new ArrayList<>();

        for(int h=0;h<=11;h++){
            for(int min=0;min<=59;min++){
                if(Integer.bitCount(h)+Integer.bitCount(min) == turnedOn){
                    String hour = String.valueOf(h);
                    String minute = (min < 10 ? "0" : "") + min;
                    result.add(hour + ":" +minute);
                }
            }
        }
        return result;
    }
}
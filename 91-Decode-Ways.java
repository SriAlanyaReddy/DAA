class Solution {
    public int numDecodings(String s) {
        if(s.length()==0 || s==null){
            return 0;
        }
      
        int[] dp=new int[s.length()];
        Arrays.fill(dp,-1);
        return decodeways(s,0,dp);
    }
    public int decodeways(String s,int ind,int[] dp){
        if (ind==s.length()){
            return 1;
        }
        if(ind> s.length() ||  s.charAt(ind)=='0'){
            return 0;
        }
        if(dp[ind]!=-1){
            return dp[ind];
        }
        int count=decodeways(s,ind+1,dp);
        if(ind<s.length()-1){
            int twodigit=Integer.parseInt(s.substring(ind,ind+2));
            if(twodigit>=10 && twodigit<=26){
                count+=decodeways(s,ind+2,dp);
            }
        }
        return dp[ind]=count;
    }
}
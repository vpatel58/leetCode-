class Solution {
    public boolean isMatch(String s, String p) {
        int sl = s.length();
        int pl = p.length();
        int sp = 0, pp = 0;
        int sStar = -1, pStar = -1;
        while (sp < sl) {
            if (pp < pl && (s.charAt(sp) == p.charAt(pp) || p.charAt(pp) == '?')) {
                sp++;
                pp++;
            } else if ((pp < pl) && (p.charAt(pp) == '*') ){
                pStar = pp;
                sStar = sp;
                pp++;
            } else if (pStar == -1) {
                return false;
            } else {
                pp = pStar;
                sp = sStar;
                sp++;
            }
        }
        while (pp < pl) {
            if (p.charAt(pp) != '*') return false;
            pp++;
        }
        return true;
    }
}

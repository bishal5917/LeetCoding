import java.util.Arrays;

public class AssignCookies {

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int greed =0;
        int cookie=0;
        while (greed<g.length && cookie<s.length){
            if(g[greed]<=s[cookie]){
                greed+=1;
                cookie+=1;
            }else{cookie+=1;}
        }
        System.out.println(greed);;
        return greed;
    }

    public static void main(String[] args) {
        int[] children = { 1, 2, 3 };
        int[] candy = { 3 };
        AssignCookies obj = new AssignCookies();
        obj.findContentChildren(children, candy);
    }

}
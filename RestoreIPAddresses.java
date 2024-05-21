import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {

    public List<String> restoreIpAddresses(String s) {
        List<String> addresses = new ArrayList<>();
        generateIpAddressesHelper(s, new ArrayList<>(), addresses, 0, 0);
        return addresses;
    }

    private List<String> generateIpAddressesHelper(String s, List<String> curr, List<String> addresses, int st,
            int points) {
        // if 3 points are added,check if valid and add to answer
        if (points == 3) {
            // check for the last remaining octet
            String octet = s.substring(st);
            if (isValidOctet(octet)) {
                curr.add(octet);
                String res = String.join("", curr);
                addresses.add(res);
                // undo the last added octet before returning
                curr.remove(curr.size() - 1);
            }
            return curr;
        }
        for (int i = 1; i <= 3; i++) {
            if (st + i >= s.length()) {
                continue;
            }
            String octet = s.substring(st, st + i);
            // If the octet starts with '0' but is not '0' itself, skip further processing
            if (octet.startsWith("0") && !octet.equals("0")) {
                break;
            }
            if (isValidOctet(octet)) {
                // means valid
                // add octet and dot and increment the point added
                curr.add(octet);
                curr.add(".");
                points += 1;
                // Check for the remaining string in DFS Manner
                curr = generateIpAddressesHelper(s, curr, addresses, st + i, points);
                // During stack unwinding
                // remove the octet and dot added and decrease the point
                // Backtracking
                curr.remove(curr.size() - 1);
                curr.remove(curr.size() - 1);
                points -= 1;
            }
        }
        return curr;
    }

    private boolean isValidOctet(String s) {
        try {
            if (s.length() > 1 && s.startsWith("0")) {
                // cant have leading zeroes
                return false;
            }
            int val = Integer.parseInt(s);
            return val >= 0 && val <= 255;
        } catch (Exception e) {
            return false;
        }
    }

    public static void main(String[] args) {
        RestoreIPAddresses obj = new RestoreIPAddresses();
        String s = "25525511135";
        System.out.println(obj.restoreIpAddresses(s));
    }
}

// My Thought process/Pseudocode
// // Input:s="25525511135"
// // // For every,1,2,3
// //
// // programiz.pro");if(
// // three dots placed){
// // //add to ans and return
// // return;
// // }
// // // last prev pos,i.e
// // // first start from 0
// // // if three dots placed,add to ans,else not
// // for(
// // int i = idx;i<3;i++)
// // {
// // // do for every 1,2 and 3
// // // get substring
// // String toCheckNext = s.substring(st,i+1);
// // //if this is valid
// // add to curr
// // curr.add(.)
// // curr.add(toCheckNext)
// // dots+=1;
// // //then while backtrack
// // //remove point and
// // curr.remove(last)
// // curr.remove(last)
// // dots-=1;
// // }

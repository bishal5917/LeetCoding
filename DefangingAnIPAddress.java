public class DefangingAnIPAddress {

    public String defangIPaddr(String address) {
        StringBuilder ans = new StringBuilder();
        for (char c : address.toCharArray()) {
            if (c == '.') {
                ans.append("[.]");
            } else {
                ans.append(c);
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        DefangingAnIPAddress obj = new DefangingAnIPAddress();
        String address = "255.100.50.0";
        System.out.println(obj.defangIPaddr(address));
    }
}
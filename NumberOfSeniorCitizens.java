public class NumberOfSeniorCitizens {

    public int countSeniors(String[] details) {
        int seniors = 0;
        for (String detail : details) {
            // Now its time to find the age
            String age = detail.substring(11, 13);
            if (Integer.valueOf(age) > 60) {
                seniors++;
            }
        }
        return seniors;
    }

    public static void main(String[] args) {
        NumberOfSeniorCitizens obj = new NumberOfSeniorCitizens();
        String[] details = { "7868190130M7522", "5303914400F9211", "9273338290F4010" };
        System.out.println(obj.countSeniors(details));
    }
}

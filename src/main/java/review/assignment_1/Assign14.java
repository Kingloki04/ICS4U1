package review.assignment_1;

import utils.MathUtil;

public class Assign14 {

    public static void main(String[] args) {

        String[] nums = new String[10];

        System.out.println("Step 1:");
        for (int i = 0; i < 10; i++) {
            nums[i] = Integer.toString(MathUtil.random(1, 30));
            System.out.print(nums[i] + " ");
        }

        System.out.println("\n\nStep 2:");
        String combined = "";
        for (int i = 0; i < 10; i++) {
            combined = combined.concat(nums[i]);
        }
        System.out.println(combined);

        System.out.println("\nStep 3:");
        int result = 0;
        for (int i = 0; i < combined.length(); i++) {
            if (i%2 == 0) result += Integer.parseInt((Character.toString(combined.charAt(i))));
        }
        System.out.println("Final number: " + result);
    }
}

package twentytwentythree;

public class AprilTwentyEight {
//    public int trap(int[] height) {
//        int result = 0;
//        for (int i = 1; i < height.length - 1; i++) {
//
//            int leftHeight = 0;
//            for (int j = 0; j < i; j++) {
//                leftHeight = Math.max(height[j], leftHeight);
//            }
//
//            int rightHeight = 0;
//            for (int j = height.length - 1; j > i; j--) {
//                rightHeight = Math.max(height[j], rightHeight);
//            }
//
//            int heightMin = Math.min(rightHeight, leftHeight);
//            if (heightMin > height[i]) {
//                result += heightMin - height[i];
//            }
//        }
//        return result;
//    }

    public int trap(int[] height) {
        int[] let_max = new int[height.length];
        return 0;
    }

    public static void main(String[] args) {
        new AprilTwentyEight().trap(new int[]{4,2,0,3,2,5});
    }
}

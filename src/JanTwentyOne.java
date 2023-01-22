public class JanTwentyOne {
    /**
     * 移动零
     * 输入: nums = [0,1,0,3,12]
     * 输出: [1,3,12,0,0]
     */
//    public void moveZeroes(int[] nums) {
//        int p = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] == 0) {
//                p = i;
//                do {
//                    if (nums[p] != 0) {
//                        nums[i] = nums[p];
//                        nums[p] = 0;
//                        break;
//                    }
//                    p++;
//                } while (p < nums.length);
//            }
//        }
//    }
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int p = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i > p) {
                    nums[p] = nums[i];
                    nums[i] = 0;
                }
                p++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1};
        new JanTwentyOne().moveZeroes(nums);
        System.out.println(nums);
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int money = root.val;

        if (root.left!=null) {
            money += rob(root.left.left) + rob(root.left.right);
        }

        if (root.right != null) {
            money += rob(root.right.left) + rob(root.right.right);
        }

        return Math.max(money, rob(root.left) + rob(root.right));
    }

    public int robdp(TreeNode root) {
        int [] result = robpart(root);
        return Math.max(result[0], result[1]);
    }

    public int[] robpart(TreeNode root) {
        if (root == null) return new int[2];

        int [] result = new int[2];

        int [] left = robpart(root.left);

        int [] right = robpart(root.right);

        result[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        result[1] = root.val + left[0] + right[0];
        return result;
    }
}

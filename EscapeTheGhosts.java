public class EscapeTheGhosts {

    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int dis = Math.abs(target[0]) + Math.abs(target[1]);
        for (int[] ghost : ghosts) {
            if (dis >= Math.abs(ghost[0] - target[0]) + Math.abs(ghost[1] - target[1])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        EscapeTheGhosts obj = new EscapeTheGhosts();
        int[][] ghosts = { { 1, 0 }, { 0, 3 } };
        int[] target = { 0, 1 };
        System.out.println(obj.escapeGhosts(ghosts, target));
    }
}

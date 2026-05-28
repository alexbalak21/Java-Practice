import java.util.*;

public class PlayerTest {
    static boolean simulate(int clawPos, int[] boxes, boolean boxInClaw) {
        int n = boxes.length;
        int steps = 0;
        while (steps++ < 200) {
            String action = Player.solve(clawPos, boxes, boxInClaw);
            if ("RIGHT".equals(action)) {
                if (clawPos < n - 1) clawPos++;
                else return false;
            } else if ("LEFT".equals(action)) {
                if (clawPos > 0) clawPos--;
                else return false;
            } else if ("PICK".equals(action)) {
                if (boxInClaw) return false;
                if (boxes[clawPos] <= 0) return false;
                boxes[clawPos]--;
                boxInClaw = true;
            } else if ("PLACE".equals(action)) {
                if (!boxInClaw) return false;
                boxes[clawPos]++;
                boxInClaw = false;
            } else {
                System.out.println("Unknown action: " + action);
                return false;
            }

            // if not carrying a box, check whether stacks are smoothed
            if (!boxInClaw) {
                int total = 0;
                for (int b : boxes) total += b;
                int target = total / n;
                int extra = total % n;
                boolean ok = true;
                for (int i = 0; i < n; i++) {
                    int desired = target + (i < extra ? 1 : 0);
                    if (boxes[i] != desired) { ok = false; break; }
                }
                if (ok) return true;
            }
        }
        return false;
    }

    static boolean runCase(int[] initBoxes, int clawPos, boolean boxInClaw) {
        int[] boxes = Arrays.copyOf(initBoxes, initBoxes.length);
        boolean ok = simulate(clawPos, boxes, boxInClaw);
        System.out.println("Case " + Arrays.toString(initBoxes) + " -> " + (ok ? "PASS" : "FAIL") + " final: " + Arrays.toString(boxes));
        return ok;
    }

    public static void main(String[] args) {
        int failures = 0;
        if (!runCase(new int[]{1,1,1}, 0, false)) failures++;
        if (!runCase(new int[]{0,3}, 0, false)) failures++;
        if (!runCase(new int[]{0,0,3}, 2, false)) failures++;
        if (!runCase(new int[]{5,0,0,0}, 0, false)) failures++;

        Random rnd = new Random(123);
        for (int t = 0; t < 10; t++) {
            int n = 2 + rnd.nextInt(7);
            int[] boxes = new int[n];
            int total = 1 + rnd.nextInt(16);
            for (int i = 0; i < total; i++) boxes[rnd.nextInt(n)]++;
            int pos = rnd.nextInt(n);
            boolean carrying = rnd.nextBoolean() && boxes[pos] > 0;
            if (carrying) boxes[pos]--;
            if (!runCase(boxes, pos, carrying)) failures++;
        }

        if (failures == 0) System.out.println("ALL TESTS PASSED");
        else System.out.println("FAILED: " + failures);
        System.exit(failures == 0 ? 0 : 1);
    }
}
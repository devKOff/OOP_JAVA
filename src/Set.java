import java.util.Arrays;

public class Set {
    public static void main(String[] args) {
        String characterName = "Dev";
        int strength = rollStat();
        System.out.println(characterName + "has a very Strength: " + strength);
    }

    public static int rollStat() {
        // Simulate 4d6, drop lowest, sum the rest
        int[] rolls = new int[4];
        for (int i = 0; i < 4; i++) {
            rolls[i] = (int) (Math.random() * 6) + 1; // 1-6
        }
        Arrays.sort(rolls);
        return rolls[1] + rolls[2] + rolls[3]; // Sum top 3
    }
}
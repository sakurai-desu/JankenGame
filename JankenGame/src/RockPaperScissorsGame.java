import java.util.Random;
import java.util.Scanner;

public class RockPaperScissorsGame {
    private static Random random = new Random();
    private static final int NUMBER_OF_HAND = 3;

    private static Scanner scanner = new Scanner(System.in);
    private static final String[] HAND_NAMES = { "グー", "チョキ", "パー" };
    private static final int[] HAND_NUMBER = { 0, 1, 2 };

    // #region メッセージ
    private static final String FIRST_SHOUT = "最初はぐー、じゃんけん：";
    private static final String DRAW_SHOUT = "あいこで：";
    private static final String WIN_MESSAGE = "あなたの勝ちです";
    private static final String LOSE_MESSAGE = "あなたの負けです";

    private static final String INPUT_INFOMATION_MESSAGE = "を数字で入力してね\n";
    private static final String GAME_TITLE_MESSAGE = "じゃんけん勝負\n";
    private static final String HAND_NAME_MESSAGE = "%s";
    private static final String DESCRIPTION_HAND_MESSAGE = "%d:%s\n";
    private static final String INFORMATION_MESSAGE = "%sと%sで...\n";
    // #endregion

    private static int computerSelectHand = 0;
    private static int playerSelectHand = 0;

    public static void main(String[] args) {
        showIntroMessage();
        computerSelectHand = selectionComputerHand();
        playerSelectHand = inputPlayerHand(FIRST_SHOUT);
        comparisonHands(computerSelectHand, playerSelectHand);
    }

    private static int inputPlayerHand(String shoutMessage) {
        showShouting(shoutMessage);
        int playerHand = scanner.nextInt();
        return playerHand;
    }

    private static int selectionComputerHand() {
        int computerHand = random.nextInt(NUMBER_OF_HAND);
        return computerHand;
    }

    private static void showIntroMessage() {
        showRuleExplanation();
        showDescriptionHandInputValues();
    }

    private static void showRuleExplanation() {
        System.out.print(GAME_TITLE_MESSAGE);
        showHandList();
    }

    private static void showHandList() {
        for (String hand : HAND_NAMES) {
            System.out.printf(HAND_NAME_MESSAGE, hand);
        }
        System.out.print(INPUT_INFOMATION_MESSAGE);
    }

    private static void showDescriptionHandInputValues() {
        int loopCount = 0;
        for (String hand : HAND_NAMES) {
            System.out.printf(DESCRIPTION_HAND_MESSAGE, loopCount, hand);
            loopCount++;
        }
    }

    private static void showShouting(String message) {
        System.out.print(message);
    }

    private static void comparisonHands(int comSelectHand, int playerHand) {
        if (isDrowGame(comSelectHand, playerHand)) {
            comparisonHands(selectionComputerHand(), inputPlayerHand(DRAW_SHOUT));
            return;
        }
        if (isRock(comSelectHand)) {
            if (isPaper(playerHand)) {
                showResultfGame(WIN_MESSAGE);
                return;
            }
        } else if (isScissors(comSelectHand)) {
            if (isRock(playerHand)) {
                showResultfGame(WIN_MESSAGE);
                return;
            }
        } else if (isPaper(comSelectHand)) {
            if (isScissors(playerHand)) {
                showResultfGame(WIN_MESSAGE);
                return;
            }
        }
        showResultfGame(LOSE_MESSAGE);
    }

    private static boolean isDrowGame(int comHand, int playerHand) {
        boolean drow = false;
        if (comHand == playerHand) {
            drow = true;
            return drow;
        }
        return drow;
    }

    private static boolean isRock(int hand) {
        boolean rock = false;
        if (hand == HAND_NUMBER[0]) {
            rock = true;
        }
        return rock;
    }

    private static boolean isScissors(int hand) {
        boolean scissors = false;
        if (hand == HAND_NUMBER[1]) {
            scissors = true;
        }
        return scissors;
    }

    private static boolean isPaper(int hand) {
        boolean paper = false;
        if (hand == HAND_NUMBER[2]) {
            paper = true;
        }
        return paper;
    }

    private static void showResultfGame(String resultMessage) {
        showHandInfomation();
        System.out.print(resultMessage);
    }

    private static void showHandInfomation() {
        System.out.printf(INFORMATION_MESSAGE, HAND_NAMES[computerSelectHand], HAND_NAMES[playerSelectHand]);
    }

}

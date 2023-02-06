package Lists;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CardGame {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> playerOne = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer> playerTwo = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        int firstSum = 0;
        int secondSum = 0;
        while (playerOne.size() > 0 && playerTwo.size() > 0){

            int firstPlayerCard = playerOne.get(0);
            int secondPlayerCard = playerTwo.get(0);

            if (firstPlayerCard == secondPlayerCard){
                playerOne.remove(0);
                playerTwo.remove(0);

            }else if (playerOne.get(0) > playerTwo.get(0)){
                playerOne.add(playerOne.get(0));
                playerOne.add(playerTwo.get(0));
                playerOne.remove(0);
                playerTwo.remove(0);
            } else {
                playerTwo.add(playerOne.get(0));
                playerTwo.add(playerTwo.get(0));
                playerTwo.remove(0);
                playerOne.remove(0);

            }
        }

        if(playerTwo.isEmpty()){
            for (Integer poSum : playerOne) {
                firstSum += poSum;

            }
            System.out.printf("First player wins! Sum: %d", firstSum);
        } else {
            for (Integer ptSum : playerTwo) {
                secondSum += ptSum;
            }

            System.out.printf("Second player wins! Sum: %d", secondSum);

        }
    }
}

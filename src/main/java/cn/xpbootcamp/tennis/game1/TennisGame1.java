package cn.xpbootcamp.tennis.game1;

import cn.xpbootcamp.tennis.TennisGame;

public class TennisGame1 implements TennisGame {

    private int player1Score = 0;
    private int player2Score = 0;
    private String[] scoreArray = new String[]{"Love", "Fifteen", "Thirty", "Forty"};
    private String player1Name;
    private String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals("player1"))
            player1Score += 1;
        else
            player2Score += 1;
    }

    public String getScore() {
        if (isEqualScore()) {
            return buildEqualScore();
        } else if (isUpToFourScore()) {
            return buildUpToFourScore();
        } else {
            return buildUnderThreeScore();
        }
    }

    private boolean isUpToFourScore() {
        return player1Score >= 4 || player2Score >= 4;
    }

    private boolean isEqualScore() {
        return player1Score == player2Score;
    }

    private String buildUnderThreeScore() {
        return scoreArray[player1Score] +
                '-' +
                scoreArray[player2Score];
        }

    private String buildUpToFourScore() {
        StringBuilder score;
        int minusResult = player1Score - player2Score;
        if (minusResult == 1) score = new StringBuilder("Advantage player1");
        else if (minusResult == -1) score = new StringBuilder("Advantage player2");
        else if (minusResult >= 2) score = new StringBuilder("Win for player1");
        else score = new StringBuilder("Win for player2");
        return score.toString();
    }

    private String buildEqualScore() {
        if (player1Score>=3){
            return "Deuce";
        }
        return scoreArray[player1Score] + '-' + "All";
    }
}

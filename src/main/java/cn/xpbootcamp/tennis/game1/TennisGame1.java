package cn.xpbootcamp.tennis.game1;

import cn.xpbootcamp.tennis.TennisGame;

public class TennisGame1 implements TennisGame {

    private int player1Score = 0;
    private int player2Score = 0;
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
        StringBuilder score = new StringBuilder();
        if (player1Score == player2Score) {
            return bulidEqualScore();
        } else if (player1Score >= 4 || player2Score >= 4) {
            return buildUpToFourScore();
        } else {
            return buildUnderThreeScore(score);
        }
    }

    private String buildUnderThreeScore(StringBuilder score) {
        int tempScore;
        for (int i = 1; i < 3; i++) {
            if (i == 1) tempScore = player1Score;
            else {
                score.append("-");
                tempScore = player2Score;
            }
            switch (tempScore) {
                case 0:
                    score.append("Love");
                    break;
                case 1:
                    score.append("Fifteen");
                    break;
                case 2:
                    score.append("Thirty");
                    break;
                case 3:
                    score.append("Forty");
                    break;
            }
        }
        return score.toString();
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

    private String bulidEqualScore() {
        StringBuilder score;
        switch (player1Score) {
            case 0:
                score = new StringBuilder("Love-All");
                break;
            case 1:
                score = new StringBuilder("Fifteen-All");
                break;
            case 2:
                score = new StringBuilder("Thirty-All");
                break;
            default:
                score = new StringBuilder("Deuce");
                break;

        }
        return score.toString();
    }
}

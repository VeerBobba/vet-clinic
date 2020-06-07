package serenitylabs.tutorials.vetclinic.playingball.model;

import static serenitylabs.tutorials.vetclinic.playingball.model.Game.*;

public class Child {
    public void goPlay(Game game) {
        Player gameToPlay = PlayerGame.called(game);
        gameToPlay.goPlay();
    }

}

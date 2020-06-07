package serenitylabs.tutorials.vetclinic.playingball.model;

import static serenitylabs.tutorials.vetclinic.playingball.model.Game.*;

public class PlayerGame {
     public static Player called(Game game) {
         switch (game) {
             case Football:
                 return new PlayFootball();
             case Tennis:
                 return new PlayTennis();
             case Cricket:
                 return new PlayCricket();
             case Handball:
                 return new PlayHandball();
             case Hockey:
                 return new PlayHockey();
             case Ice_hockey:
                 return new PlayIcehockey();
             default:
                 throw new DontKnowThatGameException();
         }
        }

}

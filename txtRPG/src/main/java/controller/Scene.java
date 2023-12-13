package controller;

import java.util.Scanner;

public abstract class Scene {
        //protected User user = null;
        protected int sceneIntel, sceneWealth, sceneSociability, sceneMorality, sceneArtistry, scenePTSD;
        protected String sceneName;

        protected Scanner scanner = null;
        public Scene()
        {
                sceneName = "";
                sceneWealth = 0;
                sceneSociability = 0;
                scenePTSD = 0;
                sceneMorality = 0;
                sceneIntel = 0;
                sceneArtistry = 0;
                //user = GameManager.getInstance().getUser();
        }

        public abstract void initialize();
        public abstract int update();
        public abstract void render();

}


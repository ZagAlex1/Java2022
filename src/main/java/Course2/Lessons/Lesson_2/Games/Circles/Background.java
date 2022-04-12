package Course2.Lessons.Lesson_2.Games.Circles;

import Course2.Lessons.Lesson_2.Games.Common.CommonObject;
import Course2.Lessons.Lesson_2.Games.Common.GameCanvas;


import java.awt.*;
//
public class Background implements CommonObject {

    private float time;
    private static final float AMPLITUDE = 255f / 2f;
    private Color color;

    @Override
    public void update(GameCanvas gameCanvas, float deltaTime) {
        time += deltaTime;
        int red = Math.round(AMPLITUDE + AMPLITUDE * (float) Math.cos(time * 2f));
        int green = Math.round(AMPLITUDE + AMPLITUDE * (float) Math.cos(time * 3f));
        int blue = Math.round(AMPLITUDE + AMPLITUDE * (float) Math.cos(time));
        color = new Color(red, green, blue);
    }
    @Override
    public void render(GameCanvas gameCanvas, Graphics g) {
        gameCanvas.setBackground(color);
    }
}

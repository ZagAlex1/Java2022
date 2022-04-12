package Course2.Lessons.Lesson_2.Games.Common;

import java.awt.*;

public interface CommonObject {
    void update(GameCanvas canvas, float deltaTime);
    void render(GameCanvas canvas, Graphics g);
}

package game.adi

import com.badlogic.gdx.{Gdx, Input}
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.{Batch, Sprite}
import com.badlogic.gdx.math.{MathUtils, Vector2}

class Player extends GameEntity(0.1) {
    private val speed = 400
    private val mousePos = new Vector2()

    override def act(v: Float): Unit = {
        super.act(v)

        rotate()
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            move("d", v)
        }
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            move("a", v)
        }
        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            move("w", v)
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            move("s", v)
        }
    }

    private def move(dir: String, delta: Float): Unit = {
        val rotation = getRotation * MathUtils.degreesToRadians

        var dx = 0f
        var dy = 0f

        dir match {
            case "w" =>
//                dx = -speed * delta
                dy = speed * delta
            case "s" =>
//                dx = speed * delta
                dy = -speed * delta
            case "a" =>
                dx = -speed * delta
//                dy = -speed * delta
            case "d" =>
                dx = speed * delta
//                dy = speed * delta
        }


        val newX = speed*delta
        val newY = speed*delta
        moveBy(dx, dy)
    }

    private def rotate(): Unit = {
        mousePos.x = Gdx.input.getX
        mousePos.y = Gdx.graphics.getHeight - Gdx.input.getY



        val centerX = getX + getWidth / 2
        val centerY = getY + getHeight / 2

        val xdiff = centerX - mousePos.x
        val ydiff = centerY - mousePos.y

        val angle = MathUtils.atan2(ydiff, xdiff) * MathUtils.radiansToDegrees + 90

        setRotation(angle)
    }

}

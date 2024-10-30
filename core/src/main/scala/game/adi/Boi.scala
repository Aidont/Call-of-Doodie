package game.adi

import com.badlogic.gdx.math.{MathUtils, Vector2}

class Boi extends GameEntity(0.3) {
    private var player:Player = _

    def turnToPlayer(p:Player):Unit = player = p

    override def act(delta: Float): Unit = {
        super.act(delta)
        rotate(player)
    }

    private def rotate(player: Player): Unit = {
        val centerX = getX + getWidth / 2
        val centerY = getY + getHeight / 2

        val xdiff = centerX - player.getX()
        val ydiff = centerY - player.getY()

        val angle = MathUtils.atan2(ydiff, xdiff) * MathUtils.radiansToDegrees + 90

        setRotation(angle)
    }
}

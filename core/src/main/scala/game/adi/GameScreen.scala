package game.adi

import com.badlogic.gdx.Screen
import com.badlogic.gdx.graphics.{Color, Texture}
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.utils.ScreenUtils
import com.badlogic.gdx.utils.viewport.ScreenViewport


class GameScreen(game: CallOfDoodie) extends Screen {
    var playerImg: Texture = null
    var player: Player = _
    var stage: Stage = _
    var boi: Boi =_




    override def show(): Unit = {
        stage = new Stage(new ScreenViewport())
        playerImg = new Texture("player.png")
        player = new Player()
        player.initSprite(playerImg)
        boi = new Boi()
        boi.initSprite(new Texture("boi.jpeg"))
        boi.turnToPlayer(player)

        boi.setPosition(200, 500)
        player.setPosition(200, 200)
        stage.addActor(player)
        stage.addActor(boi)
        Gdx.input.setInputProcessor(stage)
    }


    private def draw(): Unit = {
        ScreenUtils.clear(Color.BLACK)
        stage.act()
        stage.draw()
    }

    override def render(v: Float): Unit = {
        draw()
    }


    override def resize(width: Int, height: Int): Unit = {
        stage.getViewport.update(width, height, true)
    }

    override def hide(): Unit = {}

    override def pause(): Unit = {}

    override def resume(): Unit = {}

    override def dispose(): Unit = {
        if (playerImg != null) playerImg.dispose()
        if (stage != null) stage.dispose()
    }

}

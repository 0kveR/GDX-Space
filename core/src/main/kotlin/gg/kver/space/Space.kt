package gg.kver.space

import com.badlogic.gdx.ApplicationListener
import com.badlogic.gdx.graphics.Camera
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.PerspectiveCamera
import com.badlogic.gdx.utils.ScreenUtils
import com.badlogic.gdx.utils.viewport.FitViewport
import com.badlogic.gdx.utils.viewport.Viewport


/** [com.badlogic.gdx.ApplicationListener] implementation shared by all platforms.  */
class Space : ApplicationListener {
    private lateinit var camera: Camera
    private lateinit var viewport: Viewport
    private var w: Float = 800.0F
    private var h: Float = 480.0F

    override fun create() {
        // Prepare your application here.
        camera = PerspectiveCamera()
        viewport = FitViewport(w, h, camera) // viewport is 800x480 and uses camera
    }

    override fun resize(width: Int, height: Int) {
        // Resize your application here. The parameters represent the new window size.
        viewport.update(width, height)
    }

    override fun render() {
        // Draw your application here.
        ScreenUtils.clear(Color.GOLD)
    }

    override fun pause() {
        // Invoked when your application is paused.
    }

    override fun resume() {
        // Invoked when your application is resumed after pause.
    }

    override fun dispose() {
        // Destroy application's resources here.
    }
}

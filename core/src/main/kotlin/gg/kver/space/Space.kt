package gg.kver.space

import com.badlogic.gdx.ApplicationListener

/** [com.badlogic.gdx.ApplicationListener] implementation shared by all platforms.  */
class Space : ApplicationListener {
    override fun create() {
        // Prepare your application here.
    }

    override fun resize(width: Int, height: Int) {
        // Resize your application here. The parameters represent the new window size.
    }

    override fun render() {
        // Draw your application here.
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

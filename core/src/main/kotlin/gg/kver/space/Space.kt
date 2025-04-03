package gg.kver.space

import com.badlogic.gdx.ApplicationListener
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.*
import com.badlogic.gdx.graphics.VertexAttributes.Usage
import com.badlogic.gdx.graphics.g3d.Material
import com.badlogic.gdx.graphics.g3d.Model
import com.badlogic.gdx.graphics.g3d.ModelBatch
import com.badlogic.gdx.graphics.g3d.ModelInstance
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder


/** [com.badlogic.gdx.ApplicationListener] implementation shared by all platforms.  */
class Space : ApplicationListener {
    private lateinit var camera: Camera
    private lateinit var batch: ModelBatch
    private lateinit var boxModel: Model
    private lateinit var boxInstance: ModelInstance

    override fun create() {
        // Prepare your application here.
        batch = ModelBatch()

        camera = PerspectiveCamera(67f, Gdx.graphics.width.toFloat(), Gdx.graphics.height.toFloat())
        camera.position.set(10f, 10f, 10f)
        camera.lookAt(0f, 0f, 0f)
        camera.update()
        val modelBuilder = ModelBuilder()
        boxModel = modelBuilder.createBox(
            5f, 5f, 5f,
            Material(ColorAttribute.createDiffuse(Color.GREEN)),
            (Usage.Position or Usage.Normal).toLong()
        )
        boxInstance = ModelInstance(boxModel)
    }

    override fun resize(width: Int, height: Int) {
        // Resize your application here. The parameters represent the new window size.
    }

    override fun render() {
        // Draw your application here.
        Gdx.gl.glViewport(0, 0, Gdx.graphics.width, Gdx.graphics.height) // Sets dimensions of OpenGL viewport
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT or GL20.GL_DEPTH_BUFFER_BIT) // Clears color buffer and depth buffer
        Gdx.gl.glClearColor(0f, 0f, 0f, 1f) // Bets color of the clear, each value is between 0 and 1 (v4 is alpha)

        batch.begin(camera) // batches must have a .begin() statement before their render statements
        batch.render(boxInstance)
        batch.end() // when all instances are rendered, use .end()
    }

    override fun pause() {
        // Invoked when your application is paused.
    }

    override fun resume() {
        // Invoked when your application is resumed after pause.
    }

    override fun dispose() {
        // Destroy application's resources here.
        batch.dispose()
        boxModel.dispose()
    }
}

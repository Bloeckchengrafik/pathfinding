package io.github.bloeckchengrafik.pathfinding

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import java.awt.BorderLayout
import java.awt.event.ActionEvent
import javax.swing.*
import kotlin.system.exitProcess


@SpringBootApplication
class PathfindingApplication : CommandLineRunner {
    private val disableClicker = "disableClicker"
    private lateinit var frame: JFrame
    private lateinit var grid: JSwingGridPane
    var logger: Logger = LoggerFactory.getLogger(PathfindingApplication::class.java)

    var closeButtonAction: Action = object : AbstractAction() {
        override fun actionPerformed(e: ActionEvent) {
            logger.info("Closing application")
            exitProcess(0)
        }
    }

    override fun run(args: Array<String>) {
        logger.info("Starting application")
        frame =
            JFrame("Pathfinding Application V1.0 (ESC to close, Right click to run, Left click to lay down walls, left+alt to set end)")
        frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        frame.isResizable = false
        frame.setSize(500, 500)

        val panel = JPanel(BorderLayout())
        addCloseKeyBind(panel)

        grid = JSwingGridPane()
        grid.setSize(500, 500)
        panel.add(grid, BorderLayout.CENTER)

        grid.setGrid()

        frame.contentPane = panel
        frame.isVisible = true
    }


    private fun addCloseKeyBind(contentPane: JComponent) {
        val iMap = contentPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
        val aMap = contentPane.actionMap
        iMap.put(KeyStroke.getKeyStroke("ESCAPE"), disableClicker)
        aMap.put(disableClicker, closeButtonAction)
    }
}

fun main(args: Array<String>) {
    SpringApplicationBuilder(PathfindingApplication::class.java).headless(false).run(*args)
}

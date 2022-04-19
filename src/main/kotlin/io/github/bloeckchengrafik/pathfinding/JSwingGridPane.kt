package io.github.bloeckchengrafik.pathfinding

import java.awt.Graphics
import java.awt.Graphics2D
import java.awt.event.MouseEvent
import java.awt.event.MouseListener
import java.lang.Math.floorDiv
import javax.swing.JPanel

class JSwingGridPane : JPanel(), MouseListener {
    lateinit var grid: Grid
    private lateinit var start: IntArray
    private lateinit var end: IntArray
    private var path = mutableListOf<IntArray>()

    fun setGrid() {
        this.grid = Grid(this.width / 10, this.height / 10)
        this.start = intArrayOf(floorDiv(grid.grid.size, 2), floorDiv(grid.grid.size, 2))
        this.end = intArrayOf(floorDiv(grid.grid.size, 2), 10)
        path.add(start)
        this.repaint()
        this.addMouseListener(this)
    }

    override fun paint(g: Graphics) {
        val g2d = g as Graphics2D
        g2d.clearRect(0, 0, this.width, this.height)
        g2d.color = java.awt.Color.WHITE
        g2d.fillRect(0, 0, this.width, this.height)

        g2d.color = java.awt.Color.GRAY

        for (i in 0 until grid.grid.size) {
            for (j in 0 until grid.grid.size) {
                g2d.drawRect(i*10, j*10, 10, 10)
                if (this.grid.grid[i][j]) {
                    g2d.fillRect(i*10, j*10, 10, 10)
                }
            }
        }

        g2d.color = java.awt.Color.YELLOW
        for (i in path) {
            g2d.fillRect(i[0] * 10, i[1] * 10, 10, 10)
        }

        g2d.color = java.awt.Color.ORANGE
        g2d.fillRect(this.start[0] * 10, this.start[1] * 10, 10, 10)

        g2d.color = java.awt.Color.RED
        g2d.fillRect(this.end[0] * 10, this.end[1] * 10, 10, 10)
    }

    /**
     * Invoked when the mouse button has been clicked (pressed
     * and released) on a component.
     * @param e the event to be processed
     */
    override fun mouseClicked(e: MouseEvent?) {
        if (e!!.button == MouseEvent.BUTTON1) grid.toggle(e.x, e.y)
        else {
            JSwingStartPopup().open {
                val algo = it.instance()
                algo.run(start, end, grid)
            }
        }
        this.repaint()
    }

    /**
     * Invoked when a mouse button has been pressed on a component.
     * @param e the event to be processed
     */
    override fun mousePressed(e: MouseEvent?) {
    }

    /**
     * Invoked when a mouse button has been released on a component.
     * @param e the event to be processed
     */
    override fun mouseReleased(e: MouseEvent?) {
    }

    /**
     * Invoked when the mouse enters a component.
     * @param e the event to be processed
     */
    override fun mouseEntered(e: MouseEvent?) {
    }

    /**
     * Invoked when the mouse exits a component.
     * @param e the event to be processed
     */
    override fun mouseExited(e: MouseEvent?) {
    }
}

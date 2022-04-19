package io.github.bloeckchengrafik.pathfinding

import java.awt.Graphics
import java.awt.Graphics2D
import java.awt.event.MouseEvent
import java.awt.event.MouseListener
import javax.swing.JPanel

class JSwingGridPane : JPanel(), MouseListener {
    lateinit var grid: Grid

    fun setGrid() {
        this.grid = Grid(this.width / 10, this.height / 10)
        this.repaint()
        this.addMouseListener(this)
    }

    override fun paint(g: Graphics) {
        val g2d = g as Graphics2D
        g2d.clearRect(0, 0, this.width, this.height)
        g2d.color = java.awt.Color.WHITE
        g2d.fillRect(0, 0, this.width, this.height)

        g2d.color = java.awt.Color.GRAY

        for (i in 0 until this.width) {
            if (i % 10 == 0) {
                for (j in 0 until this.height) {
                    if (j % 10 == 0) {
                        g2d.drawRect(i, j, 10, 10)
                        if (this.grid.grid[Math.floorDiv(i, 10)][Math.floorDiv(j, 10)]) {
                            g2d.fillRect(i, j, 10, 10)
                        }
                    }
                }
            }
        }

    }

    /**
     * Invoked when the mouse button has been clicked (pressed
     * and released) on a component.
     * @param e the event to be processed
     */
    override fun mouseClicked(e: MouseEvent?) {
        grid.toggle(e!!.x, e.y)
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
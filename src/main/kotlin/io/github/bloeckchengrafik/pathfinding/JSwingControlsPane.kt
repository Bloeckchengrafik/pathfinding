package io.github.bloeckchengrafik.pathfinding

import java.awt.Color
import java.awt.Graphics
import java.awt.Graphics2D
import javax.swing.JPanel

class JSwingControlsPane : JPanel() {
    override fun paint(g: Graphics) {
        val g2d = g as Graphics2D
        g2d.clearRect(0, 0, this.width, this.height)
        g2d.color = Color.white
        g2d.fillRect(0, 0, this.width, this.height)
    }
}
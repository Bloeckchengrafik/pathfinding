package io.github.bloeckchengrafik.pathfinding

import javax.swing.JPopupMenu

class JSwingStartPopup {
    fun open(callback: (PathfindingAlgorithms) -> Unit) {
        // Create a menu to select the algorithm from PathfindingAlgorithms
        val algoMenu = JPopupMenu()
        PathfindingAlgorithms.values().forEach {
            val item = algoMenu.add(it.name)
            val value = it
            item.addActionListener {
                callback(value)
                // Close the menu
                algoMenu.isVisible = false
            }
        }

        // Open the menu
        algoMenu.show(null, 0, 0)
    }

}

package io.github.bloeckchengrafik.pathfinding

class Grid(width: Int, height: Int) {
    val grid: Array<Array<Boolean>>
    private val width: Int
    private val height: Int

    init {
        this.width = width
        this.height = height
        grid = Array(width) { Array(height) { false } }
    }

    fun put(x: Int, y: Int, state: Boolean) {
        grid[Math.floorDiv(x, 10)][Math.floorDiv(y, 10)] = state
    }

    fun toggle(x: Int, y: Int) {
        grid[Math.floorDiv(x, 10)][Math.floorDiv(y, 10)] = !grid[Math.floorDiv(x, 10)][Math.floorDiv(y, 10)]
    }
}
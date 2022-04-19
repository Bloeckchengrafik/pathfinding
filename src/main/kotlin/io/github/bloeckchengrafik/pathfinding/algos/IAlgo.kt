package io.github.bloeckchengrafik.pathfinding.algos

import io.github.bloeckchengrafik.pathfinding.Grid

interface IAlgo {
    fun run(start: IntArray, end: IntArray, grid: Grid)
}
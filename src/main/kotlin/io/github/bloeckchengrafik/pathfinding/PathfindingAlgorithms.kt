package io.github.bloeckchengrafik.pathfinding

import io.github.bloeckchengrafik.pathfinding.algos.DirectLineAlgo
import io.github.bloeckchengrafik.pathfinding.algos.IAlgo
import kotlin.reflect.KClass
import kotlin.reflect.full.createInstance

enum class PathfindingAlgorithms(val cls: KClass<DirectLineAlgo>) {
    DirectLine(DirectLineAlgo::class);

    fun instance(): IAlgo {
        return cls.createInstance()
    }
}
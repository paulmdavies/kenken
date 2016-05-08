package com.paulmdavies.kenken

sealed trait Operation {
    def correct(target: Int, values: Seq[Int]): Boolean
}

object NoOperation extends Operation {
    override def correct(target: Int, values: Seq[Int]): Boolean = values.forall(_ == target)
}

object AdditionOperation extends Operation {
    override def correct(target: Int, values: Seq[Int]): Boolean = values.sum == target
}
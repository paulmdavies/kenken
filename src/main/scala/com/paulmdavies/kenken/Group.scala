package com.paulmdavies.kenken

object Group {
    def apply(square: Square, target: Int, operation: Operation): Group = {
        new Group(Seq(square), target, operation)
    }

    def apply(squares: Seq[Square], target: Int, operation: Operation): Group = {
        new Group(squares, target, operation)
    }
}

class Group(val squares: Seq[Square], val target: Int, val operation: Operation) {
    def complete: Boolean = squares.forall(_.complete)

    def correct: Boolean = complete && operation.correct(target, squares.map(_.value.get))
}
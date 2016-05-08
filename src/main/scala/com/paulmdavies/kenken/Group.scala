package com.paulmdavies.kenken

object Group {
    def apply(square: Square, target: Int): Group = {
        new Group(Seq(square), target)
    }

    def apply(squares: Seq[Square], target: Int): Group = {
        new Group(squares, target)
    }
}

class Group(squares: Seq[Square], target: Int) {
    def complete: Boolean = squares.forall(_.complete)

}
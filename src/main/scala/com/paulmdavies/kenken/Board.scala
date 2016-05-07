package com.paulmdavies.kenken

import scala.collection.mutable.SeqLike
import java.io.File

object Board {
    def load(file : File) : Board = {
        new Board(1, 1)
    }

    protected[kenken] val MAX = 6;
}

class Board protected[kenken](protected[kenken] val rows : Int, protected[kenken] val columns : Int) {

}
package com.paulmdavies.kenken

object Square {
    def apply(row: Int, column: Int): Square = {
        new Square(row, column, None)
    }

    def apply(row: Int, column: Int, value: Int): Square = {
        new Square(row, column, Some(value))
    }
}

class Square protected[kenken](
    protected[kenken] val row: Int,
    protected[kenken] val column: Int,
    protected[kenken] var value: Option[Int]
) {
    def complete: Boolean = value != None

    def set(newValue: Int): Unit = value = Some(newValue)
}
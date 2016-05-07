package com.paulmdavies.kenken

object Square {
    def apply(row : Int, column : Int): Square = {
        new Square(row, column, None)
    }
}

case class Square protected [kenken] ( protected [kenken] val row : Int, protected [kenken] val column : Int, protected [kenken] val value : Option[Int] ) 
{

}
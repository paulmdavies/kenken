package com.paulmdavies.kenken

sealed trait Operation
{
    protected [kenken] val minimumSquares : Int
    protected [kenken] val maximumSquares : Option[Int]
    
	final def result( values : Seq[Int] ) : Int =
	{
        checkSquares( values )
        resultImpl( values )
	}
    
    protected [kenken] def resultImpl( values : Seq[Int] ) : Int
	
	final def checkSquares( values : Seq[Int] ) = assert( values.size >= minimumSquares && ( values.size <= maximumSquares.getOrElse( values.size ) ) )
}

class NoOperation extends Operation
{
    protected [kenken] val minimumSquares = 1
    protected [kenken] val maximumSquares = Some( 1 )
    
    protected [kenken] def resultImpl( values : Seq[Int] ) : Int = values.head
}

class AdditionOperation extends Operation
{
    protected [kenken] val minimumSquares = 2
    protected [kenken] val maximumSquares = None
    
    protected [kenken] def resultImpl( values : Seq[Int] ) : Int = values.sum
}
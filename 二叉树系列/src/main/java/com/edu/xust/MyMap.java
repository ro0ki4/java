package com.edu.xust;

public class MyMap {
    public char[] line;
    public Node[][] arcs;
    public int dotNumber;
    public int pageNumber;
    public MyMap(){}
    public MyMap(char[] line,Node[][] arcs,int lineNumber,int colnumNumber){
        this.line=line;
        this.arcs=arcs;
        this.dotNumber=lineNumber;
        this.pageNumber=colnumNumber;
    }

}


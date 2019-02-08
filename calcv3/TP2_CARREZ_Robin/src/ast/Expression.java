package ast;

import check.State;

import java.io.IOException;

public abstract class Expression extends AST {

    public abstract int eval(State<Integer> s) throws IOException;

}

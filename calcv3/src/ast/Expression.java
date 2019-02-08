package ast;

import check.State;

import java.io.IOException;

public abstract class Expression extends AST {

    public abstract Type check(State<Type> s) throws IOException;

}

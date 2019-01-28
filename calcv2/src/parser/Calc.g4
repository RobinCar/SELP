grammar Calc;

// syntactic rules

program  : funcDef* body
         ;
funcDef  : '(' 'defun' head body ')'
         ;
head     : '(' functionId variableId* ')'
         ;
body     : varDef* expression
         ;
varDef   : '(' '=' variableId expression ')'
         ;
expression : LITERAL                                            #Literal
           | variableId                                         #Variable
           | '(' '-' expression tail                            #UnaryMinus
           | '(' OP expression expression ')'                   #BinaryExpression
           | '(' 'if' expression expression expression ')'      #ConditionalExpression
           | '(' functionId expression* ')'                     #FunctionCall
           ;
tail       : ')'
           | expression ')'
           ;
variableId : IDENTIFIER
           ;
functionId : IDENTIFIER
           ;

// lexical rules

OP       : '+' | '-' | '*' | '/' | '==' | '<'
         ;
IDENTIFIER : ('a'..'z')('a'..'z' | '0'..'9')*
         ;
LITERAL  : '0' | ('1'..'9')('0'..'9')*              
         ;
WS : [ \t\n\r]+ -> channel(HIDDEN) ;
LINE_COMMENT : '//' ~'\n'* '\n' -> channel(HIDDEN) ;
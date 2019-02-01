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
expression : LITERAL                                                        #Literal
           | BOOLEAN                                                        #BooleanLiteral
           | '(' expression ')'                                             #ParenExpression
           | (MINUS | NOT) expression                                       #UnaryExpression
           | expression MULTIPLICATIVE expression                           #BinaryExpression
           | expression ADDITIVE expression                                 #BinaryExpression
           | expression RELATIONAL expression                               #BinaryExpression
           | expression EQUALITY expression                                 #BinaryExpression
           | expression AND expression                                      #BinaryExpression
           | expression OR expression                                       #BinaryExpression
           | variableId                                                     #Variable
           | <assoc = right> expression '?' expression ':' expression       #ConditionalExpression
           //| 'if' expression expression expression                          #ConditionalExpression
           | functionId expression*                                         #FunctionCall
           ;
variableId : IDENTIFIER
           ;
functionId : IDENTIFIER
           ;

// lexical rules

BOOLEAN  : 'true'
         | 'false'
         ;
MULTIPLICATIVE : '*' | '/';
ADDITIVE : '+' | '-';
RELATIONAL : '<' | '>' | '<=' | '>=';
EQUALITY : '==' | '!=';
AND : '&&';
OR : '||';
MINUS    : '-'
         ;
NOT      : '!'
         ;
OP       : '+' | '*' | '/' | '==' | '<' | '>' | '<=' | '>=' | '!=' | '&&' | '||'
         ;
IDENTIFIER : ('a'..'z')('a'..'z' | '0'..'9')*
         ;
LITERAL  : '0' | ('1'..'9')('0'..'9')*              
         ;
WS : [ \t\n\r]+ -> channel(HIDDEN) ;
LINE_COMMENT : '//' ~'\n'* '\n' -> channel(HIDDEN) ;
package ast;

import parser.SyntaxError;

import java.io.IOException;

public enum Op {
    PLUS {
        public String toString() {
            return "PLUS";
        }
    },

    MINUS {
        public String toString() {
            return "MINUS";
        }
    },

    TIMES {
        public String toString() {
            return "TIMES";
        }
    },

    DIVIDE {
        public String toString() {
            return "DIVIDE";
        }
    },

    EQUAL {
        public String toString() {
            return "EQUAL";
        }
    },

    LESS {
        public String toString() {
            return "LESS";
        }
    },

    MORE {
        public String toString() { return "MORE"; }
    },

    MOREOREQUAL {
        public String toString() {
            return "MOREOREQUAL";
        }
    },

    LESSOREQUAL {
        public String toString() {
            return "LESSOREQUAL";
        }
    },

    NOTEQUAL {
        public String toString() {
            return "NOTEQUAL";
        }
    },

    AND {
        public String toString() {
            return "AND";
        }
    },

    OR {
        public String toString() {
            return "OR";
        }
    },

    NOT {
        public String toString() { return "NOT"; }
    };

    public static Op parseOp(String op) throws IOException {
        switch (op) {
            case "+" : return Op.PLUS;
            case "-" : return Op.MINUS;
            case "*" : return Op.TIMES;
            case "/" : return Op.DIVIDE;
            case "==" : return Op.EQUAL;
            case ">" : return Op.MORE;
            case "<" : return Op.LESS;
            case "<=" : return Op.LESSOREQUAL;
            case ">=" : return Op.MOREOREQUAL;
            case "&&" : return Op.AND;
            case "||" : return Op.OR;
            case "!" : return Op.NOT;
            case "!=" : return Op.NOTEQUAL;
            default : throw  new SyntaxError("Can't find Symbol");
        }
    }

    public static String gen(Op op) {
        switch (op) {
            case MINUS : return "-";
            case PLUS : return "+";
            case TIMES : return "*";
            case DIVIDE : return "/";
            case EQUAL : return "==";
            case MORE : return ">";
            case LESS : return "<";
            case LESSOREQUAL: return "<=";
            case MOREOREQUAL: return ">=";
            case AND : return "&&";
            case OR : return "||";
            case NOT : return "!";
            case NOTEQUAL: return "!=";
            default : throw  new SyntaxError("Can't find Symbol");
        }
    }
}

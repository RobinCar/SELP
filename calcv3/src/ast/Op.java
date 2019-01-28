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
    };

    public static Op parseOp(String op) throws IOException {
        switch (op) {
            case "+" : return Op.PLUS;
            case "-" : return Op.MINUS;
            case "*" : return Op.TIMES;
            case "/" : return Op.DIVIDE;
            case "==" : return Op.EQUAL;
            case "<" : return Op.LESS;
            default : throw  new SyntaxError("Can't find Symbol");
        }
    }
}

package lexer;

public enum Op implements Token {
    PLUS {
        @Override
        public String toString() {
            return "PLUS";
        }
    },

    MINUS {
        @Override
        public String toString() {
            return "MINUS";
        }
    },

    TIMES {
        @Override
        public String toString() {
            return "TIMES";
        }
    },

    DIVIDE {
        @Override
        public String toString() {
            return "DIVIDE";
        }
    },

    EQUAL {
        @Override
        public String toString() {
            return "EQUAL";
        }
    },

    LESS {
        @Override
        public String toString() {
            return "LESS";
        }
    }
}

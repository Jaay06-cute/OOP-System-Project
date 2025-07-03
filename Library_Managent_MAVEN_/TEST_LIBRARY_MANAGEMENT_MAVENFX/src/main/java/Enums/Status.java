
package Enums;


public enum Status {
        AVAILABLE,
        BORROWED;
        
        public static String CheckStatus(boolean value) {
             return value ? Status.BORROWED.name() : Status.AVAILABLE.name();
        }
}

package com.amp.work;

public class utils {
    public static boolean isArgumentsValid(String[] args){
        if(args.length!=3){
            return false;
        }
        if(args[0] == null || args[1] == null || args[2]==null){
            return false;
        }

        if(args[0].isEmpty() || args[1].isEmpty() || args[2].isEmpty()){
            return false;
        }

        return true;
    }
}

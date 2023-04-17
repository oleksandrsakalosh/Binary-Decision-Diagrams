import java.util.ArrayList;

public class BDD {
    private Node root;

    public BDD BDD_create(String bFunction, String order) {
        return null;
    }

    public BDD BDD_create_with_best_order (String bFunction){
        return null;
    }

    public char BDD_use (BDD bdd, String entries){
        return ' ';
    }

    private String[] decompose(String input, String operand){
        String[] parts = input.split("\\+", 0);

        ArrayList<String> left = new ArrayList<>();
        ArrayList<String> right = new ArrayList<>();

        ArrayList<String> negatedOp = new ArrayList<>();
        ArrayList<String> nativeOp = new ArrayList<>();
        ArrayList<String> missOp = new ArrayList<>();

        String[] result = {null, null};

        for(String a : parts){
            if(a.contains(operand)){
                int idx = a.indexOf(operand);
                if(idx != 0 && a.charAt(idx - 1) == '!')
                    negatedOp.add(a);
                else
                    nativeOp.add(a);
            }
            else {
                missOp.add(a);
            }
        }

        for(String a : missOp){
            left.add(a);
            right.add(a);
        }

        for(String a : negatedOp){
            if(a.length() > 2){
                //add (a) with cutted off operand to the left
                int idx = a.indexOf(operand);
                left.add(a.substring(0, idx - 1) + a.substring(idx + 1));
            }
            else{
                left.add("1");
            }
        }

        for(String a : nativeOp){
            if(a.length() > 1){
                //add (a) with cutted off operand to the right
                int idx = a.indexOf(operand);
                right.add(a.substring(0, idx) + a.substring(idx + 1));
            }
            else{
                right.add("1");
            }
        }

        if(left.size() == 0)
            left.add("0");
        if(right.size() == 0)
            right.add("0");

        ArrayList<String> removedDuplicatesLeft = new ArrayList<>();
        for(String el : left) {
            if (!removedDuplicatesLeft.contains(el))
                removedDuplicatesLeft.add(el);
        }

        ArrayList<String> removedDuplicatesRight = new ArrayList<>();
        for(String el : right) {
            if (!removedDuplicatesRight.contains(el))
                removedDuplicatesRight.add(el);
        }

        if(left.contains("1")) {
            left.clear();
            left.add("1");
        }
        if(left.contains("0")) {
            left.clear();
            left.add("0");
        }

        if(right.contains("1")) {
            right.clear();
            right.add("1");
        }
        if(right.contains("0")) {
            right.clear();
            right.add("0");
        }

        result[0] = String.join("+", left);
        result[1] = String.join("+", right);

        return result;
    }
}

package Tree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;

public class Tree<X extends Comparable<X>> {
    private TreeElement root;
    public LinkedHashMap<Integer, ArrayList<X>> treeMap;

    Tree() {
        this.root = null;
        this.treeMap = new LinkedHashMap<>();
    }

    public TreeElement getRoot() {
        return root;
    }

    public <T extends Comparable<T>> void add(T nE){

        TreeElement newElement = new TreeElement(nE);
        // Если 1 элемент
        if(root == null) {
            root = newElement;
            treeMap.put(1, new ArrayList<>());
            treeMap.get(1).add((X) newElement.getValue());
            treeMap.put(2, new ArrayList<>());
        }

        // Если более 1 элемента
        else {
            TreeElement temp = root;
            int lvl = 3;
            while (temp.getLeft() != null || temp.getRight() != null) {
                if(newElement.getValue().compareTo(temp.getValue()) == -1 && temp.getLeft() == null) break;
                if(newElement.getValue().compareTo(temp.getValue()) != -1 && temp.getRight() == null) break;

                if(treeMap.get(lvl) == null) treeMap.put(lvl, new ArrayList<>());

                if (newElement.getValue().compareTo(temp.getValue()) == -1) {
                    temp = temp.getLeft();
                    lvl++;
                }
                else if (newElement.getValue().compareTo(temp.getValue()) != -1) {
                    temp = temp.getRight();
                    lvl++;
                }
            }

            lvl--;
            if(newElement.getValue().compareTo(temp.getValue()) == 1) {
                temp.setRight(newElement);
            }
            else {
                temp.setLeft(newElement);
            }

            treeMap.get(lvl).add((X) newElement.getValue());

        }

    }
    public <T extends Comparable<T>> boolean contains(T n){
        TreeElement<T> temp = root;

        while(temp.getLeft() != null || temp.getRight() != null) {
            if((temp.getValue().compareTo(n) == 1 && temp.getLeft() == null) ||
                    (temp.getValue().compareTo(n) == -1 && temp.getRight() == null)) return false;

            if(temp.getValue().compareTo(n) == 1) temp = temp.getLeft();
            else if(temp.getValue().compareTo(n) == -1) temp = temp.getRight();

            if(temp.getValue().compareTo(n) == 0) return true;
        }
        return false;
    }

//    public void writeTree(){
//        sortLists();
//
//        int lvl = 1;
//        int countOfSpaces = (int)Math.pow(2,treeMap.size());
//        while(treeMap.get(lvl) != null) {
//            for(int i = 0; i < (int)Math.pow(2,lvl-1); i++) { // treeMap.get(lvl).size()a
//                for(int j = 0; j < countOfSpaces; j++) System.out.print(" ");
//                if(i < treeMap.get(lvl).size()) System.out.print(treeMap.get(lvl).get(i));
//            }
//            System.out.println();
//            System.out.println();
//            lvl++;
//            countOfSpaces /= 1.5;
//        }
//    }

    private void sortLists(){
        for(int i = 1; i < treeMap.size(); i++) {
            Collections.sort(treeMap.get(i));
        }
    }

}
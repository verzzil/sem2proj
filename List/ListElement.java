public class ListElement {
    private int value;
    private ListElement next;
    ListElement(int value){
        this.value=value;
    }
    public int getValue(){
        return value;
    }
    public ListElement getNext(){
        return next;
    }
    public void setNext(ListElement listElement){
        next=listElement;
    }
}
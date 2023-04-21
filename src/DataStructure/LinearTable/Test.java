package DataStructure.LinearTable;

public class Test {
    public static void main(String[] args) {
        SequenceList<String> sequenceList = new SequenceList<>(10);
        sequenceList.insert("a");
        sequenceList.insert("b");
        sequenceList.insert("c");
        sequenceList.insert(1, "d");
//        for (String s : sequenceList) {
//            System.out.println(s);
//        }
        System.out.println(sequenceList.indexOf("d"));

        LinkList<String> linkList = new LinkList<>();
        linkList.insert("a");
        linkList.insert("b");
        linkList.insert("c");
        linkList.insert(1, "d");
        linkList.insert(4, "e");  // 插入大于当前元素个数的位置，会报错
//        for (String s : linkList) {
//            System.out.println(s);
//        }
        System.out.println(linkList.indexOf("d"));
        System.out.println("-----------------------------------------");
        DoubleLinkList<String> doubleLinkList = new DoubleLinkList<>();
        doubleLinkList.insert("a");
        doubleLinkList.insert("b");
        doubleLinkList.insert("c");
        doubleLinkList.insert("d");
        doubleLinkList.insert(1, "e");
        doubleLinkList.insert( 5, "f");
        doubleLinkList.insert(0, "g");
        doubleLinkList.insert(7, "h");
//        doubleLinkList.insert(9, "i"); // 插入大于当前元素个数的位置，会报错
        doubleLinkList.remove(7);
        System.out.println("Remove:" + doubleLinkList.remove(0));
//        System.out.println(doubleLinkList.indexOf("d"));
//        System.out.println(doubleLinkList.remove(0));
        for (String s : doubleLinkList) {
            System.out.println(s);
        }
    }
}

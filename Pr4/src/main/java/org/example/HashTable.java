package org.example;
/*
Реализовать класс работающий по принципу HashMap. Включая внутренний массив узлов с индексацией по хешу и описание узла.
Добавить в класс методы:
    Object put(Integer key , Integer value) добавить элемент
    Object get(Integer key) получить значение соответствующее ключу
    Object remove(Integer key) удалить элемент с соответствующем ключём
    Object replays(Integer key, Integer v) заменить значение
    int size() количество элементов
    boolean containsKey(Integer key) проверка наличия ключа
    boolean containsValue(Integer v) проверка наличия значения
*/
public class HashTable {
    private Node[] arr = new Node[16];
    private int count = 0;

    public Object put(Integer key , Integer value){
        Node temp = new Node();
        temp.value = value;
        temp.key = key;
        temp.hash = temp.key.hashCode() % 16;
        if (arr[temp.hash] != null){
            Node tempNode = arr[temp.hash];
            while (tempNode != null){
                if (tempNode.key == key)
                    return tempNode.value;
                tempNode = tempNode.next;
            }
            temp.next = arr[temp.hash];
        }
        arr[temp.hash] = temp;
        count++;
        return null;
    }

    public Object get(Integer key){
        int index = key.hashCode() % 16;
        if (arr[index] != null) {
            Node tempNode = arr[index];
            while (tempNode != null) {
                if (tempNode.key == key)
                    return tempNode.value;
                tempNode = tempNode.next;
            }
        }
        return null;
    }

    public Object remove(Integer key){
        int index = key.hashCode() % 16;
        if (arr[index] != null) {
            Node tempNode = arr[index];
            if (tempNode.key == key && tempNode.next == null){
                arr[index] = null;
                count--;
                return tempNode.value;
            }
            if (tempNode.key == key && tempNode.next != null){
                arr[index] = tempNode.next;
                count--;
                return tempNode.value;
            }
            while (tempNode.next != null){
                if (tempNode.next.key == key){
                    Integer tmp = tempNode.next.value;
                    tempNode.next = tempNode.next.next;
                    count--;
                    return tmp;
                }
                tempNode = tempNode.next;
            }
        }
        return null;
    }

    public Object replays(Integer key, Integer v){
        int index = key.hashCode() % 16;
        if (arr[index] != null) {
            Node tempNode = arr[index];
            while (tempNode != null) {
                if (tempNode.key == key) {
                    Integer x = tempNode.value;
                    tempNode.value = v;
                    return x;
                }
                tempNode = tempNode.next;
            }
        }
        return null;
    }

    public int size(){
        return count;
    }

    public boolean containsKey(Integer key){
        int index = key.hashCode() % 16;
        if (arr[index] != null) {
            Node tempNode = arr[index];
            while (tempNode != null) {
                if (tempNode.key == key)
                    return true;
                tempNode = tempNode.next;
            }
        }
        return false;
    }

    public boolean containsValue(Integer v){
        for (Node current: arr) {
            if (current != null){
                Node temp = current;
                while (temp != null) {
                    if (temp.value == v) {
                        return true;
                    }
                    temp = temp.next;
                }
            }
        }
        return false;
    }

    public String print(){
        int ind = 0;
        String result = "";
        for (Node current: arr) {
            if (current != null){
                result += ind + ":\n";
                Node temp = current;
                while (temp != null) {
                    result += "\t" + temp.key + "  " + temp.value + "\n";
                    temp = temp.next;
                }
            }
            ind++;
        }
        return result;
    }
}

class Node{
    Integer value, key;
    int hash;
    Node next;
}

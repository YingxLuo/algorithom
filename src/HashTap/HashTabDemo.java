package HashTap;

import java.util.Scanner;

public class HashTabDemo {
    public static void main(String[] args) {
        HashTable hashTable = new HashTable(7);

        String key = "";
        int id;
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("add： 添加雇员");
            System.out.println("list：显示雇员");
            System.out.println("find：查找雇员");
            System.out.println("delete：删除雇员");
//            System.out.println("");
            System.out.println("exit：退出系统");

            key = scanner.next();
            switch (key){
                case "add" :
                    System.out.println("输入雇员编号：");
                    id = scanner.nextInt();
                    System.out.println("请输入雇员名字：");
                    key = scanner.next();
                    hashTable.add(new Emp(id,key));
                    break;
                case "list":
                    hashTable.list();
                    break;
                case "find":
                    System.out.println("输入查找的雇员编号：");
                    id = scanner.nextInt();
                    hashTable.find(id);
                    break;
                case "delete":
                    System.out.println("输入删除的雇员编号：");
                    id = scanner.nextInt();
                    hashTable.delete(id);
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);
                    break;
            }
        }
    }
}

class HashTable{

    int size;
    EmpLinkedList[] empLinkedLists;

    public HashTable(int size) {
        this.size = size;
        empLinkedLists = new EmpLinkedList[size];
        //注意这里对列表里每一个对象都要进行初始化，不然就是null
        for(int i =0; i < size ; i++){
            empLinkedLists[i] = new EmpLinkedList();
        }
    }


    /**
     *
     * @param emp
     */
    public void add(Emp emp){
        int no = find_Link(emp.id);
        empLinkedLists[no].add(emp);
    }

    public void list(){
        int no = 0;
        for (EmpLinkedList ell:empLinkedLists
             ) {
            no++;
            ell.list(no);
        }
    }
    public void find(int id){
        int no = find_Link(id);
        Emp emp = empLinkedLists[no].find(id);

        if (emp != null){
            System.out.println("找到了该雇员");
            System.out.println(emp.id + " ,"+ emp.name);
        }
    }

    public void delete(int id){
        int no = find_Link(id);
        if (empLinkedLists[no].delete(id)){
            System.out.println("删除成功");
        }

    }

    /**
     * 计算添加的员工应该加到哪一条链表，简单取模
     * @param id
     * @return empLinkedLists下标
     */
    public int find_Link(int id){
        int i = id % size;
        return i;
    }
}
class EmpLinkedList {
    private Emp head = null;

    /**
     * 链表添加
     * @param emp
     */
    public void add(Emp emp) {
        if (head == null) {
            head = emp;
            return;
        }

        //不是第一个雇员，参考单向链表添加方法
        Emp curemp = head;
        while (true) {
            if (curemp.next == null) {
                break;
            }
            curemp = curemp.next;
        }
        curemp.next = emp;
    }

    /**
     * 链表展示
     */
    public void list(int no){
        if (head == null){
            System.out.println("第"+no+"链表为空");
            return;
        }
        System.out.print("第"+no+"链表信息为：");
        Emp curemp = head;
        while (true){
            System.out.print(curemp.id+"  ,"+curemp.name+"\t");
            if (curemp.next == null){
                break;
            }
            curemp = curemp.next;
        }
        System.out.println();
    }

    public Emp find(int id){
        if (head == null){
            System.out.println("当前链表为空");
            return null;
        }

        Emp curemp = head;
        while(true){
            if (curemp.id == id){
                return curemp;
            }
            if (curemp.next == null){
                System.out.println("没有该员工");
                return null;
            }

            curemp = curemp.next;


        }
    }
    public boolean delete(int id){
        if (head == null){
            System.out.println("该雇员不存在，无法删除");
            return false;
        }

        Emp curemp = head;
        while(true){
            if(curemp.next.next != null){ //判断是不是倒数第二个，因为倒数第二个没有.next.next
                if (curemp.next.id == id){ //找到了，删除
                    curemp.next = curemp.next.next;
                    return true;
                }
            }else if(curemp.next.id == id){//走到倒数第二个了，只需检查最后一个是否满足条件，满足直接删除即可
                curemp.next = null;
                return true;
            }


            if(curemp.next == null){
                System.out.println("该雇员不存在，无法删除");
                return false;
            }
            curemp = curemp.next;
        }
    }
}

class Emp {
    public int id;
    public String name;
    public Emp next = null;

    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
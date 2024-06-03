/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package linkedlist;

/**
 *
 * @author ADMIN
 */
public class LinkedList {

private Node head;
    // kiem tra neu danh sach rong
    boolean isEmpty(){
        return (head == null);
    }
    
    //khoi tao danh sach lien ket
    public LinkedList() {
        head = null;
    }

    // Thêm phần tử vào cuối danh sách
    public void add(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            head = newNode;
            //add neu dau null 
            //-> node mới được add = node đầu tiên
        } else {
            Node current = head;
            //node đầu tiên đã có - > 
            while (current.next != null) {
                //chuyển tiếp cho đến khi tìm được node rỗng
                current = current.next;
            }
            //khởi tạo node mới
            current.next = newNode;
        }
    }

    // Xóa phần tử đầu tiên trong danh sách
    public void removeFirst() {
        
        if (!isEmpty()) {
            head = head.next;
            //node đầu tiên trở thành node tiếp theo
            //và đẩy tiếp,nội dung sau ghi đè lên nội dung trước
        } else {
            // null
            System.out.println("danh sach null");
        }
    }

    // In các phần tử trong danh sách
    /*public void printList() {
        Node current = head;
        //current để duyệt danh sách
        while (current != null) {
            System.out.print(current.data + ", ");
            current = current.next;
            //sau khi print chuyển sang cur tiếp theo
        }
        System.out.println("null");
        //cuối danh sách ghi null
    }*/
    public void printList(){
        //node cur đầu danh sách
        //cur không phải là null
        //cur chuyển đến node tiếp theo
        for (Node cur = head; cur != null; cur = cur.next)
            if(cur.next != null){
                System.out.print(cur.data + ", ");
            }else {
                System.out.print(cur.data);
            }
        System.out.println();
    }
    
      // Xóa phần tử có giá trị data
    public void remove(int data) {
        if (isEmpty()) {
            //danh sách rỗng
            System.out.println("Danh sách rỗng.");
            return;
        }

        // Nếu phần tử cần xóa là phần tử đầu tiên
        if (head.data == data) {
            head = head.next;
            //head trỏ đến node tiếp theo 
            //(loại bỏ node đầu tiên)
            return;
        }

        Node current = head;
        Node previous = null; // lưu trữ node trước node hiện tại
        // Vòng lặp để tìm node có giá trị data 
        //hoặc đến cuối danh sách
        while (current != null && current.data != data) {
            previous = current; //Lưu trữ node trước node hiện tại
            current = current.next;
            //chuyển sang node tiếp theo
        }

        // Nếu không tìm thấy phần tử có giá trị data
        if (current == null) {
            System.out.println("Không tìm thấy phần tử có giá trị: " + data);
            return;
        }

        // Bỏ qua phần tử có giá trị data
        previous.next = current.next;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        // Thêm các phần tử vào danh sách
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(21);
        // In danh sách
        System.out.println("Danh sách sau khi thêm các phần tử:");
        list.printList();

        // Xóa phần tử đầu tiên
        
        
        //xóa phần tử đầu tiên (thứ 2)
        //sau khi phần tử đầu tiên bị xóa
        list.remove(20);
        System.out.println("Danh sách sau khi xóa phần tử đầu tiên:");
        list.printList();
    }
}

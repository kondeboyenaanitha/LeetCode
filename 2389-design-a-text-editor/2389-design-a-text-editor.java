class TextEditor {

    class Node {
        char chr;
        Node next, prev;
        Node(char _chr, Node _next, Node _prev) {
            this.chr = _chr;
            this.next = _next;
            this.prev = _prev;
        }
    }
    Node fakeHead, fakeTail, cursor;

    public TextEditor() {
        this.fakeHead = new Node('1', null, null);
        this.fakeTail = new Node('9', null, null);

        this.fakeHead.next = this.fakeTail;
        this.fakeTail.prev = this.fakeHead;

        this.cursor = this.fakeHead;
    }
    
    public void addText(String text) {
        for(char c : text.toCharArray()) {
            Node node = new Node(c, cursor.next, cursor);
            cursor.next.prev = node;
            cursor.next = node;
            cursor = node;
        }
    }
    
    public int deleteText(int k) {
        int x = k;
        while(x > 0 && cursor != fakeHead) {
            cursor.prev.next = cursor.next;
            cursor.next.prev = cursor.prev;
            cursor = cursor.prev;
            x--;
        }
        return k-x;
    }
    
    public String cursorLeft(int k) {
        while(k > 0 && cursor != fakeHead) {
            cursor = cursor.prev;
            k--;
        }
        return printLeftString(cursor);
    }
    
    public String cursorRight(int k) {
        while(k > 0 && cursor != fakeTail) {
            cursor = cursor.next;
            k--;
        }
        if(cursor == fakeTail) {
            cursor = fakeTail.prev;
        }
        return printLeftString(cursor);
    }

    private String printLeftString(Node temp) {
        int i = 0;
        StringBuffer sb = new StringBuffer();

        while(i < 10 && temp != fakeHead) {
            sb.append(Character.toString(temp.chr));
            temp = temp.prev;
            i++;
        }
        return sb.reverse().toString();
    }
}

/**
 * Your TextEditor object will be instantiated and called as such:
 * TextEditor obj = new TextEditor();
 * obj.addText(text);
 * int param_2 = obj.deleteText(k);
 * String param_3 = obj.cursorLeft(k);
 * String param_4 = obj.cursorRight(k);
 */
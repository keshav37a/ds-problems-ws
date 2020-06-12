public class RC0009_Tower_Of_Hanoi {
    public static void main(String[] args) {
        towerOfHanoi(2, 'a', 'b', 'c');
    }
    public static void towerOfHanoi(int disks, char src, char aux, char dest){
        if(disks==0)
            return;

        towerOfHanoi(disks-1, src, dest, aux);
        System.out.println("Move disk " + disks + " from " + src+" to " + dest);
        towerOfHanoi(disks-1, aux, src, dest);
    }
}
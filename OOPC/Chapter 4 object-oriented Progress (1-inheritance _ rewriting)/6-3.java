/*
 * @Description: 
 * @Author: hz157
 * @Date: 2021-10-21 20:44:33
 * @LastEditTime: 2021-10-21 20:44:33
 * @LastEditors: hz157
 */
class ComputerPlayer extends Player{
    public ComputerPlayer(String name){
        super(name);
    }
}

class PersonPlayer extends Player{
    public PersonPlayer(String name){
        super(name);
    }
}

class Game{
    ComputerPlayer ctp;
    PersonPlayer psp;
    public Game(ComputerPlayer a,PersonPlayer b){
        this.ctp = a;
        this.psp = b;
    }
    public void start() {
        int Person, Computer;
        Computer = ctp.show();
        Scanner sc = new Scanner(System.in);
        Person = sc.nextInt();
        if(Person==1&&Computer==2 || Person==2&&Computer==3 || Person==3&&Computer==1){
            System.out.println("Winner is computerPlayer.");
        }else if(Person==2&&Computer==1 || Person==3&&Computer==2 || Person==1&&Computer==3){
            System.out.println("Winner is personPlayer.");
        }else if(Person == Computer){
            System.out.println("A Draw.");
        }
    }
}
import java.io.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

class login{
    Scanner Sc=new Scanner(System.in);
    int c,age;
    boolean found=false;
    String name,bra;
    String NAMEFILE="Name_database.txt";
    String AGEFILE="Age_database.txt";
    /////////Pehle iski jarurat thi phir mene txt files me hi saara control de diya jab se iska patta saap /////////
//    ArrayList<String> nameStore=new ArrayList<>(5);
//    ArrayList<Integer> AgeStore=new ArrayList<>(5);
//    public void verification(){
//        nameStore.add(0,"Ajay");
//        nameStore.add(1,"Anmol");
//        nameStore.add(2,"Deepak");
//        nameStore.add(3,"Bhavishya");
//        AgeStore.add(0,21);
//        AgeStore.add(1,19);
//        AgeStore.add(2,19);
//        AgeStore.add(3,18);
//    }

    public void check(int c) throws IOException {
        this.c=c;
        switch (c){
            case 1:
                System.out.print("Enter name-");
                name=Sc.next();
                System.out.print("Enter age-");
                age=Sc.nextInt();
                //Reading Data to matching from user
                try {
                    //Pehle filereader use kara tha , par wo ek sath READ kar raha tha
                    //Phir research kara to pta chala bufferedreader ke bare me , ye line by line read karega ......
                    BufferedReader namedata=new BufferedReader(new FileReader(NAMEFILE) );
                    BufferedReader agedata=new BufferedReader(new FileReader(AGEFILE));
                    String nameLine,ageLine;
                    boolean NAMEmatch=false,AGEmatch=false;
                    while ((nameLine=namedata.readLine()) != null){
                        if (nameLine.trim().equalsIgnoreCase(name)){
                            NAMEmatch=true;
                            //isse islia comment out liya jisse jab tak age sahi na ho jab tak program run na ho...
//                            found=true;
                            break;
                        }
                    }
                    while ((ageLine=agedata.readLine()) != null){
                        if (Integer.parseInt(ageLine.trim()) == age){
                            AGEmatch=true;
                            found=true;
                            break;
                        }
                    }
                    if (NAMEmatch && AGEmatch){
                        System.out.println("Thank You for login back " + name + " , Welcome (●'◡'●)");
                        System.out.println();
                    }

                    //I write this because of bug , if i dont write this then my code will login in if i write wrong name but correct age . So i dont want this...
                    if(NAMEmatch==false && AGEmatch){
                        System.out.println("You have enter a wrong username and age , Either fill correctly or make new account!!!");
                        System.exit(0);
                    }
                    namedata.close();
                    agedata.close();
                }
                catch (Exception e){
                    System.out.println("Sorry ANMOL BOSS, technical error occured");
                }
                if (found==false){
                    System.out.println("You have enter a wrong username and age , Either fill correctly or make new account!!!");
                    System.exit(0);
                }
                break;
            case 2:
                System.out.print("Enter name-");
                name=Sc.next();
                //saving data from USER input
                try {
                    FileWriter namewriter = new FileWriter(NAMEFILE,true);
                    namewriter.write("\n"+name);
                    namewriter.close();
                }
                catch (IOException e){
                    System.out.println("Unable to save data");
                }
                System.out.print("Enter age-");
                age=Sc.nextInt();
                //saving data from USER input
                try {
                    FileWriter ageWriter = new FileWriter(AGEFILE,true);
                    ageWriter.write("\n"+age);
                    ageWriter.close();
                }
                catch (IOException e){
                    System.out.println("Unable to save data");
                }
                System.out.print("Enter Branch-");
                bra=Sc.next();
                System.out.println("Hello "+name+" , this is a library!!!");
                System.out.println();
                break;
            default:
                System.out.println("I know you have chull , but please enter option mentioned above!!!!");
                System.exit(0);
        }
    }
}
class library extends login{
    int c;
    Scanner sca=new Scanner(System.in);
    String nm;
    boolean found=false;
    ArrayList<String> books=new ArrayList<>(15);
    public void func(){
        books.add(0,"DSA");
        books.add(1,"DE");
        books.add(2,"DBMS");
        books.add(3,"SE");
        books.add(4,"Linux");
        books.add(5,"TOC");
        books.add(6,"AEM");
        books.add(7,"Compiler");
        books.add(8,"OS");
    }
    public void showBooks(){
        System.out.println("Books Available Here Are:-");
        for (int i=0;i<books.size();i++){
            System.out.println((i+1) +". "+ books.get(i));
        }
        System.out.println();
    }
    public void func2(int c)
    {
        this.c=c;
        switch (c){
            case 1:
                System.out.print("Enter name of book you want-");
                nm=sca.next();
                for (int j=0;j<10;j++) {
                    try {
                        if (books.get(j).equalsIgnoreCase(nm)) {
                            found = true;
                            System.out.println("Book Found.....Issuing in progress....");
                            System.out.println(books.get(j) + " Book Issued successfully , remember to return in 15 days.");
                            System.out.println();
                            books.remove(j);
                            break;
                        }
                    }
                    catch (Exception e){
                        //Just to make sure that any exception doesn't occur
                    }
                }
                if (found==false){
                    System.out.println("Sorry,Book you are looking for is not available...");
                    System.out.println();
                }
                showBooks();
                break;
            case 2:
                System.out.println("Enter the name of book-");
                nm=sca.next();
                books.add(nm);
                System.out.println("Thank you returning book in time!!!");
                System.out.println();
                showBooks();
                break;
            case 3:
                System.out.println("Now you have to submit the fine of 10000000000 rs at college office !!");
                System.out.println();
                break;
            case 4:
                System.exit(0);
            default:
                System.out.println("I know you have chull , but please enter option mentioned above!!!!");
                System.out.println();
        }
    }

}
public class Main {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int ch1,ch2;
        String tem1;

        System.out.println("*************************************************WELCOME IN ADVANCED LIBRARY MANAGEMENT SYSTEM*************************************************");
        System.out.println("Login Menu !!!");
        System.out.println("Press 1 for Sign In (If you register previously)");
        System.out.println("Press 2 for Sign Up (If you are new user)");
        ch1= s.nextInt();
        login user=new login();
    //    user.verification();
        try {
            user.check(ch1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        library user2= new library();
        user2.func();
        user2.showBooks();
        while (true) {
            System.out.println("What do you want to do-:");
            System.out.println("Press 1 for borrowing");
            System.out.println("Press 2 for returning");
            System.out.println("Press 3 if you lost borrowed book");
            System.out.println("Press 4 for exit");
            ch2 = s.nextInt();
            user2.func2(ch2);
        }
    }
}

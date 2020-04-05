/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iksoks;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import java.util.Random;

/**
 *
 * @author Luka
 */
public class FXMLDocumentController implements Initializable {

    //Stavljamo variable kako valja
    static String[] field = new String[]{"a", "b", "c", "b", "c", "c", "b", "c", "c", " "};
    static Boolean firstMoveDone = false;

    @FXML
    Button b1;
    @FXML
    Button b2;
    @FXML
    Button b3;
    @FXML
    Button b4;
    @FXML
    Button b5;
    @FXML
    Button b6;
    @FXML
    Button b7;
    @FXML
    Button b8;
    @FXML
    Button b9;
    @FXML
    TextArea console;
    //-----------------------------

    //Sada svi eventovi kada se dugme klikne
    @FXML
    private void handleButton1Action(ActionEvent event) {
        System.out.println("Dugme 1 pritisnuto");
        b1.setText("X");
        b1.setDisable(true);
        refresh();
    }

    @FXML
    private void handleButton2Action(ActionEvent event) {
        System.out.println("Dugme 2 pritisnuto");
        b2.setText("X");
        b2.setDisable(true);
        refresh();
    }

    @FXML
    private void handleButton3Action(ActionEvent event) {
        System.out.println("Dugme 3 pritisnuto");
        b3.setText("X");
        b3.setDisable(true);
        refresh();
    }

    @FXML
    private void handleButton4Action(ActionEvent event) {
        System.out.println("Dugme 4 pritisnuto");
        b4.setText("X");
        b4.setDisable(true);
        refresh();
    }

    @FXML
    private void handleButton5Action(ActionEvent event) {
        System.out.println("Dugme 5 pritisnuto");
        b5.setText("X");
        b5.setDisable(true);
        refresh();
    }

    @FXML
    private void handleButton6Action(ActionEvent event) {
        System.out.println("Dugme 6 pritisnuto");
        b6.setText("X");
        b6.setDisable(true);
        refresh();
    }

    @FXML
    private void handleButton7Action(ActionEvent event) {
        System.out.println("Dugme 7 pritisnuto");
        b7.setText("X");
        b7.setDisable(true);
        refresh();
    }

    @FXML
    private void handleButton8Action(ActionEvent event) {
        System.out.println("Dugme 8 pritisnuto");
        b8.setText("X");
        b8.setDisable(true);
        refresh();
    }

    @FXML
    private void handleButton9Action(ActionEvent event) {
        System.out.println("Dugme 9 pritisnuto");
        b9.setText("X");
        b9.setDisable(true);
        refresh();
    }

    @FXML
    private void writeCmd(String message) {
        console.setText(console.getText() + System.lineSeparator() + message);
    }

    @FXML
    private void refresh() {
        //set the field array to the buttons valiuables
        field[0] = b1.getText();
        field[1] = b2.getText();
        field[2] = b3.getText();
        field[3] = b4.getText();
        field[4] = b5.getText();
        field[5] = b6.getText();
        field[6] = b7.getText();
        field[7] = b8.getText();
        field[8] = b9.getText();

        //set other variables
        Boolean win = false;
        Boolean myTurn = true;
        //debug
        System.out.println("Filed rn");
        console.setText(console.getText() + System.lineSeparator() + "Field:");
        for (String f : field) {
            console.setText(console.getText() + " " + f);
        }
        //Checks for wins by player
        //check for vertical wins
        for (int i = 0; i < 4; i++) {

            if (field[i] == "X" && field[i + 3] == "X" && field[i + 6] == "X") {
                console.setText(console.getText() + System.lineSeparator() + "Vertical win");
            }

        }

        //check for horizontal wins
        for (int i = 0; i < 7; i += 3) {

            if (field[i] == "X" && field[i + 1] == "X" && field[i + 2] == "X") {
                console.setText(console.getText() + System.lineSeparator() + "Horizontal Win");
            }

        }

        //check for left to right diagonal wins 
        if (field[0] == "X" && field[4] == "X" && field[8] == "X") {
            console.setText(console.getText() + System.lineSeparator() + "Diagonal Left to Right win");
            win = true;
        }

        //check for left to right diagonal wins 
        if (field[2] == "X" && field[4] == "X" && field[6] == "X") {
            console.setText(console.getText() + System.lineSeparator() + "Diagonal Right to Left win");
            win = true;
        }

        //First AI part
        /*
        *   The first bit of the AI that places the first O randomly
        *   Activates only once
         */
        if (myTurn == true) {
            if (firstMoveDone == false) {
                Random rd = new Random();
                int rdn = rd.nextInt(9);
                System.out.println(rdn);
                if (field[rdn] != "X" && field[rdn] != "O") {
                    placeO(rdn);
                    myTurn = false;
                } else {
                    rdn = rd.nextInt(9);
                    if (field[rdn] != "X" && field[rdn] != "O") {
                        placeO(rdn);
                    } else {
                        rdn = rd.nextInt(9);
                        for (int i = 0; i < 100; i++) {
                            if (field[rdn] != "X" && field[rdn] != "O") {
                                placeO(rdn);
                                break;
                            }
                        }
                    }
                }
                firstMoveDone = true;
            }
        }
        //First AI part done
        //------------------
        /*
        Second part of the AI player
        Horisontal Win stopper
        Works by:
        Checking every horizontal plane (0 1 2, 3 4 5, 6 7 8) if there are 2 X's and if there are attempts to place a O .
         */
        if (myTurn == true) {
            for (int i = 0; i < 7; i += 3) {
                int xNum = 0;
                for (int j = 0; j < 3; j++) {
                    if (field[i + j] == "X") {
                        xNum++;
                    }
                    if (xNum == 2) {
                        System.out.println("Found horisontal win attempt at " + i);
                        xNum = 0;

                        if (field[i] != "X" && field[i] != "O") {
                            placeO(i);
                            myTurn = false;
                            break;
                        }
                        if (field[i + 1] != "X" && field[i + 1] != "O") {
                            placeO(i + 1);
                            myTurn = false;
                            break;
                        }

                        if (field[i + 2] != "X" && field[i + 2] != "O") {
                            placeO(i + 2);
                            myTurn = false;
                            break;
                        }

                    }
                }
            }
        }
        //Second AI bit done
        //------------------
        /*
        Third part of the AI player
        Vertical win stoppr
        Works by:
        Checking every vertical plane (0 3 6, 1 4 7, 2 5 8) if there are 2 X's and if there are attempts to place a O .
         */
        if (myTurn == true) {
            for (int i = 0; i < 3; i++) {
                int xNum = 0;
                for (int j = 0; j < 7; j += 3) {
                    if (field[i + j] == "X") { //check for x's and imcrement the xNum valiue up
                        xNum++;
                    }
                    if (xNum == 2) {
                        System.out.println("Found vertical win attempt at " + i);
                        xNum = 0;

                        //check if there are x's or o's and if there arent any place one
                        if (field[i] != "X" && field[i] != "O") {
                            placeO(i);
                            myTurn = false;
                            break;
                        }
                        if (field[i + 3] != "X" && field[i + 3] != "O") {
                            placeO(i + 3);
                            myTurn = false;
                            break;
                        }

                        if (field[i + 6] != "X" && field[i + 6] != "O") {
                            placeO(i + 6);
                            myTurn = false;
                            break;
                        }
                    }
                }
            }
        }
        //Third ai bit done
        //----------------
        /*
        Fourth part of the AI player
        Left to Right Diagonal win stopper
        Works by:
        Checking parts 0, 4, 8 and if there are more than 2 X's it tries to place a O
         */
        if (myTurn == true) {
            int numX = 0;
            for (int i = 0; i < 9; i += 4) {
                if (field[i] == "X") { //c o u n t the x's
                    numX++;
                }

                if (numX == 2) {
                    //check if there are x's or o's and if there arent any place one
                    if (field[0] != "X" && field[0] != "O") {
                        placeO(0);
                        myTurn = false;
                        break;
                    }

                    if (field[4] != "X" && field[4] != "O") {
                        placeO(4);
                        myTurn = false;
                        break;
                    }

                    if (field[8] != "X" && field[8] != "O") {
                        placeO(8);
                        myTurn = false;
                        break;
                    }
                }
            }
        }
        //Fourth AI bit done
        //------------------
        /*
        Fifth part of the AI player
        Right to left Diagonal win stopper
        Works by:
        Checking parts 2, 4, 6 and if there are more than 2 X's it tries to place a O
         */
        if (myTurn == true) {
            int numX = 0;
            for (int i = 0; i < 7; i += 2) {
                if (field[i] == "X") { //c o u n t the x's
                    numX++;
                }
                if (numX == 2) {
                    //check if there are x's or o's and if there arent any place one
                    if (field[2] != "X" && field[2] != "O") {
                        placeO(2);
                        myTurn = false;
                        break;
                    }

                    if (field[4] != "X" && field[4] != "O") {
                        placeO(4);
                        myTurn = false;
                        break;
                    }

                    if (field[6] != "X" && field[6] != "O") {
                        placeO(6);
                        myTurn = false;
                        break;
                    }
                }
            }
        }
        //Fifth part of the AI player done
        //--------------------------------
        //Sixsth part of the AI player
        /*
        If all other logic fails there is always a random number generator
        Works by:
        Checking if its still my turn , then randomising a number between 0 and 8 and checking if there is a X or a O on that part if
        there isnt a X or O on that part it will place a O , but if there is then it repeats the process untill there is a free spot
         */
        if (myTurn == true) {
            Boolean hasFoundASpot = false;
            Random rdn = new Random();
            int rdnu;
            for (int i = 0; i < 10000; i++) {
                rdnu = rdn.nextInt(9);

                if (field[rdnu] != "X" && field[rdnu] != "O") {
                    myTurn = false;
                    placeO(rdnu);
                    break;
                }
            }
        }
        myTurn = true;
        //Sixtsh part of the AI player done
        //---------------------------------

        aiWinCheck(field);

    }

    //---------------------------------------
    //Place a o and disable a button
    @FXML
    private void placeO(int i) {
        switch (i) {
            case 0:
                writeCmd("Placing O at destination 0");
                b1.setDisable(true);
                b1.setText("O");
                break;

            case 1:
                writeCmd("Placing O at destination 1");
                b2.setDisable(true);
                b2.setText("O");
                break;

            case 2:
                writeCmd("Placing O at destination 2");
                b3.setDisable(true);
                b3.setText("O");
                break;

            case 3:
                writeCmd("Placing O at destination 3");
                b4.setDisable(true);
                b4.setText("O");
                break;

            case 4:
                writeCmd("Placing O at destination 4");
                b5.setDisable(true);
                b5.setText("O");
                break;

            case 5:
                writeCmd("Placing O at destination 5");
                b6.setDisable(true);
                b6.setText("O");
                break;

            case 6:
                writeCmd("Placing O at destination 6");
                b7.setDisable(true);
                b7.setText("O");
                break;

            case 7:
                writeCmd("Placing O at destination 7");
                b8.setDisable(true);
                b8.setText("O");
                break;

            case 8:
                writeCmd("Placing O at destination 8");
                b9.setDisable(true);
                b9.setText("O");
                break;
        }
    }

    //----------------------------------------------------
    private void aiWinCheck(String[] field) {
        /*Win checker for AI player*/
        //check for vertical wins
        System.out.println("AI PLAYER WICTORY CHECKER");
        for (int i = 0; i < 4; i++) {

            if (field[i] == "O" && field[i + 3] == "O" && field[i + 6] == "O") {
                console.setText(console.getText() + System.lineSeparator() + "Vertical win by the AI player");
                System.out.println("AI PLAYER WON");
            }

        }

        //check for horizontal wins
        for (int i = 0; i < 7; i += 3) {

            if (field[i] == "O" && field[i + 1] == "O" && field[i + 2] == "O") {
                console.setText(console.getText() + System.lineSeparator() + "Horizontal Win by the AI player");
                System.out.println("AI PLAYER WON");
            }

        }

        //check for left to right diagonal wins 
        if (field[0] == "O" && field[4] == "O" && field[8] == "O") {
            console.setText(console.getText() + System.lineSeparator() + "Diagonal Left to Right win by the AI player");
            System.out.println("AI PLAYER WON");
        }

        //check for left to right diagonal wins 
        if (field[2] == "O" && field[4] == "O" && field[6] == "O") {
            console.setText(console.getText() + System.lineSeparator() + "Diagonal Right to Left win by the AI player");
            System.out.println("AI PLAYER WON");
        }
        //---------------------------------

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println(url);
    }

}

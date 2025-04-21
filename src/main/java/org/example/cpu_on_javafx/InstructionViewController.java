package org.example.cpu_on_javafx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;

import java.io.IOException;

import static org.example.cpu_on_javafx.MainController.indexForRun;


public class InstructionViewController {

    Program prog = BProgram.build();
    GridPane allView;
    int index;
    @FXML
    Label arg1_label, arg2_label, arg3_label;
    @FXML
    Pane pane;
    Command command;

    InstructionViewController(GridPane allView){
        this.allView = allView;

    }
    public void init(Command command,boolean indexForRun){
        this.command = command;
        arg1_label.setText(command.arg1);
        arg2_label.setText(command.arg2);
        arg3_label.setText(command.arg3);


        if (indexForRun) {
            arg1_label.setTextFill(Paint.valueOf("RED"));
            arg2_label.setTextFill(Paint.valueOf("RED"));
            arg3_label.setTextFill(Paint.valueOf("RED"));
        }
    }


    @FXML
    void up(){

        index = allView.getChildren().indexOf(pane);
        if(index > 0){
            prog.swap(index,index-1);
            prog.updateViewInstruction(allView, indexForRun);
        }



    }
    @FXML
    void down(){
        if(index < prog.size()-1) {
            index = allView.getChildren().indexOf(pane);
            prog.swap(index, index + 1);
            prog.updateViewInstruction(allView, indexForRun);
        }
    }


    @FXML
    void deleteInstruction() {
        prog.delete(command);
        prog.updateViewInstruction(allView,indexForRun);



    }
}
